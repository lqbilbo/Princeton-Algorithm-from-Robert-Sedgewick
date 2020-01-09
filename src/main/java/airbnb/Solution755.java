package airbnb;

public class Solution755 {

    /**
     * 直觉和算法
     *
     * 直接求解法：
     *
     * 首先，我们注意到通过水流是无法区分地形和水滴的区别的。因此，我们可以将地形的高度建模为 heights，而水滴先不用管。
     * 当一滴水落下时，我们应该检查下有没有可能落在左边。将左指针i设置为K，如果i- 1在范围内且 heights[i-1] <= heights[i]，
     * 那么水滴就会落入那个方向上的凹槽处。我们保持每次都会落入索引 best 处。如果最终落入的地方不满足 best = K，那么我们就会
     * 将水滴放到那儿。
     * 另外，如果往左边移动不能促使水滴最终落到下一个高度，那么我们将会尝试往右边做同样的检测 i = K，否则水滴就会待在原地不动。
     * 为了简单起见，我们将命名初始的数组 H = heights。
     *
     * 时间复杂度：O(V* N), N = H.length
     * 空间复杂度：O(1)
     * @param H
     * @param V
     * @param K
     * @return
     */
    public int[] pourWater(int[] H, int V, int K) {
        for(int i = 0; i < V; i++) {
            int cur = K;
            // Move left
            while(cur > 0 && H[cur] >= H[cur - 1]) {
                cur--;
            }
            // Move right
            while(cur < H.length - 1 && H[cur] >= H[cur + 1]) {
                cur++;
            }
            // Move left to K
            while(cur > K && H[cur] >= H[cur - 1]) {
                cur--;
            }
            H[cur]++;
        }

        return H;
    }

    static class Solution {
        public static int[] pourWater(int[] H, int V, int K) {
            while (V-- > 0) droplet: {
                for (int d = -1; d <= 1; d += 2) {
                    int i = K, best = K;
                    while (0 <= i+d && i+d < H.length && H[i+d] <= H[i]) {
                        if (H[i+d] < H[i]) best = i + d;
                        i += d;
                    }
                    if (H[best] < H[K]) {
                        H[best]++;
                        break;
                    } else if (best == K && V == 0) {
                        H[K]++;
                        break droplet;
                    }
                }
            }
            return H;
        }

        public static void main(String[] args) {
            int[] H = {2,1,1,2,1,2,2};
            int V = 4;
            int K = 3;
            pourWater(H, V, K);
        }
    }
}
