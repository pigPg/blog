package simpleSort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        Integer[] a = {4,3,2,10,12,1,5,6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    //原理：1.把所有的元素分为两组，已经排序的和未排序的；
    //2.找到未排序的组中的第一个元素，向已经排序的组中进行插入；
    //3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，每次交换只能和相邻的元素交换位置.直到找到一个元素小于等于待插入元素，那么就把待插入元素放到这个位置，其他的元素向后移动一位；
    private static void sort(Integer[] a){
        int temp;
        for (int i = 1; i < a.length ; i++) {
            for (int j = i; j >0; j--) {
                if(a[j]<a[j-1]){
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }else{
                    break;
                }
            }
        }
    }
}

