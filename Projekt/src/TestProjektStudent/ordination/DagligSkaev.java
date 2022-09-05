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


    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Patient patient, LocalTime tid, double antal) {
        super(startDen, slutDen, patient);
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


    //Find dagsdosis med for loop i arrayet og plus antal sammen og gang det derefter med antal dage for ordinationen

    @Override
    public double samletDosis() {
        double sum = 0;
        double temp = 0;
        for (Dosis d : dosis) {
            temp += d.getAntal();
        }
        sum = temp * (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
        return sum;
    }

    @Override
    public double doegnDosis() {
        double sum = samletDosis() / (int) ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
        return sum;
    }

    @Override
    public String getType() {
        return "Skæv";
    }
}
