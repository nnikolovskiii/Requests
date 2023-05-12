package mk.ukim.finki.application.model.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.application.model.enums.ApplicationType;

import java.time.LocalDateTime;

@Data
public class ApplicationDto {

    @NotNull
    private LocalDateTime dateFrom;

    @NotNull
    private LocalDateTime dateTo;

    @NotNull
    private ApplicationType applicationType;
}