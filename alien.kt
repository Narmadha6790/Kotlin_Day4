package misc

//function extensions
class Trainee{
var skills : String= "null"
fun printTraineeSkills(){
print(skills)
}
}
fun main(args: Array<String>) {
var t1= Trainee()
t1.skills="JAVA"

var t2= Trainee()
t2.skills="SQL"

var t3= Trainee()
t3.skills=t1.addSkills(t2)
t3.printTraineeSkills()
}
fun Trainee.addSkills(t:Trainee):String{
var t4=Trainee()
t4.skills=this.skills + " " +t.skills
return t4.skills
}