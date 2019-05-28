import java.util.HashMap;
import java.util.Scanner;
public class WeekTEST {
    public static void main(String[] args) {
        while (true) {
            int weekIndex = (int) (Math.random() * 7);
            String[] chineseWeeks = {"星期天","星期一","星期二","星期三","星期四","星期五","星期六"};
            String[] weeks = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
            HashMap<String,String> weekMap = new HashMap<>();
            for (int i = 0; i < weeks.length; i++) {
                weekMap.put(chineseWeeks[i],weeks[i]);
            }
            System.out.println(weeks[weekIndex] + ": ");
            Scanner in = new Scanner(System.in);
            try{
                if (weekMap.get(in.next()).equals(weeks[weekIndex])) {
                    System.out.println("You're right~");
                }else{
                    System.out.println("You're wrong!");
                }
            }catch (NullPointerException e){
                System.out.println("请输入正确格式 e.g. 星期一...");
            }

        }
    }
}
