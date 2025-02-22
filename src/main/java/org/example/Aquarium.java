package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium {
    private final List<Fish> fishes = new ArrayList<>();
    private final Random random = new Random();
    private final int maxCapacity;

    public Aquarium(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addFish(Fish fish, boolean printMessage) {
        if (fishes.size() >= maxCapacity) {
            System.out.println("Akvarium to'ldi! Dastur to'tatilmoqda.");
            System.exit(0);
        }
        fishes.add(fish);
        if (printMessage) {
            System.out.println("Yangi baliq tug'ildi: " + fish.getId() + " (" + fish.getGender() + ")");
        }
        new FishThread(fish, this).start();
    }

    public synchronized void removeFish(Fish fish) {
        fishes.remove(fish);
        if (fishes.isEmpty()) {
            System.out.println("Barcha baliqlar o'ldi. Dastur to'tatilmoqda.");
            System.exit(0);
        }
    }

    public synchronized void checkForReproduction() {
        Fish male = null, female = null;
        for (Fish fish : fishes) {
            if (fish.getGender().equals("Male") && male == null) {
                male = fish;
            } else if (fish.getGender().equals("Female") && female == null) {
                female = fish;
            }
            if (male != null && female != null) {
                break;
            }
        }

        if (male != null && female != null) {
            System.out.println("Baliq " + male.getId() + " (Male) va Baliq " + female.getId() + " (Female) uchrashdi.");
            Fish newFish = new Fish(random.nextBoolean() ? "Male" : "Female");
            addFish(newFish, true);
        }
    }
}
