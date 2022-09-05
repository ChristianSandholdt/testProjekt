package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.util.ArrayList;

public class PN extends Ordination {
    private double antalEnheder;

    private double antalGange = 0;

    public PN(LocalDate startDen, LocalDate slutDen, Patient patient) {
        super(startDen, slutDen, patient);
    }

    /**
     * Registrer, at der er givet en dosis paa dagen givesDen.
     * Returner true, hvis givesDen er inden for ordinationens gyldighedsperiode, og datoen huskes.
     * Returner false ellers, og datoen givesDen ignoreres.
     */
    public boolean givDosis(LocalDate givesDen) {
        ArrayList<LocalDate> datoer = new ArrayList<>();
        if (givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen())){
            datoer.add(givesDen);
            return true;
        }
        return false;
    }

    /** Returner antal gange ordinationen er anvendt. */
    public int getAntalGangeGivet() {
        return -1;
    }


    @Override
    public double samletDosis() {
        return 0;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }
}
