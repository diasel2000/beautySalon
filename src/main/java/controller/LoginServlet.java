package controller;

import org.apache.log4j.Logger;
import service.DataDao;
import service.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import db.DataBaseConection;
import main.java.dao.UsersDAO;
import main.java.entity.Users;
import service.secure.AppUtils;

import static db.DataBaseConection.getConnection;

@WebServlet("/loginPage")
public class LoginServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger ( DataBaseConection.class );

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

        String un = request.getParameter("login");
        String pw = request.getParameter("password");
        Users users =DataDao.findUser ( un,pw );

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM beauty_salon.users where login = ? and password = ?;");
            ps.setString(1, un);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (users == null) {
                    String errorMessage = "Invalid userName or Password";
                    request.setAttribute("errorMessage", errorMessage);
                    RequestDispatcher dispatcher //
                            = this.getServletContext().getRequestDispatcher("/pages/loginPage.jsp");

                    dispatcher.forward(request, response);
                    return;
                }
                AppUtils.storeLoginedUser(request.getSession(), users);
                int redirectId = -1;
                try {
                    redirectId = Integer.parseInt(request.getParameter("redirectId"));
                } catch (Exception e) {
                }
                String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
                if (requestUri != null) {
                    response.sendRedirect(requestUri);
                } else {
                    // По умолчанию после успешного входа в систему
                    // перенаправить на страницу /userInfo
                    response.sendRedirect(request.getContextPath() + "/pages/userInfoPage");
                }
            }

        } catch (SQLException e) {
            LOG.error("Some problem with  \n" + e);
        }
    }
}

