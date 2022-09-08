package TestProjektStudent.ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    Laegemiddel paracetamol = new Laegemiddel("Paracetamol", 1, 1.5,
            2, "Ml");

    @Test
    void doegnDosisBrugt0() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,17),paracetamol,1);
        //Act
        double actual = pn.doegnDosis();
        //Assert
        assertEquals(0,actual);
    }

    @Test
    void doegnDosisBrugt1() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,17),paracetamol,1);
        pn.givDosis(LocalDate.of(2022,9,15));
        //Act
        double actual = pn.doegnDosis();
        //Assert
        assertEquals(1,actual);
    }

    @Test
    void doegnDosisBrugt2() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,17),paracetamol,1);
        pn.givDosis(LocalDate.of(2022,9,15));
        pn.givDosis(LocalDate.of(2022,9,16));
        //Act
        double actual = pn.doegnDosis();
        //Assert
        assertEquals(1,actual);
    }

    @Test
    void doegnDosisBrugt3() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,17),paracetamol,1);
        pn.givDosis(LocalDate.of(2022,9,15));
        pn.givDosis(LocalDate.of(2022,9,16));
        pn.givDosis(LocalDate.of(2022,9,17));

        //Act
        double actual = pn.doegnDosis();
        //Assert
        assertEquals(1,actual);
    }
    @Test
    void doegnDosisBrugt4GangePaa3Dage() {
        //Arrange
        PN pn = new PN(LocalDate.of(2022,9,15),LocalDate.of(2022,9,17),paracetamol,1);
        pn.givDosis(LocalDate.of(2022,9,15));
        pn.givDosis(LocalDate.of(2022,9,16));
        pn.givDosis(LocalDate.of(2022,9,17));
        pn.givDosis(LocalDate.of(2022,9,17));

        //Act
        double actual = pn.doegnDosis();
        //Assert
        assertEquals(1.33,actual,0.01);
    }


}