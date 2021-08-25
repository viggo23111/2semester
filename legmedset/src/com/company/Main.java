package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String [] navn = {"peter","nikolaj","valborg","martin","asger","christian","inga","christian","valborg"};
        String [] andreNavne = {"peter","nikolaj","lille ole","martin","asger","christian","inga","christian","valborg"};

        ArrayList<String>navneListe = new ArrayList<>(Arrays.asList(navn));
        navneListe.add("nikolaj");

        for (String s : navneListe) {
            System.out.println(s);

        }

        Set<String> navneSet = new HashSet<>(navneListe);
        System.out.println("\n\nHash set");
        for (String s : navneSet) {
            System.out.println(s);

        }
        Set<String> stringTreeSet = new TreeSet<>(navneListe);
        System.out.println("\n\nTree set");
        for (String s : stringTreeSet) {
            System.out.println(s);
        }

        Set<String> StringLinkHashSet = new LinkedHashSet<>(navneListe);
        System.out.println("\n\nListe set");
        for (String s : StringLinkHashSet) {
            System.out.println(s);
        }

        Set<String>andreNavneSet = new LinkedHashSet<>(Arrays.asList(andreNavne));
        andreNavneSet.removeAll(navneListe);
        System.out.println("Navne der ikke er i begge lister");
        for (String s : andreNavneSet) {
            System.out.println(s);

        }


    }
}
