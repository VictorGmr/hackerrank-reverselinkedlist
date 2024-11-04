package org.example;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class ReverseLinkedListServiceTest {

    ReverseLinkedListService service;

    @Before
    public void init() {
        service = new ReverseLinkedListService();
    }

    @Test
    public void shouldReturnASinglyLinkedListNodeObject_whenExecuteIsCalled() {
        SinglyLinkedListNode llist = new SinglyLinkedListNode();
        SinglyLinkedListNode reversedLlist = new SinglyLinkedListNode();
        reversedLlist = service.execute(llist);
    }

    @Test
    public void shouldReturnSameNode_whenCallingExecuteAndSizeIsOne() {
        SinglyLinkedListNode llist = new SinglyLinkedListNode();
        SinglyLinkedListNode reversedLlist;

        llist.next = null;

        reversedLlist = service.execute(llist);
        assertEquals(null, reversedLlist.next);
    }

    @Test
    public void shouldCallExecutePassingPrevious() {
        SinglyLinkedListNode llist = new SinglyLinkedListNode();
        SinglyLinkedListNode previous = new SinglyLinkedListNode();
        SinglyLinkedListNode response = service.execute(llist, previous);
    }

    @Test
    public void shouldReverseLinkedListWithTwoNodes_whenExecutePreviousIsCalled() {
        SinglyLinkedListNode a = new SinglyLinkedListNode();
        SinglyLinkedListNode b = new SinglyLinkedListNode();
        SinglyLinkedListNode reversedLlist;

        a.next = b;
        b.next = null;

        reversedLlist = service.execute(b, a);

        assertEquals(a, reversedLlist.next);

    }

    @Test
    public void shouldReverseLinkedListWithNNodes_whenExecutePreviousIsCalled() {
        SinglyLinkedListNode a = new SinglyLinkedListNode();
        SinglyLinkedListNode b = new SinglyLinkedListNode();
        SinglyLinkedListNode c = new SinglyLinkedListNode();
        SinglyLinkedListNode d = new SinglyLinkedListNode();
        SinglyLinkedListNode reversedLlist;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        reversedLlist = service.execute(b, a);

        assertEquals(c, reversedLlist.next);
        assertEquals(b, c.next);
        assertEquals(a, b.next);

    }

    @Test
    public void shouldReverseLinkedList_whenExecuteIsCalled() {
        SinglyLinkedListNode a = new SinglyLinkedListNode();
        SinglyLinkedListNode b = new SinglyLinkedListNode();
        SinglyLinkedListNode c = new SinglyLinkedListNode();
        SinglyLinkedListNode d = new SinglyLinkedListNode();
        SinglyLinkedListNode reversedLlist;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        reversedLlist = service.execute(a);

        assertEquals(c, reversedLlist.next);
        assertEquals(b, c.next);
        assertEquals(a, b.next);
        assertNull(a.next);

    }
}