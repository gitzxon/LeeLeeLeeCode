package playground

fun main(args: Array<String>) {

    CourseSdkParser().parse(DependencyHolder.text)

}

class CourseSdkParser {

    fun parse(text: String) {

        val map: MutableMap<String, MutableList<String>> = mutableMapOf()
        text.split("\n").map {
            val moduleNameToDependName = it.split("->").let {
                it[0].trim() to it[1].trim()
            }

            map.putIfAbsent(moduleNameToDependName.first, ArrayList())
            val depends = map[moduleNameToDependName.first]!!
            depends.add(moduleNameToDependName.second)
        }

        println("map.toString() = ${map.toString()}")

        val appDepends: MutableCollection<String> = hashSetOf()
        dfs(appDepends, map, "app")
        println("appDepends.size = ${appDepends.size}")
        println("appDepends = ${appDepends.joinToString()}")
        val suffixList = emptyList<String>()
        val generatedKtSource = appDepends.map { depend ->
            listOf(depend) + suffixList.map {
                if (depend.endsWith(it)) {
                    depend.removeSuffix(it)
                } else {
                    ""
                }
            }
        }
            .flatten()
            .filter { it.isNotEmpty() }
            .distinct()
            .map { "\"$it\"" }


        println("${generatedKtSource.joinToString()}")
    }

    fun dfs(list: MutableCollection<String>, map: Map<String, List<String>>, startPoint: String) {
        list.addAll(map[startPoint] ?: emptyList())
        map[startPoint]?.forEach {
            dfs(list, map, it)
        }
    }
}
