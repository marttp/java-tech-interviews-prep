package datastructurealgorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RangeBasedLinkedListSmallProject {

    private static final int RANGE_SIZE = 25;

    public static void main(String[] args) {
        var maxSlot = 4;
        List<SinglyLinkedListNode> rangeList = new ArrayList<>(4);
        // Head of each range are filled
        while (maxSlot-- > 0) {
            rangeList.add(new SinglyLinkedListNode());
        }

        List<Integer> ids = List.of(1, 48, 12, 34, 58, 75, 96);
        // Expectation -> [1,12],[34,48],[58,75],[96]
        for (var id : ids) {
            var targetList = rangeList.get(findRangeId(id));
            targetList.insert(id);
        }

        for (var singlyLinkedListNode : rangeList) {
            singlyLinkedListNode.traverse();
        }
    }

    private static int findRangeId(int id) {
        return (id - 1) / RANGE_SIZE;
    }

    private static class SinglyLinkedListNode {
        ListNode<Employee> head;

        public SinglyLinkedListNode() {
            this.head = new ListNode<>(new Employee(0));
        }

        private void traverse() {
            List<Employee> employees = new ArrayList<>();
            var curr = head.next;
            while (curr != null) {
                employees.add(curr.data);
                curr = curr.next;
            }
            var traverseResult = employees.stream()
                    .map(Employee::toString)
                    .toList();
            var result = String.join("->", traverseResult);
            System.out.println(result);
        }

        public void insert(Integer id) {
            var prev = head;
            var curr = head;
            while (curr != null && curr.data.id < id) {
                prev = curr;
                curr = curr.next;
            }
            ListNode<Employee> newNode = new ListNode<>(new Employee(id));
            newNode.next = curr;
            prev.next = newNode;
        }
    }

    private static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private record Employee(int id) {
    }
}
