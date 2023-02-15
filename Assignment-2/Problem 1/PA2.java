// Programming Assignment 2 Problem 1 - Gavin Barber

import java.util.Random;

public class PA2 {
    public static void main(String[] args){
        //Start timer
        long startTime = System.nanoTime();
        int numGuests = 100; // Number of guests/threads
        boolean counter;
        Labyrinth labyrinth = new Labyrinth();
        Guests guests[] = new Guests[numGuests];
        Random rand = new Random();
        
        // Start all guests threads. Assign the first guests to be the counter.
        for(int i = 0; i < numGuests; i++){
            counter = (i == 0) ? true : false;
            guests[i] = new Guests(labyrinth, counter, numGuests);
            guests[i].start();
        }
        
        // Randomly select guests to enter labyrinth until all have entered
        while(!labyrinth.getAllEntered()){
            int int_rand = rand.nextInt(numGuests);
            if(!guests[int_rand].invitationStatus()){
                // System.out.println(guests[int_rand].getCount());
                guests[int_rand].invite();
            }
        }

        // Joins all guests threads
        for(int i = 0; i < numGuests; i++){
            // System.out.println("Thread " + i + " Cupcakes: " + guests[i].getCupcakes());
            try {
                guests[i].join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        //Stop timer
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        float totalTimeInSecond = (float)totalTime / 1_000_000_000;
        System.out.println("All " + numGuests + " guests have entered the labyrinth at least once");
        System.out.println("Runtime: " + totalTimeInSecond + " seconds");
    }
}