package org.tradingApp.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("OilTrade")
public class OilTrade extends TradeEntity {
    public OilTrade() { super("OilTrade"); }
}
