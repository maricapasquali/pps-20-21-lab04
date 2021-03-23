package u04lab.code;

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test;

class ComplexTest {

  /**
   * TEST FAIL with class implementation
   * TEST PASS with case class implementation
   */
  @Test
  def testEqualsComplex(): Unit ={
    val complex1 = Complex(1, 30)
    val complex2 = Complex(10, 2)

    val sum = complex1 + complex2
    val prod = complex1 * complex2

    println(s"Somma $sum")
    println(s"Prodotto $prod")

    assertEquals(Complex(11.0, 32.0), sum)
    assertEquals(Complex(-50.0, 302.0), prod)
  }

}