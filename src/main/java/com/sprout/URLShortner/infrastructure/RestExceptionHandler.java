package com.sprout.URLShortner.infrastructure;

import com.sprout.URLShortner.common.dto.ResponseDTO;
import com.sprout.URLShortner.common.exception.ValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ResponseDTO handleBadRequest(final ValidationException ex) {
        return new ResponseDTO(
                BAD_REQUEST.value(),
                BAD_REQUEST.getReasonPhrase(),
                ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseDTO handleException(final Exception ex) {
        return new ResponseDTO(
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Something went wrong");
    }

}
