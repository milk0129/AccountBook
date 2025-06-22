package model.dao;

import model.dto.ExpenseDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "hr";
    private final String PASSWORD = "hr";

    private Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addExpense(ExpenseDTO dto) {
        String sql = "INSERT INTO EXPENSES (EXP_ID, USER_ID, EXP_DATE, EXP_ITEM, EXP_MONEY, EXP_TYPE, EXP_CATEGORY, EXP_MEMO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int nextId = getNextExpenseId();
            pstmt.setInt(1, nextId);
            pstmt.setString(2, dto.getUserId());
            pstmt.setDate(3, Date.valueOf(dto.getExpDate()));
            pstmt.setString(4, dto.getExpItem());
            pstmt.setInt(5, dto.getExpMoney());
            pstmt.setString(6, dto.getExpType());
            pstmt.setString(7, dto.getExpCategory());
            pstmt.setString(8, dto.getExpMemo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getNextExpenseId() {
        String sql = "SELECT NVL(MAX(EXP_ID), 0) + 1 FROM EXPENSES";
        try (Connection conn = getConn();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public boolean deleteExpense(int expId) {
        String sql = "DELETE FROM EXPENSES WHERE EXP_ID = ?";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, expId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateExpense(ExpenseDTO dto) {
        String sql = "UPDATE EXPENSES SET EXP_ITEM=?, EXP_MONEY=?, EXP_CATEGORY=?, EXP_MEMO=? WHERE EXP_ID=?";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dto.getExpItem());
            pstmt.setInt(2, dto.getExpMoney());
            pstmt.setString(3, dto.getExpCategory());
            pstmt.setString(4, dto.getExpMemo());
            pstmt.setInt(5, dto.getExpId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ExpenseDTO> getUserExpenses(String userId) {
        List<ExpenseDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM EXPENSES WHERE USER_ID = ? ORDER BY EXP_DATE";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ExpenseDTO dto = new ExpenseDTO();
                dto.setExpId(rs.getInt("EXP_ID"));
                dto.setUserId(rs.getString("USER_ID"));
                dto.setExpDate(rs.getDate("EXP_DATE").toString());
                dto.setExpItem(rs.getString("EXP_ITEM"));
                dto.setExpMoney(rs.getInt("EXP_MONEY"));
                dto.setExpType(rs.getString("EXP_TYPE"));
                dto.setExpCategory(rs.getString("EXP_CATEGORY"));
                dto.setExpMemo(rs.getString("EXP_MEMO"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getUserTotalExpense(String userId) {
        String sql = "SELECT NVL(SUM(EXP_MONEY), 0) FROM EXPENSES WHERE USER_ID = ? AND EXP_TYPE = '지출'";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ExpenseDTO getExpenseById(int expId) {
        String sql = "SELECT * FROM EXPENSES WHERE EXP_ID = ?";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, expId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                ExpenseDTO dto = new ExpenseDTO();
                dto.setExpId(rs.getInt("EXP_ID"));
                dto.setUserId(rs.getString("USER_ID"));
                dto.setExpDate(rs.getDate("EXP_DATE").toString());
                dto.setExpItem(rs.getString("EXP_ITEM"));
                dto.setExpMoney(rs.getInt("EXP_MONEY"));
                dto.setExpType(rs.getString("EXP_TYPE"));
                dto.setExpCategory(rs.getString("EXP_CATEGORY"));
                dto.setExpMemo(rs.getString("EXP_MEMO"));
                return dto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}