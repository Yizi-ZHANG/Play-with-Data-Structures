import java.util.Objects;

public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d \n[", size, data.length));
        for(int i = 0; i < size; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e){

        // size指向第一个空位，index可以等于size
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if(size == data.length)
            // Dynamic array
            resize(data.length * 2);

        // 陷阱!!! 不要写i ++的形式
        for (int i = size - 1; i >= index; i --)
            data[i+1] = data[i];
        data[index] = e;
        size ++;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size.");

        E res = data[index];
        for (int i = index + 1; i < size; i ++)
            data[i - 1] = data[i];
        size --;
        // 避免复杂度震荡，lazy一点
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return res;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public boolean contains(E e){
        for(int i = 0; i < size; i ++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    public int find(E e){
        for(int i = 0; i < size; i ++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size.");
        return data[index];
    }

    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index < size.");
        data[index] = e;
    }

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i ++)
            newData[i] = data[i];
        data = newData;
    }
}
