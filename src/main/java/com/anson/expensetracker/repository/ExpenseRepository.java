package com.anson.expensetracker.repository;

import com.anson.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}
