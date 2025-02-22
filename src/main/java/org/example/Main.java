package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int K = random.nextInt(10) + 10;
        Aquarium aquarium = new Aquarium(K);

        int N = random.nextInt(5) + 3; // 3-7 ta erkak baliq
        int M = random.nextInt(5) + 3; // 3-7 ta urg‘ochi baliq

        System.out.println("Akvarium sig'imi :"+K);
        System.out.println("Dastlab " + N + " ta erkak va " + M + " ta urg‘ochi baliq mavjud.");

        for (int i = 0; i < N; i++) {
            Fish fish = new Fish("Male");
            aquarium.addFish(fish, false); // Boshlang‘ich baliqlarni konsolga chiqarilmasin
        }

        for (int i = 0; i < M; i++) {
            Fish fish = new Fish("Female");
            aquarium.addFish(fish, false); // Boshlang‘ich baliqlarni konsolga chiqarilmasin
        }

        while (true) {
            try {
                Thread.sleep(3000); // Har 3 soniyada yangi baliq tug‘ilishi mumkin
                aquarium.checkForReproduction();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
