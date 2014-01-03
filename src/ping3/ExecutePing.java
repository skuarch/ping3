package ping3;

import java.io.IOException;

/**
 *
 * @author skuarch
 */
public final class ExecutePing extends ExecuteCommand {

    private static final String FILE = "/home/skuarch/NetBeansProjects/ping2/ping.sh ";

    public ExecutePing() {
    }

    public boolean execPing(String host) throws IOException, InterruptedException, Exception {
        
        String command = FILE + host;

        /*if (tmp == null || tmp.length() < 1) {
         throw new Exception("return null");
         } else {
         flag = Boolean.parseBoolean(tmp);
         }*/
        return Boolean.parseBoolean(exec(command));

    }

}
