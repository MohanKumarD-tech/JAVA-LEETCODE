class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0) return 0;
        boolean check = false;
        if(s.charAt(0)=='-'){
            check = true;
            s = s.substring(1);
        }
        else if(s.charAt(0)=='+'){
            s = s.substring(1);
        }
        while(s.length()>1 && s.charAt(0)=='0'){
            s = s.substring(1);
        }
        long num = 0;
        int i=0;
        for(char ch : s.toCharArray()){
            if(ch>='0' && ch<='9'){
                num += ch-'0';
                num*=10;
                i++;
            }
            else{
                break;
            }
            if(i>10){
                if(check) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        }
        if(num!=0) num/=10;
        if(check) num*=-1;
        if(num>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(num<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) num;
    }
}