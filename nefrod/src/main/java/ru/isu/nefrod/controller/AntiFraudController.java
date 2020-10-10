package ru.isu.nefrod.controller;

import org.kie.api.cdi.KSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.isu.nefrod.drools.AntiFraudService;
import ru.isu.nefrod.model.Card;
import ru.isu.nefrod.model.Registr;
import ru.isu.nefrod.model.Transaction;
import ru.isu.nefrod.model.User;
import ru.isu.nefrod.repository.CardRepository;
import ru.isu.nefrod.repository.UserRepository;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/nefrod/frod")
public class AntiFraudController {

    @Autowired
    AntiFraudService antiFraudService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CardRepository cardRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/transaction",
    produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Transaction addTransaction(@RequestBody Transaction t) {
        return antiFraudService.check(t);
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST,
    consumes = {MediaType.APPLICATION_JSON_VALUE})
    public boolean login(@RequestBody User user) {
        if (user.getLogin() != "" && user.getPass() != "") {
            return true;
        }
        else return false;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/addcard")
    public String addCard(@RequestBody Card card){
        cardRepository.save(card);
        return KSession.class.toString();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/userreset", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String userRESet(@RequestBody User user){
        userRepository.save(user);
        return KSession.class.toString();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public String registr(@RequestBody Registr reg){
        userRepository.save(reg.getUser());
        cardRepository.save(reg.getCard());
        return KSession.class.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserInfo(@PathVariable("id") String id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
}
