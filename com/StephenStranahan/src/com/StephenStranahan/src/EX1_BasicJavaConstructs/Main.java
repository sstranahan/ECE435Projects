package com.StephenStranahan.src.EX1_BasicJavaConstructs;

import com.StephenStranahan.src.EX1_BasicJavaConstructs.MyArray;
import com.StephenStranahan.src.EX1_BasicJavaConstructs.IntRef;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static final int NUM_RECS = 20;

    public static void main(String[] args) {

        int[] myArr;
        myArr = MyArray.setupRandArray(NUM_RECS,1,100);

        MyArray.printArray(NUM_RECS, myArr, "Scores");
        System.out.println();

        System.out.println("Average: " + MyArray.getAverage(NUM_RECS,myArr));
        System.out.println();

        System.out.println("Sigma: " + MyArray.getStandardDev(NUM_RECS,myArr));
        System.out.println();

        System.out.println("Max: " + MyArray.getMaximum(NUM_RECS,myArr));
        System.out.println();

        System.out.println("Number of Bs: " + MyArray.getCountInRange(NUM_RECS, myArr, 80, 90));
        System.out.println();

        int[] aGradeArr;
        IntRef numAs = new IntRef();

        aGradeArr = MyArray.getValuesInRange(NUM_RECS, myArr, 90, 100, numAs);
        MyArray.printArray(NUM_RECS, aGradeArr, "Array of As");
        System.out.println();

        System.out.println("Number of As: " + numAs.value);
        System.out.println();

        int[] bGradeIdxArr;
        IntRef numBIdxs = new IntRef();

        bGradeIdxArr = MyArray.getIndexInRange(NUM_RECS, myArr, 80, 90, numBIdxs);
        MyArray.printArray(NUM_RECS, bGradeIdxArr, "Indexes of Bs");
        System.out.println();

        System.out.println("Number of B indexes: " + numBIdxs.value);
        System.out.println();

        String fileName = "com/StephenStranahan/src/com/StephenStranahan/src/EX1_BasicJavaConstructs/music.csv";
        Scanner inFile = null;

        String line = "\0";
        String[][] stringArr = new String[5][6];

        try {

            inFile = new Scanner(new File(fileName));

            int i = 0;

            while(inFile.hasNextLine()) {
                line = inFile.nextLine();
                stringArr[i] = line.split(",");
                i++;
            }

        } catch(FileNotFoundException e) {
            System.out.println("Error: File not found - terminating");
            System.exit(0);
        }

        for (int x = 0;x<5;x++) {
            for (int y = 0; y < 6; y++) {
                System.out.print(stringArr[x][y] + "\t");
            }
            System.out.println();
        }


    }

}


