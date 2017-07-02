val map = Map(1 -> "a", 2 -> "b")

val option: Option[String] = map.get(1)
val option2: Option[String] = map.get(0)

sealed trait MyOption[T]
case class None extends MyOption[Null]
case class Some[T](value: T) extends MyOption[T]

sealed trait MyTree[T]
case class Leaf[T](x : T) extends MyTree[]
case class Node[T](left: MyTree[T], right: MyTree[T])

//AST abstract syntax tree.

//JsNull
//
//JsBoolean
//JsNumber
//JSJavaString
//
//JSJavaArray
//JSObject

sealed trait Json

case object JsNull extends Json

case class JsTrue() extends Json
case class JsFalse() extends Json

case class JsBoolean() extends JsTrue; JsFalse
case class JsNumber(sig)

case class JsArray(values: List[Json])
case class JsObject(key: String, value: Json)

