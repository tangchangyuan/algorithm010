public class week04HomeWork {

    /**************************860. 柠檬水找零*****************************/
    /**
     * 思路: 1.
     * @param bills
     * @return
     */
    public boolean lemonadeChange1(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
                return true;
            } else if (bills[i] == 10) {
                ten++;
                if (five < 1) {
                    return false;
                } else {
                    five--;
                    return true;
                }
            } else {
                if (five < 1) {
                    if (five > 0 && ten > 0) {
                        five--;
                        ten--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }

                }
            }
        }
        return true;

    }

    /**
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;

    }


    /**************************33. 搜索旋转排序数组*****************************/
    /**
     * 思路: 1.二分查找法,先给数组排序,在二分查找,结果下标要变化.
     *      2.判断左边有序  还是右边有序
     *      3.左边有序,taget在左边的话,全力在左边搜索
     *      4.同理右边有序
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        else if(nums.length == 1) return nums[0]==target?0:-1;
        int lo = 0, hi = nums.length-1;
        int right = nums[nums.length-1];
        while(lo<=hi){
            int mid = (lo+hi)>>>1;
            if(nums[mid] == target) return mid;

            if(nums[mid] <= right){
                if(nums[mid] < target && target <= right) lo = mid+1;
                else hi = mid-1;
            }else {
                if(nums[0] <= target && target<nums[mid]) hi = mid-1;
                else lo = mid+1;
            }
        }
        return -1;
    }

    /*************************455. 分发饼干***********************************************/
    /**
     * 思路:贪心算法
     * 每次分配只关注未分配饼干的最小胃口的小朋友
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int curr = 0;
        int x = 0;
        for (int i = 0; i < s.length; i ++) {
            if (x < g.length && s[i] >= g[x]) {
                curr ++;
                x++;
            }
        }
        return curr;
    }

    
}
