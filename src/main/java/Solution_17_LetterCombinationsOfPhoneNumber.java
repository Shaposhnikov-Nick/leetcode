import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution_17_LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        var digits = "23";
        letterCombinations(digits);
    }

    private static List<String> letterCombinations(String digits) {
        var phoneMap = Map.of('2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz");

        var result = List.of("");

        for (char digit : digits.toCharArray()) {
            var newResult = new ArrayList<String>();
            var letters = phoneMap.getOrDefault(digit, "");

            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    newResult.add(combination + letter);
                }
            }
            result = newResult;
        }

        return result;
    }
}
