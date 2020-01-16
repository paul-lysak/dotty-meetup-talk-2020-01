package meetup

import org.junit.Assert._
import org.junit.Test

class ProgrammaticStructuresSpec {
  import ProgrammaticStructuresSpec._

  @Test def t1(): Unit = {
    val tx = Record("id" -> "qqq123", "amount" -> 100500, "message" -> "just for fun").asInstanceOf[Transaction]
    //No compile-time check for available fields during creation - this will compile, but tail at the runtime
//    val tx = Record("id" -> "qqq123", "amount" -> 100500, "msg" -> "just for fun").asInstanceOf[Transaction]
    println(s"id=${tx.id}, amount=${tx.amount}, ${tx.message}")
    //There's compile-time check when using the fields - this wouldn't compile
//    println(s"id=${tx.id}, amount=${tx.amount}, ${tx.msg}")
  }
}

object ProgrammaticStructuresSpec {

  case class Record(elems: (String, Any)*) extends Selectable {
    def selectDynamic(name: String): Any = elems.find(_._1 == name).get._2
  }

  type Transaction = Record {
    val id: String
    val amount: Int
    val message: String
  }

}