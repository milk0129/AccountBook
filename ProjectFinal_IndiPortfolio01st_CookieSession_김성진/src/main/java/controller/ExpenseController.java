package controller;

import model.dao.ExpenseDAO;
import model.dto.ExpenseDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/expense")
public class ExpenseController extends HttpServlet {
    private final ExpenseDAO expenseDAO = new ExpenseDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/JspPro/Remake/mainJsp/login_index.jsp");
            return;
        }

        if ("list".equals(action)) {
            List<ExpenseDTO> expenses = expenseDAO.getUserExpenses(userId);
            request.setAttribute("expenses", expenses);
            request.getRequestDispatcher("/JspPro/Remake/historyJsp/historySel.jsp").forward(request, response);

        } else if ("editForm".equals(action)) {
            int expId = Integer.parseInt(request.getParameter("expId"));
            ExpenseDTO dto = expenseDAO.getExpenseById(expId);
            request.setAttribute("dto", dto);
            request.getRequestDispatcher("/JspPro/Remake/historyJsp/historyUpdate.jsp").forward(request, response);

        } else if ("delete".equals(action)) {
            int expId = Integer.parseInt(request.getParameter("expId"));
            expenseDAO.deleteExpense(expId);
            response.sendRedirect(request.getContextPath() + "/expense?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/JspPro/Remake/mainJsp/login_index.jsp");
            return;
        }

        if ("add".equals(action)) {
            ExpenseDTO dto = new ExpenseDTO();
            dto.setUserId(userId);
            dto.setExpDate(request.getParameter("expDate"));
            dto.setExpItem(request.getParameter("expItem"));
            dto.setExpMoney(Integer.parseInt(request.getParameter("expMoney")));
            dto.setExpCategory(request.getParameter("expCategory"));
            dto.setExpMemo(request.getParameter("expMemo"));
            expenseDAO.addExpense(dto);
            response.sendRedirect(request.getContextPath() + "/expense?action=list");

        } else if ("update".equals(action)) {
            ExpenseDTO dto = new ExpenseDTO();
            dto.setExpId(Integer.parseInt(request.getParameter("expId")));
            dto.setUserId(userId);
            dto.setExpItem(request.getParameter("expItem"));
            dto.setExpMoney(Integer.parseInt(request.getParameter("expMoney")));
            dto.setExpCategory(request.getParameter("expCategory"));
            dto.setExpMemo(request.getParameter("expMemo"));
            expenseDAO.updateExpense(dto);
            response.sendRedirect(request.getContextPath() + "/expense?action=list");
        }
    }
}
