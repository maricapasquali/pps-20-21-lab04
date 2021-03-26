package u04lab.code

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u04lab.code.Lists.List
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
    val debugSameTeacher: (List[Course], String) => String = (c, t) => s"$c have same teacher $t"
    val debugDifferentTeacher: List[Course] => String = c => s"$c have different teachers"

    val c1 = Course("PPS","Viroli")
    val c2 = Course("PCD","Ricci")
    val c3 = Course("SDR","D'Angelo")
    val c4 = Course("OOP","Viroli")

    var courses = ListFactory(c1 ,c2 ,c3, c4)

    courses match {
      case sameTeacher(t) => assert(assertion = false, debugSameTeacher(courses, t))
      case _ => assert(true); println(debugDifferentTeacher(courses))
    }

    courses = ListFactory(c1 , c4)
    courses match {
      case sameTeacher(t) => assertEquals("Viroli", t); println(debugSameTeacher(courses, t));
      case _ => assert(assertion = false, debugDifferentTeacher(courses))
    }

    courses = Nil()
    courses match {
      case sameTeacher(_) => assert(assertion = false, s"courses NOT empty")
      case _ => assert(true); println(s"courses is empty")
    }
  }

}
