package br.fundatec.joaodier.finalproject.api.handler;

import br.fundatec.joaodier.finalproject.api.handler.dto.ApiResponseDTO;
import br.fundatec.joaodier.finalproject.api.handler.dto.ErrorMessageDTO;
import br.fundatec.joaodier.finalproject.api.handler.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Set;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(Throwable.class)
    ResponseEntity<String> unkownExceptionHandler(Throwable exception) {
        logger.error(exception.getMessage(), exception);
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ApiResponseDTO> notFoundHandlerException(NotFoundException exception) {
        logger.error(exception.getMessage(), exception);

        Set<ErrorMessageDTO> errors = Set.of(ErrorMessageDTO.builder()
                .message("Whoops, not found")
                .build());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponseDTO.builder()
                        .time(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND)
                        .errors(errors)
                        .build());
    }
}
