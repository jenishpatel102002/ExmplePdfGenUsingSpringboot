package com.example.demo;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ServiceClass implements ServiceInterface{
    @Autowired
    JpaRepoInterface jpaRepoInterface;
    @Override
    public ResponseEntity<InputStreamResource> getpdffrom(String startdate, String enddate) {


        List<employee> employeeList= jpaRepoInterface.ListOfEmployee(startdate, enddate);
        ByteArrayOutputStream by =new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(by);
        PdfDocument doc= new PdfDocument(writer);
        doc.addNewPage();
        Document document= new Document(doc);
        Table t= new Table(3);
        for(employee em: employeeList){
            Cell c1= new Cell();
            Cell c2= new Cell();
            Cell c3= new Cell();
            c1.add(new Paragraph(em.getId()));
            c2.add(new Paragraph(em.getName()));
            c3.add(new Paragraph(em.getDate().toString()));
            t.addCell(c1);
            t.addCell(c2);
            t.addCell(c3);
        }
        document.add(t);
        document.close();
        doc.close();
         //pdf convert to byte array and also required to tell which type of response given by api
        HttpHeaders hd=new HttpHeaders();
        hd.add("Content-Disposition","inline;file=jenish.pdf");
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .headers(hd)
                .body(new InputStreamResource(new ByteArrayInputStream(by.toByteArray())));
    }
}
