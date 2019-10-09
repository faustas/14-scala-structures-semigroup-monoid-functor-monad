import cats.Monoid
import cats.syntax.monoid._

/**
 *
 *
 * trait Semigroup[A] {
 *   def combine(x: A, y: A): A
 * }
 *
 * trait Monoid[A] extends Semigroup[A] {
 *   def empty: A
 * }
 */

object Examples {

  /**
   * Generic function that accepts different types to combine them.
   *
   * @param values  The values that should be combined.
   * @param monoid  Monoid with the specified laws of the type.
   * @tparam A      Type of the provided values.
   * @return Added result.
   */
  def addAll[A](values: List[A])(implicit monoid: Monoid[A]): A =
    values.foldRight(monoid.empty)(_ |+| _)

}
