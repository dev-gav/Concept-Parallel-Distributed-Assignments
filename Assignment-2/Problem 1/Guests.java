public class Guests extends Thread{ 
    private int cupcakes;
    private volatile int count;
    private int numGuests;
    private Labyrinth labyrinth;
    private boolean isCounter;
    private boolean invitation;

    public Guests(Labyrinth labyrinth, boolean isCounter, int numGuests){
        this.labyrinth = labyrinth;
        this.isCounter = isCounter;
        this.numGuests = numGuests;
    }

    @Override
    public void run() {
        while(!labyrinth.getAllEntered()){
            if(invitation){
                if(cupcakes == 0 && labyrinth.cupcakeStatus()){
                    labyrinth.eatCupcake();
                    cupcakes++;
                } else if(isCounter && !labyrinth.cupcakeStatus()){
                    labyrinth.requestCupcake();
                    count++;
                    if(count >= numGuests){
                        labyrinth.allEntered();
                    }
                }
                invitation = false;
            }
        }
    }

    public synchronized int getCount(){
        return count;
    }

    public synchronized int getCupcakes(){
        return cupcakes;
    }

    public synchronized boolean invitationStatus(){
        return invitation;
    }

    public void invite(){
        invitation = true;
    }
}
