package repules;

import java.util.Objects;

public class Repulogep {
    private String gyarto;
    private String tipus;
    private double hossz;
    private boolean sugarhajtasu;

    public Repulogep(String gyarto, String tipus, double hossz, boolean sugarhajtasu) {
        if (hossz <= 0){
            throw new IllegalArgumentException("A hossz csak pozitív lehet!");
        }
        this.gyarto = gyarto;
        this.tipus = tipus;
        this.hossz = hossz;
        this.sugarhajtasu = sugarhajtasu;
    }

    public String getGyarto() {
        return gyarto;
    }

    public boolean isSugarhajtasu() {
        return sugarhajtasu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repulogep repulogep = (Repulogep) o;

        return gyarto.equalsIgnoreCase(repulogep.gyarto) && tipus.equalsIgnoreCase(repulogep.tipus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gyarto, tipus);
    }

    @Override
    public String toString() {
        return gyarto + " " + tipus + (sugarhajtasu ? " sugárhajtású" : "") + " repülőgép, hossza: " + hossz + " m";
    }

    public int compareTo(Repulogep o) {
        int kul = gyarto.compareToIgnoreCase(o.gyarto);
        if (kul != 0) return kul;
        kul = tipus.compareToIgnoreCase(o.tipus);
        return kul;
    }
}
