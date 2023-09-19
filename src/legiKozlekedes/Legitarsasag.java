package legiKozlekedes;

import repules.Flotta;
import repules.Repulogep;
import repules.Utasszallito;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Legitarsasag implements Flotta {
    private String nev;
    private List<Repulogep> repulogepek;

    public Legitarsasag(String nev, Repulogep[] repulogepek) {
        this.nev = nev;
        this.repulogepek = Arrays.stream(repulogepek).toList();
    }

    @Override
    public void felvesz(Repulogep repulo) {
        repulogepek.add(repulo);
    }

    @Override
    public List<Utasszallito> megfeleloGepek(int utasszam) {
        List<Utasszallito> tmp = new ArrayList<>();
        for (Repulogep r : repulogepek) {
            if (r.getClass() == Utasszallito.class && ((Utasszallito) r).getFerohely() >= utasszam) {
                tmp.add((Utasszallito) r);
            }
        }
        tmp.sort(null);
        return tmp;
    }

    @Override
    public void kiir(String fajlnev) {
        try {
            FileWriter fw = new FileWriter(fajlnev);
            fw.write(nev);
            for (Repulogep r : repulogepek) {
                fw.write(r.toString());
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
