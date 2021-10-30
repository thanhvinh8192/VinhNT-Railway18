package com.extra_assignment_3;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Exercise1Loop {
    /**
     * Question 1:
     * Nhập vào dãy n số thực. Tính tổng dãy, trung bình dãy, tổng các số âm,
     * dương và tổng các số ở vị trí chẵn, vị trí lẻ trong dãy.
     * **/
    public double getSumArr(double[] arr){
        double sum = 0;
        for (double x : arr) sum += x;
        return sum;
    }

    public double getAverageArr(double[] arr){
        return  getSumArr(arr)/arr.length;
    }

    public double getSumNegativeArr(double[] arr){
        double sum = 0;
        for (double x : arr){
            if (x < 0){
                 sum = sum + x;
            }
        }
        return sum;
    }

    public double getSumPositiveArr(double[] arr){
        double sum = 0;
        for (double x : arr){
            if (x > 0){
                sum = sum + x;
            }
        }
        return sum;
    }

    public double getSumEvenIndex(double[] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i%2 ==0){
                sum = sum + arr[i];
            }
        }
        return sum;
    }

    public double getSumUnevenIndex(double[] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i%2 != 0){
                sum = sum + arr[i];
            }
        }
        return sum;
    }

    /**Question 2:
        Tìm và chỉ ra vị trí xuất hiện đầu tiên của phần tử x trong dãy.
      */
    public void findIndex(double[] arr){
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number you want find: ");
        int n = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i]){
                System.out.println("Your number is at index: " + i);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Your number is not found!...");
        }
    }

    /**Question 3:
        Hãy nhập vào 16 số nguyên. In ra thành 4 dòng, 4 cột.
     * */

    /**Question 4:
     Nhập vào dãy số. In ra dãy đã được sắp xếp tăng dần, giảm dần*/
    public void bubbleSortASC(double[] arr){
        double temp;
        boolean has_swapped;

        for (int i = 0; i < arr.length-1; i++){
            has_swapped = false;
            for (int index = 0; index < arr.length-1-i; index++){
                if (arr[index] > arr[index+1]){
                    temp = arr[index];
                    arr[index] = arr[index+1];
                    arr[index+1] = temp;
                    has_swapped = true;
                }
            }
            if(!has_swapped){
                break;
            }
        }
        System.out.print("Result bubble sort: ");
        displaySort(arr);
    }

    public void bubbleSortDESC(double[] arr){
        double temp;
        boolean has_swapped;

        for (int i = 0; i < arr.length; i++){
            has_swapped = false;
            for (int index = 0; index < arr.length-i; index++){
                if (arr[index] < arr[index+1]){
                    temp = arr[index];
                    arr[index] = arr[index+1];
                    arr[index+1] = temp;
                    has_swapped = true;
                }
            }
            if(!has_swapped){
                break;
            }
        }
        displaySort(arr);
    }
    public void displaySort(double[] arr){
        for (double x: arr) {
            System.out.print(x + "  ");
        }
    }
}
