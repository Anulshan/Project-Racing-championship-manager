package racingleague.comparator;

import racingleague.model.Formula1Driver;

import java.util.Comparator;

public class CustomComparator2 implements Comparator<Formula1Driver> {
    @Override
    public int compare(Formula1Driver o1, Formula1Driver o2) {
        return o1.getSeasonPoints().compareTo(o2.getSeasonPoints());
    }
}//uses the total season point score to sort drivers in ascending order