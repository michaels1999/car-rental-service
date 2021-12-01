package io.angelwing;

import io.angelwing.service.ExpenseCategoryService;
import io.angelwing.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class,args);
    }

    @Bean
    public CommandLineRunner run(@Autowired final ExpenseService expenseService ,
                                 @Autowired final ExpenseCategoryService expenseCategoryService){

        return args -> {

        };
    }
}
