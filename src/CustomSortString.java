import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按S的顺序对T进行排序
 * @author 张浩
 * @date 2019.10.14
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        //用来存储 字符在S出现的顺序，key表示字符，value表示第几个出现的
        Map<Character,Integer> sortMap=new HashMap<>();
        char[] charS=S.toCharArray();
        //按出现的先后顺序存储字符
        for (int i = 0 ; i < charS.length; i++) {
            sortMap.put(charS[i],i);
        }
        for (Character c:sortMap.keySet()){
            System.out.println(c+"--"+sortMap.get(c));
        }
        //用来按S出现的顺序对T进行排序，没有出现在S的一次放在最后面
        char[] charT=T.toCharArray();
        List<Character> listT=new ArrayList<>();
        for (Character c:charT) {
            if (sortMap.containsKey(c)){
                int i=0;
                for (i = 0; i <listT.size() ; i++) {
                    //遍历已有顺序列，发现不存在的或第一个比c出现的早的，结束，在其之前插入c
                    if (!sortMap.containsKey(listT.get(i))||sortMap.get(listT.get(i))>sortMap.get(c))
                        break;
                }
                listT.add(i,c);
            }else listT.add(c);//不在S里，直接放在最后面
        }
        StringBuffer answer=new StringBuffer();
        for (int i = 0; i < listT.size(); i++) {
            answer.append(listT.get(i));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("cba","abcd"));
    }
}
