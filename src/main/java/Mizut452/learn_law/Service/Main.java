package Mizut452.learn_law.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String telPhone = sc.nextLine();
        String [] telPhones = telPhone.split("-");

        List<String> telList;
        telList = Arrays.stream(telPhones).toList();
        int total = 0;
        for (int i = 0; i < telList.size(); i++) {
            String a = telList.get(i);

            for (int j = 0; j < a.length(); j++) {
                int b = a.charAt(j);
                System.out.println("int bは" + b);
                switch(b) {
                    case 0 :
                        total += 24;
                        break;
                    case 1 :
                        total += 6;
                        break;
                    case 2 :
                        total += 8;
                        break;
                    case 3 :
                        total += 10;
                        break;
                    case 4 :
                        total += 12;
                        break;
                    case 5 :
                        total += 14;
                        break;
                    case 6 :
                        total += 16;
                        break;
                    case 7 :
                        total += 18;
                        break;
                    case 8 :
                        total += 20;
                        break;
                    case 9 :
                        total += 22;
                        break;
                }
            }
        }
        System.out.println(total);
    }
}
