public class Labyrinth {
    private volatile boolean available = true;

    public void busy(){
        available = false;
    }

    public void available(){
        available = true;
    }

    public boolean status(){
        return available;
    }
}
