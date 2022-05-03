import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordGenerator {
    public void createWord(String text, String outputDirectory, String name) throws IOException {
        if (!Paths.get(outputDirectory).toFile().exists()) Files.createDirectories(Paths.get(outputDirectory));
        XWPFDocument document = new XWPFDocument();
        FileOutputStream out = new FileOutputStream( outputDirectory + name + ".docx");
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        document.write(out);
        out.close();
        System.out.println("createdWord" + "_" + name + ".docx" + " written successfully");
    }
}
