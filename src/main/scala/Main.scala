import Examples._
import cats.{Functor, Monoid, Semigroup}
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

    val md7: String = addAll(List("I", " am ", " a ", " sentence."))
    println(md7)
    // I am  a  sentence.

    //
    // Functor
    //
    // Option is a Functor
    val x: Option[Int] = Some(1)
    val y: Int = 2
    val m: Int = 2
    // adding an Int to an Option of Int and multiplying that by another
    // Int without e.g. `map` looks like follows
    val f1 = if(x.isDefined) Some((x.get + y) * m) else None
    // wih `map`
    val f2 = x.map(a => (a+y) * m)
    // by using the associative law
    val f3 = x.map(_ + y).map(_ * m)

  }

}
