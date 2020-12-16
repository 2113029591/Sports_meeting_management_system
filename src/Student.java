public class Student {
    private String userName;
    private String password;
    private String trueName;
    private String userId;
    private boolean isJoin;
    private int isPassed;
    //1为待审核，2为通过
    private int grade;

    public Student() {}

    public Student(String userName, String password, String trueName, String userId, boolean isJoin, int isPassed, int grade) {
        this.userName = userName;
        this.password = password;
        this.trueName = trueName;
        this.userId = userId;
        this.isJoin = isJoin;
        this.isPassed = isPassed;
        this.grade = grade;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isJoin() {
        return isJoin;
    }

    public void setJoin(boolean join) {
        isJoin = join;
    }

    public int getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(int isPassed) {
        this.isPassed = isPassed;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
