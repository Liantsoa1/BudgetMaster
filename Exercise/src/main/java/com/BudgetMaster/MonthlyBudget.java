package com.BudgetMaster;

import java.time.LocalDate;

public class MonthlyBudget {
    private LocalDate budgetDate;
    private double budget;

    public MonthlyBudget(LocalDate budgetDate, double budget) {
        this.budgetDate = budgetDate;
        this.budget = budget;
    }

    public LocalDate getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(LocalDate budgetDate) {
        this.budgetDate = budgetDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
