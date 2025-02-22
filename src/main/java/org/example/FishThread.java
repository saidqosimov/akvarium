package org.example;
public class FishThread extends Thread {
    private final Fish fish;
    private final Aquarium aquarium;

    public FishThread(Fish fish, Aquarium aquarium) {
        this.fish = fish;
        this.aquarium = aquarium;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(fish.getLifespan());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Baliq " + fish.getId() + " hayotdan ko‘z yumdi.");
        aquarium.removeFish(fish);
    }
}
