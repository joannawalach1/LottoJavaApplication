package org.jjr.domain.numberreceiver;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserNumberValidator {
    void validateNumbers(Set<Integer> userNumbers){
        long validCount = userNumbers.stream()
                .filter(number -> number >= 1 && number <= 99)
                .distinct()
                .count();

        if (validCount != 6) {
            throw new IllegalArgumentException("Musisz podać dokładnie 6 unikalnych liczb z zakresu 1–99!");
        }
    }
}
