package com.matahariramadhan;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);
    public static double readNumber(String prompt){
            System.out.print(prompt + ": ");
            return scanner.nextDouble();
    }
    public static double readNumber(String prompt, int min, int max){
        double value;
        while (true){
            System.out.print(prompt + ": ");
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;

            System.out.println("Please enter "+ prompt.toLowerCase() +" between" + min + " and " + max);
        }
        return value;
    }
}
