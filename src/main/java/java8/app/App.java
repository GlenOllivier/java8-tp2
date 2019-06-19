package java8.app;

import java8.bo.Utilisateur;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        LocalTime t1 = LocalTime.now();
        for (int i = 0; i < 500000; i++) {
            List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
            mockList(utilisateurs);

            utilisateurs.stream()
                    .forEach(utilisateur -> System.out.println(utilisateur));

            System.out.println("-----");

            utilisateurs.stream()
                    .sorted(Comparator.comparing(Utilisateur::getDateAdhesion))
                    .forEach(utilisateur -> System.out.println(utilisateur.getLastName() + " " + utilisateur.getFirstName()));

            utilisateurs.stream()
                    .sorted(Comparator.comparing(Utilisateur::getLastName).thenComparing(Utilisateur::getFirstName).reversed())
                    .limit(3)
                    .map(utilisateur -> {
                        if (utilisateur.getLastName().toLowerCase().contains("a")) {
                            utilisateur.setLastName(utilisateur.getLastName().toUpperCase());
                        }
                        return utilisateur;
                    })
                    .collect(Collectors.toList());

            utilisateurs.stream()
                    .forEach(utilisateur -> System.out.println(utilisateur));

        }

        LocalTime t2 = LocalTime.now();
        Duration d = Duration.between(t1, t2);
        System.out.println(d);

    }

    public static void mockList(List<Utilisateur> list) {
        list.add(new Utilisateur("Etienne", "Cassin", LocalDate.of(2018, 10, 5)));
        list.add(new Utilisateur("Valentin", "Grimoux", LocalDate.of(2018, 4, 13)));
        list.add(new Utilisateur("Quentin", "Forgeau", LocalDate.of(2019, 2, 24)));
        list.add(new Utilisateur("François", "Mauxion", LocalDate.of(2018, 11, 2)));
        list.add(new Utilisateur("Argann", "Bonneau", LocalDate.of(2019, 4, 15)));
    }
}
