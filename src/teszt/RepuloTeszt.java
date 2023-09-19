package teszt;

import legiKozlekedes.Legitarsasag;
import repules.Repulogep;
import repules.Utasszallito;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RepuloTeszt {
    static List<Repulogep> repulok = new ArrayList<>();

    public static void valogat(Collection<Repulogep> rep, String gyarto){
        for (Repulogep r:rep) {
            if (r.getGyarto().equalsIgnoreCase(gyarto)){
                System.out.println(r.toString());
            }
        }
    }
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        try {
            fr = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Nincs megadva az input fájl.");
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] tmp = line.split(";");
            if (tmp.length == 5) {
                Repulogep rep = new Repulogep(tmp[1], tmp[2], Double.parseDouble(tmp[3].replace(",", ".")),
                        tmp[4].equals("S") ? true : false);
                repulok.add(rep);
            } else {
                Utasszallito rep = new Utasszallito(tmp[1], tmp[2], Double.parseDouble(tmp[3].replace(",", ".")),
                        tmp[4].equals("S") ? true : false, Integer.parseInt(tmp[5]));
                repulok.add(rep);
            }
        }
        br.close();
        fr.close();

        String legitarsasagNeve = args.length == 2 ? args[1] : "Unideb Airlines";
        Legitarsasag legitarsasag = new Legitarsasag(legitarsasagNeve, repulok.toArray(new Repulogep[0]));

        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy darabszámot: ");
        int darabSzam = sc.nextInt();
        List<Utasszallito> ered = legitarsasag.megfeleloGepek(darabSzam);
        System.out.println(ered);

        sc.nextLine();
        System.out.println("Adjon meg egy gyártót: ");
        String gy = sc.nextLine();
        valogat(repulok, gy);
        sc.close();
    }
}
