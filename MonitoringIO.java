package Project_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MonitoringIO {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Continue or Exit >> ");
        String dec = scan.next();

        while(!dec.equals("Exit")){
            System.out.print("1. Enter Observatory data \n2. Enter Galamsey data  \n3. Monitoring Statistics\n" + "\nPrompt >> ");
            int input = scan.nextInt();

            switch (input){
                case 1:
                    FileReader fileReader = new FileReader("C:\\Users\\Kwaku Ofosu-Agyeman\\Desktop\\Observatory Data.txt");
                    Scanner scan1 = new Scanner(fileReader);
                    while(scan1.hasNext()) {
                        System.out.println(scan1.nextLine());
                    }

                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;
                case 2:
                    FileReader fileReader2 = new FileReader("C:\\Users\\Kwaku Ofosu-Agyeman\\Desktop\\Galamsey Data.txt");
                    Scanner scan2 = new Scanner(fileReader2);
                    while(scan2.hasNext()){
                        System.out.println(scan2.nextLine());
                    }
                    System.out.print("\nContinue or Exit >> ");
                    dec = scan.next();
                    break;

                default:
                    System.out.println("Input error: Please follow the prompt to select 1, 2 or 3");
                    break;
            }
        }
    }
}


