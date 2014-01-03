package ping3;

/**
 *
 * @author skuarch
 */
public class SendPingThread extends Thread {

    private String ip;
    private int timeout;

    //==========================================================================
    public SendPingThread(String ip, int timeout) {
        this.ip = ip;
        this.timeout = timeout;
    }

    //==========================================================================
    @Override
    public void run() {
        
        boolean flag = false;
        
        try {
            
            flag = new ExecutePing().execPing(ip);
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        System.out.println(ip + " " + flag);
    }

}
