package TestProjektStudent.ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DagligSkaevTest {

    /**
     * PRE: Tid skal være  > 0
     *      Tid skal være < 24
     */

    @Test
    void opretDosisWithMinusOne() {
        //Arrange
        //Act
        Dosis actual = new Dosis(LocalTime.of(12,0),-1);
        //Assert
        assertEquals(LocalTime.of(12,0),actual.getTid());
        assertEquals(-1,actual.getAntal());
    }

    @Test
    void opretDosisWithZero(){
        //Arrange
        //Act
        Dosis actual = new Dosis(LocalTime.of(12,0),0);
        //Assert
        assertEquals(LocalTime.of(12,0),actual.getTid());
        assertEquals(0,actual.getAntal());
    }

    @Test
    void opretDosisWithOne(){
        //Arrange
        //Act
        Dosis actual = new Dosis(LocalTime.of(12,0),1);
        //Assert
        assertEquals(LocalTime.of(12,0),actual.getTid());
        assertEquals(1,actual.getAntal());
    }

    @Test
    void opretDosisWithTwo(){
        //Arrange
        //Act
        Dosis actual = new Dosis(LocalTime.of(12,0),2);
        //Assert
        assertEquals(LocalTime.of(12,0),actual.getTid());
        assertEquals(2,actual.getAntal());
    }

    @Test
    void opretDosisWithThree(){
        //Arrange
        //Act
        Dosis actual = new Dosis(LocalTime.of(12,0),3);
        //Assert
        assertEquals(LocalTime.of(12,0),actual.getTid());
        assertEquals(3,actual.getAntal());
    }

    @Test
    void opretDosisWithThreeTime2359(){
        //Arrange
        //Act
        Dosis actual = new Dosis(LocalTime.of(23,59),3);
        //Assert
        assertEquals(LocalTime.of(23,59),actual.getTid());
        assertEquals(3,actual.getAntal());
    }


//    @Test
//    void opretDosisWithThreeTime24ExpectedError(){
//        //Arrange
//        //Act
//        Dosis actual = new Dosis(LocalTime.of(24,0),3);
//        //Assert
//        assertEquals(LocalTime.of(24,0),actual.getTid());
//        assertEquals(3,actual.getAntal());
//    }



}