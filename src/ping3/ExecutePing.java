package ping3;

import java.io.IOException;

/**
 *
 * @author skuarch
 */
public final class ExecutePing extends ExecuteCommand {

    private static final String FILE = "/home/skuarch/NetBeansProjects/ping3/ping.sh ";

    public ExecutePing() {
    }

    public boolean execPing(String host) throws IOException, InterruptedException, Exception {

        return Boolean.parseBoolean(ExecuteCommand.exec(FILE + host));

    }

}
