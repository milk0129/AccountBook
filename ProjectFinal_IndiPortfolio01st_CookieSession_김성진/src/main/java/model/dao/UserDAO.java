package model.dao;

import model.dto.UserDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = "hr";
    private final String PASSWORD = "hr";

    public Connection getConn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean addUser(UserDTO user) {
        String sql = "INSERT INTO MY_USERS (USER_ID, USER_NAME, USER_BIRTH, CREATED_AT) VALUES (?, ?, ?, SYSDATE)";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            pstmt.setDate(3, Date.valueOf(user.getUserBirth()));
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserDTO getUser(String userId) {
        String sql = "SELECT * FROM MY_USERS WHERE USER_ID = ?";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new UserDTO(
                    rs.getString("USER_ID"),
                    null, // 비밀번호 컬럼 없으므로 null
                    rs.getString("USER_NAME"),
                    rs.getDate("USER_BIRTH").toString(),
                    rs.getDate("CREATED_AT").toString()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean loginCheck(String userId) {
        return getUser(userId) != null;
    }

    public String findUserId(String userName, String userBirth) {
        String sql = "SELECT USER_ID FROM MY_USERS WHERE USER_NAME = ? AND USER_BIRTH = ?";
        try (Connection conn = getConn(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setDate(2, Date.valueOf(userBirth));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getString("USER_ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM MY_USERS";
        try (Connection conn = getConn(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new UserDTO(
                    rs.getString("USER_ID"),
                    null,
                    rs.getString("USER_NAME"),
                    rs.getDate("USER_BIRTH").toString(),
                    rs.getDate("CREATED_AT").toString()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
