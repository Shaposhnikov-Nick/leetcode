const haystack = "sadbutsad"
const needle = "sad"

console.log(strStr(haystack, needle))

function strStr(haystack, needle) {
    if (haystack.length < needle.length) return -1
    if (haystack === needle) return 0
    let targetSize = 0


    for (let i = 0; i < haystack.length; i++) {
        for (let j = 0; j < needle.length; j++) {
            if (i + j === haystack.length || haystack[i + j] !== needle[j]) {
                targetSize = 0
                break
            }
            targetSize++
            if (targetSize === needle.length) {
                return i
            }
        }
    }

    return -1
}