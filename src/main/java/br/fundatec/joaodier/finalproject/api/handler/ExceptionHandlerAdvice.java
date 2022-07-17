package br.fundatec.joaodier.finalproject.api.handler;

import br.fundatec.joaodier.finalproject.api.handler.dto.ApiResponseDTO;
import br.fundatec.joaodier.finalproject.api.handler.dto.ErrorMessageDTO;
import br.fundatec.joaodier.finalproject.api.handler.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@RestControllerAdvice
public class ExceptionHandlerAdvice implements ResponseErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == CLIENT_ERROR ||
                response.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().series() == CLIENT_ERROR) {
            if (response.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new NotFoundException(response.getBody().toString());
        }
    }

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
