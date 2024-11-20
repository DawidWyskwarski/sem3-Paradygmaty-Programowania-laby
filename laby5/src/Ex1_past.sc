import java.lang.module.ModuleFinder.compose
import scala.language.postfixOps

def compList[A](xs:List[ A => A ]): A=>A =
  xs match
    case Nil => throw new Exception("aaaaaaaaaaa");
    case _ =>
      def compListRec(xs:List[A=>A], resultingFun:A=>A): A=>A =
        xs match
          case Nil => resultingFun
          case head::tail => compListRec(tail,head.compose(resultingFun))
      compListRec(xs.tail,xs.head)

def compListFold[A](xs:List[A=>A]): A=>A =
  xs match
    case Nil => throw new Exception("aaaaaaaaaaa");
    case head::tail =>
     tail.foldLeft(head)( (acc,x) => x.compose(acc) )


val f1: Double => Double = x => 2*x
val f2: Double => Double = x => x*x

compList(List(f1,f2))(9)
compListFold(List(f1,f2))(9)