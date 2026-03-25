/**
 * 71 Simplify Path
 *
 * Medium
 *
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.
 *
 * The rules of a Unix-style file system are as follows:
 *
 * A single period '.' represents the current directory.
 * A double period '..' represents the previous/parent directory.
 * Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
 * Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
 * The simplified canonical path should follow these rules:
 *
 * The path must start with a single slash '/'.
 * Directories within the path must be separated by exactly one slash '/'.
 * The path must not end with a slash '/', unless it is the root directory.
 * The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
 * Return the simplified canonical path.
 *
 *
 *
 * Example 1:
 *
 * Input: path = "/home/"
 *
 * Output: "/home"
 *
 * Explanation:
 *
 * The trailing slash should be removed.
 *
 * Example 2:
 *
 * Input: path = "/home//foo/"
 *
 * Output: "/home/foo"
 *
 * Explanation:
 *
 * Multiple consecutive slashes are replaced by a single one.
 *
 * Example 3:
 *
 * Input: path = "/home/user/Documents/../Pictures"
 *
 * Output: "/home/user/Pictures"
 *
 * Explanation:
 *
 * A double period ".." refers to the directory up a level (the parent directory).
 *
 * Example 4:
 *
 * Input: path = "/../"
 *
 * Output: "/"
 *
 * Explanation:
 *
 * Going one level up from the root directory is not possible.
 *
 * Example 5:
 *
 * Input: path = "/.../a/../b/c/../d/./"
 *
 * Output: "/.../b/d"
 *
 * Explanation:
 *
 * "..." is a valid name for a directory in this problem.
 *
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */
fun main() {
    val path = "/.../a/../b/c/../d/./"
    simplifyPath(path)
}

/**
 * Делим строку на отдельные слова по знаку /, таким образом остаются только пути или пустые слова
 * Добавляем каждое получившееся слово в очередь initial, чтоюы потом доставать оттуда их по порядку
 * Достаем из очереди initial пути (segment):
 * - если это пустая строка, ничего не делаем (тоже самое если это ".")
 * - если это не "." и не "..", значит это фрагмент пути и добавляем его  в стек result
 * - если это "..", удаляем из стека result последний добавленный путь (возвращаемся на путь выше)
 * если result пустой, то возвращаем корень, иначе полный путь
 */
fun simplifyPath(path: String): String {
    val initial = ArrayDeque<String>() // используется как очередь
    val result = ArrayDeque<String>() // используется как стек

    // Делим строку на отдельные слова по знаку /, таким образом остаются только пути или пустые слова
    val words = path.split("/")

    // Добавляем каждое получившееся слово в очередь initial, чтоюы потом доставать оттуда их по порядку
    for (ch in words) {
        initial.addLast(ch)
    }

    while (initial.isNotEmpty()) {
        // Достаем из очереди initial пути (segment)
        val segment = initial.removeFirst()
        when {
            // если это пустая строка, ничего не делаем (тоже самое если это ".")
            segment == "" -> continue
            // если это не "." и не "..", значит это фрагмент пути и добавляем его  в стек result
            segment != "." && segment != ".." -> {
                result.addLast("/")
                result.addLast(segment)
            }
            // если это "..", удаляем из стека result последний добавленный путь (возвращаемся на путь выше)
            segment == ".." -> {
                if (result.isNotEmpty()) {
                    result.removeLast()
                    result.removeLast()
                }
            }
        }
    }

    // если result пустой, то возвращаем корень, иначе полный путь
    return if (result.isEmpty()) "/" else result.joinToString(separator = "")
}