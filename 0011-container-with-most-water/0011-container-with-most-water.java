class Solution {
    public int maxArea(int[] height) {
        int pointer1 = 0;
        int pointer2 = height.length-1;
        int maxWater = Integer.MIN_VALUE;

        while(pointer1<pointer2){
            int minHeight = Math.min(height[pointer1],height[pointer2]);
            int width = pointer2-pointer1;
            int waterhold = minHeight * width;
            maxWater = Math.max(maxWater,waterhold);

            if(height[pointer1]<height[pointer2]){
                pointer1++;
            }else{
                pointer2--;
            }
        }

        return maxWater;
    }
}