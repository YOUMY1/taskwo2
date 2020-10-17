import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String fileIn = "ori.txt";
        String fileOut = "des.txt";
        int WorkerNum = 4;
        MyLatch latch = new MyLatch(WorkerNum);
        Woker[] wokers = new Woker[WorkerNum];
        for (int i = 0; i < WorkerNum; i++) {
            wokers[i] = new Woker(latch, fileIn,i);
            wokers[i].start();
        }
        latch.await();//到此全部读取完毕 下面开始合并
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fileOut));
        for (int i = 0; i < wokers.length; i++) {
            System.out.println(wokers[i].startline);
            wokers[i].write(bufferedWriter);
        }
        bufferedWriter.close();
    }
}