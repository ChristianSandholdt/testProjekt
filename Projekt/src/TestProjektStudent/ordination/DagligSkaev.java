package TestProjektStudent.ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {

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
        Dosis doser = new Dosis(navn, tid, antal);
        dosis.add(doser);
        return doser;
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
