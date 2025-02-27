package org.tradingApp.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PowerTrade")
public class PowerTrade extends TradeEntity {
    public PowerTrade() {
        super("PowerTrade");
    }
}

