public class Solution_171_ExcelSheetColumnNumber {
    public static void main(String[] args) {
        var columnTitle = "ZY";
        titleToNumber(columnTitle);
    }

    private static int titleToNumber(String columnTitle) {
        var result = 0;

        for (var c : columnTitle.toCharArray()) {
            var value = c - 'A' + 1;
            result = result * 26 + value;
        }

        return result;
    }
}
