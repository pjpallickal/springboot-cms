package com.cms.authservice.rest;

public class AuthResponse {
    private int returnCode;
    private int userId;
    private String message;

    public AuthResponse(int returnCode, int userId, String message) {
        this.returnCode = returnCode;
        this.userId = userId;
        this.message = message;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "returnCode=" + returnCode +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                '}';
    }
}
