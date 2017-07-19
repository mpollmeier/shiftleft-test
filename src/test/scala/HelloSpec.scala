package example

import org.scalatest._

class HelloSpec extends WordSpec with Matchers {
  "blubs very much" in {
    1 shouldBe 1
  }
}
