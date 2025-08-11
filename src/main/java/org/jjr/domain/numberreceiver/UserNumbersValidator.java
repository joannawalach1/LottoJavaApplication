package org.jjr.domain.numberreceiver;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
class UserNumbersValidator {
    void validateUserNumbers(Set<Integer> userNumbers) {
        long validCount = userNumbers.stream()
                .filter(number -> number >= 1 && number <= 99)
                .distinct()
                .count();

        if (validCount != 6) {
            throw new IllegalArgumentException("Numbers must be between 1 and 99");
        }
    }
}
