package ctci.first.moderate;

import java.util.Arrays;

public class LivingPeople {
    public static void main(String[] args) {

        Person[] people = {new Person(1900, 1970), new Person(1920, 1960), new Person(2000, 2090), new Person(2010, 2090), new Person(1960, 1980)};
        LivingPeople ob = new LivingPeople();
        System.out.println(ob.maxAliveYear(people));
    }

    static class Person {
        int birth;
        int death;

        Person(int b, int d) {
            birth = b;
            death = d;
        }
    }

    int maxAliveYear(Person[] people) {
        int[] births = getSortedYears(people, true);
        int[] deaths = getSortedYears(people, false);

        int maxAlive = 0;
        int maxAliveYear = 0;
        int currAlive = 0;
        int birthIndex = 0;
        int deathIndex = 0;

        while (birthIndex < births.length) {
            if (births[birthIndex] <= deaths[deathIndex]) {
                currAlive++;
                if (currAlive > maxAlive) {
                    maxAlive = currAlive;
                    maxAliveYear = births[birthIndex];
                }
                birthIndex++;
            } else {
                currAlive--;
                deathIndex++;
            }
        }

        return maxAliveYear;
    }

    int[] getSortedYears(Person[] people, boolean isBirth) {
        int[] years = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            if (isBirth) years[i] = people[i].birth;
            else years[i] = people[i].death;
        }

        Arrays.sort(years);
        return years;
    }

}
