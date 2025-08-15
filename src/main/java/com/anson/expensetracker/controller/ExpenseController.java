package com.anson.expensetracker.controller;

import com.anson.expensetracker.dto.ExpenseFilter;
import com.anson.expensetracker.model.Expense;
import com.anson.expensetracker.repository.ExpenseRepository;
import com.anson.expensetracker.service.ExpenseService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;





@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable Long id) {
        return expenseRepository.findById(id);
    }
    
    @PostMapping
    public Expense creatExpense(@Valid @RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @PostMapping("/filter")
    public List<Expense> filterExpenses(@RequestBody ExpenseFilter filter) {
        return expenseService.filterExpenses(filter);
    }
    

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expenseDetails) {
        Expense expense = expenseRepository.findById(id).orElseThrow(()-> new RuntimeException("Expense not found with id " + id));

        expense.setTitle(expenseDetails.getTitle());
        expense.setAmount(expenseDetails.getAmount());
        expense.setDate(expense.getDate());

        return expenseRepository.save(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
    }
}