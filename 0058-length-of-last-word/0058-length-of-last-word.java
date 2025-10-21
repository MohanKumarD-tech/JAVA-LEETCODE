class Solution {
    public int lengthOfLastWord(String s) {
        int last = s.length()-1; int count = 0;
        while(last>=0){
            if(s.charAt(last)==' ' && count!=0) break;
            else if(s.charAt(last)!=' ') count++;
            last--;
        }
        return count;
    }
}