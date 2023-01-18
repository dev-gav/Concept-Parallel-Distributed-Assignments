import java.util.ArrayList;
import java.util.List;

public class Counter {
    private int value;
    private List<Integer> primeNumbers = new ArrayList<>();

    public Counter(int value){
        this.value = value;
    }
    
    public void addToList(int n){
        synchronized(primeNumbers){
            primeNumbers.add(n);
        }
        
    }

    public int getListLength() {
        return primeNumbers.size();
    }

    public long getListSum(){
        long sum = 0;
        for(int i = 0; i < primeNumbers.size(); i++){
            if(primeNumbers.get(i) != null){
                sum += primeNumbers.get(i);
            }
        }
        return sum;
    }

    public int getListNum(int i){
        if(primeNumbers.get(i) != null){
            return primeNumbers.get(i);
        } else {
            return 0;
        }
    }
    
    // Followed the class slides for this piece of code
    public int getAndIncrement() {
        int temp;
        synchronized(this){
            temp = value;
            value = temp + 1;
        }
        return temp;
    }
}
