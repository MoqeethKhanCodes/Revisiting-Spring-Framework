package org.tradingApp.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GasTrade")
public class GasTrade extends TradeEntity {
    public GasTrade() { super("GasTrade"); }
}
