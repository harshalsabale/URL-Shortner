package com.sprout.URLShortner.infrastructure;

import com.sprout.URLShortner.common.dto.ResponseDTO;
import com.sprout.URLShortner.common.exception.NotFoundException;
import com.sprout.URLShortner.common.exception.ValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.sprout.URLShortner.common.constant.ErrorMessageConstant.NOT_FOUND_ERROR;
import static com.sprout.URLShortner.common.constant.ErrorMessageConstant.SOMETHING_WENT_WRONG;
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

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ResponseDTO handleNotFoundException(final NotFoundException ex) {
        return new ResponseDTO(
                NOT_FOUND.value(),
                NOT_FOUND.getReasonPhrase(),
                NOT_FOUND_ERROR);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseDTO handleException(final Exception ex) {
        return new ResponseDTO(
                INTERNAL_SERVER_ERROR.value(),
                INTERNAL_SERVER_ERROR.getReasonPhrase(),
                SOMETHING_WENT_WRONG);
    }

}
