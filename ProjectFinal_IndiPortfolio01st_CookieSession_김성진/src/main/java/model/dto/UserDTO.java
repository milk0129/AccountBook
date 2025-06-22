package model.dto;

public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String userBirth;
    private String userCreateAt;

    // 생성자
    public UserDTO() {}

    public UserDTO(String userId, String userPw, String userName, String userBirth, String userCreateAt) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userCreateAt = userCreateAt;
    }

    // Getter / Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserCreateAt() {
        return userCreateAt;
    }

    public void setUserCreateAt(String userCreateAt) {
        this.userCreateAt = userCreateAt;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userName='" + userName + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userCreateAt='" + userCreateAt + '\'' +
                '}';
    }
} 
