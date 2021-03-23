package u04lab.code

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u04lab.code.Lists.List._

class OptionalTasksTest {

  @Test
  def testFactoryList(): Unit ={
    var list = ListFactory(1, 2, 4, 5)
    assertEquals(Cons(1, Cons(2, Cons(4, Cons(5, Nil())))), list)

    list = ListFactory(3)
    assertEquals(Cons(3, Nil()), list)
  }

  @Test
  def testExtractor(): Unit ={
    val c1 = Course("PPS","Viroli")
    val c2 = Course("PCD","Ricci")
    val c3 = Course("SDR","D'Angelo")
    val c4 = Course("OOP","Viroli")

    var courses = ListFactory(c1 ,c2 ,c3, c4)

    courses match {
      case sameTeacher(_) => assert(false)
      case _ => assert(true); println(s"$courses have different teachers")
    }

    courses = ListFactory(c1 , c4)
    courses match {
      case sameTeacher(t) => assertEquals("Viroli", s"$t"); println (s"$courses have same teacher $t");
    }
  }

}
