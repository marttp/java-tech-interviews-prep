package lc.general.medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers_1352 {

    class Solution1 {
        class ProductOfNumbers {

            private List<Integer> nums;

            public ProductOfNumbers() {
                nums = new ArrayList<>();
            }

            public void add(int num) {
                nums.add(num);
            }

            public int getProduct(int k) {
                int product = 1;
                for (int i = nums.size() - k; i < nums.size(); i++) {
                    product *= nums.get(i);
                }
                return product;
            }
        }
    }

    class Solution2 {
        class ProductOfNumbers {

            private List<Integer> nums;

            public ProductOfNumbers() {
                nums = new ArrayList<>();
                nums.add(1);
            }

            public void add(int num) {
                if (num == 0) {
                    nums = new ArrayList<>();
                    nums.add(1);
                } else {
                    nums.add(num * nums.getLast());
                }
            }

            public int getProduct(int k) {
                if (k >= nums.size()) {
                    return 0;
                }
                int index = nums.size() - k - 1;
                return nums.getLast() / nums.get(index);
            }
        }
    }
}
