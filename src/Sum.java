import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Sum {

    int a, b;
    Robot robot;
    int autoDelay = 10;
    String nazwaKlasy = "Sum";
    char znak;

    char tablicaZnakow[] = {'{', '}', ']', ')', '(', '[', '/', '*', '-', '+', ',', '.', '%', '='};
    Engine eng;


    public Sum() {
        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę");
        a = skaner.nextInt();
        System.out.println("Podaj drugą liczbę");
        b = skaner.nextInt();

    }

    public Sum(boolean test) {
        a = 2;
        b = 2;
    }


    public void piszTekst(String tekst) {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        eng = new Engine();

        robot.setAutoDelay(autoDelay);

        String aktualnyTekst = tekst;
        int dlugoscTekstu = aktualnyTekst.length();
        boolean specjalnyZnak = false;


        for (int i = 0; i < dlugoscTekstu; i++) {
            char aktualnyZnak = aktualnyTekst.charAt(i);


            if (skanujTablice(aktualnyZnak)) {
                zapiszWklej(znak);

            } else {

                if (Character.isUpperCase(aktualnyZnak)) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                } else {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(Character.toUpperCase(aktualnyZnak));
                robot.keyRelease(Character.toUpperCase(aktualnyZnak));

            }

        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }


    public boolean skanujTablice(char aktualnyZnak) {

        char charTable[] = tablicaZnakow;

        for(int i = 0; i < charTable.length; i++) {
            if (aktualnyZnak == charTable[i]) {
                znak = charTable[i];
                return true;
            }
        }

        return false;

    }


    public void zapiszWklej(char znak) {

        String ciag = Character.toString(znak);
        eng.zapiszDoSchowka(ciag);
        eng.wklej();

    }

    public void piszKod() {

        piszTekst("public class " + nazwaKlasy + " {");
        piszTekst("    public static void main(String[] args) {");

    }


}
