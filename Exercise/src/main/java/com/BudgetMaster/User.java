package com.BudgetMaster;

import java.util.List;
import java.util.Objects;

public class User {
    private String id;
    private String userName;
    private double monthlyBudget;
    private List<Spending> spendings;

    public User(String id, String userName, double monthlyBudget, List<Spending> spendings) {
        this.id = id;
        this.userName = userName;
        this.monthlyBudget = monthlyBudget;
        this.spendings = spendings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public List<Spending> getSpendings() {
        return spendings;
    }

    public void setSpendings(List<Spending> spendings) {
        this.spendings = spendings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(monthlyBudget, user.monthlyBudget) == 0 && Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(spendings, user.spendings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, monthlyBudget, spendings);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", monthlyBudget=" + monthlyBudget +
                ", spendings=" + spendings +
                '}';
    }
}
