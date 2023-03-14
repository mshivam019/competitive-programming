public class sortn {
    public void sortColors(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        int temp;
        while (mid <= hi) {
            switch (nums[mid]) {
                case 0: {
                    temp = nums[lo];
                    nums[lo] = nums[mid];
                    nums[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = nums[mid];
                    nums[mid] = nums[hi];
                    nums[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
    }

    // my approach
    public void sortColors2(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0, l = nums.length;
        for (int i = 0; i < l; i++) {
            if (nums[i] == 0)
                count0++;
            else if (nums[i] == 1)
                count1++;
            else if (nums[i] == 2)
                count2++;
        }
        for (int j = 0; j < l; j++) {
            if (count0 > 0) {
                nums[j] = 0;
                count0--;
            } else if (count1 > 0) {
                nums[j] = 1;
                count1--;
            } else if (count2 > 0) {
                nums[j] = 2;
                count2--;
            }

        }

    }
}
