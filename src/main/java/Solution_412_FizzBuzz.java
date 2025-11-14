import java.util.ArrayList;
import java.util.List;

public class Solution_412_FizzBuzz {
    public static void main(String[] args) {
        var n = 5;
        fizzBuzz(n);
    }

    private static List<String> fizzBuzz(int n) {
        var answer = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            var divisibleBy3 = (i % 3 == 0);
            var divisibleBy5 = (i % 5 == 0);

            if (divisibleBy3 && divisibleBy5) {
                answer.add("FizzBuzz");
            } else if (divisibleBy3) {
                answer.add("Fizz");
            } else if (divisibleBy5) {
                answer.add("Buzz");
            } else {
                answer.add(Integer.toString(i));
            }
        }

        return answer;
    }
}