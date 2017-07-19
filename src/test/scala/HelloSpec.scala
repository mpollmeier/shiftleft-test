package example

import org.scalatest._

class HelloSpec extends WordSpec with Matchers {
  "blubs very much" in {
    2 shouldBe 1
  }
}
