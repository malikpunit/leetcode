/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //return bruteForceWay(nums, target);
        return anotherway(nums, target);
    }
    //O(N^2)
    public int[] bruteForceWay(int []nums, int target){
        int numsLength = nums.length;
        int[] result  = new int[2];
        for(int i=0; i<numsLength; i++){
            for(int j = numsLength-1; j>i; j--){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }            
            }
        }
        return new int[0];
    }
  
    // O(N)
    public int[] anotherway(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>();
        int numsLength = nums.length;
        int complement = 0;
        
        for(int i = 0; i< numsLength; i++){
            complement = target - nums[i];
            if(numMap.containsKey(complement)){
                int[] result = new int[2];
                result[0] = i;
                result[1] = numMap.get(complement);    
                return result;
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }
    
    
}
