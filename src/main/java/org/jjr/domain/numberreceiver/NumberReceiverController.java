package org.jjr.domain.numberreceiver;

import org.jjr.domain.numberreceiver.dto.TicketDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/tickets")
public class NumberReceiverController {
    private NumberReceiverFacade numberReceiverFacade;

    @PostMapping
    public ResponseEntity<TicketDto> inputNumbers(Set<Integer> userNumbers) {
        TicketDto numbersFromUser = numberReceiverFacade.getNumbersFromUser(userNumbers);
        return ResponseEntity.status(HttpStatus.CREATED).body(numbersFromUser);
    }
}
