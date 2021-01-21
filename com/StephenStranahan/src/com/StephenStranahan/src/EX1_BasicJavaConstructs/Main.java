package com.StephenStranahan.src.EX1_BasicJavaConstructs;

import com.StephenStranahan.src.EX1_BasicJavaConstructs.MyArray;

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
    }

}


