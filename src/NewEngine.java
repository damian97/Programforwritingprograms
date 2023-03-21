import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class NewEngine {

    Robot bot;
    int robotDelay = 1;
    String className = "Game";



    public NewEngine() {



    }

    public void writingLine(String line) {

        try {
            bot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        int lineLenght = line.length();

        bot.setAutoDelay(robotDelay);

        for (int i = 0; i < lineLenght; i++) {
            char tmpChar = line.charAt(i);

            if (tmpChar >= 33 && tmpChar < 48 || tmpChar >= 58 && tmpChar < 65 || tmpChar >= 123 && tmpChar < 127) {
                String charToString = Character.toString(tmpChar);
                copyPaste(charToString);
            } else {
                if (Character.isUpperCase(tmpChar)) {
                    bot.keyPress(KeyEvent.VK_SHIFT);
                    bot.keyPress(Character.toUpperCase(tmpChar));
                    bot.keyRelease(Character.toUpperCase(tmpChar));
                    bot.keyRelease(KeyEvent.VK_SHIFT);
                } else {
                    bot.keyPress(Character.toUpperCase(tmpChar));
                    bot.keyRelease(Character.toUpperCase(tmpChar));
                }
            }
        }

        bot.keyPress(KeyEvent.VK_ENTER);
        bot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void writtingTextInSout(String text, int tabulatorCounter) {

        try {
            bot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        char charToCopy = '"';
        String tabulator1 = "   ";
        String tabulator2 = "      ";
        String tabulator3 = "         ";
        if (tabulatorCounter == 0) {
            writingLine("System.out.println(");
        } else if (tabulatorCounter == 1) {
            writingLine(tabulator1 + "System.out.println(");
        } else if (tabulatorCounter == 2) {
            writingLine(tabulator2 + "System.out.println(");
        } else {
            writingLine(tabulator3 + "System.out.println(");
        }

        bot.keyPress(KeyEvent.VK_BACK_SPACE);
        bot.keyRelease(KeyEvent.VK_BACK_SPACE);

        copyPaste(Character.toString(charToCopy));

        writingLine(text);

        bot.keyPress(KeyEvent.VK_BACK_SPACE);
        bot.keyRelease(KeyEvent.VK_BACK_SPACE);

        copyPaste(Character.toString(charToCopy));

        writingLine(");");

    }

    public void copyPaste(String charToPaste) {
        String myString = charToPaste;
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        try {
            bot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        bot.setAutoDelay(40);

        bot.keyPress(KeyEvent.VK_CONTROL);
        bot.keyPress(KeyEvent.VK_V);
        bot.keyRelease(KeyEvent.VK_V);
        bot.keyRelease(KeyEvent.VK_CONTROL);

        bot.setAutoDelay(robotDelay);


    }


    public void writtingCode() {

        writingLine("import java.util.Scanner;");
        writingLine("");

        writingLine("public class " + className + " {");
        writingLine("   public static void main(String[] args) {");
        writtingTextInSout("Gra w kostke", 2);
        writtingTextInSout("Program losuje liczbe z zakresu 123 oraz 456", 2);
        writtingTextInSout("Twoim zadaniem jest wytypowanie liczby od 1 do 6", 2);
        writtingTextInSout("Podaj liczbe: ", 2);
        writingLine("      Scanner scaner = new Scanner(System.in);");
        writingLine("      int number = scaner.nextInt();");
        writingLine("      boolean loop = true;");
        writingLine("      while(loop) {");
        writingLine("      if (number >= 1 && number <= 3) {");
        writtingTextInSout("Podales liczbe od 1 do 3", 3);
        writingLine("      } else if (number >= 3 && number <= 6) {");
        writtingTextInSout("Podales liczbe od 3 do 6", 3);
        writingLine("      } else {");
        writtingTextInSout("Podales liczbe z podanego zakresu!", 3);
        writingLine("      number = scaner.nextInt();");
        writingLine("      }");

        writingLine("      ");

        writingLine("   }");
        writingLine("}");


    }



    public void openNotepad() {

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



    public void zwracajZnaki() {

        int liczbowaReprezentacjaZnaku = 0;
        char znak;

        for (int i = 0; i < 999; i++) {

            znak = (char) i;

            System.out.println(znak + "  -   " + i);


        }
    }

}
