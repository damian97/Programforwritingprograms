import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.Key;

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


    String nazwaKlasy = "Tringle";


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



    public void liczPoleTrojkata() {

        utworzMetody();


        System.out.println("Test gita");



        zamknijMetody();


    }

}
