import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PythagoreanTheorem {

    String nazwaKlasy = "PyTheory";
    String sciezkaDoPliku = "File";
    String sciezkaDoCmd = "C:\\Users\\srync\\IdeaProjects\\Programforwritingprograms\\File";

    int a, b;

    Scanner skaner;
    Robot robot;
    Sum suma;
    Engine eng;

    public PythagoreanTheorem() {

        File file = new File(sciezkaDoPliku + "/" + nazwaKlasy + ".java");
        suma = new Sum(false);
        eng = new Engine();

        pobierzZmienne();
        tworzPlik(file);
        spij(1);
        otworzPlik(file);
        spij(1);
        piszKod();
        spij(1);
        zamknijOkno();
        spij(1);
        otworzTerminal();
        spij(1);
        suma.piszTekst("cd " + sciezkaDoCmd);
        eng.wpiszEnter(1);
        suma.piszTekst("javac " + nazwaKlasy + ".java");
        eng.wpiszEnter(1);
        suma.piszTekst("java " + nazwaKlasy);
        eng.wpiszEnter(1);



    }


    public void pobierzZmienne() {

        skaner = new Scanner(System.in);

        System.out.println("Podaj długość pierwszej przyprostokątnej:");
        a = skaner.nextInt();
        System.out.println("Podaj długość drugiej przyprostokątnej: ");
        b = skaner.nextInt();

    }

    public void zamknijOkno() {

        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
    }


    public void tworzPlik(File plik) {

        File file = plik;

        try {
            FileWriter fw = new FileWriter(file);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }

    public void spij(int iloscSekund) {

        int miliSekundy = iloscSekund * 1000;

        try {
            Thread.sleep(miliSekundy);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    public void otworzPlik(File file) {

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().edit(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("Cos poszlo nie tak!");
        }


    }

    public void piszKod() {

        suma = new Sum(false);
        String syso = "System.out.print(";
        char znak = '"';
        String tekst = "Dlugosc przyprostokatnej jest rowna: ";


        String[] kod = {"public class " + nazwaKlasy + " {",
                "    public static void main(String[] args) {",
                "    double a = " + a + ";",
                "    double b = " + b + ";",
                "    double c, c2;",
                "    double a2 = Math.pow(a, 2);",
                "    double b2 = Math.pow(b, 2);",
                "    c2 = a2 + b2;",
                "    c = Math.sqrt(c2);",
                "    " + syso.concat(String.valueOf(znak).concat(tekst).concat(String.valueOf(znak))) + ");",
                "    System.out.print(c);",
                "    }",
                "}"};


        for (String linijkaKodu : kod) {
            suma.piszTekst(linijkaKodu);
        }

        spij(1);
        Compiler kompiluj = new Compiler();
        kompiluj.skrotKlawiszowy('s', false);
        spij(1);

    }


    public void otworzTerminal() {

        try {
           Runtime.getRuntime().exec("cmd /c start cmd.exe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
