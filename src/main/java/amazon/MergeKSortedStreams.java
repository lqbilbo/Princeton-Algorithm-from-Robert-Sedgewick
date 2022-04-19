package amazon;

/***
 * 描述：假如有一些streams(可以认为是分布式队列)，这些streams会输出可以比较的对象，并且streams整体是非降序排列的。举个例子，如果他们包含一些指定
 * 的数字，一个stream将看起来是这样的：1，1，3，4，5，5，6，7，10，12，13. 有若干个类似这样的streams。
 *
 * 目标：开发一个系统可以创建一个stream作为输出output，保证和输入streams是同样的顺序——如果输入streams是非降序排列，那么输出streams也应该是非降序
 * 的。
 */
public class MergeKSortedStreams {

    interface InputStream<T extends Comparable<T>> {
        T poll();
    }

    interface OutputStream<T extends Comparable<T>> {
        void offer(T value);
    }

    public static <T extends Comparable> void merge(List<InputStream<T>> input, OutputStream<T> output) {

    }

    public <T extends Comparable> Stream mergeKLists(List<Stream<T>> input) {
        merge(input, 0, input.size() - 1);
    }

    public Stream<T> merge(List<Stream<T>> input, int l, int r) {
        if (l == r) {
            return input.get(l);
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(input, l, mid), merge(input, mid + 1, r));
    }

    public <T extends Comparable> Stream<T> mergeTwoLists(List<Stream<T>> a, List<Stream<T>> b) {

    }
}
