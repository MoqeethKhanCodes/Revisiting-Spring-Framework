package org.tradingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tradingApp.model.TradeEntity;

import java.util.UUID;

public interface TradeRepository extends JpaRepository<TradeEntity, UUID> {
}