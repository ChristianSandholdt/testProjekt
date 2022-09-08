package TestProjektStudent.ordination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrdinationTest {

    private Ordination ordination;

    /**
     * PRE:Startdato skal være >= slutdato
     */
    Laegemiddel paracetamol = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Ml");

    @Test
    void antalDage15Til17() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,17),paracetamol,1);
        //Act
        int actual = pn.antalDage();
        //Assert
        assertEquals(3,actual);
    }

    @Test
    void antalDage15Til16() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,16),paracetamol,1);
        //Act
        int actual = pn.antalDage();
        //Assert
        assertEquals(2,actual);
    }

    @Test
    void antalDage15Til15() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,15),paracetamol,1);
        //Act
        int actual = pn.antalDage();
        //Assert
        assertEquals(1,actual);
    }

    @Test
    void antalDage15Til14() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,14),paracetamol,1);
        //Act
        int actual = pn.antalDage();
        //Assert
        assertEquals(0,actual);
    }






}