package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class Dosis {
    private final LocalTime tid;
    private final double antal;
    private String navn;

    // ----------------------------------------------------------------------------------------------------------------

    Dosis(String navn, LocalTime tid, double antal) { // OBS: Package visible
        this.navn = navn;
        this.tid = tid;
        this.antal = antal;
    }

    public String getNavn() {
        return navn;
    }

    public double getAntal() {
        return antal;
    }

    public LocalTime getTid() {
        return tid;
    }

    @Override
    public String toString() {
        return "Kl: " + tid + "   antal:  " + antal;
    }
}
