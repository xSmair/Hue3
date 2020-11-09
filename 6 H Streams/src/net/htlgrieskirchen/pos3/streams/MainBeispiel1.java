package net.htlgrieskirchen.pos3.streams;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MainBeispiel1 {
    public static void main(String[] args) {
        try {
            List<Weapon> weapons = Files.lines(new File("C:\\Users\\simon\\Desktop\\Student_Stub\\6 H Streams\\weapons.csv").toPath())
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(array -> new Weapon(
                            array[0],
                            CombatType.valueOf(array[1]),
                            DamageType.valueOf(array[2]),
                            Integer.parseInt(array[3]),
                            Integer.parseInt(array[4]),
                            Integer.parseInt(array[5]),
                            Integer.parseInt(array[6]))).collect(Collectors.toList());
            weapons.sort((a, b) -> {
                return b.getDamage() - a.getDamage();
            });
            //weapons.forEach(System.out::println);
            System.out.println("");

            weapons.sort((Weapon o1, Weapon o2) -> {
                if (o1.getCombatType().name().compareTo(o2.getCombatType().name()) == 0) {
                    if (o1.getDamageType().name().compareTo(o2.getDamageType().name()) == 0) {
                        return o1.getName().compareTo(o2.getName());
                    } else {
                        return o1.getDamageType().name().compareTo(o2.getDamageType().name());
                    }
                } else {
                    return o1.getCombatType().name().compareTo(o2.getCombatType().name());
                }
            });
            Printable printable = a -> a.forEach(System.out::println);
            printable.print(weapons);

            System.out.println("");

            Printable tablePrint = a -> {
                System.out.println("-----------------------------------------------------------------");
                a.forEach(b -> {
                    System.out.printf("%-20s", " | " + b.getName());
                    System.out.printf("%-9s", " | " + b.getCombatType());
                    System.out.printf("%-11s ", " | " + b.getDamageType());
                    System.out.printf("%-6s", " | " + b.getDamage());
                    System.out.printf("%-3s", " | " + b.getSpeed());
                    System.out.printf("%-6s", " | " + b.getMinStrength());
                    System.out.printf("%-7s %n", " | " + b.getValue());

                });
                System.out.println("-----------------------------------------------------------------");

            };
            tablePrint.print(weapons);

        } catch (IOException ex) {
            Logger.getLogger(MainBeispiel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}