
// EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  

object ScalaEx3 {

 
  def convert(c:String): String = {
  c.toUpperCase
  }                                               //> convert: (c: String)String
  println(convert("navneet"))                     //> NAVNEET
  
  def trans(name:String, g: String => String) : String = {
  g(name)
  }                                               //> trans: (name: String, g: String => String)String
  trans("navneet", name => name.toUpperCase)      //> res0: String = NAVNEET
  

}