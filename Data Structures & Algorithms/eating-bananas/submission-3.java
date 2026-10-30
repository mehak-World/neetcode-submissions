class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = 1;

        for(int pile: piles){
            max = Math.max(max, pile);
        }

        int high = max;

        int ans = max;

        while(low <= high){
            int mid = low + (high - low)/2;
            long hrs = findHrs(piles, mid);
            if(hrs <= h){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans;
    }

    public long findHrs(int[] piles, int speed){
        long hrs = 0;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] % speed == 0) hrs += piles[i]/speed;
            else hrs += (piles[i]/speed) + 1;
        }

        return hrs;
    }
}
