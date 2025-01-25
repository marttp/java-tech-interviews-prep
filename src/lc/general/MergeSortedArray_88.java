package lc.general;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int writeIndex = nums1.length - 1;
        int mPtr = m - 1;
        int nPtr = n - 1;

        while (writeIndex >= 0) {
            if (mPtr >= 0 && nPtr >= 0) {
                if (nums1[mPtr] > nums2[nPtr]) {
                    nums1[writeIndex] = nums1[mPtr--];
                } else {
                    nums1[writeIndex] = nums2[nPtr--];
                }
            } else if (mPtr >= 0) {
                nums1[writeIndex] = nums1[mPtr--];
            } else {
                nums1[writeIndex] = nums2[nPtr--];
            }
            writeIndex--;
        }
    }
}
