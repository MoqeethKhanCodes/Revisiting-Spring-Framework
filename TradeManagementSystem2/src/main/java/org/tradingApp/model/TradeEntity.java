package org.tradingApp.model;

import jakarta.persistence.*;
import org.tradingApp.state.TradeState;

import java.util.UUID;

@Entity
@Table(name = "trades")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "trade_type", discriminatorType = DiscriminatorType.STRING)
public abstract class TradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String tradeType;

    @Enumerated(EnumType.STRING)
    private TradeState state;

    protected TradeEntity(String tradeType) {
        this.tradeType = tradeType;
        this.state = TradeState.NEW_STATE;
    }

    public UUID getId() { return id; }
    public String getTradeType() { return tradeType; }
    public TradeState getState() { return state; }
    public void setState(TradeState state) { this.state = state; }
    public void moveToNextState() {
        if (state == TradeState.MATURED) {
            throw new IllegalStateException("Trade is already executed");
        }
        state = state.next();
    }
}