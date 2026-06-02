public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int N1 = nums1.length;
        int N2 = nums2.length;

        if (N1 > N2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lo = 0;
        int hi = N1;

        while (lo <= hi) {

            int mid1 = (lo + hi) / 2;
            int mid2 = (N1 + N2 + 1) / 2 - mid1;

            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            double R1 = (mid1 == N1) ? Integer.MAX_VALUE : nums1[mid1];

            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            double R2 = (mid2 == N2) ? Integer.MAX_VALUE : nums2[mid2];

            if (L1 <= R2 && L2 <= R1) {

                if ((N1 + N2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }

                return Math.max(L1, L2);
            }

            else if (L1 > R2) {
                hi = mid1 - 1;
            }

            else {
                lo = mid1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2, 5, 7};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}