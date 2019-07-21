public class Main {

    public static void main(String[] args){

        // 后一个Integer可省
        Array<Integer> arr = new Array<>(20);
        for(int i = 0; i < 10; i ++)
            arr.addLast(i);
        System.out.println(arr);

        // 复杂度震荡
        arr.add(2,100);
        System.out.println(arr);

        arr.remove(5);
        System.out.println(arr);

        arr.addLast(1);
        arr.addFirst(-1);
        System.out.println(arr);

        arr.removeElement(5);
        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr);
    }
}
