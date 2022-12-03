import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PythagoreanTheorem {

    String nazwaKlasy = "PyTheory";
    String komendaKompilacji = "javac";
    String komendaUruchamiajaca = "java";
    String sciezkaDoPliku = "File";



    public PythagoreanTheorem() {

        File file = new File(sciezkaDoPliku + "/" + nazwaKlasy + ".java");

        tworzPlik(file);
        spij(1);
        otworzPlik(file);




    }



    public void tworzPlik(File plik) {

        File file = plik;

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


}
