

// EXERCISE
	 // Write some code that prints out the first 10 values of the Fibonacci sequence.
	 // This is the sequence where every number is the sum of the two numbers before it.
	 // So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34


object ScalaEx2 {

var n1 = 0                                        //> n1  : Int = 0
	  var n2 = 1                              //> n2  : Int = 1
	  var n3 =0                               //> n3  : Int = 0
	  for( j <- 0 to 8){
	  if(j == 0){
	  println(j)
	  }
	  if (j == 1){
	  println(j)
	  }
	  else{
	  var n3 = n1 + n2
	  println(n3)
	  n1 = n2
	  n2 = n3
	  }
	  }                                       //> 0
                                                  //| 1
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 5
                                                  //| 8
                                                  //| 13
                                                  //| 21
                                                  //| 34
}