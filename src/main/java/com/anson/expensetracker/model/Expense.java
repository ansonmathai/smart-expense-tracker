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

    @Column(nullable = true)
    private String category;

    public Expense() {}

    public Expense(String title, double amount, LocalDate date, String category) {
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public Expense(Long id, String title, double amount, LocalDate date, String category) {
        this(title, amount, date, category);
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

    public String getCategory() {
        return this.category;
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

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Expense{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", amount=" + amount +
               ", date=" + date +
               ", category='" + category + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;
        Expense expense = (Expense) o;
        return Double.compare(expense.amount, amount) == 0 &&
               Objects.equals(id, expense.id) &&
               Objects.equals(title, expense.title) &&
               Objects.equals(date, expense.date) &&
               Objects.equals(category, expense.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, amount, date, category);
    }
}