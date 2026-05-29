class CarPooling{
    static boolean carPooling(int[][] trips,int capacity){
        int m[]=new int[1001];
        for(int a[]:trips){
            m[a[1]]+=a[0];
            m[a[2]]-=a[0];
        }
        for(int i=0;capacity>=0 && i<1001;i++){
            capacity-=m[i];
        }
        return capacity>=0;
    }
    public static void main(String[] args){
        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity=5;
        System.out.println(carPooling(trips,capacity));
    }
}