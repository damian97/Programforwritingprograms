import java.awt.*;
import java.awt.event.KeyEvent;

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

        for (int i = 0; i < nazwaPliku.length(); i++) {
            if (i < 1) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }
            robot.keyPress(Character.toUpperCase(nazwaPliku.charAt(i)));
            robot.keyRelease(Character.toUpperCase(nazwaPliku.charAt(i)));
            if (i < 1) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
        }
        String rozszerzenie = ".java";
        for (int i = 0; i < rozszerzenie.length(); i++) {
            robot.keyPress(Character.toUpperCase(rozszerzenie.charAt(i)));
            robot.keyRelease(Character.toUpperCase(rozszerzenie.charAt(i)));
        }


            System.out.println(MouseInfo.getPointerInfo().getLocation().x);
            System.out.println(MouseInfo.getPointerInfo().getLocation().y);

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

}
