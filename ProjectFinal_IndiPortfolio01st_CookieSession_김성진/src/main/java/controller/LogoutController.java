package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();

        // 리팩토링된 메인 경로로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/JspPro/Remake/mainJsp/index.jsp");
    }
}
