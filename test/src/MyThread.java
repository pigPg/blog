public class MyThread implements Runnable{
    int t = 100;

    @Override
    public void run() {
       payTicket();
    }

    public synchronized void payTicket(){
        while(t>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("出售第"+t+"张票");
            t--;
        }
    }
}
