package com.example.model;

/**
 * 栈的而基本操作
 * 
 * @author liupan Jun 4, 2022 11:39:00 AM
 * @param <T>
 */
public class DemoStack<T> {

    private T[]     arrayItems;

    /**
     * 栈顶指针
     */
    private Integer topIndex = 0;

    public DemoStack(int size) {
        setArrayItems((T[]) new Object[size]);
    }

    //将某个元素压入栈顶
    public void push(T obj) {
        int i = arrayItems.length;

        arrayItems[topIndex] = obj;
    }

    //栈顶元素弹出来
    public void pop() {
        int i = arrayItems.length;
        System.out.println("元素:" + arrayItems[i - 1] + ",弹出");
        arrayItems[i - 1] = null;
    }

    public T[] getArrayItems() {
        return arrayItems;
    }

    public void setArrayItems(T[] arrayItems) {
        this.arrayItems = arrayItems;
    }

    //    public Integer getItemsSize() {
    //        return itemsSize;
    //    }
    //
    //    public void setItemsSize(Integer itemsSize) {
    //        this.itemsSize = itemsSize;
    //    }

    public static void main(String[] args) {

        DemoStack<String> stack = new DemoStack<>(5);

        stack.push("1");

    }

}
