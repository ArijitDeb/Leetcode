package problems;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = IntStream.of(piles).max().getAsInt();

        while(low < high){
            int mid = low + (high - low) / 2;
            int time = timeToFinish(piles, mid);
            if(time > h){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    private int timeToFinish(int[] piles, int speedPerHour){
        int time = 0;
        for(int pile : piles){
            time += pile/speedPerHour;
            if(pile % speedPerHour != 0){
                ++time;
            }
        }
        return time;
    }
}
