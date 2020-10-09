package ru.isu.nefrod.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Transaction")
public class Transaction {
    @Id
    private String id;
    private String senderAccount;
    private String receiverAccount;
    private String countryFrom;
    private String cityFrom;
    private Integer failuresNumber;
    private String senderIP;
    private LocalDate transactionDate;
    private LocalTime transactionalTime;
    private String status;
}
