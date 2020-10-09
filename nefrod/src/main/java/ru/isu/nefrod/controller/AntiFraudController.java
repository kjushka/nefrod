package ru.isu.nefrod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.isu.nefrod.drools.AntiFraudService;
import ru.isu.nefrod.model.Transaction;

@RestController
@RequestMapping(value = "/transaction")
public class AntiFraudController {

    @Autowired
    AntiFraudService antiFraudService;

    @RequestMapping(method = RequestMethod.POST)
    public Transaction addTransaction(@RequestBody Transaction t) {
        return antiFraudService.check(t);
    }
}
