package ASSIGNMENT_3_SVG;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class SvgMaker {
    public String imageName;
    public int width;
    public int height;

    private FileWriter myWriter;

    public SvgMaker(String imageName, int width, int height) {
        this.imageName = imageName;
        this.width = width;
        this.height = height;
    }

    public void writeRootTag() {
         //TODO: WRITE TO FILE, ETC, ETC
    }
}
