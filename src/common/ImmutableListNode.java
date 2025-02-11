package common;

public class ImmutableListNode {

    int val;
    ImmutableListNode next;

    ImmutableListNode(int val, ImmutableListNode next) {
        this.val = val;
        this.next = next;
    }

    ImmutableListNode(int val) {
        this.val = val;
    }

    public void printValue() {
        System.out.println(val);
    }

    public ImmutableListNode getNext() {
        return next;
    }
}
