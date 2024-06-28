package de.dhbw.programming.secondsemester.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Soccer {
    private final List<Player> playerList = new ArrayList<>();

    public void createPlayer(String s) {
        final var attributeList = Stream.of(s.split(";"))
                .map(String::new)
                .toList();
        playerList.add(new Player(
                Integer.parseInt(attributeList.get(0)),
                attributeList.get(1),
                attributeList.get(2),
                attributeList.get(3),
                attributeList.get(4),
                Integer.parseInt(attributeList.get(5)),
                Integer.parseInt(attributeList.get(6))
        ));
    }

    public void printPlayerList() {
        for (final var player : playerList) {
            System.out.println(player);
        }
    }
    public static void main(String[] args) {
        BufferedReader reader = null;
        Soccer soccer = new Soccer();

        try {
            reader = new BufferedReader(new FileReader("/home/adschoen/Desktop/33_Java8_Aufgaben_TeamDE.txt"));
            String line = reader.readLine();

            while (line != null) {
                soccer.createPlayer(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                // again, a resource is involved, so try-catch another time
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        soccer.printPlayerList();
    }
}
