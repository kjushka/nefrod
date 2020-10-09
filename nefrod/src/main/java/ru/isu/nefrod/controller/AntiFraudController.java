package ru.isu.nefrod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.isu.nefrod.drools.AntiFraudService;
import ru.isu.nefrod.model.Transaction;
import ru.isu.nefrod.model.User;

@RestController
@RequestMapping(value = "/nefrod/frod")
public class AntiFraudController {

    @Autowired
    AntiFraudService antiFraudService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/transaction",
    produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Transaction addTransaction(@RequestBody Transaction t) {
        return antiFraudService.check(t);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String home(@PathVariable("id") String id) {
        return "home " + id + " is welcome";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_JSON_VALUE})
    public boolean login(@RequestBody User user) {
        if (user.getLogin() != "" && user.getPass() != "") {
            return true;
        }
        else return false;
    }
}
