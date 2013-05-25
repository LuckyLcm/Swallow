package lcmtest;
import java.io.*;
/**
 * @author ICMLucky
 */
public class Handler {
    public static void main(String[] args) {
        //new a client
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            s = br.readLine();
            while (s != null){
                if(s.equalsIgnoreCase("exit"))  break;
                //System.out.println() 比较输入和client文件的字符串是否相同
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
