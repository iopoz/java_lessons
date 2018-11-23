package ru.kravchenko.cf;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat wants to eat
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("List of cats:");
        List<Cat> cats = new ArrayList();
        cats.add(new Cat("Matroskin", 10));
        cats.add(new Cat("Muska", 5));
        cats.add(new Cat("Murzik", 7));

        Bowl bowl = new Bowl(20);
        for (Cat c : cats) {
            System.out.println(c);
        }
        System.out.println("\n" + bowl);
        System.out.println("***********************************************");
        System.out.println("Cats take food:");
        for (Cat c : cats) {
            c.feedCat(bowl);
            System.out.println(c);
            System.out.println(bowl);
        }
    }
}
