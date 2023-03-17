import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SampleGame {

    String[] figures = {"As", "Krol", "Dama", "Walet"};
    String[] colors = {"Pik", "Kier", "Trefl", "Karo"};

    Random rand = new Random();
    Scanner skaner = new Scanner(System.in);
    String[] wylosowana = new String[2];
    int wybor, kolor;

    boolean test = false;

    public SampleGame() {

        System.out.println("Komputer wylosował karte, twoja kolej. Wybierz kartę");
        wylosowana[0] = figures[rand.nextInt(4)];
        wylosowana[1] = colors[rand.nextInt(4)];
        for (int i = 1; i <= figures.length; i++) {
            System.out.print("[" + i + "]." + figures[i-1] + "   ");
        }
        System.out.println();
        wybor = skaner.nextInt();
        System.out.println("Wybierz kolor: ");

        for (int i = 1; i <= colors.length; i++) {
            System.out.print("[" + i + "]." + colors[i-1] + "   ");
        }
        System.out.println();
        kolor = skaner.nextInt();
        System.out.println("Wybrałeś " + figures[wybor-1] + " " + colors[kolor-1]);
        System.out.println("Komputer wylosował " + wylosowana[0] + " " + wylosowana[1]);
        if (figures[wybor-1].equals(wylosowana[0]) && colors[kolor-1].equals(wylosowana[1])) {
            System.out.println("Wygrales");
            test = true;
        } else {
            System.out.println("Nie udalo sie");
            test = false;
        }



    }

    int licznikGier = 0;

    public boolean test() {

        licznikGier++;
        SampleGame sg = new SampleGame();

        if (test) {
            System.out.println("licznikGier: " + licznikGier);
            return true;
        }

        return false;
    }


    String[] imie = {"Damian", "Sebastian", "Krzysztof", "Andrzej", "Adam", "Krystian"};
    String[] nazwisko = {"Kowalski", "Waclawik", "Sluszniak", "Nowak", "Brzezinski", "Olszewski"};
    String domena = "@o2.pl";

    public void createAcount() {

    String mail;
    int dlugoscImie = imie.length, dlugoscNazwisko = nazwisko.length;

    mail = imie[rand.nextInt(dlugoscImie)].concat(nazwisko[rand.nextInt(dlugoscNazwisko)]);

        System.out.println(mail);

        int liczba = rand.nextInt(94)+1964;

        mail = mail + liczba + domena;

        System.out.println(mail);

    }



}
