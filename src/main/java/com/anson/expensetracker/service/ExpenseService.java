package com.anson.expensetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anson.expensetracker.dto.ExpenseFilter;
import com.anson.expensetracker.model.Expense;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Path;

@Service
public class ExpenseService {
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Expense> filterExpenses(ExpenseFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Expense> query = cb.createQuery(Expense.class);
        Root<Expense> root = query.from(Expense.class);

        List<Predicate> predicates = new ArrayList<>();

        //Date
        if (filter.getFromDate() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("date"), filter.getFromDate()));
        }

        if (filter.getToDate() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("date"), filter.getToDate()));
        }

        //Amount
        if (filter.getMinAmount() != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get("amount"), filter.getMinAmount()));
        }

        if (filter.getMaxAmount() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("amount"), filter.getMaxAmount()));
        }

        //Category
        if (filter.getCategory() != null && !filter.getCategory().isEmpty()) {
            predicates.add(cb.equal(root.get("category"), filter.getCategory()));   
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        //Sorting
        String sortBy = filter.getSortBy() != null ? filter.getSortBy() : "date";
        String sortOrder = filter.getSortOrder() != null ? filter.getSortOrder() : "asc";

        Path<?> sortPath = root.get(sortBy);
        if ("desc".equalsIgnoreCase(sortOrder)) {
            query.orderBy(cb.desc(sortPath));
        } else {
            query.orderBy(cb.asc(sortPath));
        }

        return entityManager.createQuery(query).getResultList();
    }
}
