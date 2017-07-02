package Course2.week4

class Consolidator(observed: List[BankAccount]) extends Subscriber {
  private var total: Int = sum()

  private def sum() =
    observed.map(_.currentBalance).sum

  def handler(pub: Publisher) = sum()

  def totalBalance = total
}
