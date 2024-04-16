package com.lostfound.animalback.infrastructure;

import com.lostfound.animalback.infrastructure.error.ApiError;
import com.lostfound.animalback.infrastructure.exception.DataNotFoundException;
import com.lostfound.animalback.infrastructure.exception.ForbiddenException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiError> handleForbiddenException(ForbiddenException exception) {
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleDataNotFoundException(DataNotFoundException exception) {
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setErrorCode(exception.getErrorCode());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }


//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiError apiError = new ApiError();
//        String message = "Invalid request body content. ";
//        message = message + exception.getMessage();
//        apiError.setMessage(message);
//        apiError.setErrorCode(666);
//        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
//    }

//    @Override
//    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ApiError apiError = new ApiError();
//        apiError.setMessage("Invalid parameter type.");
//        apiError.setErrorCode(exception.getMessage());
//        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
//    }
//


//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        ApiError apiError = new ApiError();
//        String message = "Invalid request body content. ";
//        final List<String> errors = new ArrayList<>();
//        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
//            // default lahendus
//            // errors.add(error.getField() + ": " + error.getDefaultMessage());
//            errors.add(error.getDefaultMessage());
//        }
//        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//        }
//        message = message + errors.toString();
//        apiError.setMessage(message);
//        apiError.setErrorCode(666);
//        return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
//    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException exception,  HttpHeaders headers,  HttpStatus status, final WebRequest request) {
//        ApiError apiError = new ApiError();
//        apiError.setMessage("Invalid request body content.");
//        final List<String> errors = new ArrayList<>();
//        for (final FieldError error : exception.getBindingResult().getFieldErrors()) {
//            // default lahendus
//            // errors.add(error.getField() + ": " + error.getDefaultMessage());
//            errors.add(error.getDefaultMessage());
//        }
//        for (final ObjectError error : exception.getBindingResult().getGlobalErrors()) {
//            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//        }
//        apiError.setErrorCode(errors.toString());
//        return handleExceptionInternal(exception, apiError, headers, HttpStatus.BAD_REQUEST, request);
//    }

}
