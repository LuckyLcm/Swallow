package lcmtest;
import java.io.*;
/**
 * @author ICMLucky
 */
public class Client {
    try {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d://workspace//test.txt"));
        osw.write("yesorno");
        osw.close();
    }catch (IOException e){
        e.printStackTrace();
    }
}
