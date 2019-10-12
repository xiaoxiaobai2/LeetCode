import java.util.ArrayList;
import java.util.Arrays;

public class Robot {
    public static boolean robot(String command,int[][] obstacles, int x, int y) {
        //表示机器人当前位置
        int[] position={0,0};
        char[] chars=command.toCharArray();
        int num_U=0;
        int num_R=0;
        for (char b:chars) {
            System.out.println(b);
            if (b == 'U') {
                num_U++;
            } else num_R++;
        }
        int loop_R=x/num_R;//x的圈数
        int loop_U=y/num_U;//y的圈数
        //只有在同一个圈数内才有可能到达终点
        if (loop_R==loop_U){
            //存入列表，方便操作
            ArrayList<int[]> obs=new ArrayList<>();
            for (int[] obst:obstacles) {
                obs.add(obst);
            }
            //检测路线中是否有障碍
            while (!obs.isEmpty()){
                for (char b:chars){
                    System.out.println(b);
                    if (b=='U'){
                        position[1]++;
                    }
                    else position[0]++;
                    for (int i=0;i<obs.size();i++){
                        if (obs.get(i)[0]==position[0]&&obs.get(i)[1]==position[1])
                            return false;
                        //横竖坐标均不会减少所以任何一个坐标大于障碍物坐标就表明已经越过障碍，所以剔除
                        if ((obs.get(i)[0]<position[0])||(obs.get(i)[1]<position[1]))
                            obs.remove(i);
                    }
                    if (x==position[0]&&y==position[1])
                        return true;
                }
            }
            position[0]=loop_R*num_R;
            position[1]=loop_U*num_U;
            for (char b:chars) {
                if (b=='U'){
                    position[1]++;
                }
                else position[0]++;
            }
            if (x==position[0]&&y==position[1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        System.out.println(robot("RUUR",new int[][]{{10,5},{1,6},{6,10},{3,0},{0,3},{0,10},{6,2}},7856,9033));
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
