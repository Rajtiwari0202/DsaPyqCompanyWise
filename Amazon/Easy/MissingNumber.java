class MissingNumber{
    public static void main(String[] args){
        int nums[] = new int[3];
        nums[0]=3;
        nums[1]=0;
        nums[2]=1;

        System.out.println(MissingNumber(nums));
    }
    public static int MissingNumber(int[] nums) {
        int n_xor=nums.length;
        for(int i=0;i<nums.length;i++){
            n_xor=n_xor^i;
            n_xor = n_xor ^nums[i];
        }
        return n_xor;
    }
}