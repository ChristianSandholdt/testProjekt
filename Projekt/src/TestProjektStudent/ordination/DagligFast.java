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

    private LocalDate fra;
    private LocalDate til;
    private double morgen;
    private double middag;
    private double aften;
    private double nat;

    public DagligFast(LocalDate fra, LocalDate til, double morgen, double middag, double aften, double nat){
        super();
        this.fra = fra;
        this.til = til;
        this.morgen = morgen;
        this.middag = middag;
        this.aften = aften;
        this.nat = nat;
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
