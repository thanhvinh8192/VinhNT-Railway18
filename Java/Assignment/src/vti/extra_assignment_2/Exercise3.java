package com.extra_assignment_2;

public class Exercise3 {
    public static final int NUMBER_STAR = 8;
    public static void tricangle(int row){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    public static void tricangle1(int row){
        for (int i = 0; i < row; i++){
            for (int space = row-1; space > i; --space){
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }



    public static void  upSideDownTricangle(int row){
        do{
            for (int i = 0; i < row; i++){
                System.out.print("* ");
            }
            System.out.println();
        }while (--row > 0);

    }

    public static void  upSideDownTricangle1(int n){
        for (int row=0; row<n; row++){
            for(int space=0; space<row; space++)
                System.out.print("  ");
            for (int star=n; star>row; star--){
                System.out.print(" *");
            }
            System.out.println("");
        }
    }
    public int deQuy(int n){
        if(n == 1)
            return 1;
        return n * deQuy(n-1);
    }
    public static void main(String[] args) {
        Exercise3 exercise = new Exercise3();
        tricangle(8);
        tricangle1(8);
        upSideDownTricangle(8);
        upSideDownTricangle1(8);
        System.out.println(exercise.deQuy(5));
    }
}
