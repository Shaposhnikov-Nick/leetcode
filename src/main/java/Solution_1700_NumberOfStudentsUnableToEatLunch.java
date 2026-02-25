import java.util.ArrayDeque;

public class Solution_1700_NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        var students = new int[]{1, 1, 1, 0, 0, 1};
        var sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        countStudents(students, sandwiches);
    }

    private static int countStudents(int[] students, int[] sandwiches) {
        var studentsQueue = new ArrayDeque<Integer>();
        var sandwichesStack = new ArrayDeque<Integer>();
        var attempts = 0;

        for (var s : students) {
            studentsQueue.add(s);
        }

        for (var s : sandwiches) {
            sandwichesStack.add(s);
        }

        while (!studentsQueue.isEmpty() && attempts < studentsQueue.size()) {
            var student = studentsQueue.removeFirst();
            var sandwich = sandwichesStack.getFirst();
            if (student == sandwich) {
                sandwichesStack.removeFirst();
                attempts = 0;
            } else {
                studentsQueue.addLast(student);
                attempts++;
            }
        }

        return studentsQueue.size();
    }
}
