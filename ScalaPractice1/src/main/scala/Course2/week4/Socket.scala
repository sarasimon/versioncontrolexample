package Course2.week4

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}


trait Socket {
  def readFromMemory(): Future[Array[Byte]]

  def sendToEurope(packet: Array[Byte]):
  Future[Array[Byte]]

}

trait Future[T] { self =>
  def flatMap[S](f: T => Future[S]) : Future[S] =
    new Future[S] {
      def onComplete(callback: (Try[S]) => Unit)
                    (implicit executor: ExecutionContext): Unit =
        self onComplete {
          case Success(x) => f(x).onComplete(callback)
          case Failure(e) => callback(Failure(e))
        }
    }

  def onComplete(callback: Try[T] => Unit)
                (implicit executor: ExecutionContext): Unit

}
