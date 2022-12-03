import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PythagoreanTheorem {

    String nazwaKlasy = "PyTheory";
    String komendaKompilacji = "javac";
    String komendaUruchamiajaca = "java";
    String sciezkaDoPliku = "File";

    int a, b, c;

    Scanner skaner;
    Sum suma;

    public PythagoreanTheorem() {

        File file = new File(sciezkaDoPliku + "/" + nazwaKlasy + ".java");

        pobierzZmienne();
        tworzPlik(file);
        spij(1);
        otworzPlik(file);
        spij(1);

        piszKod();


    }


    public void pobierzZmienne() {

        skaner = new Scanner(System.in);

        System.out.println("Podaj długość pierwszej przyprostokątnej:");
        a = skaner.nextInt();
        System.out.println("Podaj długość drugiej przyprostokątnej: ");
        b = skaner.nextInt();

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
        String syso = "System.out.println(";
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

    }


}
