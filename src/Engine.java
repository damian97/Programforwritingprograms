import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class Engine {

    Robot bot;
    Compiler kompilator;
    public Engine() {

//        pomagaj();
        //Pole trojkata:   P = a * h / 2
        try {
            bot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    String nazwaKlasy = "Triangle";


    String zdanie1 = "public class " + nazwaKlasy + " *";
    String zdanie2 = "    public static void main(String[] args) *";

    String zapiszDo = "Dokumenty";

    int a = 0;
    int h = 0;

    public void otworzNotepad() {

        String command = "notepad.exe";
        Runtime run = Runtime.getRuntime();
        try {
            run.exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    public void pisz(String ciagZnakow) {

        int dlugoscZdania = ciagZnakow.length();
        char znak;

        bot.setAutoDelay(30);

        for (int i = 0; i < dlugoscZdania; i++) {
            znak = ciagZnakow.charAt(i);
            if (Character.isUpperCase(znak)) {
                bot.keyPress(KeyEvent.VK_SHIFT);
                bot.keyPress(Character.toUpperCase(znak));
                bot.keyRelease(Character.toUpperCase(znak));
                bot.keyRelease(KeyEvent.VK_SHIFT);
            } else {
                bot.keyPress(Character.toUpperCase(znak));
                bot.keyRelease(Character.toUpperCase(znak));
            }
        }


    }


    public boolean przesunKursor(int pozycjaX, int pozycjaY) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (int) screenSize.getWidth();
        int y = (int) screenSize.getHeight();

        if (pozycjaX > x || pozycjaY > y) {
            System.out.println("Wyszedłeś poza zakres");
            return false;
        } else {
            bot.mouseMove(pozycjaX, pozycjaY);

            return true;
        }
    }


    public void zapiszDoSchowka(String znak) {

        String myString = znak;
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        }

    public void wklej() {
        bot.delay(100);
        bot.keyPress(KeyEvent.VK_CONTROL);
        bot.delay(100);
        bot.keyPress(KeyEvent.VK_V);
        bot.delay(100);
        bot.keyRelease(KeyEvent.VK_V);
        bot.delay(100);
        bot.keyRelease(KeyEvent.VK_CONTROL);
        bot.delay(100);
    }

    public void utworzMetody() {

        String zdanie = zdanie1;
        int dlugoscZdania = zdanie.length();

        bot.delay(500);

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < dlugoscZdania; i++) {
                if(zdanie.charAt(i) == '*') {
                    zapiszDoSchowka("{");
                    wklej();
                } else if (zdanie.charAt(i) == '(') {
                    zapiszDoSchowka("(");
                    wklej();
                } else if (zdanie.charAt(i) == ')') {
                    zapiszDoSchowka(")");
                    wklej();
                }
                else {
                    if (zdanie.charAt(i) == 'S' || zdanie.charAt(i) == nazwaKlasy.charAt(0)) {
                        bot.keyPress(KeyEvent.VK_SHIFT);
                    }
                        bot.keyPress(Character.toUpperCase(zdanie.charAt(i)));
                        bot.delay(50);
                        bot.keyRelease(KeyEvent.VK_SHIFT);
                    }


            }
            zdanie = zdanie2;
            dlugoscZdania = zdanie.length()-1;

            if (j == 1) {
                zapiszDoSchowka("{");
                wklej();
            }

            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);
            bot.delay(100);
        }



    }

    public void zamknijMetody() {

        bot.keyPress(KeyEvent.VK_ENTER);
        bot.keyRelease(KeyEvent.VK_ENTER);
        zapiszDoSchowka("   }");
        wklej();
        bot.keyPress(KeyEvent.VK_ENTER);
        bot.keyRelease(KeyEvent.VK_ENTER);
        zapiszDoSchowka("}");
        wklej();

    }

    public void wpiszEnter(int liczba) {

        for(int i = 0; i < liczba; i++) {
            bot.keyPress(KeyEvent.VK_ENTER);
            bot.delay(50);
            bot.keyRelease(KeyEvent.VK_ENTER);
        }

    }

    public void wpiszTab() {
        bot.keyPress(KeyEvent.VK_TAB);
        bot.keyRelease(KeyEvent.VK_TAB);
    }


    public void pobierzZmiene() {


        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj a");
        a = skaner.nextInt();
        System.out.println("Podaj h");
        h = skaner.nextInt();

    }


    public void liczPoleTrojkata() {



        utworzMetody();

        String pole =  "int area;";
        String a = "int a =  ";
        String h = "int h =  ";

        wpiszEnter(1);
        wpiszTab();

        bot.setAutoDelay(50);

        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < pole.length(); i++) {
                if (j == 0) {
                    bot.keyPress(Character.toUpperCase(pole.charAt(i)));
                } else if (j == 1) {
                    bot.keyPress(Character.toUpperCase(a.charAt(i)));
                    if (i == pole.length()-1) {
                        bot.keyPress(KeyEvent.VK_BACK_SPACE);
                        bot.keyRelease(KeyEvent.VK_BACK_SPACE);
                        if (this.a > 9) {
                            rozbijLiczbeNaCyfry(this.a);
                        } else {
                            bot.keyPress(zwracajKeyCode(this.a));
                            bot.keyRelease(zwracajKeyCode(this.a));
                        }
                        bot.keyPress(KeyEvent.VK_SEMICOLON);
                        bot.keyRelease(KeyEvent.VK_SEMICOLON);
                    }
                } else {
                    bot.keyPress(Character.toUpperCase(h.charAt(i)));
                    if (i == pole.length()-1) {
                        bot.keyPress(KeyEvent.VK_BACK_SPACE);
                        bot.keyRelease(KeyEvent.VK_BACK_SPACE);
                        if (this.h > 9) {
                            rozbijLiczbeNaCyfry(this.h);
                        } else {
                            bot.keyPress(zwracajKeyCode(this.h));
                            bot.keyRelease(zwracajKeyCode(this.h));
                        }
                        bot.keyPress(KeyEvent.VK_SEMICOLON);
                        bot.keyRelease(KeyEvent.VK_SEMICOLON);
                    }
                }

            }
            wpiszEnter(1);
            wpiszTab();
        }


        bot.setAutoDelay(30);

        String drukuj = "System.out.println('Pole trojkata = ' + (a*h) / 2);";


        for(int i = 0; i < drukuj.length(); i++) {
            char znak = drukuj.charAt(i);


            if (znak == '(') {
                zapiszDoSchowka("(");
                wklej();
            } else if (znak == '_') {
                zapiszDoSchowka("'");
                wklej();
            } else if (znak == '*') {
                zapiszDoSchowka("*");
                wklej();
            } else if  (znak == ')') {
                zapiszDoSchowka(")");
                wklej();
            } else if  (znak == '+') {
                zapiszDoSchowka("+");
                wklej();
            } else {
                if (i == 0 || i >= 19 && i <= 20 || i == 36) {
                    bot.keyPress(KeyEvent.VK_SHIFT);
                    wcisnijZnak(znak);
                    bot.keyRelease(KeyEvent.VK_SHIFT);
                } else {
                    wcisnijZnak(znak);
                }
            }





        }


