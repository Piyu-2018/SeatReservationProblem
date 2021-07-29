import scala.io.StdIn._

object SeatReservation extends App{
  var airports= Array("Colombo","Mumbai","Delhi","Kolkata")

  var colomboToDelhi = Array(Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0))
  var delhiToMumbai = Array(Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0))
  var mumbaiToKolkata = Array(Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0),Array(0,0,0,0,0,0))

  // Colombo -> Delhi -> Mumbai -> Kolkata

  def reserveSeat(airport:String, destination:String, m:Int, n:Int):Unit={
    var airportId:Int = 0
    var destinationId:Int = 0
    var count:Int = 0

    for(k <- airports){
      if(k == airport){
        airportId = count
      }
      else if(k == destination){
        destinationId=count
      }
      count=count+1
    }
    count=airportId
    for(j<- airports){
      if(j == airport && destinationId>count){
        j match{
          case "Colombo" => if(colomboToDelhi(m)(n) == 1){
            println("The seat is cannot reserve")
          }
            else{
            colomboToDelhi(m)(n) =1
            println("Reserve this seat")
          }
          case "Delhi" => if(delhiToMumbai(m)(n) == 1){
            println("The seat is cannot reserve")
          }
          else{
            delhiToMumbai(m)(n) =1
            println("Reserve this seat")
          }
          case "Mumbai" => if(mumbaiToKolkata(m)(n) == 1){
            println("The seat is cannot reserve")
          }
          else{
            mumbaiToKolkata(m)(n) =1
            println("Reserve this seat")
          }
        }
      }
    }
    if(airportId <= destinationId){
      for(k <- airportId to destinationId){
        print(airports(k))
        if(destinationId != k){
          print("->")
        }
      }
    }
    println("")
  }

  def display():Unit={
    for(a <- colomboToDelhi){
      for(b <- a){
        print(b+" ")
      }
      println("")
    }
  }

  println("Enter airport name: ")
  var airportName:String = readLine()
  println("Enter destination: ")
  var destinationName:String = readLine()
  println("Enter seat number(row): ")
  var rowNo:Int = readInt()
  println("Enter seat number(column)")
  var columnNO:Int = readInt()

  reserveSeat(airportName,destinationName,rowNo,columnNO)
  println("")
  reserveSeat("Colombo","Mumbai",2,4)
  println("")
  reserveSeat("Mumbai","Kolkata",2,4)
  println("")
  reserveSeat("Colombo","Delhi",2,3)
  println("")
  display()

}
