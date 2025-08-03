package com.anson.expensetracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Positive
    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDate date;

    public Expense() {}

    public Expense(String title, double amount, LocalDate date) {
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    public Expense(Long id, String title, double amount, LocalDate date) {
        this(title,amount,date);
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{"+"id="+id+", title='"+title+'\''+", amount="+amount+", date="+date+'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.amount, amount) == 0 && Objects.equals(id, expense.id) && Objects.equals(title, expense.title) && Objects.equals(date, expense.date); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, amount, date);
    }
}