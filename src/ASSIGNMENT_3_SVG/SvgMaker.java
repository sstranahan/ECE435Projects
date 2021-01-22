package ASSIGNMENT_3_SVG;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class SvgMaker {
    public String fileName;
    public int imgWidth;
    public int imgHeight;

    private FileWriter myWriter;

    public SvgMaker(String imageName, int width, int height) {
        this.fileName = imageName;
        this.imgWidth = width;
        this.imgHeight = height;
    }

    public void writeRootTag() {
         //TODO: WRITE TO FILE, ETC, ETC
    }
}
