import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Read the elements of the array
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Sort the array
        sortArray(nums);

        // Print the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] leftPart = new int[n1];
        int[] rightPart = new int[n2];

        System.arraycopy(array, low, leftPart, 0, n1);
        System.arraycopy(array, mid + 1, rightPart, 0, n2);

        int p1 = 0, p2 = 0, writeInd = low;
        while (p1 < n1 && p2 < n2) {
            if (leftPart[p1] <= rightPart[p2]) {
                array[writeInd++] = leftPart[p1++];
            } else {
                array[writeInd++] = rightPart[p2++];
            }
        }

        while (p1 < n1) {
            array[writeInd++] = leftPart[p1++];
        }

        while (p2 < n2) {
            array[writeInd++] = rightPart[p2++];
        }
    }
}