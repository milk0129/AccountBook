package model.dto;

public class ExpenseDTO {
    private int expId;
    private String userId;
    private String expDate;
    private String expItem;
    private int expMoney;
    private String expType;       // 추가: 수입 or 지출
    private String expCategory;
    private String expMemo;

    public ExpenseDTO() {}

    public ExpenseDTO(int expId, String userId, String expDate, String expItem,
                      int expMoney, String expType, String expCategory, String expMemo) {
        this.expId = expId;
        this.userId = userId;
        this.expDate = expDate;
        this.expItem = expItem;
        this.expMoney = expMoney;
        this.expType = expType;
        this.expCategory = expCategory;
        this.expMemo = expMemo;
    }

    // Getter / Setter
    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getExpItem() {
        return expItem;
    }

    public void setExpItem(String expItem) {
        this.expItem = expItem;
    }

    public int getExpMoney() {
        return expMoney;
    }

    public void setExpMoney(int expMoney) {
        this.expMoney = expMoney;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getExpCategory() {
        return expCategory;
    }

    public void setExpCategory(String expCategory) {
        this.expCategory = expCategory;
    }

    public String getExpMemo() {
        return expMemo;
    }

    public void setExpMemo(String expMemo) {
        this.expMemo = expMemo;
    }

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "expId=" + expId +
                ", userId='" + userId + '\'' +
                ", expDate='" + expDate + '\'' +
                ", expItem='" + expItem + '\'' +
                ", expMoney=" + expMoney +
                ", expType='" + expType + '\'' +
                ", expCategory='" + expCategory + '\'' +
                ", expMemo='" + expMemo + '\'' +
                '}';
    }
}
