public class Guests extends Thread{
    private Labyrinth labyrinth;
    private boolean entered = false;

    public Guests(Labyrinth labyrinth, int id){
        this.labyrinth = labyrinth;
    }
    
    @Override
    public void run() {
        while(!entered){
            if(labyrinth.status()){
                labyrinth.busy();
                // Simulate viewing vase
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                labyrinth.available();
                entered = true;
            }
        }
    }
}
