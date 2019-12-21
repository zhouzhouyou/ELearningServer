package yuri.elearning.server.util;

import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class RF {
    public static <T> ResponseEntity<T> success(T t) {
        return new ResponseEntity<>(t, OK);
    }

    public static <T> ResponseEntity<T> badRequest(T t) {
        return new ResponseEntity<>(t, BAD_REQUEST);
    }

    public static <T> ResponseEntity<T> notFound(T t) {
        return new ResponseEntity<>(t, NOT_FOUND);
    }

    public static <T> ResponseEntity<T> unauthorized(T t) {
        return new ResponseEntity<>(t, UNAUTHORIZED);
    }
}