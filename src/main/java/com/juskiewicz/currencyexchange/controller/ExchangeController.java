package com.juskiewicz.currencyexchange.controller;

import com.juskiewicz.currencyexchange.model.Exchange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.ValidationException;


@RestController
public class ExchangeController {

    @GetMapping("/exchange/gbp-to-usd/{value}")
    Exchange currencyExchange(@PathVariable Double value ) throws ValidationException {

        if(value >= 0.0)
            return new Exchange(value, 1.3);
        else if(value < 0.0) throw new ValidationException("only positive values can be converted");
        else throw new ValidationException("cannot convert");

    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<String> exceptionHandler(ValidationException e) {

        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
