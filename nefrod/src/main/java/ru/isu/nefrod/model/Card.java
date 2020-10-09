package ru.isu.nefrod.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long id;
    private String number;
    //private String pass;
    //private LocalDate endDate;
    //private String cvv2;
    //private String account;
    private Double balance;
    private User owner;
}
