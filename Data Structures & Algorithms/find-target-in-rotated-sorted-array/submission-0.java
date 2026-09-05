class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target) return mid;
            else if(nums[start] <= nums[mid]){   //left array sorted
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{                               //right array sorted
                if(nums[mid] <= nums[end]){
                    if(nums[mid] <= target && target <= nums[end]){
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
