class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result=0;
        int end=0;
        Set<Integer> set=new HashSet<>();
        while(end<arr.length){
            int start=end+1;
           if(arr[end]!=end){
              int largest=arr[end];
              set.add(arr[end]);
              while(start<arr.length && (set.size()<=largest || !set.contains(end))){
                set.add(arr[start]);
                largest=Math.max(largest,arr[start]);
                start++;
              }
           }else{
              set.add(end);
           }
           end=start;
           result++;
        }
        return result;
    }
}