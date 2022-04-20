sealed trait Expression {
  def evaluate(): Double = this match {
    case Addition(l, r) => l.evaluate() + r.evaluate()
    case Subtraction(l, r) => l.evaluate() - r.evaluate()
    case Number(v) => v
  }
}
final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Number(value: Double) extends Expression


