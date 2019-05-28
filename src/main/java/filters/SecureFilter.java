package filters;

import service.secure.AppUtils;
import service.secure.SecurityUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import main.java.entity.Users;
import service.secure.UserRoleRequestWrapper;

@WebFilter("/*")
public class SecureFilter implements Filter {
    public SecureFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String servletPath = request.getServletPath();

        // Информация пользователя сохранена в Session
        // (После успешного входа в систему).
        Users enterUser = AppUtils.getLoginedUser(request.getSession());

        if (servletPath.equals("/loginPage")) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest wrapRequest = request;

        if (enterUser != null) {
            // User Name
            String login = enterUser.getLogin ();

            // Роли (Role).
            List<String> roles = enterUser.getRoles();

            // Старый пакет request с помощью нового Request с информацией userName и Roles.
            wrapRequest = new UserRoleRequestWrapper (login, roles, request);
        }

        // Страницы требующие входа в систему.
        if (SecurityUtils.isSecurityPage(request)) {

            // Если пользователь еще не вошел в систему,
            // Redirect (перенаправить) к странице логина.
            if (enterUser == null) {

                String requestUri = request.getRequestURI();

                // Сохранить текущую страницу для перенаправления (redirect) после успешного входа в систему.
                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }

            // Проверить пользователь имеет действительную роль или нет?
            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
            if (!hasPermission) {

                RequestDispatcher dispatcher //
                        = request.getServletContext().getRequestDispatcher("/pages/userInfoPage.jsp");

                dispatcher.forward(request, response);
                return;
            }
        }

        chain.doFilter(wrapRequest, response);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }
}
