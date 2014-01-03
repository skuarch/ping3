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
    public ExecuteCommand() {
    }

    //==========================================================================
    public String exec(String command) throws IOException, InterruptedException {

        /*if (command == null || command.length() < 1) {
         throw new IllegalArgumentException("command is null or empty");
         }*/
        
        Process process = null;
        int exitValue;
        String line = null;
        StringBuilder lines = new StringBuilder();

        try {

            process = Runtime.getRuntime().exec(command);
            process.waitFor();
            exitValue = process.exitValue();

            if (exitValue == 0) {

                try (
                        InputStream inputStream = process.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

                    while ((line = bufferedReader.readLine()) != null) {
                        lines.append(line);
                    }

                }

            } else {

                try (
                        InputStream inputStream = process.getErrorStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

                    while ((line = bufferedReader.readLine()) != null) {
                        lines.append(line);
                    }

                }

            }

        } catch (IOException | InterruptedException e) {
            throw e;
        } finally {            
            process = null;            
        }

        return lines.toString();

    } // end 

} // end class
