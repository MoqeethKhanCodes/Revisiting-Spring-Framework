package org.tradingApp.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TradeNotFoundException extends RuntimeException {
    public TradeNotFoundException(String message) {
        super(message);
    }
}
