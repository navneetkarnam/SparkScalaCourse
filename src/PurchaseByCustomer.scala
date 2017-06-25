package com.sundogsoftware.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object PurchaseByCustomer {
  
  def parseLine (line:String)= {
    val fields = line.split(",")
    val customerID = fields(0).toInt
    val amountSpent = fields(2).toFloat
    (customerID,amountSpent)
  }
  
  def main(args:Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    val sc = new SparkContext("local[*]","PurchaseByCustomer")
    val lines = sc.textFile("../customer-orders.csv")
    val parsedLines = lines.map(parseLine)
    val totalAmountSpent = parsedLines.reduceByKey((x,y) => (x+y))
    val results = totalAmountSpent.collect()
    
    for(results <- results.sorted){
      val customer = results._1
      val amount = results._2
      println(s"CUSTOMER =$customer AMOUNT= $amount")
    }
  }
  
}