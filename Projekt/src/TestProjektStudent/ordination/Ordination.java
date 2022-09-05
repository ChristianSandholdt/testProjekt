package TestProjektStudent.ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {

    private LocalDate startDato;
    private LocalDate slutDato;

    // association --> 0..1 laegemiddel
    private Laegemiddel laegemiddel; // nullable

    // ----------------------------------------------------------------------------------------------------------------
    public Ordination(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel){
        this.startDato = startDen;
        this.slutDato = slutDen;
        this.laegemiddel = laegemiddel;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
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
        return (int) ChronoUnit.DAYS.between(startDato, slutDato) + 1;
    }

    @Override
    public String toString() {
        return startDato.toString();
    }

    /** Returner den totale dosis, der er givet i den periode ordinationen er gyldig. */
    public abstract double samletDosis();
    

    /** Returner den gennemsnitlige dosis givet pr dag i den periode, ordinationen er gyldig. */
    public abstract double doegnDosis();

    /** Returner ordinationstypen som en String. */
    public abstract String getType();
}
