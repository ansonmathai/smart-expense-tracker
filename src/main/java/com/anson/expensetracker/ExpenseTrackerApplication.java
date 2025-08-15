package com.anson.expensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("EXPENSE_TRACKER_DB_URL", dotenv.get("DB_URL"));
        System.setProperty("EXPENSE_TRACKER_DB_USER", dotenv.get("DB_USER"));
        System.setProperty("EXPENSE_TRACKER_DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

}
