import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Witaj. Napisałem dla Ciebie program, który napisze prgram, który wykona wybraną przez Ciebie czynność.");
        System.out.println("Just for fun ;)");

        String command = "notepad.exe";
        Runtime run = Runtime.getRuntime();
        run.exec(command);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}