package misc

fun main(args: Array<String>) {
 val demo = Sample().SampleInner().foo() // caling nested class method
 print(demo)

}
class Sample {
 private val welcomeMessage: String = "Inner nested"
 inner class SampleInner {
 fun foo() = welcomeMessage
 }
}