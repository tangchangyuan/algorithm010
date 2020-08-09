public class week09HomeWork {

    /**
     * 387. 字符串中的第一个唯一字符
     * 思路: 遍历一遍字符串，然后把字符串中每个字符出现的次数保存在一个散列表中
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < l; i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 151. 翻转字符串里的单词
     *
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        // 去除首尾空格
        String[] list = s.split(" ");
        int len = list.length;
        s = "";
        for (int i = len - 1; i >= 0 ; i--) {
            if(list[i].trim().equals("")) continue;
            if(i == len -1) {
                s = s + list[i];
            } else {
                s = s + " " + list[i];
            }
        }
    }

    /**
     * 63. 不同路径 II
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }


}
