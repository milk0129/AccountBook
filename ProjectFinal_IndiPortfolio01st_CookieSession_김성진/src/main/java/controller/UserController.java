package controller;

import model.dao.UserDAO;
import model.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("signupForm".equals(action)) {
            request.getRequestDispatcher("/JspPro/Remake/view/signUp.jsp").forward(request, response);
        } else if ("findIdForm".equals(action)) {
            request.getRequestDispatcher("/JspPro/Remake/view/find-id.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("signup".equals(action)) {
            String userId = request.getParameter("userId");
            String userPw = request.getParameter("userPw");
            String userName = request.getParameter("userName");
            String userBirth = request.getParameter("userBirth");
            String userCreateAt = LocalDate.now().toString();

            UserDTO newUser = new UserDTO(userId, userPw, userName, userBirth, userCreateAt);
            boolean success = userDAO.addUser(newUser);

            if (success) {
                response.sendRedirect("/login");
            } else {
                request.setAttribute("error", "이미 존재하는 아이디입니다.");
                request.getRequestDispatcher("/JspPro/Remake/view/signUp.jsp").forward(request, response);
            }

        } else if ("findId".equals(action)) {
            String userName = request.getParameter("userName");
            String userBirth = request.getParameter("userBirth");

            String foundId = userDAO.findUserId(userName, userBirth);
            request.setAttribute("foundId", foundId);
            request.getRequestDispatcher("/JspPro/Remake/view/find-id.jsp").forward(request, response);
        }
    }
}
