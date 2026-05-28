import java.util.*;
public class SumOfSubarrayRanges {
    public static long subArrayRanges(int []nums){
        int n = nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            int minV=nums[i];
            int maxV=nums[i];
            for(int j=i;j<n;j++){
                maxV=Math.max(maxV,nums[j]);
                minV=Math.min(minV,nums[j]);
                ans+=maxV-minV;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int []nums = {1,2,3};
        System.out.println(subArrayRanges(nums));
    }
}
