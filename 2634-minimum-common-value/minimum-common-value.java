// class Solution {
//     public int getCommon(int[] nums1, int[] nums2) {
//         HashSet<Integer> hs=new HashSet<>();
//         for(int i=0; i<nums1.length; i++){
//             hs.add(nums1[i]);
//         }

//         for(int i=0; i<nums2.length; i++){
//             if(hs.contains(nums2[i])){
//                 return nums2[i];
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int nums1Pointer = 0;
        int nums2Pointer = 0;
        while (nums1Pointer < nums1.length && nums2Pointer < nums2.length) {
            if (nums1[nums1Pointer] == nums2[nums2Pointer]) {
                return nums1[nums1Pointer];
            } else if (nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums2Pointer++;
            } else {
                nums1Pointer++;
            }
        }

        return -1;
    }
}