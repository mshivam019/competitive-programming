import java.util.ArrayList;
import java.util.List;

public class pascal {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> in = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    in.add(1);
                } else {
                    Integer num = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    in.add(num);
                }

            }

            res.add(in);

        }
        return res;
    }
}
