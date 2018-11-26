package com.udacity.gradle.builditbigger;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class JokeGenerator {

    private List<String> jokes;

    public JokeGenerator() {
        jokes = asList(
                "Why was 6 afraid of 7?\n" +
                        "Because 7 ate 9!",

                "I’m reading an antigravity book\n" +
                        "It’s impossible to put down!",

                "What kind of cheese doesn’t belong to you?\n" +
                        "Nacho cheese!",

                "You can’t trust atoms.\n" +
                        "They make up everything!",

                "Why do mushrooms get invited to all the best parties?\n" +
                        "Because they are such fungis!",

                "How do you fix a broken tomato?\n" +
                        "Tomato paste!",

                "Why did the hipster burn his tongue on coffee?\n" +
                        "Because he drank it before it was cool!",

                "Why did the farmer win an award?\n" +
                        "He was out standing in his field!\n" +
                        "\n");
    }

    public String getRandomJoke() {
        int randomInt = new Random().nextInt(this.jokes.size());
        return jokes.get(randomInt);
    }
}
