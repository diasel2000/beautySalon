package controller;


import org.apache.log4j.Logger;
import service.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger ( RegistrationServlet.class );

    public RegistrationServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                this.getServletContext ().getRequestDispatcher ( "/pages/registration.jsp" );
        dispatcher.forward ( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter ( "login" );
        String password = request.getParameter ( "password" );

        main.java.entity.Users users = new main.java.entity.Users ();
        users.setLogin ( login );
        users.setPassword ( password );

        UsersService registerDao = new UsersService ();

        String userRegister = registerDao.add ( users );
        if (userRegister !=null)
        {
            request.getRequestDispatcher ( "/pages/index.jsp" ).forward ( request, response );
            LOG.debug ("Registration compleat\n");
        } else
        {
            request.setAttribute ( "errMessage", userRegister );
            request.getRequestDispatcher ( "/pages/registration.jsp" ).forward ( request, response );
            LOG.debug ("Registration error\n");
        }

    }
}
