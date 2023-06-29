package me.pj.gameawards.controller;

import me.pj.gameawards.service.exception.BusinessException;
import me.pj.gameawards.service.exception.NoContentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public abstract class BaseRestController {

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Void> handlerNoContentException(NoContentException exception){
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorDto> handlerBusinessException(BusinessException exception){
        ApiErrorDto error = new ApiErrorDto(exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorDto> handlerUnexpectedException(Throwable exception){
        //exception.printStackTrace();  // mostra a exceção no console. Não deixar quando subir para produção
        ApiErrorDto error = new ApiErrorDto("Ops, ocorreu um erro inesperado");
        return ResponseEntity.internalServerError().body(error);
    }
}
