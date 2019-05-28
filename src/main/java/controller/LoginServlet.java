package controller;

import service.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import db.DataBaseConection;
import main.java.dao.UsersDAO;
import main.java.entity.Users;
@WebServlet("/loginPage")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = this.getServletContext().getRequestDispatcher("/pages/loginPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter ( "password" );

        Users users = new Users ();
        users.setLogin (login);
        users.setPassword ( password );

        UsersService usersService = new UsersService ();

        String userValidate = usersService.getUser ( users );

        if(userValidate.equals("SUCCESS"))
        {
            request.setAttribute("login", login);
            request.getRequestDispatcher("/pages/userInfoPage.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("errMessage", userValidate);
            request.getRequestDispatcher("/pages/loginPage.jsp").forward(request, response);
        }
    }
}

