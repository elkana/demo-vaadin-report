package com.example.demovaadinreport.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demovaadinreport.service.ServicePdf;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;


@RestController
public class ControllerPdf {
    
    @Autowired ServicePdf svc;
    
    @GetMapping("/pdf")
    public void getPdf(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=pdf_123.pdf");
        
        svc.export(response);
    }
    
}
