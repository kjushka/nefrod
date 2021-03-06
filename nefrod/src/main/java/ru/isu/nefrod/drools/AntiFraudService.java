package ru.isu.nefrod.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isu.nefrod.model.Transaction;
import ru.isu.nefrod.repository.TransactionRepository;

@Service
public class AntiFraudService {

    KieContainer kieContainer;
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    public AntiFraudService() {
        KieServices ks = KieServices.Factory.get();
        this.kieContainer = ks.getKieClasspathContainer();
    }

    public Transaction check(Transaction t) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rule");
        kieSession.insert(t);
        kieSession.fireAllRules();
        kieSession.dispose();
        saveTransaction(t);
        return t;
    }

    private void saveTransaction(Transaction t) {
        transactionRepository.save(t);
    }
}
