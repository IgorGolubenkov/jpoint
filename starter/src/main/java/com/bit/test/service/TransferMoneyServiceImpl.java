package com.bit.test.service;

import com.bit.test.dao.repository.MoneyRepository;
import com.bit.test.model.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransferMoneyServiceImpl implements TransferMoneyService {

    private final MoneyRepository moneyRepository;
    private final ProphetService prophetService;

    @Override
    public Long transfer(String addresseeName, Long amount) {
        Bank bank = moneyRepository.findAll().get(0);

        if (bank.getTotalAmount() > amount
                && prophetService.willSurvice(addresseeName)) {
            bank.credit(amount);
            return moneyRepository.save(bank).getTotalAmount();
        }
        return -1L;
    }
}
