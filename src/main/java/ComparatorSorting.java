import java.util.Comparator;

public class ComparatorSorting implements Comparator<CricketLeagueDTO> {
    @Override
    public int compare(CricketLeagueDTO r1, CricketLeagueDTO r2) {
        int i=(r1.sixCount+r1.fourCount) - (r2.fourCount+r2.sixCount);
        return i;
    }
}
