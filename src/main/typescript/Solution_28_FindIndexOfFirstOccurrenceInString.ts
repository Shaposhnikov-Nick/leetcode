const haystack: string = "sadbutsad"
const needle: string = "sad"

console.log(strStr(haystack, needle))

function strStr(haystack: string, needle: string): number {
    if (haystack.length < needle.length) return -1
    if (haystack == needle) return 0

    for (let i = 0; i < haystack.length; i++) {
        let j = 0
        while (j < needle.length && haystack[i + j] === needle[j]) {
            j++;
        }
        if (j === needle.length) return i

    }

    return -1
}