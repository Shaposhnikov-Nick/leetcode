public class Solution_1652_DefuseTheBomb {
    public static void main(String[] args) {
        var code = new int[]{5, 7, 1, 4};
        var k = 3;
        decrypt(code, k);
    }

    private static int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) return new int[n];

        int[] result = new int[n];
        int absK = Math.abs(k);
        int step = k > 0 ? 1 : -1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 1; j <= absK; j++) {
                int index = (i + step * j + n) % n;
                sum += code[index];
            }
            result[i] = sum;
        }

        return result;
    }

}
