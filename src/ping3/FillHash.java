package ping3;

import java.util.HashMap;

/**
 *
 * @author skuarch
 */
public class FillHash {

    public static HashMap<String, Integer> fillHash() {

        HashMap<String,Integer> hm = new HashMap<>();
        
        String ip = "187.188.";
        //String ip = "187.140.";
        //String ip = "192.168.";
        //String ip = "74.125.";

        for (int octeto3 = 149; octeto3 < 181; octeto3++) {

            ip = ip + octeto3 + ".";

            for (int octeto4 = 1; octeto4 < 256; octeto4++) {
                hm.put(ip + octeto4, 3000);
            }

            ip = "187.188.";

        }
        
        return hm;
        
    }

} // end class
