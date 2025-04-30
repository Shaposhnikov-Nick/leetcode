public class Solution_28_FindIndexOfFirstOccurrenceInString {
    public static void main(String[] args) {
        var haystack = "sadbutsad";
        var needle = "sad";
        var result = strStr(haystack, needle);
        System.out.println(result);

    }

    private static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        if (haystack.equals(needle)) return 0;

        var hArr = haystack.toCharArray();
        var nArr = needle.toCharArray();
        var targetSize = 0;

        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < haystack.length(); j++) {
                if (i + j == hArr.length || hArr[i + j] != nArr[j]) {
                    targetSize = 0;
                    break;
                }
                targetSize++;
                if (targetSize == needle.length()) return i;
            }
        }

        return -1;
    }
}
