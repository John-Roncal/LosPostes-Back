package com.backend.LosPostes.controller.WebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.backend.LosPostes.data.model.entity.DetalleOrden;

@Controller
public class WSOrdenController {
    @MessageMapping("/orden1")
    @SendTo("/escuchar/canal1")
    public DetalleOrden getDetalleOrden(DetalleOrden orden) {
        System.out.println("La orden es: " + orden);
        return orden;
    }
}