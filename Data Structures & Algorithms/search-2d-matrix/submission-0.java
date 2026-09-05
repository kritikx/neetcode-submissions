class Solution {
    public boolean searchMatrix(int[][] a, int target) {
        int n = a.length, m = a[0].length;
        int start = 0;
        int end = m*n - 1;

        while(start <= end){
            int mid = start +(end - start)/2;
            int midEl = a[mid/m][mid%m];
            if(midEl == target) return true;
            else if(midEl < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
