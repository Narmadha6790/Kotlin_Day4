package misc

fun main(args: Array<String>) {
 val demo = Outer.Nested().foo() // caling nested class method
 print(demo)

}
class Outer {
 class Nested {
 fun foo() = "welcome to the sample"

 }
}