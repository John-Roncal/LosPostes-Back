package com.backend.LosPostes.controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.LosPostes.service.ReportService;

@RestController
@RequestMapping("/admin/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/productos")
    public ResponseEntity<byte[]> generarReporte() {
        try {
            byte[] report = reportService.generarReport("ReporteProductos");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/empleados")
    public ResponseEntity<byte[]> generarReporte2() {
        try {
            byte[] report = reportService.generarReport("ReporteEmpleados");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/articulos")
    public ResponseEntity<byte[]> generarReporte3() {
        try {
            byte[] report = reportService.generarReport("ResumenDeProductos");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/ordenes")
    public ResponseEntity<byte[]> generarReporte4() {
        try {
            byte[] report = reportService.generarReport("Ordenes");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/mozo")
    public ResponseEntity<byte[]> generarReporte5() {
        try {
            byte[] report = reportService.generarReport("ReportePedidosPorMozo");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/boleta")
    public ResponseEntity<byte[]> generarReporte6() {
        try {
            byte[] report = reportService.generarReport("Boleta");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/boleta-simple")
    public ResponseEntity<byte[]> generarReporte7() {
        try {
            byte[] report = reportService.generarReport("BoletaSimple");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/factura")
    public ResponseEntity<byte[]> generarReporte8() {
        try {
            byte[] report = reportService.generarReport("Factura");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/sin-comprobante")
    public ResponseEntity<byte[]> generarReporte9() {
        try {
            byte[] report = reportService.generarReport("SinComprobante");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=report.pdf");
            return new ResponseEntity<>(report, headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
