package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {

    private LocalDate startDen;
    private LocalDate slutDen;

    // association --> 0..1 laegemiddel
    private Laegemiddel laegemiddel; // nullable

    // ----------------------------------------------------------------------------------------------------------------
    public Ordination(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel){
        this.startDen = startDen;
        this.slutDen = slutDen;
        this.laegemiddel = laegemiddel;
    }

    public LocalDate getStartDen() {
        return startDen;
    }

    public LocalDate getSlutDen() {
        return slutDen;
    }

    /** Note: Nullable return value. */
    public Laegemiddel getLaegemiddel() {
        return laegemiddel;
    }

    /** Pre: This person is not connected to a laegemiddel. */
    public void setLaegemiddel(Laegemiddel laegemiddel) {
        this.laegemiddel = laegemiddel;
    }

    /** Pre: This person is connected to a laegemiddel. */
    public void removeLaegemiddel() {
        this.laegemiddel = null;
    }

    /** Returner antal hele dage mellem startdato og slutdato. Begge dage inklusive. */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDen, slutDen) + 1;
    }

    @Override
    public String toString() {
        return startDen.toString();
    }

    /** Returner den totale dosis, der er givet i den periode ordinationen er gyldig. */
    public abstract double samletDosis();
    

    /** Returner den gennemsnitlige dosis givet pr dag i den periode, ordinationen er gyldig. */
    public abstract double doegnDosis();

    /** Returner ordinationstypen som en String. */
    public abstract String getType();
}
