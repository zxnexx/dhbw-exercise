package de.dhbw.programming.firstsemester.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RomanNumber {
    public static void main(final String[] args) {
        final var scanner = new Scanner(System.in);
        final Map<Character, Integer> romanDict = Map.of(
                'M', 1000,
                'D', 500,
                'C', 100,
                'L', 50,
                'X', 10,
                'V', 5,
                'I', 1
        );

        System.out.println("Enter a roman number: ");
        final String input = scanner.next();

        final var charArray = input.toCharArray();

        final List<Character> characterList = new ArrayList<>();
        for (final char c : charArray) {
            characterList.add(c);
        }

        // map each character in characterList to Integer via romanDict
        final List<Integer> intList = characterList.stream().map(romanDict::get).toList();

        final List<Integer> resList = new ArrayList<>();

        for (int i = 0; i < intList.size(); i++) {
            if (i + 1 >= intList.size()) {
                // means index i is last number -> means finished; break to prevent out of bounds
                resList.add(i, intList.get(i));
                break;
            } else {
                if (intList.get(i) < intList.get(i + 1)) {
                    // smaller number, followed by larger number -> subtract
                    resList.add(intList.get(i + 1) - intList.get(i));
                    // increase i, because both numbers were subtracted; bad practice to increase 'i' in loop, but idc
                    i++;
                } else {
                    // nothing special, don't subtract
                    resList.add(intList.get(i));
                }
            }
        }

        System.out.printf("intList: %s%n", intList);
        System.out.printf("resList: %s%n", resList);

        var res = 0;
        for (final Integer i : resList) {
            res += i;
        }

        System.out.printf("The value of the number %s is: %d", input, res);
    }
}
