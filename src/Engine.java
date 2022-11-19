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


    public boolean szukajOkna() {



        return false;
    }


    public void liczPoleTrojkata() {


        char[][] linie = {
                {'p', 'u', 'b', 'l', 'i', 'c', ' ', 'c', 'l', 'a', 's', 's', ' ', 'M', 'a', 'i', 'n', ' ', '{'},
                {'p', 'u', 'b', 'l', 'i', 'c', ' ', 's', 't', 'a', 't', 'i', 'c', ' ', 'v', 'o', 'i', 'd', ' ', 'm', 'a', 'i', 'n', '(', 'S', 't', 'r', 'i', 'n', 'g', '[', ']', ' ', 'a', 'r', 'g', 's', ')', ' ', '{'},
                {'}'},
                {'}'},
                {}
        };



        //        Thread.sleep(500);
//        robot.keyPress(KeyEvent.VK_S);

    }

}
