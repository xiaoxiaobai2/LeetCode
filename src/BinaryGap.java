/**
 * 查找两个1之间的最大距离
 * @author 张浩
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int maxLen=0;
        int start=0;
        int end=start;
        //找到第一个1
        while (N/2!=0){
            if (N%2==1)
                break;
            N=N/2;
        }
        while(N/2>0){
            N=N/2;
            end++;
            if(N%2==1){
                //有新的1出现
                if (end-start>maxLen)
                    maxLen=end-start;
                //重置start的位置
                start=end;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryGap().binaryGap(8));
    }
}
