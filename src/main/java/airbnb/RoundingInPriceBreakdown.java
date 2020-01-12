package airbnb;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RoundingInPriceBreakdown {

    static List<Integer> roundPricesToMatchTarget(List<Float> prices, int target) {
        List<Float> filteredPrices = new ArrayList<>();
        int n = prices.size();

        List<Integer> result = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            BigDecimal t = new BigDecimal(prices.get(i));
            BigDecimal floor = t.setScale(0, RoundingMode.FLOOR);

            target -= floor.intValue();

            if (t.compareTo(floor) != 0) {
                filteredPrices.add(t.floatValue());
                result.add(floor.intValue());
            }
        }

        Collections.sort(filteredPrices);

        for (int i = 0; i < target; i++) {
            BigDecimal t = new BigDecimal(filteredPrices.get(i));
            BigDecimal floor = t.setScale(0, RoundingMode.FLOOR);
            BigDecimal ceil = t.setScale(0, RoundingMode.CEILING);

            result.add(new BigDecimal(res).subtract(t).subtract(t).add(floor).add(ceil).intValue());
        }

        result.add(new BigDecimal(res).setScale(3, RoundingMode.FLOOR).intValue());

        return result;
    }

}
