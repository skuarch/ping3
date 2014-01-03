package ping3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author skuarch
 */
public class ExecuteCommand {

    //==========================================================================
    /*public ExecuteCommand() {
    } // end ExecuteCommand*/

    //==========================================================================
    public static String exec(String command) throws IOException, InterruptedException {

        Process process;
        int exitValue;
        String line = null;

        try {

            process = Runtime.getRuntime().exec(command);
            process.waitFor();
            exitValue = process.exitValue();

            if (exitValue == 0) {

                line = readReturnCommand(process.getInputStream());

            } else {

                line = readReturnCommand(process.getErrorStream());

            }

        } catch (IOException | InterruptedException e) {
            throw e;
        }

        return line;

    } // end exec

    //==========================================================================
    private static String readReturnCommand(InputStream inputStream) throws IOException {

        String line;
        StringBuilder lines = new StringBuilder();

        try (
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

            while ((line = bufferedReader.readLine()) != null) {
                lines.append(line);
            }

        }

        return lines.toString();

    } // end readReturnCommand

} // end class
