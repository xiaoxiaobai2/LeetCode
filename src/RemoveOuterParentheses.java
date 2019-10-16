import java.util.Stack;

/**
 * 去掉最外面一层括号   "(()())(())"     ----->   "()()()"
 */
public class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        //用来存放一个有效的字段
        Stack<Character> charStack=new Stack<>();
        char[] chars=S.toCharArray();
        boolean isRight=false;
        for (int i = 0; i < chars.length; i++) {
            //找到最外层左括号的位置，先记录下来，因为后面要用，用完之后置空
            if (charStack.isEmpty())
                isRight=true;
            if (chars[i] == '('){
                charStack.push(chars[i]);
                if (isRight){
                    chars[i]=' ';
                    isRight=false;
                }
            }
            if (chars[i]==')'){
                charStack.pop();
                //找到最外层右括号的位置，置空
                if (charStack.isEmpty())
                    chars[i]=' ';
            }
        }
        String answer="";
        //拼接剩余部分
        for (char c:chars)
            if (c!=' ')
                answer +=c;
        return answer;
    }


    public String removeOuterParentheses_2(String S) {
        //用来存放一个有效的字段
        int totalL=0;
        int totalR=0;
        char[] chars=S.toCharArray();
        int start=1;//记录最外层左括号后的位置
        String answer="";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='(') totalL++;
            else totalR++;
            //当左括号和右括号数量相等时，即好到一个原语，截取原语部分，附加到answer，同事start右移两位
            if (totalL==totalR){
                answer+=S.substring(start,i);
                start=i+2;
            }
        }
        return answer;
    }

    /**
     * 与解法2不同之处   String替换为StringBuilder     当需要不同累加时，一定要用StringBuilder
     * @param S
     * @return
     */
    public String removeOuterParentheses_3(String S){
        //用来存放一个有效的字段
        int totalL=0;
        int totalR=0;
        char[] chars=S.toCharArray();
        int start=1;//记录最外层左括号后的位置
        StringBuffer answer=new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='(') totalL++;
            else totalR++;
            //当左括号和右括号数量相等时，即好到一个原语，截取原语部分，附加到answer，同事start右移两位
            if (totalL==totalR){
//                answer.append(S.substring(start,i));
                answer.append(S,start,i); //内部函数就是截取，所以直接调取原函数
                start=i+2;
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(new RemoveOuterParentheses().removeOuterParentheses_2("(()())(())"));
    }
}
