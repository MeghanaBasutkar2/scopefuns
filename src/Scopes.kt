import kotlin.random.Random

open class Scopes {
    fun main() {
        useLet()
        println()
        useApply()
        getRandomInt()
    }

//functions - object
//let, apply, with, also, run
//apply and also can return whatever you provide
// with, run and let cannot

    /**
     *let functions can be accessed by "it" - can be used for each item
     * */
    fun useLet() {
        val list = mutableListOf("meg", "dee", "beztt", "ye")
        list.map { it.length }
            .filter { it > 2 }
            .let { print("resultt: $it") }
    }

    /**
     * apply can be used instead of doing above lines by allowing us to
     * use the obj functions directly inside the apply block
     * */
    fun useApply() {
        val users: MutableList<UserObj> = mutableListOf()
        users.add(UserObj("djhg1", 1, "8976756536"))
        users.add(UserObj("dkhg2", 2, "8976868656"))
        users.add(UserObj("dmhg3", 3, "8979996536"))

        println("list filtered: ${users.filter { it.id > 1 }}")
        users.apply {
            add(UserObj("hghhgh", 4, "8976756536"))
            add(UserObj("djhg5", 5, "8976756536"))
        }.also { print(it[3]) } //used to iterate - similar to let
        println("list unfiltered: $users")
    }

    /**
     * "also" can be used to return the context obj type
     * while "let" can only be used to perform a lambda op
     * */
    fun getRandomInt(): Int {
        return Random.nextInt(100).also { value ->
            print("getRandomInt() generated value $value")
        }
    }

    /**
     * "also" can be used to chain functions - not "let" because let does not provide the object scope
     * "also" can be used to access item by item. However, it cannot be used to access obj funs like apply does!
     * */
    fun chainingFunctions() {
        val numberList = mutableListOf<Double>()
        numberList.also { println("Populating the list") }
            .apply {
                add(2.71)
                add(3.14)
                add(1.0)
            }
            .also { println("Sorting the list") }.sort()
    }

    /**
     * run can be used to access object functions but not return it
     * */
    fun testRun() {
        var list: MutableList<String> = mutableListOf("ko", "ni", "chi", "wa")
        list.apply {
            add("ohaio")
            add("gozaimus")
            count { it.startsWith('k') }
        }
    }

    /**
     * uses as also but parsed as arg
     * */
//also - called on the obj, run and with(arg)
    fun testWith() {
        var list: MutableList<String> = mutableListOf("ko", "ni", "chi", "wa")
        with(list) {
            add("ohaio")
            add("gozaimus")
            count { it.startsWith('k') }
        }
    }
}
//before pushing you need to check if opposite type is there

// all flower brackets are of same char type
//all round brackets are of same char type
