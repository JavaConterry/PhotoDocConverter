import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Converter {

    public String getImgText(String path) {
        ITesseract instance = new Tesseract();

        try
        {
            String imgText = instance.doOCR(new File(path));
            return imgText;
        }
        catch (TesseractException e)
        {
            e.getMessage();
            return "Error while reading image";
        }
    }

}
