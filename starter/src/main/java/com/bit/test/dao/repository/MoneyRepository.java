package com.bit.test.dao.repository;

import com.bit.test.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Bank, Long> {
}
