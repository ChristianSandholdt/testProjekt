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
        if (givesDen.isAfter(getStartDato()) && givesDen.isBefore(getSlutDato())){
            datoer.add(givesDen);
            return true;
        }
        return false;
    }

    /** Returner antal gange ordinationen er anvendt. */
    public int getAntalGangeGivet() {
        return datoer.size()-1;
    }


    @Override
    public double samletDosis() {
        double sum = getAntalGangeGivet() * getAntalEnheder();
        return sum;
    }

    @Override
    public double doegnDosis() {
        double sum = antalEnheder / (int) ChronoUnit.DAYS.between(getStartDato(),getSlutDato());
        return sum;
    }

    @Override
    public String getType() {
        return "PN";
    }
}
