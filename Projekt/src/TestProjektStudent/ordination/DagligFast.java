package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {

    public Dosis[] doser = new Dosis[4];

    public Dosis[] getDoser(){
        return doser;
    }

    public Dosis opretDosis(LocalTime tid, double antal){
        Dosis dosis = new Dosis(tid, antal);
        doser.add(dosis);
        return dosis;
    }

    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient){
        super(startDen, slutDen, patient);
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
