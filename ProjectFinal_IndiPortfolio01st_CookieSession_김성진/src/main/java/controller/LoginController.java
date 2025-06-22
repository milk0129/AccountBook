package controller;

import model.dao.UserDAO;
import model.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // login 화면으로 포워딩
        request.getRequestDispatcher("/JspPro/Remake/userJsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");

        if (userDAO.loginCheck(userId)) {
            UserDTO user = userDAO.getUser(userId);
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getUserName());

            // 로그인 성공 → 메인 화면으로 이동
            response.sendRedirect(request.getContextPath() + "/JspPro/Remake/mainJsp/mainAfter.jsp");

        } else {
            request.setAttribute("error", "로그인 정보가 일치하지 않습니다.");
            request.getRequestDispatcher("/JspPro/Remake/userJsp/login.jsp").forward(request, response);
        }
    }
}
