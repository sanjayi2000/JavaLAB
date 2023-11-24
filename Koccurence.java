import java.util.Scanner;

public class Koccurrence {
    static int n;
    static int[] arr;

    static void occurrence(int k) {
        int[] k_occ = new int[n];
        int v = 0;
        int maxcount = 0;

        for (int i = 0; i < n; i++) {
            int count = 1; // Initialize count to 1 for the current element

            for (int j = i + 1; j < n; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            if (count > maxcount || (count == maxcount && arr[i] > k_occ[0])) {
                maxcount = count;
                v = 0; // Reset the index for k_occ

                k_occ[v] = arr[i];

                // Shift elements to make room for the new k_occ[0]
                for (int x = v + 1; x < k && x < n; x++) {
                    k_occ[x] = k_occ[x - 1];
                }
            } else if (v < k - 1) {
                v++;
                k_occ[v] = arr[i];
            }
        }

        System.out.println("Top " + k + " elements with the highest occurrence:");
        for (int j = 0; j < k && j <= v; j++) {
            System.out.println(k_occ[j]);
        }
    }

    public static void main(String[] args) {
        Koccurrence kOccurrence = new Koccurrence();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements");
        kOccurrence.n = input.nextInt();
        kOccurrence.arr = new int[kOccurrence.n];

        System.out.println("Enter the elements");
        for (int i = 0; i < kOccurrence.n; i++) {
            kOccurrence.arr[i] = input.nextInt();
        }

        System.out.println("Enter the value of K");
        int k = input.nextInt();

        kOccurrence.occurrence(k);
    }
}
