public class MyLatch {
    private int count;

    public MyLatch(int count) {
        this.count = count;
    }
    public synchronized void await() throws InterruptedException {
        while (count>0){
            wait();
        }
    }
    public synchronized void countdown(){
        count--;
        if(count<=0){
            notifyAll();
        }
    }

}