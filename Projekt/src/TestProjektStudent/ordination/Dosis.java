package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.time.LocalTime;

public class Dosis {
    private final LocalTime tid;
    private final double antal;

    // ----------------------------------------------------------------------------------------------------------------

    Dosis(LocalTime tid, double antal) { // OBS: Package visible
        this.tid = tid;
        this.antal = antal;
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
