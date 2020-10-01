package model;

public class User {
    private static Long generateId = 0L;
    private Long userId;
    private String name;
    private String password;

    public User () {
        generateId = generateId + 1;
        this.userId = generateId;
    }
    public User(String name, String password) {
        this.userId = generateId;;
        this.name = name;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

