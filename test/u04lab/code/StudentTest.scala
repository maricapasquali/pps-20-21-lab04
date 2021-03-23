package u04lab.code;

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u04lab.code.Lists.List.{Cons, Nil}

class StudentTest {

  @Test
  def testEnrollingCourseS(): Unit ={
    val PPS = "PPS";
    val PCD = "PCD";
    val SDR = "SDR"

    val cPPS = Course(PPS,"Viroli")
    val cPCD = Course(PCD,"Ricci")
    val cSDR = Course(SDR,"D'Angelo")

    val s4 = Student("anna",2018);
    s4.enrolling(cPPS, cPCD, cSDR);

    assertEquals(Cons(SDR,Cons(PCD,Cons(PPS,Nil()))), s4.courses)
  }

}