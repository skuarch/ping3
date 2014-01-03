package ping3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 *
 * @author skuarch
 */
public class Main {

    Main main = this;

    Thread t1 = null;

    HashMap<String, Integer> ips = FillHash.fillHash();
    HashMap<String, Integer> one = new HashMap<>();

    int counter = 0;    
    int maximun = 120;
    int time = 1500;

    static long start = 0;
    static long end = 0;
    
    //==========================================================================
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        start = System.currentTimeMillis();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                end = System.currentTimeMillis();
                System.out.println("milis " + (end-start));
                System.out.println("seconds " + (end-start) / 1000);
            }
        }));
        new Main().start();

    } // end main

    //==========================================================================
    private void start() {

        t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("ips: " + ips.size());

                try {

                    for (Map.Entry<String, Integer> entry : ips.entrySet()) {

                        counter++;
                        String ip = entry.getKey();
                        Integer timeout = entry.getValue();

                        one.put(ip, timeout);

                        if (counter == maximun) {
                            main.run(new HashMap<>(one));
                            one.clear();                            
                            t1.join(1);
                            Thread.sleep(1398);
                            counter = 0;
                            
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        t1.setName("t1");
        t1.start();

    }

    //==========================================================================
    public void run(final HashMap<String, Integer> hm) {

        System.out.println("hm" + hm.size());

        final ExecutorService es1 = Executors.newFixedThreadPool(maximun);

        new Thread(new Runnable() {

            @Override
            public void run() {

                for (Map.Entry<String, Integer> entry : hm.entrySet()) {

                    String ip = entry.getKey();
                    Integer timeout = entry.getValue();

                    es1.execute(new FutureTask(new SendPIngCallable(new String(ip), new Integer(timeout))));

                }

                es1.shutdown();

            }
        }).start();

    }

} // end class
