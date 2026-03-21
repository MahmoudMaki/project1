package com.amigoscode;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getPersons")
public class CustomerController {

    private final JdbcTemplate jdbcTemplate;

    public CustomerController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public String getCustomers() {
        // query the customers table for all customers
        String sql = "SELECT name FROM customers";
        List<String> customers = jdbcTemplate.queryForList(sql, String.class);

        String customersString = customers.toString();
        return customersString;
    }
}