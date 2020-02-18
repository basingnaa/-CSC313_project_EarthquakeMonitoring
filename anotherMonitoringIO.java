package project;

import java.util.Scanner;

public class anotherMonitoringIO {
    public static void main(String[] args) {
        System.out.print("Enter name");
        Scanner scanner = new Scanner(System.in);

        String dec = scanner.next();

        while(!dec.equals("Quit")){
            System.out.print("Enter name");
            dec = scanner.next();
        }

    }

}
