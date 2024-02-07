package com.example.demovaadinreport.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ServicePdf {

    public PdfPTable export(HttpServletResponse response) throws DocumentException, IOException {
        var document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        var title = new Paragraph("Product Information", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        var paragraph2 = new Paragraph("Below is the information of current product");
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(paragraph2);

        var paragraph3 = new Paragraph(" ");    // harus ada spasinya
        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(paragraph3);

        var table = new PdfPTable(3);
        table.addCell("Header1");
        table.addCell("Header2");
        table.addCell("Header3");

        table.addCell("Column 1");
        table.addCell("Column 2");
        table.addCell("Column 3");

        document.add(table);
        document.close();
        return table;
    }

    
}
