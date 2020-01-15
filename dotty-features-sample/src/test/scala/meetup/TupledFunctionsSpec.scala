package meetup

import org.junit.Test
import org.junit.Assert._

class TupledFunctionsSpec {
  import TupledFunctionsSpec._

  def m2(a: Int, b: Int): Int = {
    a + b
  }

  val f2 = m2 _

  def m26(a: Int,
          b: Int,
          c: Int,
          d: Int,
          e: Int,
          f: Int,
          g: Int,
          h: Int,
          i: Int,
          j: Int,
          k: Int,
          l: Int,
          m: Int,
          n: Int,
          o: Int,
          p: Int,
          q: Int,
          r: Int,
          s: Int,
          t: Int,
          u: Int,
          v: Int,
          w: Int,
          x: Int,
          y: Int,
          z: Int): Int = {
    a +
      b +
      c +
      d +
      e +
      f +
      g +
      h +
      i +
      j +
      k +
      l +
      m +
      n +
      o +
      p +
      q +
      r +
      s +
      t +
      u +
      v +
      w +
      x +
      y +
      z
  }

  val f26 = m26 _


  @Test def t1(): Unit = {
    println("f2=" + f2(10, 20))
    val f2t = f2.tupled
    val t2 = (10, 20)
    println("f2t=" + f2t(t2))

    println("f26=" + f26(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26))
    //with implicits
    val f26t = f26.tupled
    //with "explicits" requires tedious type specification - doesn't work this way:
//    val f26t = scala.internal.TupledFunction.tupledFunctionXXL.tupled(f26)
    val t26 = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26)
    println("f26t=" + f26t(t26))
  }

}

object TupledFunctionsSpec {
  def [F, Args <: Tuple, R](f: F) tupled (given tf: TupledFunction[F, Args => R]): Args => R = tf.tupled(f)
}


