import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class Woker extends Thread {
    private  MyLatch latch;
    private  String in;
    public int startline;
    private   FileUtil fileUtil=new FileUtil();
    private String  content=null;//用于缓存当前读入的内容
    public Woker(MyLatch latch, String  in,int i) {
        this.latch = latch;
        this.in = in;
        this.startline=i;

    }

    public synchronized void write(BufferedWriter bfw) throws IOException {
        fileUtil.write(bfw,content);
    }
    @Override
    public void run() {
        // 拷贝文件
        try {
            FileUtil fileUtil=new FileUtil();
            content = fileUtil.read(in, this.startline);
            this.latch.countdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}