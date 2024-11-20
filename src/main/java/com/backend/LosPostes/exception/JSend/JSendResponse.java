package com.backend.LosPostes.exception.JSend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class JSendResponse {
    public static ResponseEntity<Object> success(Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<Object> fail(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "fail");
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Object> error(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
