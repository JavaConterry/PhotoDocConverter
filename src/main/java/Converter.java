import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.Section;
import com.spire.doc.documents.Paragraph;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Converter {

    public String getImgText(String path) {
        ITesseract instance = new Tesseract();
        try {
            String imgText = instance.doOCR(new File(path));
            return imgText;
        } catch (TesseractException e) {
            e.getMessage();
            return "Error while reading image";
        }
    }

//    public void docFromText(String text, String outputDirectory) {
//            Document document = new Document();
//            Section section = document.addSection();
//            Paragraph para1 = section.addParagraph();
//            para1.appendText(text);
//            System.out.println(text);
//            System.out.println(outputDirectory);
//            document.saveToFile(outputDirectory, FileFormat.Docx);
//    }

    public void docFromText(String text, String outputDirectory, String name) {
        try {
            WordGenerator wg = new WordGenerator();
            wg.createWord(text, outputDirectory, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
