import org.scalatest.flatspec.AnyFlatSpec

class TestCalculator extends AnyFlatSpec {
  "A calculator" should "add numbers properly" in {
    val x: Expression = Addition(Number(2), Number(5))
    assertResult(7) {
      x.evaluate()
    }
  }
  it should "subtract properly" in {
    val x = Subtraction(Number(10), Number(5))
    assert(x.evaluate() == 5)
  }
}
