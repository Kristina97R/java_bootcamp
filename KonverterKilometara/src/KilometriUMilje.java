import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class KilometriUMilje {

    public static void main(String[] args) {
        // unos kilometara
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite broj kilometara: ");
        float kilometri = scanner.nextFloat();

        // provjera je li broj kilometara pozitivan
        if (kilometri <= 0) {
            System.out.println("Broj kilometara mora biti pozitivan broj!");
            return;
        }

        // unos konverzijskog faktora
        System.out.print("Unesite konverzijski faktor (broj milja po kilometru): ");
        float konverzijskiFaktor = scanner.nextFloat();

        // provjera je li konverzijski faktor pozitivan
        if (konverzijskiFaktor <= 0) {
            System.out.println("Konverzijski faktor mora biti pozitivan broj!");
            return;
        }

        // spremanje konverzijskog faktora u datoteku
        try {
            PrintWriter writer = new PrintWriter("konverzijski_faktor.txt");
            writer.print(konverzijskiFaktor);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka konverzijski_faktor.txt nije pronađena!");
        }

        // čitanje konverzijskog faktora iz datoteke
        float ucitaniFaktor = 0;
        try {
            Scanner fileScanner = new Scanner(new File("konverzijski_faktor.txt"));
            ucitaniFaktor = fileScanner.nextFloat();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka konverzijski_faktor.txt nije pronađena");
        }

        // provjera je li uneseni konverzijski faktor jednak pročitanom
        if (konverzijskiFaktor != ucitaniFaktor) {
            System.out.println("Uneseni konverzijski faktor se ne podudara s pročitanim iz datoteke!");
        }

        // kilometri u milje
        int milje = Math.round(kilometri / konverzijskiFaktor);
        System.out.println("Uneseno je " + kilometri + " kilometara, što je " + milje + " milja.");
    }
}