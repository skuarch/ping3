package ping3;

import java.util.concurrent.Callable;

/**
 *
 * @author skuarch
 */
public final class SendPIngCallable implements Callable<Boolean> {

    String ip = null;
    int timeout = 0;

    //==========================================================================
    public SendPIngCallable(String ip, int timeout) {

        this.ip = ip;
        this.timeout = timeout;

    }

    //==========================================================================
    @Override
    public Boolean call() throws Exception {

        boolean flag = new ExecutePing().execPing(ip);
        System.out.println(ip + " " + flag);

        return flag;

    }
} // end class
