package org.tradingApp.state;

public enum TradeState {
    NEW_STATE {
        @Override
        public TradeState next() { return VALIDATED; }
    },
    VALIDATED {
        @Override
        public TradeState next() { return MATURED; }
    },
    MATURED {
        @Override
        public TradeState next() { throw new IllegalStateException("Trade is already Executed"); }
    };
    public abstract TradeState next();
}
