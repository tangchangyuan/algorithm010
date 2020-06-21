import java.math.BigInteger;
import java.util.Arrays;

public class week02HomeWork {



    /********************************94. 二叉树的前序遍历*************************************************/

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        return preOrder(root, output);
    }

    /**
     *前序遍历,递归算法
     * @param node
     * @param output
     * @return
     */
    private LinkedList<Integer> preOrder(TreeNode node, LinkedList<Integer> output) {
        if (node == null) return output;
        output.add(node.val);
        preOrder(node.left, output);
        preOrder(node.right, output);
        return output;
    }


    /**
     *
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**********************************242. 有效的字母异位词***********************************************/

    /**
     * 242. 有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //统计每个子母出现的次数
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character str : s.toCharArray()) {
            if (map.containsKey(str)) {
                int v = map.get(str);
                v++;
                map.put(str, v);
            } else {
                map.put(str, 1);
            }
        }


//        Map<Character,Integer> map1 = new LinkedHashMap<>();
        for (Character str : t.toCharArray()) {
            if (map.containsKey(str)) {
                int v = map.get(str);
                v--;
                if (v > 0) {
                    map.put(str, v);
                } else {
                    map.remove(str);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();

    }



}
