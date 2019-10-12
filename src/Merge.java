import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 去除整个区间数组中是重叠的区间
 * @author 张浩
 * @date 2019.10.12
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        //把数组  转为ArrayList方便删除
        List<int[]> ints=new ArrayList<>();
        Collections.addAll(ints,intervals);
        for (int[] k:ints){
            System.out.println(Arrays.toString(k));
        }
        int i=0;
        while (i<=(ints.size()-1)){
            //把第一个区间和后面的每个区间进行比较，如果1区间更新，则重新比较
            int j=i+1;
            while(j<ints.size()){
                //方便比较
                int a=ints.get(i)[0];
                int b=ints.get(i)[1];
                int c=ints.get(j)[0];
                int d=ints.get(j)[1];
                if (a<=c){
                    if (b>=d){
                        //j区间被i区间整个包含，直接去掉
                        ints.remove(j);
                        for (int[] k:ints){
                            System.out.println("i包含j--------------"+Arrays.toString(k));
                        }
                        System.out.println("**********************************");
                    }else if (b>=c){
                        //j区间的左边界在i区间内
                        ints.remove(j);
                        ints.remove(i);
                        ints.add(i,new int[]{a,d});
                        j=i+1;//更新一次i区间，则重置j
                        for (int[] k:ints){
                            System.out.println("c<= b <d--------------"+Arrays.toString(k));
                        }
                        System.out.println("**********************************");
                    }else j++;//毫不相关
                }else {
                    if (d<a){
                        //整个j区间在i区间之前
                        j++;
                    }else if (d>=a&&d<b){
                        //j区间的右边界在i区间内
                        ints.remove(j);
                        ints.remove(i);
                        ints.add(i,new int[]{c,b});
                        j=i+1;
                        for (int[] k:ints){
                            System.out.println("a <= d <b--------------"+Arrays.toString(k));
                        }
                        System.out.println("**********************************");
                    }else {
                        // j区间整个包含i区间
                        ints.remove(j);
                        ints.remove(i);
                        ints.add(i,new int[]{c,d});
                        j=i+1;
                        for (int[] k:ints){
                            System.out.println("j包含i--------------"+Arrays.toString(k));
                        }
                        System.out.println("**********************************");
                    }
                }
            }
            i++;
        }
        for (int[] k:ints){
            System.out.println("结束-----------"+Arrays.toString(k));
        }
        int[][] answer=new int[ints.size()][2];
        for (int k=0;k<ints.size();k++){
            answer[k][0]=ints.get(k)[0];
            answer[k][1]=ints.get(k)[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] ints=new Merge().merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        List<int[]> intss=new ArrayList<>();
        Collections.addAll(intss,ints);
        for (int[] i:intss){
            System.out.println(Arrays.toString(i));
        }
    }
}
