package org.example;

import java.util.Random;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Fish {
    private static final Random random = new Random();
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final int id;
    private final String gender;
    private final int lifespan;

    public Fish(String gender) {
        this.id = idGenerator.getAndIncrement();
        this.gender = gender;
        this.lifespan = random.nextInt(5000) + 5000;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public int getLifespan() {
        return lifespan;
    }
}
