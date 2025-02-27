package org.tradingApp.model;

import org.tradingApp.state.TradeState;

import java.util.UUID;

public interface Trade {

    UUID getId();

    String getType();

    void setState(TradeState state);

    void moveToNextState();


}
