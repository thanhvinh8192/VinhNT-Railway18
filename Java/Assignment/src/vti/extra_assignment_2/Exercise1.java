package vti.extra_assignment_2;


import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {


    /*Question 1:
        Viết chương trình nhập vào một số thực. Đơn vị tính cho số này là centimet
        (cm).
        Hãy in ra số tương đương tính bằng foot (số thực, có 2 số lẻ thập phân) và inch
        (số thực, có 2 số lẻ thập phân).
        Với 1 inch = 2.54 cm và 1 foot = 12 inches.
    * */
    public void changeCm(double number){
        double toChangeInch = number/2.54;
        // System.out.printf("%.2f",toChangeInch);
        System.out.print("\nResult for change " + number + "cm to inch: " + Math.round(toChangeInch*100.0)/100.0 + "inch\n");
        double toChangeFoot = number/(2.54*12);
        System.out.print("Result for change " + number + "cm to foot: " + Math.round(toChangeFoot*100.0)/100.0 + "foot\n");
    }

    /*Question 2:
        Viết chương trình nhập vào số giây từ 0 tới 68399, đổi số giây này thành dạng
        [giờ:phút:giây], mỗi thành phần là một số nguyên có 2 chữ số.
        Ví dụ: 02:11:05
    * */
    public void changeSecondsToTime(int secondsNumber){
        int hours, minutes, seconds;
        hours = secondsNumber/3600;
        minutes = (secondsNumber%3600)/60;
        seconds = (secondsNumber%3600)%60;
        System.out.println("Time: "+ hours + ":" + minutes + ":" + seconds);
    }

    /*Question 3:
        Viết chương trình nhập vào 4 số nguyên.
        Hiển thị ra số lớn nhất và nhỏ nhất
        Ví dụ: nhập vào 4 số 1,2,3,4 thì kết quả là:
            Số lớn nhất là: 4
            Số nhỏ nhất là: 1
    * */
    public static int findMaxValueArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        return max;
    }
    public int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter value of element " + arr[i] + ": ");
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        return arr;
    }

    /*Question 4:
        Nhập vào hai số tự nhiên a và b. Tính hiệu của hai số đó.
        Nếu hiệu số lớn hơn 0 thì in ra dòng chữ [Số thứ nhất lớn hơn số thứ
        hai].
        Nếu hiệu số nhỏ hơn 0 thì in ra dòng chữ [Số thứ nhất nhỏ hơn số thứ
        hai].
    * */
    public void checkSubtraction(){
        int firstNumber, secondNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        firstNumber = scanner.nextInt();
        System.out.print("Enter the second number: ");
        secondNumber = scanner.nextInt();
        int resultSbtraction = firstNumber - secondNumber;
        System.out.println((resultSbtraction > 0) ? (firstNumber + ">" + secondNumber) : (firstNumber + "<" + secondNumber));
    }

    /*Question 5:
        Nhập vào 2 số tự nhiên a và b. Kiểm tra xem a có chia hết cho b không
    * */
    public boolean checkDivisible(int a, int b){
        return a % b == 0;
    }
    public void divisibleNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();
        if (checkDivisible(a, b)){
            System.out.println(a + " divisible by " + b);
        }
        else{ System.out.println(a + " not divisible by " + b);}

    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 4, 1, 3, 5, 7, 6};
        Arrays.sort(arr);
        for (int a: arr) {
            System.out.println();
        }

        Exercise1 exercise = new Exercise1();
        //exercise.changeCm(986.2);
        //exercise.changeSecondsToTime(46822);
        //System.out.println(findMaxValueArray(exercise.createArray()));
        //exercise.checkSubtraction();
        exercise.divisibleNumber();

        //Question 6
        Student student = new Student();
        student.setMathMark(10.0);
        student.setPhysicalMark(9.0);
        student.setChemistryMark(8.5);
        System.out.println("GPA of student:" + student.getGpaStudent());
        System.out.println("Grade of student: " + student.getGradeStudent(student.getGpaStudent()));
    }
}
