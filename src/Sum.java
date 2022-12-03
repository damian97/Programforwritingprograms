import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Sum {

    int a, b;
    Robot robot;
    int autoDelay = 10;
    String nazwaKlasy = "Sum";
    char znak;

    char[] tablicaZnakow = {'{', '}', ']', ')', '(', '[', '/', '*', '-', '+', ',', '.', '%', '='};
    Engine eng;


    public Sum() {
        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę");
        a = skaner.nextInt();
        System.out.println("Podaj drugą liczbę");
        b = skaner.nextInt();

    }


    public void piszTekst(String tekst) {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        eng = new Engine();

        robot.setAutoDelay(autoDelay);

        int dlugoscTekstu = tekst.length();


        for (int i = 0; i < dlugoscTekstu; i++) {
            char aktualnyZnak = tekst.charAt(i);


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

        char[] charTable = tablicaZnakow;

        for(char x : charTable) {
            if (aktualnyZnak == x) {
                znak = x;
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
        piszTekst("    int a = " + a + ";");
        piszTekst("    int b = " + b + ";");
        piszTekst("    int sum;");
        piszTekst("    sum = a + b;");
        piszTekst("    System.out.println(sum);");
        piszTekst("    }");
        piszTekst("}");

    }

    Compiler kompilator;
    public void kompiluj() {

        String nazwaKlasy = "Sum";

        kompilator = new Compiler();

        robot.delay(500);

        kompilator.zapiszPlik(nazwaKlasy);

        eng.przesunKursor(585, 480);

        robot.delay(500);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(250);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.delay(500);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.setAutoDelay(500);
        eng.przesunKursor(390,510);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        eng.wpiszEnter(1);

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);

        robot.delay(1000);

        kompilator.kompiluj(nazwaKlasy);


    }



}
