

    import java.util.Arrays;

    public class ArrayAndStringOperations {

        // 1. rotateRight(int[] a, int k) - O(n) time, O(1) space
        public static void rotateRight(int[] a, int k) {
            if (a == null || a.length <= 1) return;

            int n = a.length;
            k = k % n;
            if (k < 0) k += n;

            reverseArray(a, 0, n - 1);
            reverseArray(a, 0, k - 1);
            reverseArray(a, k, n - 1);
        }

        private static void reverseArray(int[] a, int start, int end) {
            while (start < end) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }
        public static boolean isAnagram(String a, String b) {
            if (a == null || b == null || a.length() != b.length()) {
                return false;
            }


            int[] charCounts = new int[256];

            for (int i = 0; i < a.length(); i++) {
                charCounts[a.charAt(i)]++;
                charCounts[b.charAt(i)]--;
            }


            for (int count : charCounts) {
                if (count != 0) {
                    return false;
                }
            }

            return true;
        }


        public static int[] twoSumSorted(int[] a, int target) {
            int left = 0;
            int right = a.length - 1;

            while (left < right) {
                int sum = a[left] + a[right];

                if (sum == target) {
                    return new int[] { left, right };
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return new int[] { -1, -1 };
        }
    }

