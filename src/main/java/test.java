import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class test {

    public static void main(String[] args) {

        Integer[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        Integer[] nums_0 = {};
        testBucketSort(nums);
        printQuickSort(nums);
    }


    /**
     * BucketSort
     * @param nums
     */
    public static void testBucketSort(Integer[] nums){
        if (nums.length <= 0){
            return;
        }


        List<Integer> buckets = new ArrayList<>();
        int numsMax = (int) Collections.max(Arrays.asList(nums));
        int numsMin = (int) Collections.min(Arrays.asList(nums));
        for (int i = 0; i <= numsMax - numsMin +1; i++){
            buckets.add(0);
        }
        //System.out.println(buckets.toString());
        for (int i = 0; i < nums.length; i++) {
            int tmp = buckets.get(nums[i] - numsMin);
            buckets.set(nums[i]-numsMin, tmp+1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < buckets.size(); i++){
            if (buckets.get(i) != 0){
                for (int j = 0; j < buckets.get(i); j++){
                    res.add(i + numsMin);
                }
            }
        }

        System.out.println(res.toString());

    }


    public static void testQuickSort(Integer[] nums, int left, int right){

        if (left >= right){
            return;
        }
        int key = nums[left];
        int i = left;
        int j = right;
        while(nums[j] >= key && j>i){
            j--;
        }
        while(nums[i] <= key && j>i){
            i++;
        }
        if (i<j){
            int tmp;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[left] = nums[i];
        nums[i] = key;
        testQuickSort(nums, 0, i - 1);
        testQuickSort(nums, i+1, right);


    }

    public static void printQuickSort(Integer[] nums){
        testQuickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.asList(nums).toString());
    }





}


