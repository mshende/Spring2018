// Instructions:
// Copy over your code from CombinationsComparison into 
// methods numCombinations() and numCombinationsRecursive()
// Then implement the second recursive approach in numCombinationsRecursive2()
// and the iterative approach in numCombinationsIterative()

public class CombinationsComparison2 {

    static int numCalls = 0;
    static int numCallsRecursive = 0;
    static int numCallsRecursive2 = 0;
    static int numIterations = 0;

    public static void main(String[] argv) {
        // Try n=5, n=10, n=20.
        int n = 10;
        for (int k = 0; k <= n; k++) {
            int p = numCombinations(n, k);
            int q = numCombinationsRecursive(n, k);
            double r = numCombinationsRecursive2(n, k);
            double s = numCombinationsIterative(n, k);
            System.out.println("n=" + n + " k=" + k + " p=" + p + " q=" + q + " r=" + r + " s=" + s);
        }
        System.out.println("numCalls=" + numCalls + " numCallsRecursive=" + numCallsRecursive + " numCallsRecursive2=" + numCallsRecursive2 + " numIterations=" + numIterations);
    }

    static double numCombinationsIterative(int n, int k) {
        if ((n == k) || (n == 1) || (k == 0)) {
            return 1;
        }

        double result = n/k;
        for (int i = n - 1; i > 0; i--) {
            numIterations++;
            k--;
            if ((k == 0) || (n == k)) {
                return result;
            }
            result = result * i/k;
        }
        return result;
    }

    static double numCombinationsRecursive2(int n, int k) {
        numCallsRecursive2++;
        if ((n == k) || (n == 1) || (k == 0)) {
            return 1;
        }
        return (n / k) * numCombinationsRecursive2(n - 1, k - 1);
    }

    static int numCombinationsRecursive(int n, int k) {
        numCallsRecursive++;
        if ((n == k) || (n == 1) || (k == 0)) {
            return 1;
        }

        return numCombinationsRecursive(n - 1, k) + numCombinationsRecursive(n - 1, k - 1);
    }

    static int numCombinations(int n, int k) {
        int numer = factorial(n);
        int denom = factorial(k) * factorial(n - k);
        return (numer / denom);
    }

    static int factorial(int n) {
        numCalls++;
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
