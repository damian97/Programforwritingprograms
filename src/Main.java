import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {

        System.out.println("Witaj. Napisałem dla Ciebie program, który napisze program, który wykona wybraną przez Ciebie czynność.");
        System.out.println("Just for fun ;)");


        //menu wyboru

        int wybor = 0;
        String[] menusTable = {"1. Obliczanie pola trójkąta", "2. Suma dwoch liczb", "3. Twierdzenie Pitagorasa", "4. Prosta gierka"};
        for (int i = 0; i < menusTable.length; i++) {
            System.out.println(menusTable[i]);
        }


        Scanner skaner = new Scanner(System.in);
        String wyborMenu = skaner.nextLine();


        if (wyborMenu.equals(menusTable[0]) || wyborMenu.equals("1")) {
            System.out.println("Wybrałeś pole trójkąta");

        }

        if (wyborMenu.equals(menusTable[1]) || wyborMenu.equals("2")) {
            System.out.println("Wybrałeś sumę dwóch liczb");
        }

        if (wyborMenu.equals(menusTable[2]) || wyborMenu.equals("3")) {
            System.out.println("Wybrałeś Twierdzenie Pitagorasa");
        }

        if (wyborMenu.equals(menusTable[3]) || wyborMenu.equals("4")) {
            System.out.println("Wybrałeś prostą gierkę");
        }



        String command = "notepad.exe";
        Runtime run = Runtime.getRuntime();
        run.exec(command);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Robot robot = new Robot();


        System.out.println("siema");


//
//
//
//        Thread.sleep(500);
//        robot.keyPress(KeyEvent.VK_S);




    }
}