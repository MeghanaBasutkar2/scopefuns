fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2)
    print("${list[0]} ${list[1]} ${list[2]}")

    2.addExt(3)
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun Int.addExt(num: Int){
    print("exttt ${this+num}")
}