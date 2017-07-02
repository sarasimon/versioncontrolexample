


//val socket = Socket()
//val packet: Future[Array[Byte]] =
//  socket.readFromMemory()
//val confirmation: Future[Array[Byte]] =
//  packet.flatMap(p => socket.sendToEurope(p))
//
//def sendToSafe(packet: Array[Byte]): Future[Array[Byte]] =
//  sendTo()
//
//def sendTo(url: URL, packet: Array[Byte]): Future[Array[Byte]] =
//  Http(url, Request(packet))
//    .filter(response => response.isOK)
//    .map(response => response.toByteArray)
