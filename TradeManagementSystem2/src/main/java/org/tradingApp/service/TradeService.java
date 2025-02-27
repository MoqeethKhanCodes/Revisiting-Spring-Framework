package org.tradingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tradingApp.factory.TradeFactory;
import org.tradingApp.handler.TradeNotFoundException;
import org.tradingApp.model.TradeEntity;
import org.tradingApp.repo.TradeRepository;

import java.util.UUID;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public TradeEntity createTrade(String type) {
        TradeEntity trade = TradeFactory.createTrade(type);
        return tradeRepository.save(trade);
    }

    public TradeEntity getTrade(UUID id) {
        return tradeRepository.findById(id).orElseThrow(() -> new TradeNotFoundException("Trade not found"));
    }

    public TradeEntity moveToNextState(UUID id) {
        TradeEntity trade = getTrade(id);
        trade.moveToNextState();
        return tradeRepository.save(trade);
    }
}

