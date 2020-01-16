package meetup

import org.junit.Assert._
import org.junit.Test

class OtherSpec {
  @Test def wildcardTypes(): Unit = {
    //Works
    val l1: List[?] = List(123)
    //Works for now, but is deprecated. With "-strict" compiler option doesn't work
    //    val l2: List[_] = List(456)
    println(s"l1=$l1")
    //    println(s"l1=$l1, l2=$l2")
  }

  @Test def matches(): Unit = {
    val v1 = "aaa"

    val v2 = v1 match {
      case "aaa" => "3a"
      case _ => "other"
    }
    match
    {
      case "3a" => "three a"
      case _ => "something other"
    }

    println("v2=" + v2)
  }

  @Test def decomposition(): Unit = {
    //    val l1: List[Any] = List(1, 2)
    val l1: List[Any] = List(1, 2, 3)
    val t1 = (1, 2, 3)
    //    val l1 = List(1, 2, 3)
    //    val l1 = List(1, 2, 3, 4)
    //    val a :: b :: c = l1
    //    val (a: String) :: b :: c = l1

    //Doesn't compile with -strict
    //    val (a: String) :: _ = l1
    //Doesn't compile with -strict
    //    val a :: b  = l1
    //Doesn't compile with -strict
    //    val a :: _  = l1
    //Does compile even with -strict
    val a :: _ : @unchecked = l1
    //Also compile even with -strict, but fails in runtime
    //    val (a: String) :: _ : @unchecked  = l1
    println(s"a=$a")
    //    println(s"a,b,c=$a, $b, $c")
    //    println(s"a,b=$a, $b")

//    val elems = (1, 2, 3)
    val (x, _, _) = t1
    println(s"x=$x")

  }
}