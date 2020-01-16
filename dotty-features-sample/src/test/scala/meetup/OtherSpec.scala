package meetup

import org.junit.Assert._
import org.junit.Test

class OtherSpec {
  @Test def wildcardTypes(): Unit = {
    //Works
    val l1: List[?] = List(123)
    //Works for now, but is deprecated
    val l2: List[_] = List(456)
    println(s"l1=$l1, l2=$l2")
  }
}