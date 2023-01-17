public class Multithread extends Thread{

    private Counter counter;
    public Multithread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        int j = 0;
        while(j < (Math.pow(10, 8) - 7)){
            j = counter.getAndIncrement();
            if(isPrime(j)){
                counter.addToList(j);
            }
        }
    }

    private boolean isPrime(int num) {
        if(num == 2 || num == 3){
            return true;
        }

        if(num <= 1 || num % 2 == 0 || num % 3 == 0){
            return false;
        }

        for(int i = 5; i * i <= num; i += 6){
            if(num % i == 0 || num % (i + 2) == 0)
                return false;
        }
        return true;
    }
}


