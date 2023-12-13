public class ArrayDeque<T> {
    private T[] items;
    private int size;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item){
        if (size == items.length){
            resize(size * 2);
         }

        System.arraycopy(items, 0, items ,1, size);
        items[0] = item;
        size += 1;
    }
    public void addLast(T item){
        if (size == items.length){
            resize(size * 2);
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
        if (isEmpty()){
            return null;
         }
        if (items.length*100 / size <= 25){
            resize(items.length / 2);
         }
        T item = items[0];
        System.arraycopy(items, 1, items, 0, size-1);
        items[size - 1] = null;
        size -= 1;
        return item;
    }
    public T removeLast(){
        if (isEmpty()){
            return null;
         }
        if (items.length*100 / size <= 25){
            resize(items.length / 2);
         }
        T item = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return item;
    }
    public T get(int index){
        return items[index];
    }
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0 , a , 0 , size);
        items = a;
    }



}
