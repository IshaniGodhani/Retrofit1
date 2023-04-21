package com.example.retrofit.Models;

public class RegisterData
{
    int connection;
    int result;

    public int getConnection() {
        return connection;
    }

    public void setConnection(int connection) {
        this.connection = connection;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RegisterData{" +
                "connection=" + connection +
                ", result=" + result +
                '}';
    }
}
