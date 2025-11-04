class Solution {
    public int countGoodNumbers(long n) {
        long a=1000000007;
        long p=pow(5,(n+1)/2,a);
        long q=pow(4,(n)/2,a);
        return (int)((p*q)%a);
    }
    long pow(long x,long n,long a){
        if(n==0) return 1;
        long temp=pow(x,n/2,a);
        if(n%2==0){
            return (temp*temp)%a;
        }else{
            return (temp*temp*x)%a;
        }
    }
}