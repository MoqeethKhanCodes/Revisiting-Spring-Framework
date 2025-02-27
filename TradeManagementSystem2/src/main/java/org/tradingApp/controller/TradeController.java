package org.tradingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tradingApp.model.TradeEntity;
import org.tradingApp.service.TradeService;

import java.util.UUID;

@RestController
@RequestMapping("/trades")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @PostMapping
    public ResponseEntity<TradeEntity> createTrade(@RequestParam String type) {
        return new ResponseEntity<>(tradeService.createTrade(type), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TradeEntity> getTrade(@PathVariable UUID id) {
        return ResponseEntity.ok(tradeService.getTrade(id));
    }

    @PutMapping("/{id}/next")
    public ResponseEntity<TradeEntity> moveToNextState(@PathVariable UUID id) {
        return ResponseEntity.ok(tradeService.moveToNextState(id));
    }
}