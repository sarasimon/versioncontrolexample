
val f: PartialFunction[String,String] = { case "ping" => "pong" }

f("ping")
f("abs")
f.isDefinedAt("pong")


