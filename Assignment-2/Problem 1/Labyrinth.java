public class Labyrinth {
    private volatile boolean cupcake = true;
    private volatile boolean allEntered = false;

    public void eatCupcake(){
        cupcake = false;
    }

    public void requestCupcake(){
        cupcake = true;
    }

    public synchronized boolean cupcakeStatus(){
        return cupcake;
    }

    public void allEntered(){
        allEntered = true;
    }

    public synchronized boolean getAllEntered(){
        return allEntered;
    }
}
