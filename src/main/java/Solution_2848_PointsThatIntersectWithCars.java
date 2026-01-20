import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_2848_PointsThatIntersectWithCars {
    public static void main(String[] args) {
        var nums = new ArrayList<List<Integer>>();
        nums.add(List.of(3, 6));
        nums.add(List.of(1, 5));
        nums.add(List.of(4, 7));
        numberOfPoints(nums);
    }

    private static int numberOfPoints(List<List<Integer>> nums) {
        var coveredPoints = new HashSet<Integer>();

        for (var cars : nums) {
            var start = cars.get(0);
            var end = cars.get(1);
            for (int i = start; i <= end; i++) {
                coveredPoints.add(i);
            }
        }

        return coveredPoints.size();
    }
}
