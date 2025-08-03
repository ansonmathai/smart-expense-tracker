package com.anson.expensetracker.dto;

import java.time.LocalDate;

public class ExpenseFilter {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Double minAmount;
    private Double maxAmount;
    private String category;
    private String sortBy;                  // "date" or "amount"
    private String sortOrder;               // "asc" or "desc"

    public LocalDate getFromDate() {
        return this.fromDate;
    }

    public LocalDate getToDate() {
        return this.toDate;
    }

    public Double getMinAmount() {
        return this.minAmount;
    }

    public Double getMaxAmount() {
        return this.maxAmount;
    }

    public String getCategory() {
        return this.category;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }
}
