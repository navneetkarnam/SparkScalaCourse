package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math.max

object MaxPrecipitation {
  
  def parseLine (line:String)= {
    
    val fields = line.split(",")
    val stationID = fields(0)
    val entryType = fields(2)
    val precipitation = fields(3).toInt
    (stationID, entryType, precipitation)
  }
  
  def main (args: Array[String]) {
    
   Logger.getLogger("org").setLevel(Level.ERROR)
   
   val sc = new SparkContext("local[*]","MaxPrecipitation")
   val lines = sc.textFile("../1800.csv")
   val parsedLines = lines.map(parseLine)
   val maxpreci = parsedLines.filter(x => x._2 == "PRCP")
   val stationPreci = maxpreci.map(x => (x._1,x._3.toInt))
   val maxPreciByStation = stationPreci.reduceByKey( (x,y) => max(x,y))
   val results = maxPreciByStation.collect()
   
   for(results <- results.sorted){
     val station = results._1
       val preci = results._2
       println(s"$station max Precipitation: $preci") 
     
   }
   
       
  }
}