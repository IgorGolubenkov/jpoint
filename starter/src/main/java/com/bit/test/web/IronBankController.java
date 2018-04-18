package com.bit.test.web;

import com.bit.test.dao.repository.MoneyRepository;
import com.bit.test.service.TransferMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequiredArgsConstructor
public class IronBankController {
    private final TransferMoneyService transferService;
    private final MoneyRepository moneyRepository;

    @GetMapping("/credit")
    public String credit(@RequestParam String name,
                         @RequestParam Long amount) {
        Long resultedDeposit = transferService.transfer(name, amount);
        if (resultedDeposit == -1) {
            return format(
                    "Rejected<br/>%s <b>will't</b> survive this winter",
                    name
            );
        }
        return format(
                "<i>Credit approved for %s</i> <br/>Current bank balance: <b>%s</b>",
                name,
                resultedDeposit
        );
    }

    @GetMapping("/state")
    public Long currentState() {
        return moneyRepository.findAll().get(0).getTotalAmount();
    }
}
