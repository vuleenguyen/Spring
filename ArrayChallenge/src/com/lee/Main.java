package com.lee;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> result = fourSum(new int[]{-4, -3, -2, -1, 0, 0, 1 , 2 , 3 , 4}, 0);
        System.out.println(result);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 3) {
            int j = i + 1;
            int k = nums.length - 2;
            while(j < k) {
                int l = nums.length - 1;
                int sum = nums[i] + nums[j] + nums[k] + nums[l];
                if (sum < target) while(nums[j] == nums[++j] && j < k);
                while (l > k && k > j) {
                    sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                    if (sum < target) {while(nums[j] == nums[++j] && j < k); break;}
                    if (sum >= target) {
                        if (k > j) {
                            if (l > k + 1) {
                                while (nums[l] == nums[--l] && l > k) ;
                            } else {
                                while (nums[k] == nums[--k] && k > j) ;
                                l = nums.length - 1;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            while(nums[i] == nums[++i] && i < nums.length - 3);
        }
        return result;
    }


//    List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//    int i = 0;
//        while (i < nums.length - 3) {
//        int j = i + 1;
//        int k = nums.length - 2;
//        while(j < k) {
//            int l = nums.length - 1;
//            int sum = nums[i] + nums[j] + nums[k] + nums[l];
//            if (sum <= target) while(nums[j] == nums[++j] && j < k);
//            if (sum >= target) while(nums[k] == nums[--k] && k > j);
//            while (l > k && k > j) {
//                sum = nums[i] + nums[j] + nums[k] + nums[l];
//                if (sum == target) result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
//                if (sum >= target) {
//                    if (k > j && l > k + 1) {
//                        while(nums[l] == nums[--l] && l > k);
//                    } else {
//                        break;
//                    }
//                }
//                if (sum < target) break;
//            }
//        }
//        while(nums[i] == nums[++i] && i < nums.length - 3);
//    }
//        return result;

}
