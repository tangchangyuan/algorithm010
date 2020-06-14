import java.math.BigInteger;
import java.util.Arrays;

public class firstWeekHomeWork {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        //  0,3,3,-3,-1,0,0
////        rotate(arr,3);
//        int[] arr1 = new int[]{1,2,3,0,0,0,0};
//        int[] arr2 = new int[]{1,3,4,5};
//        merge(arr1,3,arr2,3);

//        int[] arr3 = new int[]{6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        int[] arr3 = new int[]{2, 4, 9, 3, 9};
        System.out.println(Arrays.toString(plusOne(arr3)));

    }

    /**
     * 26. 删除排序数组中的重复项
     * 思路: 利用LinkedHashMap有序且不重复,像map中put有序元素,统计 key的数量   且重置nums
     * 缺点: 两次遍历 执行时间 内存消耗 较长 且 利用了新容器 不符合题意
     * 时间复杂度: 0(n)
     * 空间复杂度: ??
     * @param nums
     * @return
     */
//    public static int removeDuplicates(int[] nums) {
//        Map<Integer,Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(!map.containsKey(nums[i])) {
//                map.put(nums[i],i);
//            }
//        }
//        Set<Integer> keys = map.keySet();
//        int i = 0;
//        for(Integer key :keys){
//            nums[i] = key;
//            i++;
//        }
//        return i;
//    }

    /**
     * 26. 删除排序数组中的重复项 看题解后
     * 思路: 利用双指针
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        //如果数据为null 或者 nums.length == 0 return 0
        if (nums == null || nums.length == 0) return 0;
        //定义两个指针
        int z1 = 0;
        int z2 = 1;

        while (z2 < nums.length) {
            if (nums[z1] != nums[z2]) {  //表示两个元素不重复
                z1++;
                nums[z1] = nums[z2];
                z2++;
            } else {
                z2++;
            }
        }
        return z1 + 1;
    }

    /**
     * 189. 旋转数组
     * 第一个思路
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)  不符合题意 //TODO
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newIndex = (i + k) % nums.length;
            newArr[newIndex] = nums[i];
        }

        for (int i = 0; i < newArr.length; i++) {
            nums[i] = newArr[i];
        }
    }

    /**
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 思路
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            if (m <= 0 || nums2[n - 1] >= nums1[m - 1]) {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            } else {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
        }
    }


    /**
     * 66. 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 思路 : 1 先转换成数字
     *       2 +1 后转换成数组
     *
     *      当数字值大于可存储的最大值是 将会排查异常 行不通
     * @param digits
     * @return
     */
//    public static int[] plusOne(int[] digits) {
//        long sum=0;
//        for(int j=0;j<digits.length;j++) {
//            sum = sum * 10 + digits[j];
//        }
////        {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
//        sum = sum + 1;
//
//        String str = String.valueOf(sum); //num为需要转化的整数
//        int[] tmp = new int[str.length()];
//        for(int i=0;i<str.length();i++) {
//            //tmp[i]=str.charAt(i);
//            //数组长度还不确定，所以不能像上面那样直接赋值
//            //可以在之前确定数组的额长度然后就能那样赋值了
//            //tmp[i]=Integer.parseInt(str.charAt(i));char型需要转化为String
//            tmp[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
//        }
//        return tmp;
//    }

    /**
     * 66. 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 思路2 : 1 当最后一位大于 9->10 99->100  9999->10000
     * 缺点: 代码太丑  太恶心了 时间复杂度 O(2n)
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int num = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[digits.length - 1] == 9 && digits[i] == 9) {
                num++;
            } else if (digits[digits.length - 1] == 9 && digits[i] != 9) {
                break;
            }
        }
        int d = digits[digits.length - 1] + 1;
        if (d >= 10) {
            if (num == digits.length) {
                int[] newDigits = new int[digits.length + 1];
                System.arraycopy(digits, 0, newDigits, 0, digits.length);
                newDigits[digits.length - num] = 1;
                for (int i = digits.length - num + 1; i < digits.length; i++) {
                    newDigits[i] = 0;
                }
                return newDigits;
            } else {
                digits[digits.length - num - 1] = digits[digits.length - num - 1] + 1;
                for (int i = digits.length - num; i < digits.length; i++) {
                    digits[i] = 0;
                }
                return digits;
            }

        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
    }

}
