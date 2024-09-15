import java.util.ListIterator;
import java.util.NoSuchElementException;

// TwoWayLinkedList class implementing MyList interface
public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    // Default constructor
    public TwoWayLinkedList() {
    }

    // Node class representing each element in the list
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) {
            element = e;
        }
    }

    // Add an element at the specified index
    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.previous = current;
            current.next.previous = newNode;
            current.next = newNode;
        }
        size++;
    }

    // Clear the list
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // Check if the list contains a specific element
    @Override
    public boolean contains(Object e) {
        Node<E> current = head;
        while (current != null) {
            if (current.element.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    // Get the element at the specified index
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    // Get the index of the first occurrence of the specified element
    @Override
    public int indexOf(Object e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) return i;
            current = current.next;
        }
        return -1;
    }

    // Check if the list is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the index of the last occurrence of the specified element
    @Override
    public int lastIndexOf(E e) {
        Node<E> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.element.equals(e)) return i;
            current = current.previous;
        }
        return -1;
    }

    // Remove the element at the specified index
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<E> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
            if (head != null) head.previous = null;
        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.previous;
            if (tail != null) tail.next = null;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            removedNode = current;
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
        return removedNode.element;
    }

    // Set the element at the specified index
    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldElement = current.element;
        current.element = e;
        return oldElement;
    }

    // Get the size of the list
    @Override
    public int size() {
        return size;
    }

    // Return a list iterator starting from the head of the list
    @Override
    public ListIterator<E> listIterator() {
        return new TwoWayLinkedListIterator();
    }

    // Return a list iterator starting from the specified index
    @Override
    public ListIterator<E> listIterator(int index) {
        return new TwoWayLinkedListIterator(index);
    }

    // Inner class for the list iterator
    private class TwoWayLinkedListIterator implements ListIterator<E> {
        private Node<E> current = head;
        private int index = 0;

        public TwoWayLinkedListIterator() {
        }

        public TwoWayLinkedListIterator(int index) {
            if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E e = current.element;
            current = current.next;
            index++;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return current != null && current.previous != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.previous;
            index--;
            return current.element;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            if (current == null) throw new IllegalStateException();
            current.element = e;
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}
