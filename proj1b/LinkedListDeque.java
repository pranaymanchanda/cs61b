public class LinkedListDeque<T> implements Deque<T>{
    private TNode sentinel_front;
    private int size;

    private TNode last;

    private TNode sentinel_last;

    private class TNode{
        T item;
        TNode prev;
        TNode next;

        public TNode(T i, TNode p, TNode n){
            item = i;
            prev = p;
            next = n;
        }
    }

    /* Creates an empty LLDeque */
    public LinkedListDeque(){
        sentinel_last = new TNode(null, null, null);
        sentinel_front = new TNode(null, null, sentinel_last);
        sentinel_last.prev = sentinel_front;
        size = 0;
    }

    @Override
    public void addFirst(T item){
        sentinel_front.next.prev = new TNode(item, sentinel_front, sentinel_front.next);
        sentinel_front.next = sentinel_front.next.prev;
        size += 1;
    }

    @Override
    public void addLast(T item){
        sentinel_last.prev.next = new TNode(item, sentinel_last.prev, sentinel_last);
        sentinel_last.prev = sentinel_last.prev.next;
        size += 1;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        TNode pointer = sentinel_front.next;
        while (pointer != sentinel_last){
            System.out.println(pointer.item);
            pointer = pointer.next;
        }
        return;
    }

    @Override
    public T removeFirst(){
        TNode pointer = sentinel_front.next;
        if (pointer == sentinel_last){
            return null;
        }
        pointer.next.prev = pointer.prev;
        pointer.prev.next = pointer.next;
        pointer.next = null;
        pointer.prev = null;
        size -= 1;
        return pointer.item;
    }

    @Override
    public T removeLast(){
        TNode pointer = sentinel_last.prev;
        if (pointer == sentinel_front){
            return null;
        }

        pointer.prev.next = pointer.next;
        pointer.next.prev = pointer.prev;
        pointer.next = null;
        pointer.prev = null;
        size -= 1;
        return pointer.item;
    }

    @Override
    public T get(int index){
        if (index > this.size - 1 || index < 0){
            return null;
        }
        TNode pointer = sentinel_front;
        while (index >= 0){
            pointer = pointer.next;
            index -= 1;
        }
        return pointer.item;
    }


    public T getRecursive(int index){
        if (index < 0 || index > this.size - 1){
            return null;
        }
        TNode pointer = sentinel_front;
        return getRecursiveHelper(index, pointer.next);

    }

    private T getRecursiveHelper(int index, TNode node){
        if (index == 0){
            return node.item;
        } else {
            return getRecursiveHelper(index - 1, node.next);
        }

    }





}