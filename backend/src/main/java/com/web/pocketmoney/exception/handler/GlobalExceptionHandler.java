package com.web.pocketmoney.exception.handler;

import com.web.pocketmoney.exception.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice //모든 컨트롤러에서 발생하는 exception 처리
public class GlobalExceptionHandler {

    @ExceptionHandler(ChatRoomNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleChatRoomNotFoundException(ChatRoomNotFoundException ex){
        log.error("handleChatRoomNotFoundException", ex);
        ErrorResponse response = new ErrorResponse(ex.getErrorCode());
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler({CBoardIdFailedException.class, CCommentIdFindFailedException.class,
            CEmailSigninFailedException.class, CEmailSignupFailedException.class,
            CNickNameSignupFailedException.class, CPasswordSigninFailedException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(
            Exception e) {
        ErrorResponse response = new ErrorResponse(ErrorCode.NOT_FOUND, e.getMessage());
        log.info(response.toString());
        return ResponseEntity.status(HttpStatus.valueOf(response.getStatus()))
                .body(response);
    }

    @ExceptionHandler({CNoBoardAndUserException.class,CNotSameUserException.class,
            CUserNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotSameException(
            Exception e) {
        ErrorResponse response = new ErrorResponse(ErrorCode.FORBIDDEN, e.getMessage());
        return ResponseEntity.status(HttpStatus.valueOf(response.getStatus()))
                .body(response);

    }
}
