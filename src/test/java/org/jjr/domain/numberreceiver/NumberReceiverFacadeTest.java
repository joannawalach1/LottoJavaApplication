package org.jjr.domain.numberreceiver;

import org.jjr.domain.numberreceiver.dto.TicketDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.InvalidMidiDataException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberReceiverFacadeTest {
    NumberReceiverFacade numberReceiverFacade;

    @BeforeEach
    void setUp() {
        numberReceiverFacade = new NumberReceiverFacade();
    }

    @Test
    void should_return_ticket_if_users_gave_six_numbers() {
        //given
        Set<Integer> userNumbers = Set.of(1, 2, 3, 4, 5, 6);
        //when
        TicketDto result = numberReceiverFacade.getNumbersFromUser(userNumbers);
        //then
        assertEquals(result.userNumbers().size(), userNumbers.size());
    }

    @Test
    void should_return_exception_if_users_gave_less_than_six_numbers() {
        Set<Integer> userNumbers = Set.of(1, 2, 3, 4, 5);
        //when
        //then
        InvalidDataException invalidDataException = assertThrows(InvalidDataException.class, () ->
                numberReceiverFacade.getNumbersFromUser(userNumbers)
        );
        assertEquals("", invalidDataException.getMessage());
    }

    @Test
    void should_return_exception_if_users_gave_more_than_six_numbers() {
        Set<Integer> userNumbers = Set.of(1, 2, 3, 4, 5, 6, 7);
        //when
        //then
        InvalidDataException invalidDataException = assertThrows(InvalidDataException.class, () ->
                numberReceiverFacade.getNumbersFromUser(userNumbers)
        );
        assertEquals("", invalidDataException.getMessage());
    }

    @Test
    void should_return_exception_if_even_one_number_is_out_of_range() {
        Set<Integer> userNumbers = Set.of(1, 2, 3, 4, 5, 1000);
        //when
        //then
        InvalidDataException invalidDataException = assertThrows(InvalidDataException.class, () ->
                numberReceiverFacade.getNumbersFromUser(userNumbers)
        );
        assertEquals("", invalidDataException.getMessage());
    }
}