package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SelectRandomAmazonProblems {

    final static List<Integer> mostProblems = new ArrayList<>();
    final static List<Integer> realProblems = new ArrayList<>();

    static {
        mostProblems.addAll(Arrays.asList(1,200,146,937,5,2,42,973,21,3,23,20,1192,121,138,1041,56,53,4,994,15,127,763,
                819,33,295,139,11,238,17,253,49,103,206,239,297,692,155,236,79,48,572,98,215,240,347,322,13,12,207));

        realProblems.addAll(Arrays.asList(937,200,973,1,146,1192,1041,138,994,127,42,819,763,253,23,295,5,4,21,2,56,121,
                692,139,238,297,572,1152,49,212,20,472,239,33,273,210,79,140,1268,155,15,12,957,103,17,48,240,347,387,380));
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(50));
        System.out.println(mostProblems.size());
        System.out.println(realProblems.size());
        // todo:  剩余题目：[937, 200, 973, 1, 146, 1192, 1041, 138, 994, 127, 42, 819, 763, 253, 23, 295, 5, 4, 21, 2, 56, 121, 692, 139, 238, 297, 572, 1152, 49, 212, 20, 472, 239, 33, 273, 210, 79, 140, 1268, 155, 15, 12, 957, 103, 17, 48, 240, 347, 387, 380]
        System.out.println("出题指数去除出现频率：" + mostProblems.removeAll(realProblems));
        realProblems.removeAll(mostProblems);
        System.out.println("剩余题目：" + realProblems);
        // todo:  剩余题目：[1, 200, 146, 937, 5, 2, 42, 973, 21, 3, 23, 20, 1192, 121, 138, 1041, 56, 53, 4, 994, 15, 127, 763, 819, 33, 295, 139, 11, 238, 17, 253, 49, 103, 206, 239, 297, 692, 155, 236, 79, 48, 572, 98, 215, 240, 347, 322, 13, 12, 207]
        System.out.println("出现频率去除出题指数：" + realProblems.removeAll(mostProblems));
        mostProblems.removeAll(realProblems);
        System.out.println("剩余题目：" + mostProblems);

        List<Integer> mostPopularProblems = mostProblems.subList(0, 20);
        List<Integer> mostRealProblems = realProblems.subList(0, 20);

        // todo: 剩余题目：[937, 200, 973, 1, 146, 1192, 1041, 138, 994, 127, 42, 819, 763, 253, 23, 295, 5, 4, 21, 2]
        System.out.println(mostPopularProblems.removeAll(mostRealProblems));
        mostRealProblems.removeAll(mostPopularProblems);
        System.out.println("剩余题目：" + mostRealProblems);

        // todo: 剩余题目：[1, 200, 146, 937, 5, 2, 42, 973, 21, 3, 23, 20, 1192, 121, 138, 1041, 56, 53, 4, 994]
        System.out.println(mostRealProblems.removeAll(mostPopularProblems));
        mostPopularProblems.removeAll(mostRealProblems);
        System.out.println("剩余题目：" + mostPopularProblems);

        int[] nums = {1,2,3,4,5};

        int[] toArray = IntStream.of(nums).boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();

    }

}
