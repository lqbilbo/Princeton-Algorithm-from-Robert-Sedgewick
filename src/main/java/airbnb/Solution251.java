package airbnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution251 {

    class Vector2D {

        private Iterator<List<Integer>> i;
        private Iterator<Integer> j;

        public Vector2D(int[][] v) {
            List<List<Integer>> vector = new ArrayList<>();
            for (int i = 0; i < v.length; i++) {
                List<Integer> rows = new ArrayList<>();
                for (int j = 0; j < v[i].length; j++) {
                    rows.add(v[i][j]);
                }
                vector.add(rows);
            }
            i = vector.iterator();
        }

        public int next() {
            hasNext();
            return j.next();
        }

        public boolean hasNext() {
            while ((j == null || !j.hasNext()) && i.hasNext())
                j = i.next().iterator();
            return j != null && j.hasNext();
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
