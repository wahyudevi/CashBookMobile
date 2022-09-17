package com.example.cashbook;

public class Users {
    public static final String SYNCDOWN_PASSWORDS_TABLE_NAME = "users";
    public static final String KEY_USER_ID = "id_user";
    public static final String KEY_PASSWORD = "password";

    private String id_user , password;

    public Users(String id_user, String password) {
        this.id_user = id_user;
        this.password = password;
    }

    public Users() {
    }

    public String getUserId() {
        return id_user;
    }

    public void setUserId(String id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
