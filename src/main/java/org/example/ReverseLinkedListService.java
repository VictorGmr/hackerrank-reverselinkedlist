package org.example;

public class ReverseLinkedListService {

    public SinglyLinkedListNode execute(SinglyLinkedListNode llist) {
        SinglyLinkedListNode head = execute(llist.next, llist);
        llist.next = null;
        return head;
    }

    public SinglyLinkedListNode execute(SinglyLinkedListNode llist, SinglyLinkedListNode previous) {

        if(llist == null) {
            return previous;
        }

        SinglyLinkedListNode head = execute(llist.next, llist);

        llist.next = previous;

        return head;
    }

}