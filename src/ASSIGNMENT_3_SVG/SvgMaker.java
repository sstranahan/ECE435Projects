package ASSIGNMENT_3_SVG;

import java.io.*;

public class SvgMaker {

    private String fileName;
    private int imgWidth;
    private int imgHeight;

    private PrintWriter myWriter;

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
        myWriter = null;
    }

    public void initFileWriter() {
        try{
            myWriter = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeRootTag() {
            myWriter.println("<svg\n\t" +
                    "xmlns = 'http://www.w3.org/2000/svg'\n\t" +
                    "xmlns:xlink = 'http://www.w3.org/1999/xlink'\n\t" +
                    "version = '1.1'\n\t" +
                    "width = '" + imgWidth + "' height = '" + imgHeight + "'>");
    }

    public void writeClosingTag() {
        myWriter.println("</svg>");
        myWriter.close();
    }

    public void drawLine (Line line) {
        myWriter.print("<line x1 = '" + line.getX1() + "' y1 = '" + line.getY1() + "'\n\t" +
                "x2 = '" + line.getX2() + "' y2 = '" + line.getY2() + "'\n\t" +
                "stroke = 'rgb(" + line.getStroke().getRed() + "," + line.getStroke().getGreen()
                + "," + line.getStroke().getBlue() + ")' stroke-width = '" + line.getStroke().getStrokeWidth() + "'");

        if (line.getStroke() instanceof DashedStroke) {
            myWriter.print(" stroke-dasharray = '");
            for (int i = 0; i < ((DashedStroke) line.getStroke()).dashArray.length; i++) {
                myWriter.print(((DashedStroke) line.getStroke()).dashArray[i] + " ");
            }
            myWriter.print("'");
        }
        myWriter.println("/>");
    }

    public void drawRectangle (Rectangle rectangle) {
        myWriter.print("<rect x = '" + rectangle.getX() + "' y = '" + rectangle.getY() + "'\n\t" +
                " width = '" + rectangle.getWidth() + "' height = '" + rectangle.getLength() + "'\n\t" +
                "stroke = 'rgb(" + rectangle.getStroke().getRed() + "," + rectangle.getStroke().getGreen()
                + "," + rectangle.getStroke().getBlue() + ")' stroke-width = '"
                + rectangle.getStroke().getStrokeWidth() + "'");

        if (rectangle instanceof RoundedRectangle) {
            myWriter.print(" rx = '" + ((RoundedRectangle) rectangle).rx + "'");
        }

        if (rectangle.getStroke() instanceof DashedStroke) {
            myWriter.print(" stroke-dasharray = '");
            for (int i = 0; i < ((DashedStroke) rectangle.getStroke()).dashArray.length; i++) {
                myWriter.print(((DashedStroke) rectangle.getStroke()).dashArray[i] + " ");
            }
            myWriter.print("'");
        }
        myWriter.println(" fill = 'rgb(" + rectangle.getFill().getRed() + ", " + rectangle.getFill().getGreen() + ", "
                + rectangle.getFill().getBlue() + ")' opacity = '" + rectangle.getFill().getOpacity() + "' />");
    }

    public void drawCircle (Circle circle) {
        myWriter.print("<circle cx = '" + circle.getCx() + "' cy = '" + circle.getCy() + "'\n\t" +
                " r = '" + circle.getR() + "' stroke = 'rgb(" + circle.getStroke().getRed() + ","
                + circle.getStroke().getGreen() + "," + circle.getStroke().getBlue() + ")' stroke-width = '"
                + circle.getStroke().getStrokeWidth() + "'");

        if (circle.getStroke() instanceof DashedStroke) {
            myWriter.print(" stroke-dasharray = '");
            for (int i = 0; i < ((DashedStroke) circle.getStroke()).dashArray.length; i++) {
                myWriter.print(((DashedStroke) circle.getStroke()).dashArray[i] + " ");
            }
            myWriter.print("'");
        }
        myWriter.println(" fill = 'rgb(" + circle.getFill().getRed() + ", " + circle.getFill().getGreen() + ", "
                + circle.getFill().getBlue() + ")' opacity = '" + circle.getFill().getOpacity() + "' />");
    }

    public void drawPath(Path path) {
        myWriter.print("<path d = '" + path.getdString() + "' stroke = 'rgb(" + path.getStroke().getRed() + ","
                + path.getStroke().getGreen() + "," + path.getStroke().getBlue() + ")' stroke-width = '"
                + path.getStroke().getStrokeWidth() + "'");

        if (path.getStroke() instanceof DashedStroke) {
            myWriter.print(" stroke-dasharray = '");
            for (int i = 0; i < ((DashedStroke) path.getStroke()).dashArray.length; i++) {
                myWriter.print(((DashedStroke) path.getStroke()).dashArray[i] + " ");
            }
            myWriter.print("'");
        }
        myWriter.println(" fill = 'rgb(" + path.getFill().getRed() + ", " + path.getFill().getGreen() + ", "
                + path.getFill().getBlue() + ")' opacity = '" + path.getFill().getOpacity() + "' />");
    }
}


