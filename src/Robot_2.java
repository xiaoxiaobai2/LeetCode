import java.util.ArrayList;

/**
 * 问题描述：给定一个指令（不断重复），给一个绊脚石集合，给一个终点，判断机器人是否可以到达终点
 * 执行结果：通过
 * 显示详情
 * 执行用时 :0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗 : 35.6 MB, 在所有 Java 提交中击败了100.00%的用户
 * @author 张浩
 * @date 2019.10.10
 */
public class Robot_2 {
    public static boolean robot(String command,int[][] obstacles, int x, int y) {
        //首先判断是否经过终点，不经过直接返回false
        if (isPass(x,y,command)){
            for (int i=0;i<obstacles.length;i++){
                //如果障碍物在终点的后面，则不需要判断此障碍
                if (x<obstacles[i][0]||y<obstacles[i][1])
                    continue;
                //判断是否经过障碍物,是则返回false
                if (isPass(obstacles[i][0],obstacles[i][1],command))
                    return false;
            }
            //经过终点，且不经过所有的障碍物，返回true
            return true;
        }
        return false;
    }

    //判断是否经过（x,y）
    public static boolean isPass(int x,int y,String command){
        char[] chars=command.toCharArray();
        int num_U=0;
        int num_R=0;
        for (char b:chars) {
            if (b == 'U') {
                num_U++;
            } else num_R++;
        }
        int loop=Math.min(x/num_R,y/num_U);
        int position_x=loop*num_R;
        int position_y=loop*num_U;
        if (x==position_x&&y==position_y)
            return true;
        else for (char b:chars) {
            if (b=='U'){
                position_y++;
            }
            else position_x++;
            if (x==position_x&&y==position_y)
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
