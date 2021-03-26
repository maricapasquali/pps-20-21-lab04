package u04lab.code

import Optionals._
import Lists._
import Streams._

import scala.util.Random

trait PowerIterator[A] {
  def next(): Option[A]
  def allSoFar(): List[A]
  def reversed(): PowerIterator[A]
}

trait PowerIteratorsFactory {

  def incremental(start: Int, successive: Int => Int): PowerIterator[Int]
  def fromList[A](list: List[A]): PowerIterator[A]
  def randomBooleans(size: Int): PowerIterator[Boolean]
}

class PowerIteratorsFactoryImpl extends PowerIteratorsFactory {

  private def fromStream[A](_stream: Stream[A]): PowerIterator[A] = new PowerIterator[A] {

    private var stream = _stream

    private var pastList: List[A] = List.Nil()

    override def next(): Option[A] = stream match {
      case Stream.Cons(h, t) =>
        val next = h();
        pastList = List.Cons(next, pastList)
        stream = t()
        Option.Some(next)
      case _ => Option.None()
    }

    override def allSoFar(): List[A] = List.reverse(pastList)

    override def reversed(): PowerIterator[A] = fromStream(Stream.of(pastList))
  }

  override def incremental(start: Int, successive: Int => Int): PowerIterator[Int] = fromStream(Stream.iterate(start)(successive))

  override def fromList[A](list: List[A]): PowerIterator[A] = fromStream(Stream.of(list))

  override def randomBooleans(size: Int): PowerIterator[Boolean] = fromStream(Stream.take(Stream.generate(Random.nextBoolean()))(size))

}