package TestProjektStudent.ordination;

import TestProjektStudent.controller.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DagligFastTest {

    private Laegemiddel paracetamol;

    @BeforeEach
    void setup(){
        paracetamol = new Laegemiddel("Paracetamol",
                1,1.5,2,"ml");
    }

    /**
     * PRE: Antal skal være større end 0
     */

    @Test
    void opretDosisPositives() {
        //Arrange
        DagligFast dagligFast = new DagligFast(LocalDate.of(2022,9,15),
                LocalDate.of(2022,9,17),paracetamol);
        Dosis actualMorgen = new Dosis(LocalTime.of(8,0),1);
        Dosis actualMiddag = new Dosis(LocalTime.of(12,0),2);
        Dosis actualAften = new Dosis(LocalTime.of(18,0),3);
        Dosis actualNat = new Dosis(LocalTime.of(0,0),4);

        //Assert
        dagligFast.opretDosis(1,2,3,4);
        //Act
        assertEquals(LocalTime.of(8,0), actualMorgen.getTid());
        assertEquals(1, actualMorgen.getAntal());

        assertEquals(LocalTime.of(12,0), actualMiddag.getTid());
        assertEquals(2, actualMiddag.getAntal());

        assertEquals(LocalTime.of(18,0), actualAften.getTid());
        assertEquals(3, actualAften.getAntal());

        assertEquals(LocalTime.of(0,0), actualNat.getTid());
        assertEquals(4, actualNat.getAntal());
    }



//    @Test
//    void opretDosisWithNegativesExpectedError() {
//        //Arrange
//        DagligFast dagligFast = new DagligFast(LocalDate.of(2022,9,15),
//                LocalDate.of(2022,9,17),paracetamol);
//        Dosis actualMorgen = new Dosis(LocalTime.of(8,0),-1);
//        Dosis actualMiddag = new Dosis(LocalTime.of(12,0),2);
//        Dosis actualAften = new Dosis(LocalTime.of(18,0),-3);
//        Dosis actualNat = new Dosis(LocalTime.of(0,0),4);
//
//        Dosis[] doser = dagligFast.getDoser();
//        //Assert
//
//        dagligFast.opretDosis(-1,2,-3,4);
//        //Act
//        assertEquals(LocalTime.of(8,0), actualMorgen.getTid());
//        assertEquals(-1, actualMorgen.getAntal());
//
//        assertEquals(LocalTime.of(12,0), actualMiddag.getTid());
//        assertEquals(2, actualMiddag.getAntal());
//
//        assertEquals(LocalTime.of(18,0), actualAften.getTid());
//        assertEquals(-3, actualAften.getAntal());
//
//        assertEquals(LocalTime.of(0,0), actualNat.getTid());
//        assertEquals(4, actualNat.getAntal());
//    }

}