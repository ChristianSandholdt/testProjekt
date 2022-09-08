package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {

    private double antalEnheder;

    private ArrayList<LocalDate> datoer = new ArrayList<>();

    public PN(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDato, slutDato, laegemiddel);
        this.antalEnheder = antalEnheder;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    /**
     * Registrer, at der er givet en dosis paa dagen givesDen.
     * Returner true, hvis givesDen er inden for ordinationens gyldighedsperiode, og datoen huskes.
     * Returner false ellers, og datoen givesDen ignoreres.
     */
    public boolean givDosis(LocalDate givesDen) {
        if (givesDen.compareTo(getStartDato()) >= 0 && givesDen.compareTo((getSlutDato())) <= 0){
            datoer.add(givesDen);
            return true;
        }
        return false;
    }

    /** Returner antal gange ordinationen er anvendt. */
    public int getAntalGangeGivet() {
        return datoer.size();
    }


    @Override
    public double samletDosis() {
        double sum = getAntalGangeGivet() * getAntalEnheder();
        return sum;
    }

    @Override
    public double doegnDosis() {
        double dosis = 0;
        if (datoer.size() == 1){
            dosis = samletDosis();
        }
        else if (datoer.size() > 1){
            dosis = samletDosis() / (datoer.get(0).until(datoer.get(datoer.size()-1), ChronoUnit.DAYS) + 1);
        }
        return dosis;
    }

    @Override
    public String getType() {
        return "PN";
    }
}
