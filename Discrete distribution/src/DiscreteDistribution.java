import org.jetbrains.annotations.NotNull;

public class DiscreteDistribution {

    public DiscreteDistribution(int[] args) {
        int m = 0, size = args.length - 1;
        m = args[0];

        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = args[i + 1];
        }

        int[] S = new int[size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y <= x; y++) {
                S[x] += a[y];
            }
        }

        //displayArray(a);
        //displayArray(S);
        
        int intervalBegin = 0, intervalEnd = S[S.length - 1] - 1;

        for (int i = 0; i < m; i++) {
            int r = randInt(0, intervalEnd);
            int index = 0;

            while (S[index] <= r && r < S[index + 1]) {
                index++;
                if (index == S.length) break;
            }
            System.out.print(index + 1 + " ");
        }

    }

    public int randInt(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{25, 80, 20};
        DiscreteDistribution testObject = new DiscreteDistribution(intArray);
    }


}
