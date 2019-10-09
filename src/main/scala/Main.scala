import Examples._
import cats.Monoid
import cats.Semigroup
import cats.instances.int._
import cats.instances.string._
import cats.instances.option._

object Main {

  def main(args: Array[String]): Unit = {

    //
    // semigroup from cats
    //
    val s1: String = Semigroup[String].combine("My ", "Semigroup")
    println(s1)
    // "My Semigroup"

    //
    // monoid from cats
    //
    val m1: String = Monoid[String].combine("My ", "Monoid")
    println(m1)
    // "Hi there"

    val m2: String = Monoid[String].empty
    println(m2)
    // ""

    val m3: Int = Monoid[Int].combine(1, 2)
    println(m3)
    // 3

    val m4: Int = Monoid[Int].empty
    println(m4)
    // 0

    //
    // generic use of monoids
    //
    val m5: Int = addAll(List(1, 2, 3))
    println(m5)
    // 6

    val m6: Option[Int] = addAll(List(Some(1), None, Some(2)))
    println(m6)
    // Some(3)

  }

}
