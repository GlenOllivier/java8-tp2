package java7.app;

import java7.bo.Utilisateur;

import java.util.*;

public class App {
    public static void main(String[] args) {

        Date d1 = new Date();

        for (int i = 0; i < 500000; i++) {
            List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
            mockList(utilisateurs);

            for (Utilisateur u : utilisateurs) {
                System.out.println(u.toString());
            }

            System.out.println("-----");

            utilisateurs.sort(new Comparator<Utilisateur>() {
                @Override
                public int compare(Utilisateur o1, Utilisateur o2) {
                    return o1.getDateAdhesion().compareTo(o2.getDateAdhesion());
                }
            });

            for (Utilisateur u : utilisateurs) {
                System.out.println(u.getFirstName() + " " + u.getLastName());
            }

            utilisateurs.sort(new Comparator<Utilisateur>() {
                @Override
                public int compare(Utilisateur o1, Utilisateur o2) {
                    int compare = o2.getLastName().compareTo(o1.getLastName());
                    return (compare != 0) ? compare : o2.getFirstName().compareTo(o1.getFirstName());
                }
            });

            for (int j = 0; j < 3; j++) {
                if (j < utilisateurs.size()) {
                    if (utilisateurs.get(j).getLastName().toLowerCase().contains("a")) {
                        utilisateurs.get(j).setLastName(utilisateurs.get(j).getLastName().toUpperCase());
                    }
                }
            }

            for (Utilisateur u : utilisateurs) {
                System.out.println(u);
            }
        }

        Date d2 = new Date();
        System.out.println((d2.getTime() - d1.getTime())/1000.0f);
    }

    public static void mockList(List<Utilisateur> list) {
        Calendar c = new GregorianCalendar(2018, 10 , 5);
        list.add(new Utilisateur("Etienne", "Cassin", c.getTime()));
        c = new GregorianCalendar(2018, 4 , 13);
        list.add(new Utilisateur("Valentin", "Grimoux", c.getTime()));
        c = new GregorianCalendar(2019, 2 , 24);
        list.add(new Utilisateur("Quentin", "Forgeau", c.getTime()));
        c = new GregorianCalendar(2018, 11 , 2);
        list.add(new Utilisateur("François", "Mauxion", c.getTime()));
        c = new GregorianCalendar(2019, 4 , 15);
        list.add(new Utilisateur("Argann", "Bonneau", c.getTime()));
    }
}
