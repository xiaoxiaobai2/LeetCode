import java.util.*;

/**
 *  判断交易是否有效
 *      符合以下任一点则无效：
 *          1、交易金额大于1000
 *          2、姓名相同、城市不同、交易时间相差小于等于60
 * @author zhanghao
 * @date 2019.10.11
 */
public class InvalidTransaction {
    //存储答案，为避免重复，先存在set里
    private Set<Transaction> answerSet =new HashSet<>();
    public List<String> invalidTransactions(String[] transactions) {
        //用来返回可能出错的交易
        List<String> answerList=new ArrayList<>();
        //将交易转变成对应的对象存储起来
        Set<Transaction> transactionSet=new HashSet<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] strings=transactions[i].split(",");
            Transaction transaction=new Transaction(strings[0],Integer.parseInt(strings[1]),Integer.parseInt(strings[2]),strings[3]);
            System.out.println(strings[0]+"--"+Integer.parseInt(strings[1])+"--"+Integer.parseInt(strings[2])+"--"+strings[3]);
            System.out.println(transaction.getAmount());
            if (transaction.getAmount()>1000)
                answerSet.add(transaction);
            if (transactionSet.size()<1){
                transactionSet.add(transaction);
            }else {
                isValid(transaction,transactionSet);
                transactionSet.add(transaction);
            }
        }
        for (Transaction t: answerSet){
            String s=t.getName()+","+t.getTime()+","+t.getAmount()+","+t.getCity();
            answerList.add(s);
        }
        return answerList;
    }
    private void isValid(Transaction transaction,Set<Transaction> transactionSet){
        for (Transaction t:transactionSet) {
            if ((transaction.getName().equals(t.getName()))&&(!transaction.getCity().equals(t.getCity()))){
                if ((transaction.getTime()-t.getTime())<=60&&(transaction.getTime()-t.getTime())>=0){
                    if (!answerSet.contains(transaction))
                        answerSet.add(transaction);
                    if (!answerSet.contains(t))
                        answerSet.add(t);
                }else if ((t.getTime()-transaction.getTime())<=60&&(t.getTime()-transaction.getTime())>=0) {
                    if (!answerSet.contains(transaction))
                        answerSet.add(transaction);
                    if (!answerSet.contains(t))
                        answerSet.add(t);
                }
            }
        }
    }

    class Transaction{
        private String name;
        private int time;
        private int amount;
        private String city;

        public Transaction() {
        }

        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new InvalidTransaction().invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}).toArray()));
    }
}
