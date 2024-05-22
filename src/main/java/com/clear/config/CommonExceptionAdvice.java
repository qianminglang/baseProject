package com.clear.config;

import com.clear.exception.BizIllegalException;
import com.clear.exception.CommonException;
import com.clear.domain.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CommonExceptionAdvice {

    @ExceptionHandler(BizIllegalException.class)
    public Object handleDbException(BizIllegalException e) {
        log.error("业务异常 -> ", e);
        return processResponse(e);
    }

    @ExceptionHandler(CommonException.class)
    public Object handleBadRequestException(CommonException e) {
        log.error("自定义异常 -> {} , 异常原因：{}  ",e.getClass().getName(), e.getMessage());
        log.debug("", e);
        return processResponse(e);
    }
    private ResponseEntity<R<Void>> processResponse(CommonException e){
        return ResponseEntity.status(e.getCode()).body(R.error(e));
    }
}
