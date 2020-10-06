package ru.isu.nefrod.controller;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.isu.nefrod.model.Product;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String getName() {
        return "home_form";
    }

    @RequestMapping(value = "/discount", method = RequestMethod.POST)
    public String showDiscont(@RequestParam(name = "product") String type, Model model) {
        Product product = getDiscount(type);
        model.addAttribute("product", product);
        return "show_discount";
    }

    private Product getDiscount(String type) {
        Product product = new Product();
        product.setType(type);
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            //Get the session named kseesion-rule that we defined in kmodule.xml above.
            //Also by default the session returned is always stateful.
            KieSession kSession = kContainer.newKieSession("ksession-rule");
            FactHandle fact1;
            fact1 = kSession.insert(product);
            kSession.fireAllRules();

            System.out.println("The discount for the jewellery product "
                    + product.getType() + " is " + product.getDiscount());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return product;
    }
}
