import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Witaj. Napisałem dla Ciebie program, który napisze prgram, który wykona wybraną przez Ciebie czynność.");
        System.out.println("Just for fun ;)");

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("C:\\Windows\\notepad.exe");


    }
}