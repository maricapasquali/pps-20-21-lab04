package u04lab.code

import u04lab.code.Lists._
import u04lab.code.Lists.List._
import u04lab.code.Optionals.Option.{Some, None, toScalaOption}

/**
 * 4. Implement a factory List(e1,e2,...) that builds a list Cons(e1,Cons(e2,...))
 *    out of the variable number of elements provided.
 */
object ListFactory {
  def apply[A](args: A*): List[A] = {
    var list: List[A] = Nil()
    args foreach(arg => list = append(list, Cons(arg, Nil())))
    list
  }
}

/**
 * 5. Implement an extractor sameTeacher(t) on a list of Courses that extracts the
 *    teacher t in common to ALL courses (if any) NB: extractors (unapply) must use
 *    scala.Option, scala.Some...
 *    (it is easy to write a method to convert "our" Option to Scala's one)
 * */
object sameTeacher {
  def unapply(courses: List[Course]): scala.Option[String] = {
    @scala.annotation.tailrec
    def _unapply(cs: List[Course])(t: String): scala.Option[String]  = cs match {
      case Cons(head, tail) if head.teacher == t => _unapply(tail)(t)
      case Nil() => toScalaOption(Some(t))
      case _ => toScalaOption(None())
    }
    courses match {
      case Cons(head, tail) => _unapply(tail)(head.teacher)
      case Nil() => toScalaOption(None())
    }
  }
}



