import java.io.*;

public class FileUtil {

    public synchronized String read(String in, int startLine) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(in));
        String content = null; //用来暂存文本数据
        System.out.println(Thread.currentThread().getName()+":"+startLine);
        while ((startLine--)!=0){
            String s = bufferedReader.readLine();
        }
        String s = bufferedReader.readLine();
        System.out.println(content=Thread.currentThread().getName()+"  "+s);
        return content;
    }

    public void write(BufferedWriter bfw, String content) throws IOException {
        bfw.write(content);
        bfw.newLine();
        bfw.flush();
    }
}