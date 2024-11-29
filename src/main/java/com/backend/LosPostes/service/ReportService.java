package com.backend.LosPostes.service;

import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.util.Map;

import javax.sql.DataSource;

@Service
public class ReportService {

    private final DataSource dataSource;

    public ReportService(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public byte [] generarReport(String reportName) throws Exception{
        //Cargar el reporte
        InputStream reportStream = this.getClass().getResourceAsStream("/reports/"+reportName+".jasper");

        Map<String,Object> parms = null;
        //Llenado
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream,parms, dataSource.getConnection());
        //Exporta a un report pdf
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
