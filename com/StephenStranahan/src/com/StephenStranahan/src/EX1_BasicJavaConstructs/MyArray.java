package com.StephenStranahan.src.EX1_BasicJavaConstructs;

import java.lang.Math;
import com.StephenStranahan.src.EX1_BasicJavaConstructs.IntRef;

public class MyArray {

    public static int[] setupRandArray(int n, int minVal, int maxVal) {

        int[] randArr;
        randArr = new int[n];

        int range = (maxVal - minVal) + 1;

        for (int i = 0; i < n; i++) {
            randArr[i] = (int)(Math.random() * range) + minVal;
        }

        return randArr;
    }

    public static void printArray(int n, int[] x, String label) {
        System.out.print(label + ": ");
        for (int i = 0; i < n; i++) {
            System.out.print(x[i] + "\t");
        }
        System.out.print("\n");
    }

    public static double getAverage(int n, int[] x) {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += x[i];
        }

        double average = sum / (double)(n);

        return average;
    }

    public static double getStandardDev(int n, int[] x) {
        double ave = MyArray.getAverage(n,x);

        double[] devArr = new double[n];

        double devSum = 0;
        double devMean = 0;
        double sigma = 0;

        for (int i = 0; i < n; i++) {
            devArr[i] = (double)(x[i]) - ave;
            devArr[i] = devArr[i] * devArr[i];
            devSum += devArr[i];
        }

        devMean = devSum / (double)(n);
        sigma = Math.sqrt(devMean);

        return sigma;
    }

    public static int getMaximum(int n, int[] x) {
        int max = 0;

        for (int i = 0; i < n; i++) {
            if(x[i] > max) {
                max = x[i];
            }
        }

        return max;
    }

   public static int getCountInRange(int n, int[] x, int minVal, int maxVal) {

        int count = 0;

        for (int i = 0; i < n ; i++) {
            if ((x[i] >= minVal) && (x[i] <= maxVal))
                count++;
        }
        return count;
   }

   public static int[] getValuesInRange(int n, int[] x, int minVal, int maxVal, IntRef numInRange) {

        int[] outArr = new int[n];
        int j = 0;
        numInRange.value = 0;

            for (int i = 0; i < n; i++) {
                if ((x[i] <= maxVal) && (x[i] >= minVal)) {
                    outArr[j] = x[i];
                    j++;
                    numInRange.value++;
                }
            }
        return outArr;
   }

    public static int[] getIndexInRange(int n, int[] x, int minVal, int maxVal, IntRef numInRange) {
        int[] outArr = new int[n];

        for (int k = 0; k<n; k++) {
            outArr[k] = 999;
        }

        int j = 0;
        numInRange.value = 0;

        for (int i = 0; i < n; i++) {
            if ((x[i] <= maxVal) && (x[i] >= minVal)) {
                outArr[j] = i;
                j++;
                numInRange.value++;
            }
        }
        return outArr;
    }

}

