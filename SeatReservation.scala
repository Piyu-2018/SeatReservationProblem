import scala.io.StdIn._

object SeatReservation extends App{
  var airports= Array("Colombo","Mumbai","Delhi","Kolkata")

  var colomboToDelhi = Array(Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0))
  var delhiToMumbai = Array(Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0))
  var mumbaiToKolkata = Array(Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0))


  // Colombo -> Delhi -> Mumbai -> Kolkata

  def reserveSeat(startingPlace:String, destination:String, m:Int, n:Int):Unit={
    var startingPlaceId:Int = 0
    var destinationId:Int = 0
    var count:Int = 0

    for(k <- airports){
      if(k == startingPlace){
        startingPlaceId = count
      }
      else if(k == destination){
        destinationId=count
      }
      count=count+1
    }
    count=startingPlaceId
    for(j<- airports){
      if(j == startingPlace && destinationId>count){
        j match{
          case "Colombo" => if(colomboToDelhi(m-1)(n-1) == 1){
            println("The seat is cannot reserve")
          }
            else{
            colomboToDelhi(m-1)(n-1) =1
            println("Reserve this seat")
          }
          case "Delhi" => if(delhiToMumbai(m-1)(n-1) == 1){
            println("The seat is cannot reserve")
          }
          else{
            delhiToMumbai(m-1)(n-1) =1
            println("Reserve this seat")
          }
          case "Mumbai" => if(mumbaiToKolkata(m-1)(n-1) == 1){
            println("The seat is cannot reserve")
          }
          else{
            mumbaiToKolkata(m-1)(n-1) =1
            println("Reserve this seat")
          }
        }
      }
    }
    if(startingPlaceId <= destinationId){
      for(k <- startingPlaceId to destinationId){
        print(airports(k))
        if(destinationId != k){
          print("->")
        }
      }
    }
    println("")
  }
  var NewArray = Array(Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0),Array(0,0,0,0,0))

  def display():Unit={
    var i,j=0
    for(a <- colomboToDelhi){
      i=0
      for(b <- a){
        NewArray(j)(i) = b
        i = i+1
      }
      j = j+1

    }
    j=0
    for(a <- delhiToMumbai){
      i=0
      for(b <- a){
        if(b==1){
          NewArray(j)(i) = b
        }

        i = i+1
      }
      j = j+1

    }
    j=0
    for(a <- mumbaiToKolkata){
      i=0
      for(b <- a){
        if(b==1){
          NewArray(j)(i) = b
        }

        i = i+1
      }
      j = j+1

    }
    for(a<-NewArray){
      for(b<-a)
      {
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
  reserveSeat("Delhi","Kolkata",3,2)
  println("")
  reserveSeat("Colombo","Delhi",2,3)
  println("")
  display()

}
