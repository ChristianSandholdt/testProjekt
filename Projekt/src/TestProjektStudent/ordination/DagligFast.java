package TestProjektStudent.ordination;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DagligFast extends Ordination {
    private final Dosis[] doser = new Dosis[4];

    public DagligFast(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel) {
        super(startDato, slutDato, laegemiddel);
    }

    public void opretDosis(double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        double[] antal = {morgenAntal, middagAntal, aftenAntal, natAntal};
        LocalTime[] tidspunkter = {LocalTime.of(8, 0), LocalTime.of(12,0), LocalTime.of(18,0),LocalTime.of(0,00)};
        for (int i = 0; i < doser.length; i++) {
            if (antal[i] < 0){
                throw new IllegalArgumentException("Fejl, antal kan ikke være mindre end 0");
            }
            Dosis d = new Dosis(tidspunkter[i], antal[i]);
            doser[i] = d;
        }
    }

    public Dosis[] getDoser() {
        return doser;
    }

    @Override
    public double samletDosis() {
        double samletDosis = 0;
        for (int i = 0; i < doser.length; i++) {
            samletDosis += doser[i].getAntal();
        }
        return samletDosis;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / (int)getStartDato().until(getSlutDato(), ChronoUnit.DAYS);
    }

    @Override
    public String getType() {
        return "Daglig Fast";
    }
}