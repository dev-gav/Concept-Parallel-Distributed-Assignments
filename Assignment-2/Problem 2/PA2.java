// Programming Assignment 2 Problem 2 (Option 2) - Gavin Barber

public class PA2{
    public static void main(String[] args){
        //Start timer
        long startTime = System.nanoTime();
        int numGuests = 100;
        Labyrinth labyrinth = new Labyrinth();
        Guests guests[] = new Guests[numGuests];

        // Start all threads
        for(int i = 0; i < numGuests; i++){
            guests[i] = new Guests(labyrinth, i);
            guests[i].start();
        }

        // Joins all threads before program ends
        for(int i = 0; i < numGuests; i++){
            try {
                guests[i].join();
            } catch (InterruptedException e) {
            }
        }

        //Stop timer
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        float totalTimeInSecond = (float)totalTime / 1_000_000_000;
        System.out.println("All " + numGuests + " guests have viewed the vase");
        System.out.println("Runtime: " + totalTimeInSecond + " seconds");
    }
}