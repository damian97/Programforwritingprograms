import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Compiler {

    Robot robot;
    Engine engine = new Engine();
    String nazwaPliku = engine.nazwaKlasy;


    public void zapiszPlik(String nazwa) {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.setAutoDelay(50);

        skrotKlawiszowy('s', false);

        for (int i = 0; i < nazwa.length(); i++) {
            if (i < 1) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }
            robot.keyPress(Character.toUpperCase(nazwa.charAt(i)));
            robot.keyRelease(Character.toUpperCase(nazwa.charAt(i)));
            if (i < 1) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
        }
        String rozszerzenie = ".java";
        for (int i = 0; i < rozszerzenie.length(); i++) {
            robot.keyPress(Character.toUpperCase(rozszerzenie.charAt(i)));
            robot.keyRelease(Character.toUpperCase(rozszerzenie.charAt(i)));
        }


    }


    /**
     *
     * @param znak znak z klawiatury
     * @param shiftCtrl true jesli skrot z shiftem, false jesli skrot z ctrl
     */
    public void skrotKlawiszowy(char znak, boolean shiftCtrl) {


        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


        robot.setAutoDelay(50);

        if (shiftCtrl) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        } else {
            robot.keyPress(KeyEvent.VK_CONTROL);
        }
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(znak));
        robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(znak));

        if (shiftCtrl) {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        } else {
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

    }




    public void kompiluj(String nazwa) {


        try {
            Runtime.getRuntime().exec("explorer.exe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.delay(2000);

        robot.setAutoDelay(500);

        engine.przesunKursor(600, 230);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        engine.pisz("Dokumenty");

        engine.wpiszEnter(1);

        engine.przesunKursor(650, 550);

        robot.delay(500);

        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

        engine.przesunKursor(680, 530);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        String komendaKopilacji = "javac ";
        String komendaOdpalenia = "java ";
        String rozszerzenie = ".java";

        robot.delay(2000);

        engine.pisz(komendaKopilacji.concat(nazwa).concat(rozszerzenie));

        engine.wpiszEnter(1);

        robot.delay(1000);

        engine.pisz(komendaOdpalenia.concat(nazwa));

        engine.wpiszEnter(1);
    }






}
