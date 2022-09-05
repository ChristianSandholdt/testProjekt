package TestProjektStudent.ordination;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private final String cprnr;
    private final String navn;
    private final double vaegt;

    //--------------------------------------------------------------------------------------------
    public List<Ordination> ordinationer = new ArrayList<>();

    public List<Ordination> getOrdinationer(){
        return new ArrayList<>(ordinationer);
    }

    public void addOrdination(Ordination ordination){
        ordinationer.add(ordination);
    }
    //--------------------------------------------------------------------------------------------
    public Patient(String cprnr, String navn, double vaegt) {
        this.cprnr = cprnr;
        this.navn = navn;
        this.vaegt = vaegt;
    }

    public String getCprnr() {
        return cprnr;
    }

    public String getNavn() {
        return navn;
    }

    public double getVaegt() {
        return vaegt;
    }

    @Override
    public String toString() {
        return navn + "  " + cprnr;
    }
}
