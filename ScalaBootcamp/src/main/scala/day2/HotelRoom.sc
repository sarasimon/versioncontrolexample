//List of Days: 2 types weekday and weekend
//Type of customer
//
//input: Regular, List(Weekday, Weekday, Weekend) = list of number of days
//output: name of the best hotel (cheapest hotel) if there is a tie, give the higher rating

sealed trait Customer
case object RegularCustomer extends Customer
case object RewardsCustomer extends Customer

sealed trait Day
case object Weekday extends Day
case object Weekend extends Day

case class Category(customer: Customer, day: Day)

type Price = Int

case class BookingRequest(customer: Customer, days: List[Day]) {
  def categories = days.map(day => Category(customer, day))
}

case class Hotel(name: String, rating: Int, rateCard: Map[Category, Price]) {
  def priceFor(bookingRequest: BookingRequest): Int = {
    bookingRequest.categories.map(rateCard).sum
  }
}

class HotelRepo(hotels: Hotel*) {
  def getBestHotel(bookingRequest: BookingRequest): String = {
    hotels.minBy(hotel => (hotel.priceFor(bookingRequest), - hotel.rating)).name
  }
}

//HotelRoom(RegularCustomer,List(Weekday,Weekday,Weekend))