package racingleague.comparator;

import racingleague.model.Formula1Driver;

import java.util.Comparator;

public class CustomComparator implements Comparator<Formula1Driver> {
    @Override
    public int compare(Formula1Driver o1, Formula1Driver o2) {
        return o1.getPosition().compareTo(o2.getPosition());
    }
}//uses driver position data to sort drivers in ascending order
