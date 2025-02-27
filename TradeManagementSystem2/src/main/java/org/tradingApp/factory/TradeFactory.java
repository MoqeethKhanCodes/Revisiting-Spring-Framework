package org.tradingApp.factory;

import org.tradingApp.model.GasTrade;
import org.tradingApp.model.OilTrade;
import org.tradingApp.model.PowerTrade;
import org.tradingApp.model.TradeEntity;

import java.util.HashMap;
import java.util.Map;

public class TradeFactory {
    private static final Map<String, Class<? extends TradeEntity>> registry = new HashMap<>();

    static {
        registerTrade("PowerTrade", PowerTrade.class);
        registerTrade("GasTrade", GasTrade.class);
        registerTrade("OilTrade", OilTrade.class);
    }

    public static void registerTrade(String type, Class<? extends TradeEntity> tradeClass) {
        registry.put(type, tradeClass);
    }

    public static TradeEntity createTrade(String type) {
        Class<? extends TradeEntity> tradeClass = registry.get(type);
        if (tradeClass != null) {
            try {
                return tradeClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to create trade of type: " + type, e);
            }
        }
        throw new IllegalArgumentException("Unknown trade type: " + type);
    }
}