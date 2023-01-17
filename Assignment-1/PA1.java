import java.io.*;

public class PA1 {
    public static void main(String[] args){
        //Start timer
        long startTime = System.nanoTime();
        Counter counter = new Counter(1);
        Multithread threads[] = new Multithread[8]; 

        // Start all threads
        for(int i = 0; i < 8; i++){
            threads[i] = new Multithread(counter);
            threads[i].start();
        }

        //Wait for all threads to finish
        for(int i = 0; i < 8; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
            }
        }

        try{
            File out = new File("primes.txt");

            if(!out.exists()){
                out.createNewFile();
            }

            PrintWriter pw = new PrintWriter(out);

            //Stop timer
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            float totalTimeInSecond = (float)totalTime / 1_000_000_000;

            pw.printf("execution time: %.2fs" + "\ttotal number of primes found: %,d " + "\t\tsum of all primes found: %,d\n", totalTimeInSecond, counter.getListLength(), counter.getListSum());
            pw.printf("top ten maximum primes (lowest to highest): ");
            for(int i = 10; i >= 1; i--){
                pw.printf("%d, ", counter.getListNum(counter.getListLength()-i));
            }
            
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
