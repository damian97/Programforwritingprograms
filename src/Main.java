import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Witaj. Napisałem dla Ciebie program, który napisze program, który wykona wybraną przez Ciebie czynność.");
        System.out.println("Just for fun ;)");


        //menu wyboru

        String[] menusTable = {"1. Obliczanie pola trójkąta", "2. Suma dwoch liczb", "3. Twierdzenie Pitagorasa", "4. Prosta gierka"};
        for (String s : menusTable) {
            System.out.println(s);
        }

        Engine eng = new Engine();

        Scanner skaner = new Scanner(System.in);
        String wyborMenu = skaner.nextLine();

                // test
        if (wyborMenu.equals("0")) {
            eng.test();
            Compiler kom = new Compiler();
            kom.kompiluj();
            System.out.println("To jest tryb testowy");
        }
                //test

        if (wyborMenu.equals(menusTable[0]) || wyborMenu.equals("1")) {
            System.out.println("Wybrałeś pole trójkąta");
            eng.pobierzZmiene();
            eng.otworzNotepad();
            eng.liczPoleTrojkata();
        }

        if (wyborMenu.equals(menusTable[1]) || wyborMenu.equals("2")) {
            System.out.println("Wybrałeś sumę dwóch liczb");
            eng.otworzNotepad();
        }

        if (wyborMenu.equals(menusTable[2]) || wyborMenu.equals("3")) {
            System.out.println("Wybrałeś Twierdzenie Pitagorasa");
            eng.otworzNotepad();
        }

        if (wyborMenu.equals(menusTable[3]) || wyborMenu.equals("4")) {
            System.out.println("Wybrałeś prostą gierkę");
            eng.otworzNotepad();
        }


    }
}