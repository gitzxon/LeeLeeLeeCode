package coroutine.study

import coroutine.study.JsonableStringDataGenerator.Companion.CommonJsonableStringGenerator

fun main(args: Array<String>) {
    val g1= JsonableStringDataGenerator.JsonClass1Generator()
    println("g1.toString = ${g1.generate()}")
    val g2 = CommonJsonableStringGenerator(JsonClass1(2048))
    println("g2 = ${g2.generate()}")
    val g3 = CommonJsonableStringGenerator(JsonClass2("wahaha"))
    println("g3 = ${g3.generate()}")
}

interface BaseDataGenerator<RETURN_TYPE> {
    fun generate(): RETURN_TYPE
}

class IntStringDataGenerator(
    val value: Int = 0
): BaseDataGenerator<String> {
    override fun generate(): String {
        return value.toString()
    }
}

interface Jsonable {
    fun writeJson(): String
}

data class JsonClass1(
    val value: Int = 0
): Jsonable {
    override fun writeJson(): String {
        return """
            {
                "value": $value
            }
        """.trimIndent()
    }
}

data class JsonClass2(
    val content: String = "Hello World"
): Jsonable {
    override fun writeJson(): String {
        return """
            {
                "content": $content
            }
        """.trimIndent()
    }
}

open class JsonableStringDataGenerator<PARAM_TYPE: Jsonable>(
    val inputJsonable: Jsonable
): BaseDataGenerator<String> {

    override fun generate(): String {
        return inputJsonable.writeJson()
    }

    companion object {
        fun JsonClass1Generator(): JsonableStringDataGenerator<JsonClass1> {
            return object : JsonableStringDataGenerator<JsonClass1>(JsonClass1(1024)) {}
        }

        inline fun <reified T: Jsonable> CommonJsonableStringGenerator(inputJsonable: T): JsonableStringDataGenerator<T> {
            return object : JsonableStringDataGenerator<T>(inputJsonable) {}
        }
    }
}