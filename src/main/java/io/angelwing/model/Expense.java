package io.angelwing.model;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="expense")
public class Expense {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private ExpenseCategory expenseCategory;

    private String name;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDateTime date;

    public Expense() {
        // NOOP
    }

    public Expense(UUID id, ExpenseCategory expenseCategory, String name, Double amount, Currency currency, LocalDateTime date) {
        this.id = id;
        this.expenseCategory = expenseCategory;
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenseCategory=" + expenseCategory +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", currency=" + currency +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) && Objects.equals(expenseCategory, expense.expenseCategory) && Objects.equals(name, expense.name) && Objects.equals(amount, expense.amount) && currency == expense.currency && Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expenseCategory, name, amount, currency, date);
    }
}
