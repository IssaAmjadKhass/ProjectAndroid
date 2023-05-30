package com.example.projectandroid.modail;

public class Accounts {
    public static final String COL_REMEMBER_ME = "remember_me";
    private int id;
    private String userName;
    private String email;
    private int password;

    private static final String DATABASE_NAME = "UserAccounts.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "accounts";
    public static final String COL_ID = "id";
    public static final String COL_USERNAME = "userName";
    public static final String COL_EMAIL = "email";
    public static final String COL_PASSWORD = "password";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_USERNAME + " TEXT,"
            + COL_EMAIL + " TEXT,"
            + COL_PASSWORD + " TEXT,"
            + COL_REMEMBER_ME + " INTEGER DEFAULT 0)";

    public Accounts(int id, String userName, String email, int password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}