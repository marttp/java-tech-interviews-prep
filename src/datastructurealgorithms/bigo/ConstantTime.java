package datastructurealgorithms.bigo;

public class ConstantTime {

    public static void printData(int data) {
        System.out.println("data: " + data);
    }

    public static int accessData(int[] nums, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index should not below than zero");
        }
        return nums[index];
    }
}
