package playground

fun main(args: Array<String>) {
    val parent = Child(
        "child name", "sports"
    )
    Visitor().test(parent)
}

open class Parent(
    val name: String
)

class Child(
    name: String,
    val game: String
) : Parent(name)

class Visitor {
    fun test(p: Parent) {
        println("p = [${p}]")
    }

    fun test(c: Child) {
        println("c = [${c}]")
    }
}