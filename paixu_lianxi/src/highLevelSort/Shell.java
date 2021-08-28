package highLevelSort;


import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        Integer[] a = {9,1,2,5,7,4,8,6,3,5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    //排序原理：
    // 1.选定一个增长量h，按照增长量h作为数据分组的依据，对数据进行分组；
    // 2.对分好组的每一组数据完成插入排序；
    // 3.减小增长量，最小减为1，重复第二步操作。
    private static void sort(Integer[] a){
        //首先确定h的最大值
        int N = a.length;
        int h = 1;
        while(h<N/2){
            h=2*h+1;
        }
        //System.out.println(h);
        //先做最大值h的分组
        while(h>=1){
            for (int i = h; i < N; i+=h) {
                for (int j = i; j > 0; j-=h) {
                    if(a[j]<a[j-h]){
                        exchange(a,j,j-h);
                    }else {
                        break;
                    }
                }
            }
            h=h/2;
        }

    }

    private static void exchange(Integer[] a,int x,int y){
        int temp= a[y];
            a[y] = a[x];
            a[x] = temp;
        }
}


