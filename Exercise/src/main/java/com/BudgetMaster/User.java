package com.BudgetMaster;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.BudgetMaster.ExpenseCategories.*;

public class User {
    private String id;
    private String userName;
    private List<Expense> expenses;
    private MonthlyBudget monthlyBudget;

    public User(String id, String userName, MonthlyBudget monthlyBudget, List<Expense> expenses) {
        this.id = id;
        this.userName = userName;
        this.monthlyBudget = monthlyBudget;
        this.expenses = expenses;
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

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public MonthlyBudget getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(MonthlyBudget monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public List<Expense> getSpendings() {
        return expenses;
    }

    public void setSpendings(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(expenses, user.expenses) && Objects.equals(monthlyBudget, user.monthlyBudget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, expenses, monthlyBudget);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", expenses=" + expenses +
                ", monthlyBudget=" + monthlyBudget +
                '}';
    }

    public void addExpense(Expense expense) {
        if(expense.getAmount() < 0){
            throw new RuntimeException("Expense amount cannot be negative");
        }
        else {
            this.expenses.add(expense);
        }
    }

    public List<Expense> getExpenseByCategories(ExpenseCategories category) {
        List<Expense> expenseByCategories = new ArrayList<>();
        for(Expense expense : expenses){
            if(expense.getCategory().equals(category)){
                expenseByCategories.add(expense);
            }
        }
        return expenseByCategories;
    }

    public double getRemainingBudget(){
        double totalExpenses = 0;
        LocalDate actualDate = LocalDate.now();
        for(Expense expense : expenses){
            if(expense.getDate().getMonthValue() == actualDate.getMonthValue()){
              totalExpenses += expense.getAmount();
            }
        }
        if(monthlyBudget.getBudgetDate().getMonthValue() == actualDate.getMonthValue()){
            return monthlyBudget.getBudget() - totalExpenses;
        }
    };

    public String calculateAverageSpendingPerCategory(){
        double foodBudget = 0;
        double transportBudget = 0;
        double entertainmentBudget = 0;
        double publicBudget = 0;
        double otherBudget = 0;
        int foodNumber = 0;
        int transportNumber = 0;
        int entertainmentNumber = 0;
        int publicNumber = 0;
        int otherNumber = 0;
        for(Expense expense : expenses){
            if(expense.getCategory().equals(FOODS_AND_DINING)){
                foodBudget += expense.getAmount();
                foodNumber++;
            } else if (expense.getCategory().equals(TRANSPORT)) {
                transportBudget += expense.getAmount();
                transportNumber++;
            } else if(expense.getCategory().equals(ENTERTAINMENT)){
                entertainmentBudget += expense.getAmount();
                entertainmentNumber++;
            } else if(expense.getCategory().equals(PUBLIC_SERVICES)){
                publicBudget += expense.getAmount();
                publicNumber++;
            } else if(expense.getCategory().equals(OTHERS)){
                publicBudget += expense.getAmount();
                otherBudget++;
        }
            return "The average for food is " + foodBudget/foodNumber + " , The average for transport is" + transportBudget/transportNumber + " , The average for entertainment" + entertainmentBudget/entertainmentNumber + " , The average for public service is" + publicBudget/publicNumber +  " ,The average for other is" + otherBudget/otherNumber;
    }
