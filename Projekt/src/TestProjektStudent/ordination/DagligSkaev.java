package TestProjektStudent.ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev {

    // komposition --> 0..* Dosis
    private final ArrayList<Dosis> dosis = new ArrayList<>();

    public LocalTime tid;
    public double antal;

    // ----------------------------------------------------------------------------------------------------------------


    public DagligSkaev(LocalTime tid, double antal) {
        this.tid = tid;
        this.antal = antal;
    }

    public ArrayList<Dosis> getDosis() {
        return new ArrayList<>();
    }

    public double getAntal() {
        return antal;
    }

    public LocalTime getTid() {
        return tid;
    }

    // ----------------------------------------------------------------------------------------------------------------


    public Dosis opretDosis(String navn, LocalTime tid, double antal) {
        Dosis nyDosis = new Dosis(navn, tid, antal);
        dosis.add(nyDosis);
        return nyDosis;
    }



}
