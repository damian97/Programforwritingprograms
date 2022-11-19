import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;
import java.util.Scanner;

public class Engine {

    Robot bot;

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
    String klamra = "}";


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


    public boolean szukajOkna() {



        return false;
    }


    public void pomagaj() {


        for(int i = 0; i < 1000000; ++i) {
            String text = java.awt.event.KeyEvent.getKeyText(i);
            if(!text.contains("Unknown keyCode: ")) {
                System.out.println("" + i + " -- " + text);
            }
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

    public boolean sprawdzLiczbeZmiennej() {


        bot.delay(500);
        bot.keyPress(KeyEvent.VK_CONTROL);
        bot.keyPress(KeyEvent.VK_A);
        bot.keyRelease(KeyEvent.VK_A);
        bot.delay(50);
        bot.keyPress(KeyEvent.VK_C);
        bot.keyRelease(KeyEvent.VK_C);
        bot.keyRelease(KeyEvent.VK_CONTROL);
        bot.delay(250);



        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor dataFlavor = DataFlavor.stringFlavor;


        Object text;

        try {
            text = systemClipboard.getData(dataFlavor);
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String tekst = (String) text;

        String pole = "int area;";

        int dlugoscKodu = tekst.length();

        for (int i = 0, j = 0; i < dlugoscKodu; i++) {

            if (tekst.charAt(i) == pole.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
            if (j >= pole.length()-1) {
                System.out.println(pole.charAt(j));
            }
            System.out.print(tekst.charAt(i));

        }


        return false;
    }


    public void liczPoleTrojkata() {



        utworzMetody();

        String pole =  "int area;";
        String a = "int a =";
        String h = "int h =";

        wpiszEnter(1);
        wpiszTab();
        for (int i = 0; i < pole.length(); i++) {
            bot.keyPress(Character.toUpperCase(pole.charAt(i)));
            bot.delay(50);
        }


        while (!sprawdzLiczbeZmiennej()) {

            bot.delay(5000);

        }
        bot.delay(4000);





//        System.out.println("Pole kwadratu = " + (a*h) / 2);    wzor na pole trojkata

        zamknijMetody();


    }

}
