import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个赎金信（字符串）和一个杂志（字符串），判断前者是否可以有后者组成
 * @author zhanghao
 * @date 2019.10.11
 */
public class CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> magMap=new HashMap<>();
        Map<Character,Integer> ranMap=new HashMap<>();
        char[] chars_mgz=magazine.toCharArray();
        char[] chars_ran=ransomNote.toCharArray();
        //计算并存储杂志字符串出现的所有字母的个数
        for (char c: chars_mgz) {
            if (!magMap.containsKey(c))
                magMap.put(c,1);
            else magMap.put(c,magMap.get(c)+1);
        }
        //计算并存储赎金信字符串的所有字母和个数
        for (char c: chars_ran) {
            //如果杂志字母集不包含该字母，直接false
            if (!magMap.containsKey(c))
                return false;
            else {
                if (!ranMap.containsKey(c))
                    ranMap.put(c,1);
                else ranMap.put(c,ranMap.get(c)+1);
            }
        }
        //判断赎金新对应字母的个数是否小于杂志对应字母的个数，不小于直接false
        for (char c: ranMap.keySet()){
            if (ranMap.get(c)>magMap.get(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aac", "aabc"));
    }
}