//        System.out.println("Pole kwadratu = " + (a*h) / 2);    wzor na pole trojkata

        kompilator = new Compiler();

        zamknijMetody();

        bot.delay(500);

        kompilator.zapiszPlik(nazwaKlasy);

        przesunKursor(585, 480);

        bot.delay(500);

        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.delay(250);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        bot.delay(500);

        bot.keyPress(KeyEvent.VK_DOWN);
        bot.keyRelease(KeyEvent.VK_DOWN);

        bot.setAutoDelay(500);
        przesunKursor(390,510);

        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        wpiszEnter(1);

        bot.keyPress(KeyEvent.VK_ALT);
        bot.keyPress(KeyEvent.VK_F4);
        bot.keyRelease(KeyEvent.VK_F4);
        bot.keyRelease(KeyEvent.VK_ALT);

        bot.delay(1000);

        kompilator.kompiluj();

    }



    public void test() {

        bot.delay(250);

        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


        System.out.println(MouseInfo.getPointerInfo().getLocation().x);
        System.out.println(MouseInfo.getPointerInfo().getLocation().y);


    }

    public void rozbijLiczbeNaCyfry(int liczba) {

        int liczba1 = liczba / 10;
        int liczba2 = liczba % 10;
        bot.keyPress(zwracajKeyCode(liczba1));
        bot.keyRelease(zwracajKeyCode(liczba1));
        bot.keyPress(zwracajKeyCode(liczba2));
        bot.keyRelease(zwracajKeyCode(liczba2));

    }


    public void wcisnijZnak(char znak) {


        bot.keyPress(KeyEvent.getExtendedKeyCodeForChar(znak));
        bot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(znak));
    }

    public int zwracajKeyCode(int liczba) {


        switch (liczba) {
            case 0:
                return KeyEvent.VK_0;
            case 1:
                return KeyEvent.VK_1;
            case 2:
                return KeyEvent.VK_2;
            case 3:
                return KeyEvent.VK_3;
            case 4:
                return KeyEvent.VK_4;
            case 5:
                return KeyEvent.VK_5;
            case 6:
                return KeyEvent.VK_6;
            case 7:
                return KeyEvent.VK_7;
            case 8:
                return KeyEvent.VK_8;
            case 9 :
                return KeyEvent.VK_9;
            default:
                return KeyEvent.VK_0;
        }
    }


}
