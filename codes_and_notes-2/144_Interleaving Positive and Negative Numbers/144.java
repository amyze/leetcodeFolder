class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        if (A == null || A.length == 0){
            return;
        }
        partition(A, 0);
        int l = 0, count =0,r = A.length-1;
        //此题注意是正数多还是负数多，因为要相间所以最多只能多1，
        
        for (int num : A){
	   		count += num >= 0 ? 1 : -1;
	   	}
	   	//如果负数多， l++
	   	if (count < 0) {
	   		l++;
	   	////如果正数多， r--
	   	} else if (count > 0){
	   		r--;
	   	}
        while (l < r) {
            
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            
            l+=2;
            r-=2;
        }
   }
   
   public void partition(int[] nums, int k){
       int l =0, r = nums.length-1;
       while(l<=r){
           while(l<=r && nums[l]<k){
               l++;
           }
           while(l<=r && nums[r]>=k){
               r--;
           }
           if(l<=r){
               int temp = nums[l];
               nums[l] = nums[r];
               nums[r] = temp;
               l++;
               r--;
           }
       }
       
   }
}