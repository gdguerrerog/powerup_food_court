/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.application.configuration;

import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import pragmafoodcourt.users.infrastructure.output.jpa.exception.UserAlreadyExistsException;

/**
 *
 * @author German at CLEZ
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Void> handleNoSuchElementException(NoSuchElementException ex){
        return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body(Map.of("message", "User already exists"));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(Map.of("details", ex.getAllErrors().stream().map(e -> e.getObjectName() + ": " + e.getDefaultMessage()).toList()));
    }
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> defaultErrorHandler(Exception e) throws Exception {
      if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) throw e;
      if (e instanceof ResponseStatusException responseStatusException) throw responseStatusException;
      
      return ResponseEntity.internalServerError().build();
    }
    
    
}
