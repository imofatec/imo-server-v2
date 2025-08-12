package com.imo.imoserverv2.infra.errors;

import com.imo.imoserverv2.contexts.utils.errors.BadRequestError;
import com.imo.imoserverv2.contexts.utils.errors.ConflictError;
import com.imo.imoserverv2.contexts.utils.errors.ForbiddenError;
import com.imo.imoserverv2.contexts.utils.errors.NotFoundError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    // 400
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errorMessages = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        String errorMessage = errorMessages.get(0);
        String description = String.format("path: %s", request.getDescription(false));

        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(errorMessage, description);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    // 400
    @ExceptionHandler(BadRequestError.class)
    public final ResponseEntity<Object> handleBadRequestError(BadRequestError ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        String description = String.format("path: %s", request.getDescription(false));

        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(errorMessage, description);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    // 403
    @ExceptionHandler(ForbiddenError.class)
    public final ResponseEntity<Object> handleForbiddenError(ForbiddenError ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        String description = String.format("path: %s", request.getDescription(false));

        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(errorMessage, description);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.FORBIDDEN);
    }

    // 404Exception.class)
    //    public final ResponseEntity
    @ExceptionHandler(NotFoundError.class)
    public final ResponseEntity<Object> handleNotFoundError(NotFoundError ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        String description = String.format("path: %s", request.getDescription(false));

        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(errorMessage, description);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    // 409
    @ExceptionHandler(ConflictError.class)
    public final ResponseEntity<Object> handleConflictError(ConflictError ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        String description = String.format("path: %s", request.getDescription(false));

        ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(errorMessage, description);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.CONFLICT);
    }
}
