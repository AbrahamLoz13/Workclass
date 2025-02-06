package com.example.workclass.`class`
//class Variable {
//}
fun main(){
    //Numeric variables
    val age:Int = 20
    val long_number:Long = 1276327813612782222
    val temperature:Float = 27.33f
    val weight:Double = 64.12323

    //String variables
    val gender:Char='M'
    val name:String="Abraham Jafet"

    //Bool variables
    val isGreater:Boolean = false

    //Collection variables

    val names = arrayOf("Abraham","Pepe","Lopez","Guzmán")

    println(age)
    println("Welcome $name, to your first kotlin program")
    println(add())
    println(product(5,8))
    printArray(names)

    var numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)
    isEven(numbers)


}
//función suma 2 números
fun add():Int{
    val x = 10
    val y = 5
   return(x+y)

}
fun product(x:Int, y:Int):Int{
    return(x * y)
}

//Array con ciclo for para iterar cada posición del arreglo lo cual imprime cada nombre
fun printArray(names:Array<String>){
    println(names)
    for(name in names){
        println("Hola $name")
    }
}

fun isEven(numbers:Array<Int>){
    for (number in numbers){
        if(number % 2 == 0){
            println("the number $number is even")
        }else{
            println("the number $number is odd")
        }
    }
}