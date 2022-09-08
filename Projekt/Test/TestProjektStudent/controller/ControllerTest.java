package TestProjektStudent.controller;

import TestProjektStudent.ordination.DagligFast;
import TestProjektStudent.ordination.DagligSkaev;
import TestProjektStudent.ordination.Laegemiddel;
import TestProjektStudent.ordination.Patient;
import TestProjektStudent.storage.Storage;
import org.junit.jupiter.api.Test;

import javax.naming.ldap.Control;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {



    Laegemiddel paracetamol = new Laegemiddel("Paracetamol", 1, 1.5,2, "Ml");



    Patient vaegt1 = new Patient("1234","Martin",1);
    Patient vaegt24 = new Patient("1234","Martin",24);
    Patient vaegt25 = new Patient("1234","Martin",25);
    Patient vaegt69 = new Patient("1234","Martin",69);
    Patient vaegt120 = new Patient("1234","Martin",120);
    Patient vaegt121 = new Patient("1234","Martin",121);
    Patient vaegt145 = new Patient("1234","Martin",145);
//    Patient vaegtMinus1 = new Patient("1234","Martin",-1);


     /**
     * PRE: Vægt > 0
     */

    @Test
    void anbefaletDosisPrDoegnVaegt1() {
        //Act
        double actual = Controller.anbefaletDosisPrDoegn(vaegt1,paracetamol);
        //Assert
        assertEquals(1,actual);
    }
    @Test
    void anbefaletDosisPrDoegnVaegt24() {
        //Act
        double actual = Controller.anbefaletDosisPrDoegn(vaegt24,paracetamol);
        //Assert
        assertEquals(24*1,actual);
    }
    @Test
    void anbefaletDosisPrDoegnVaegt25() {
        //Act
        double actual = Controller.anbefaletDosisPrDoegn(vaegt25, paracetamol);
        //Assert
        assertEquals(25*1.5, actual);
    }
    @Test
    void anbefaletDosisPrDoegnVaegt69() {
        //Act
        double actual = Controller.anbefaletDosisPrDoegn(vaegt69, paracetamol);
        //Assert
        assertEquals(69*1.5, actual);
    }
    @Test
    void anbefaletDosisPrDoegnVaegt120() {
        //Act
        double actual = Controller.anbefaletDosisPrDoegn(vaegt120,paracetamol);
        //Assert
        assertEquals(120*1.5,actual);
    }
    @Test
    void anbefaletDosisPrDoegnVaegt121() {
        //Act
        double actual = Controller.anbefaletDosisPrDoegn(vaegt121,paracetamol);
        //Assert
        assertEquals(121*2,actual);
    }
    @Test
    void anbefaletDosisPrDoegnVaegt145() {
        //Act
        double actual = Controller.anbefaletDosisPrDoegn(vaegt145,paracetamol);
        //Assert
        assertEquals(145*2,actual);
    }
//    @Test
//    void anbefaletDosisPrDoegnVaegtMinus1() {
//        //Act
//        double actual = Controller.anbefaletDosisPrDoegn(vaegtMinus1, paracetamol);
//        //Assert
//        assertEquals(-1*1.0,actual);
//    }

    @Test
    void opretDagligFastOrdination(){
        //Arrange
        Storage storage = new Storage();
        Controller.setStorage(storage);
        Patient p = Controller.opretPatient("121212", "Kurt", 100.0);

        //Act
        DagligFast d = Controller.opretDagligFastOrdination(LocalDate.of(2022,9,15),
                LocalDate.of(2022,9, 17),p,paracetamol,
                1,2,3,4);

        //Assert
        assertNotNull(d);
        assertTrue(storage.getAllPatienter().get(0).getOrdinationer().contains(d));
        assertEquals(1,d.getDoser()[0].getAntal() );
        assertEquals(2,d.getDoser()[1].getAntal() );
        assertEquals(3,d.getDoser()[2].getAntal());
        assertEquals(4,d.getDoser()[3].getAntal());
        assertEquals(LocalDate.of(2022,9,15), d.getStartDato());
        assertEquals(LocalDate.of(2022,9,17), d.getSlutDato());
    }


}