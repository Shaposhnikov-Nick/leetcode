/**
 * 205 Isomorphic Strings
 *
 * Easy
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 *
 * Output: true
 *
 * Explanation:
 *
 * The strings s and t can be made identical by:
 *
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * Example 2:
 *
 * Input: s = "f11", t = "b23"
 *
 * Output: false
 *
 * Explanation:
 *
 * The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */
fun main() {
    val s = "badc"
    val t = "baba"
    isIsomorphic(s, t)
}

/**
 * Необходимо сопоставить каждый символ из одной строки соответствующему символу другой строки
 * Если строки разной длины, автоматически false
 * В map будем сохранять ключ - символ из s, значение - соответствующий символ из t
 * Поочередно проверям каждую пару символов
 * Если в map нет пары для символа из s, то также проверяем, что символ tChar из t не соответствует какой-либо другой паре
 * и добавляем новую пару в map
 * Если символ tChar из t не соответствует значению из уже существующей пары, возвращаем false
 * Если все пары совпали, возвращаем true
 */
fun isIsomorphic(s: String, t: String): Boolean {
    // Если строки разной длины, автоматически false
    if (s.length != t.length) return false

    // В map будем сохранять ключ - символ из s, значение - соответствующий символ из t
    val map = mutableMapOf<Char, Char>()

    // Поочередно проверям каждую пару символов
    for (i in s.indices) {
        // символ из s
        val sChar = s[i]
        // символ из t
        val tChar = t[i]
        // уже существующая пара символов для sChar
        val value = map[sChar]

        // Если в map нет пары для символа из s, то также проверяем, что символ tChar из t не соответствует
        // какой-либо другой паре и добавляем новую пару в map
        if (value == null && tChar !in map.values)
            map[sChar] = tChar
        // иначе если символ tChar из t не соответствует значению из уже существующей пары, возвращаем false
        else if (tChar != value)
            return false
    }

    // Если все пары совпали, возвращаем true
    return true
}