package com.ecommerce.emazon.infrastructure.exceptionhandler;

import com.ecommerce.emazon.domain.exception.InvalidDescriptionCategoryException;
import com.ecommerce.emazon.domain.exception.InvalidNameCategoryException;
import com.ecommerce.emazon.infrastructure.exception.ErrorResponse;
import com.ecommerce.emazon.infrastructure.exception.NotFoundCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidNameCategoryException.class)
    public ResponseEntity<ErrorResponse> handleInvalidNameException(InvalidNameCategoryException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "NOMBRE_INVALIDO");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDescriptionCategoryException.class)
    public ResponseEntity<ErrorResponse> handleInvalidDescriptionException(InvalidDescriptionCategoryException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "DESCRIPCION_INVALIDA");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundCategory.class)
    public ResponseEntity<ErrorResponse> handlerNotFoundCategoryException(NotFoundCategory ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "LA CATEGORIA NO SE PUDO ENCONTRAR");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse("Ha ocurrido un error interno. Por favor, inténtalo de nuevo más tarde.", "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
