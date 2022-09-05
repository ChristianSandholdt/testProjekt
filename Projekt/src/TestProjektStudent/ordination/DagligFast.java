package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class DagligFast extends Ordination {

    private final Dosis[] doser = new Dosis[4];

    public Dosis[] getDoser(){
        Dosis[] ny = new Dosis[4];
        for (int i = 0; i < doser.length ; i++) {
            ny[i] = doser[i];
        }
        return ny;
    }

    public Dosis[] opretDosis(double antal1, double antal2, double antal3, double antal4){
        Dosis dose = new Dosis(LocalTime.of(8, 00), antal1);


        return doser;
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
