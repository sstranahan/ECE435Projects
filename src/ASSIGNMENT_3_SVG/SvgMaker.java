package ASSIGNMENT_3_SVG;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class SvgMaker {
    private String fileName;
    private int imgWidth;
    private int imgHeight;

    private FileWriter myWriter;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public SvgMaker(String imageName, int width, int height) {
        this.fileName = imageName;
        this.imgWidth = width;
        this.imgHeight = height;
    }

    public void writeRootTag() throws IOException {

    }
}
