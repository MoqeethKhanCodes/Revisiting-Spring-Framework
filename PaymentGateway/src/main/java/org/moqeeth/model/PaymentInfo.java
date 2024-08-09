package org.moqeeth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Payments")
@Getter
@Setter
@NoArgsConstructor
public class PaymentInfo {

    @Id
    private String id;
    private String name;
    private double amount;
    private String currency;
    private Date date;

    public PaymentInfo(String name, double amount, String currency, Date date) {
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
    }
}
