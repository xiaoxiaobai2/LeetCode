import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        List<int[]> arrayList=new ArrayList<>();
        arrayList.add(A);
        arrayList.add(B);
        arrayList.add(C);
        arrayList.add(D);
        int sum=0;
        int[] length={A.length,B.length,C.length,D.length};
        int temp;
        for (int i = 0; i < 3; i++) {
            for (int j=0;j<4-i-1;j++){
                if (length[j]>length[j+1]){
                    temp=length[j+1];
                    length[j+1]=length[j];
                    length[j]=temp;
                }
            }
        }
        int start=0;
        for (int k=0;k<4;k++){
            //找到起始点
            start=k==0?0:length[k-1];
            for (int i=start;i<length[k];i++){
                for (int j=0;j<arrayList.size();j++){
                    sum +=arrayList.get(j)[i];
                }
            }
            //从list里去除当下最小的长度的数组
            for (int j=0;j<arrayList.size();j++){
                if (arrayList.get(j).length==length[k]){
                    arrayList.remove(j);
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A={1,2};
        int[] B={-2,-1};
        int[] C={-1,2};
        int[] D={0,2};
        Solution solution=new Solution();
        System.out.println(solution.fourSumCount(A,B,C,D));
    }
}