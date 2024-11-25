package com.backend.LosPostes.controller.WebSocket;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.backend.LosPostes.data.model.entity.DetalleOrden;

@Controller
public class WSOrdenController {
    
    @PostMapping("/orden1")
    @SendTo("/escuchar/canal1")
    public DetalleOrden getDetalleOrden(DetalleOrden orden){
        System.out.println("La orden es: " + orden);
        return orden;
    }
}
