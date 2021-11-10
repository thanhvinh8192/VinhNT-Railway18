package vti.extra_assignment_3;

import java.util.Scanner;

public class Exercise1Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Exercise1Loop ex = new Exercise1Loop();
        System.out.print("Enter length of your array: ");
        int arrayLength = input.nextInt();
        double[] array = new double[arrayLength];
        for(int i = 0; i <arrayLength; ++i){
            System.out.print("Enter value of element " + i + ": ");
            array[i] = input.nextDouble();
        }

        /*
        System.out.println("Sum of your array: " + ex.getSumArr(array));
        System.out.println("Average of your array: " + ex.getAverageArr(array));
        System.out.println("Sum negative of your array: " + ex.getSumNegativeArr(array));
        System.out.println("Sum positive of your array: " + ex.getSumPositiveArr(array));
        System.out.println("Sum even index of your array: " + ex.getSumEvenIndex(array));
        System.out.println("Sum uneven index of your array: " + ex.getSumUnevenIndex(array));
        */
        //ex.findIndex(array);

        ex.bubbleSortASC(array);
    }
}
