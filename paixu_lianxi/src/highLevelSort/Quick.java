package highLevelSort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        Integer[] a = {8,4,5,7,1,3,6,2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
    //排序原理：
    //1.首先设定一个分界值，通过该分界值将数组分成左右两部分；
    //2.将大于或等于分界值的数据放到到数组右边，小于分界值的数据放到数组的左边。此时左边部分中各元素都小于或等于分界值，而右边部分中各元素都大于或等于分界值；
    //3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
    //4.重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左侧和右侧两个部分的数据排完序后，整个数组的排序也就完成了。
    private static void sort(Integer[] a) {
        int l = 0;
        int h= a.length-1;
        sort(a,l,h);
    }

    //对分组后的数据进行排序
    private static void sort(Integer[] a,int l,int h){
        if(l>=h){
            return;
        }
        int key = part(a, l, h);
        sort(a,l,key-1);
        sort(a,key+1,h);
    }

   private static int part(Integer[] a,int l,int h){
        int key = a[l];
        int left = l;
        int right = h+1;
        while(true){
            //从右边开始扫描。找到一个比key小的数
            while(key < a[--right]){
                if(l == right){
                    break;
                }
            }
            //然后从左边扫描。找到一个比key大的数
            while(key > a[++left]){
                if(left == h){
                    break;
                }
            }
            if(left >= right){
                break;
            }else{
                exch(a,left,right);
            }
        }
        //交换key和left，right同时指向的位置
       exch(a,l,right);
        //返回分界值
       return right;
   }

   private static void exch(Integer[] a,int i,int j){
        int m = a[i];
        a[i] = a[j];
        a[j] = m;
   }
}
