import java.io.IOException;

public class Engine {

    public Engine() {

        //Pole trojkata:   P = a * h / 2

    }



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


    public void liczPoleTrojkata() {



    }

}
