public class ArrayDeque<T> {
    public T[] items;
    int size;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item){
        if (size == items.length){
            resize2(size * 2);
        } else {
            resize2(size);
        }
        items[0] = item;
        size += 1;
    }
    public void addLast(T item){
        if (size == items.length){
            resize1(size * 2);
        }
        items[size] = item;
        size += 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for (T item: items ){
            System.out.println(item);
        }
    }
    public T removeFirst(){
        if (items.length*100 / size <= 25){
            resize1(items.length/2);
        }
        T item = items[0];
        System.arraycopy(items, 1, items, 0, size - 1);
        size -= 1;
        return item;
    }
    public T removeLast(){
        if (items.length*100 / size <= 25){
            resize1(items.length/2);
        }
        T item = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return item;
    }
    public T get(int index){
        return items[index];
    }
    private void resize1(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0 , a , 0 , size);
        items = a;
    }
    private void resize2(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0 , a , 1 , size);
        items = a;
    }


}
