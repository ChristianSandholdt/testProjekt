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

        Dosis[] doser = dagligFast.getDoser();
        //Assert
        dagligFast.opretDosis(1,2,3,4);
        //Act
        assertEquals(doser[0].getTid(), actualMorgen.getTid());
        assertEquals(doser[0].getAntal(), actualMorgen.getAntal());

        assertEquals(doser[1].getTid(), actualMiddag.getTid());
        assertEquals(doser[1].getAntal(), actualMiddag.getAntal());

        assertEquals(doser[2].getTid(), actualAften.getTid());
        assertEquals(doser[2].getAntal(), actualAften.getAntal());

        assertEquals(doser[3].getTid(), actualNat.getTid());
        assertEquals(doser[3].getAntal(), actualNat.getAntal());
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
//        assertEquals(doser[0].getTid(), actualMorgen.getTid());
//        assertEquals(doser[0].getAntal(), actualMorgen.getAntal());
//
//        assertEquals(doser[1].getTid(), actualMiddag.getTid());
//        assertEquals(doser[1].getAntal(), actualMiddag.getAntal());
//
//        assertEquals(doser[2].getTid(), actualAften.getTid());
//        assertEquals(doser[2].getAntal(), actualAften.getAntal());
//
//        assertEquals(doser[3].getTid(), actualNat.getTid());
//        assertEquals(doser[3].getAntal(), actualNat.getAntal());
//    }

}