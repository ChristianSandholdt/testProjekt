package TestProjektStudent.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import TestProjektStudent.ordination.*;
import TestProjektStudent.storage.Storage;

public abstract class Controller {
    private static Storage storage;

    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }

    /**
     * Opret og returner en PN ordination.
     * Hvis startDato er efter slutDato, kastes en IllegalArgumentException,
     * og ordinationen oprettes ikke.
     * Pre: antal > 0.
     */
    public static PN opretPNOrdination(
            LocalDate startDato, LocalDate slutDato, Patient patient, Laegemiddel laegemiddel, double antal) {
        PN pn;
        if (startDato.isBefore(slutDato)){
            pn = new PN(startDato,slutDato,laegemiddel,antal);
            patient.addOrdination(pn);
        }else
            throw new IllegalArgumentException("Startdatoen er efter slutdatoen. FEJL!");

        return pn;
    }

    /**
     * Opret og returner en DagligFast ordination.
     * Hvis startDato er efter slutDato, kastes en IllegalArgumentException,
     * og ordinationen oprettes ikke.
     * Pre: morgenAntal, middagAntal, aftenAntal, natAntal >= 0
     */
    public static DagligFast opretDagligFastOrdination(
            LocalDate startDato, LocalDate slutDato, Patient patient, Laegemiddel laegemiddel,
            double morgenAntal, double middagAntal, double aftenAntal, double natAntal) {
        DagligFast dagligFast;
        if (startDato.isBefore(slutDato)){
            dagligFast = new DagligFast(startDato,slutDato,laegemiddel);
            dagligFast.opretDosis(morgenAntal, middagAntal, aftenAntal, natAntal);
            patient.addOrdination(dagligFast);
        }else
            throw new IllegalArgumentException("Startdatoen er efter slutdatoen. FEJL!");

        return dagligFast;
    }

    /**
     * Opret og returner en DagligSkæv ordination.
     * Hvis startDato er efter slutDato, kastes en IllegalArgumentException,
     * og ordinationen oprettes ikke.
     * Hvis antallet af elementer i klokkeSlet og antalEnheder er forskellige,
     * kastes en IllegalArgumentException.
     * Pre: I antalEnheder er alle tal >= 0.
     */
    public static DagligSkaev opretDagligSkaevOrdination(
            LocalDate startDato, LocalDate slutDato, Patient patient, Laegemiddel laegemiddel,
            LocalTime[] klokkeSlet, double[] antalEnheder) {
        DagligSkaev dagligSkaev = null;
        if (startDato.isBefore(slutDato)){
            dagligSkaev = new DagligSkaev(startDato,slutDato,laegemiddel);
            patient.addOrdination(dagligSkaev);
            
            for (int i = 0; i < antalEnheder.length; i++){
                dagligSkaev.opretDosis(klokkeSlet[i], antalEnheder[i]);
            }
        }
        return dagligSkaev;
    }

    /**
     * Tilføj en dato for anvendelse af PN ordinationen.
     * Hvis datoen ikke er indenfor ordinationens gyldighedsperiode,
     * kastes en IllegalArgumentException.
     */
    public static void ordinationPNAnvendt(PN ordination, LocalDate dato) {
        ArrayList<LocalDate> anvendt = new ArrayList<>();
        if (dato.isAfter(ordination.getStartDato()) || dato.isBefore(ordination.getSlutDato())){
            anvendt.add(dato);
        }else
            throw new IllegalArgumentException("Startdatoen er efter slutdatoen. FEJL!");
    }

    /**
     * Returner den anbefalede dosis pr. døgn af lægemidlet til patienten
     * (afhænger af patientens vægt).
     */
    public static double anbefaletDosisPrDoegn(Patient patient, Laegemiddel laegemiddel) {
        double dosis = 0;
        if (patient.getVaegt() < 25){
            dosis = laegemiddel.getEnhedPrKgPrDoegnLet();
        }
        else if (patient.getVaegt() >= 25|| patient.getVaegt() < 120){
            dosis = laegemiddel.getEnhedPrKgPrDoegnNormal();
        }
        else dosis = laegemiddel.getEnhedPrKgPrDoegnTung();
        return dosis;
    }

    /** Returner antal ordinationer for det givne vægtinterval og det givne lægemiddel. */
    public static int antalOrdinationerPrVaegtPrLaegemiddel(
            double vaegtStart, double vaegtSlut, Laegemiddel laegemiddel) {
        ArrayList<Ordination> ordinationer = new ArrayList<>();
        for (Patient p : getAllPatienter()){
            if (p.getVaegt() >= vaegtStart && p.getVaegt() <= vaegtSlut){
                ordinationer.addAll(p.getOrdinationer());
            }
        }
        return ordinationer.size();
    }

    public static List<Patient> getAllPatienter() {
        return storage.getAllPatienter();
    }

    public static List<Laegemiddel> getAllLaegemidler() {
        return storage.getAllLaegemidler();
    }

    public static Patient opretPatient(String cpr, String navn, double vaegt) {
        Patient p = new Patient(cpr, navn, vaegt);
        storage.storePatient(p);
        return p;
    }

    public static Laegemiddel opretLaegemiddel(
            String navn, double enhedPrKgPrDoegnLet, double enhedPrKgPrDoegnNormal,
            double enhedPrKgPrDoegnTung, String enhed) {
        Laegemiddel lm = new Laegemiddel(navn, enhedPrKgPrDoegnLet,
                enhedPrKgPrDoegnNormal, enhedPrKgPrDoegnTung, enhed);
        storage.storeLaegemiddel(lm);
        return lm;
    }

    public static void initStorage() {
        Patient jane = opretPatient("121256-0512", "Jane Jensen", 63.4);
        Patient finn = opretPatient("070985-1153", "Finn Madsen", 83.2);
        opretPatient("050972-1233", "Hans Jørgensen", 89.4);
        opretPatient("011064-1522", "Ulla Nielsen", 59.9);
        Patient ib = opretPatient("090149-2529", "Ib Hansen", 87.7);

        Laegemiddel acetylsalicylsyre = opretLaegemiddel(
                "Acetylsalicylsyre", 0.1, 0.15,
                0.16, "Styk");
        Laegemiddel paracetamol = opretLaegemiddel(
                "Paracetamol", 1, 1.5,
                2, "Ml");
        Laegemiddel fucidin = opretLaegemiddel(
                "Fucidin", 0.025, 0.025,
                0.025, "Styk");
        opretLaegemiddel(
                "Methotrexate", 0.01, 0.015,
                0.02, "Styk");

        opretPNOrdination(LocalDate.parse("2019-01-01"), LocalDate.parse("2019-01-12"),
                jane, paracetamol, 123);

        opretPNOrdination(LocalDate.parse("2019-02-12"), LocalDate.parse("2019-02-14"),
                jane, acetylsalicylsyre, 3);

        opretPNOrdination(LocalDate.parse("2019-01-20"), LocalDate.parse("2019-01-25"),
                ib, fucidin, 5);

        opretPNOrdination(LocalDate.parse("2019-01-01"), LocalDate.parse("2019.01-12"),
                jane, paracetamol, 123);

        opretDagligFastOrdination(LocalDate.parse("2019-01-10"), LocalDate.parse("2019-01-12"),
                finn, fucidin, 2, 0, 1, 0);

        LocalTime[] kl = {
                LocalTime.parse("12:00"), LocalTime.parse("12:40"),
                LocalTime.parse("16:00"), LocalTime.parse("18:45")};
        double[] an = {0.5, 1, 2.5, 3};
        opretDagligSkaevOrdination(LocalDate.parse("2019-01-23"), LocalDate.parse("2019-01-24"),
                finn, fucidin, kl, an);
    }
}