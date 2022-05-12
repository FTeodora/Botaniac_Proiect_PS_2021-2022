package com.botaniac.plantsservice.fileManagers.writers;

import com.botaniac.plantsservice.DTO.PlantPageDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class PlantPDFGenerator implements FileGenerator<PlantPageDTO>{
    @Override
    public File generateFile(PlantPageDTO object) {
        try{
            PDDocument document = new PDDocument();
            PDPage page=new PDPage();
            document.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            PDFont font = PDType1Font.COURIER;
            contentStream.newLineAtOffset(50, 700);
            contentStream.setFont(font, 18);
            contentStream.showText(object.getCommonName());
            contentStream.newLineAtOffset(50, 680);
            contentStream.showText(object.getScientificName());
            contentStream.newLineAtOffset(50, 660);
            contentStream.showText(object.getType().toString());
            contentStream.newLineAtOffset(50, 640);
            contentStream.showText("Native continent:"+object.getNativeContinent());
            contentStream.endText();
            contentStream.close();
            document.save(object.getCommonName()+".pdf");
            document.close();
            File f=new File(object.getCommonName()+".pdf");
            return f;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
