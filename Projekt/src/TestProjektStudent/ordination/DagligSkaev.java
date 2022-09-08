package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

    // komposition --> 0..* Dosis
    private final ArrayList<Dosis> dosis = new ArrayList<>();

    public LocalTime tid;
    public double antal;

    // ----------------------------------------------------------------------------------------------------------------


    public DagligSkaev(LocalDate startDato, LocalDate slutDato, Laegemiddel laegemiddel) {
        super(startDato, slutDato, laegemiddel);
    }

    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(dosis);
    }
    // ----------------------------------------------------------------------------------------------------------------


    public Dosis opretDosis(LocalTime tid, double antal) {
        Dosis doser = new Dosis(tid, antal);
        dosis.add(doser);
        return doser;
    }


    @Override
    public double samletDosis(){
        double samletDosis = 0;
        for (Dosis d : dosis){
            samletDosis += d.getAntal();
        }
        return samletDosis;
    }

    @Override
    public double doegnDosis() {
        return samletDosis() / antalDage();
    }

    @Override
    public String getType() {
        return "Skæv";
    }
}
