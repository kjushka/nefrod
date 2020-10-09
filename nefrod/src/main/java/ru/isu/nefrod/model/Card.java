package ru.isu.nefrod.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document(collection = "Card")
public class Card {
    @Id
    private String id;
    @Indexed(unique = true)
    private String number;
    //private String pass;
    //private LocalDate endDate;
    //private String cvv2;
    //private String account;
    private Double balance;
    private User owner;
}
