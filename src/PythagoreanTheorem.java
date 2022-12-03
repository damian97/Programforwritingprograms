import java.io.File;
import java.io.IOException;

public class PythagoreanTheorem {

    String nazwaKlasy = "PyTheory";
    String komendaKompilacji = "javac";
    String komendaUruchamiajaca = "java";
    String sciezkaDoPliku = "File";



    public PythagoreanTheorem() {

        File file = new File(sciezkaDoPliku + "/" + nazwaKlasy + ".java");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
