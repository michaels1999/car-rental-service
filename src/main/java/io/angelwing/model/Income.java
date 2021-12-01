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
@Table(name = "income")
public class Income {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private IncomeCategory incomeCategory;

    private String name;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDateTime date;

    public Income() {
        // NOOP
    }

    public Income(UUID id, IncomeCategory incomeCategory, String name, Double amount, Currency currency, LocalDateTime date) {
        this.id = id;
        this.incomeCategory = incomeCategory;
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

    public IncomeCategory getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(IncomeCategory incomeCategory) {
        this.incomeCategory = incomeCategory;
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
        return "Income{" +
                "id=" + id +
                ", incomeCategory=" + incomeCategory +
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
        Income income = (Income) o;
        return Objects.equals(id, income.id) && Objects.equals(incomeCategory, income.incomeCategory) && Objects.equals(name, income.name) && Objects.equals(amount, income.amount) && currency == income.currency && Objects.equals(date, income.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incomeCategory, name, amount, currency, date);
    }
}
