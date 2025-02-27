package org.tradingApp.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTradeStateException extends RuntimeException {
    public InvalidTradeStateException(String message) {
        super(message);
    }
}
