package com.matahariramadhan;

import java.util.Scanner;

public class Console {
    public static double readNumber(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);
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
