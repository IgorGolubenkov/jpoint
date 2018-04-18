package com.bit.test.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Bank {

    @Id
    private Long id;
    private Long totalAmount;

    public void credit(Long amount) {
        totalAmount -= amount;
    }
}
