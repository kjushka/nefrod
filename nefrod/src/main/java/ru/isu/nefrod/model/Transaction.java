package ru.isu.nefrod.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
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
