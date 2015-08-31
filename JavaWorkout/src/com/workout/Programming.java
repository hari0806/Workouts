package com.workout;

public class Programming {

    private static String suffixText = " is greatest";


    private static String findMax(int a, int b){
        return a > b ? String.valueOf(a).concat(suffixText)
                : String.valueOf(b).concat(suffixText);
    }

    public static void main(String args[]){
       // System.out.println(findMax(3,4));
//        fibonacci3(3);
//        fibonacciSeries(6);
//        System.out.println(fibonacci(6));
//        System.out.println(stringReverse("Reverse"));
        System.out.println(sumAllCubicDigits(371, -1));
    }

    private static void findFibonacci(int inputNumber){

        int fibonacci = 1;
        int tempNumber = 1;

        for(int i=1; i < inputNumber; i++){
            fibonacci = fibonacci + tempNumber;
            fibonacci = tempNumber;
            System.out.println(fibonacci + " " + i);
        }

    }

    /*
     * Java program to calculate Fibonacci number using loop or Iteration.
     * @return Fibonacci number
     */
    public static int fibonacci2(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++){

            //Fibonacci number is sum of previous two Fibonacci number
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;

        }
        return fibonacci; //Fibonacci number

    }

    public static int fibonacci3(int number){
//        if(number == 1 || number == 2){
//            return 1;
//        }
        int fibo1=-1, fibo2=1, fibonacci=1;
        for(int i= 1; i<= number; i++){

            //Fibonacci number is sum of previous two Fibonacci number
            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
            System.out.println(fibonacci);
        }
        return fibonacci; //Fibonacci number

    }

    private static void fibonacciSeries(int uptoN){
        int fibonacci=1,tempNum1 = -1,tempNum2=1;

        for(int i=0;i < uptoN;i++){
            fibonacci = tempNum1 + tempNum2;
            tempNum1 = tempNum2;
            tempNum2=fibonacci;
            System.out.println(fibonacci + " ");
        }

    }

    private static int fibonacci(int nNum){
        if(nNum == 0 || nNum == 1)
            return nNum;
        else
            return fibonacci(nNum - 1) + fibonacci(nNum - 2);
    }

    private static boolean isArmstrong1(int inputNum){
        int tempNum = inputNum;
        int sumDigits = 0;
        while(tempNum > 0){
            double singleDigit = Math.pow((tempNum % 10), String.valueOf(inputNum).length());
            sumDigits += singleDigit;
            tempNum /= 10;
        }
        return (sumDigits == inputNum);

    }

    private static boolean isArmstrong(int inputNum){
        int tempNum = inputNum;
        double digitValue = 0;
        int sumDigits = 0;
        while(tempNum > 0){
            digitValue = Math.pow((tempNum %10),String.valueOf(inputNum).length());
            sumDigits += digitValue;
            tempNum /= 10;
        }
        return (sumDigits == inputNum);
    }

    private static String stringReverse1(String inputStr){
        char[] chars = null;
        StringBuilder sb = new StringBuilder();
        if(inputStr != null
                && inputStr.length() > 0){
            chars = inputStr.toCharArray();
            for(int i= chars.length - 1; i >= 0; i--){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    private static String stringReverse(String inputStr){
        String reverseString = "";
        if(inputStr != null
                && inputStr.trim().length() > 0){
            reverseString = stringReverse(inputStr.substring(1)) + inputStr.charAt(0);
        }

        return reverseString;
    }

    private static int sumAllCubicDigits(int inputNum, int length){
        if(length < 0){
            length = String.valueOf(inputNum).length();
        }
        if(inputNum == 0){
            return inputNum;
        }else{
            return sumAllCubicDigits(inputNum/10, length) + (int)Math.pow(inputNum % 10, length);
        }
    }
}