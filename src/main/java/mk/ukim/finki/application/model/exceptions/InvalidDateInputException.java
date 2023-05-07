package mk.ukim.finki.application.model.exceptions;

import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvalidDateInputException extends RuntimeException{

    public InvalidDateInputException(LocalDateTime dateFrom, LocalDateTime dateTo) {
        super(String.format("Date From: %s should be before Date To: %s",dateFrom, dateTo));
    }
}
