import java.util.Comparator;

public class ComparatorSortingForWicket implements Comparator<CricketLeagueDTO> {
    @Override
    public int compare(CricketLeagueDTO v1, CricketLeagueDTO v2) {
        int i=(v1.sixCount+v1.fourCount) - (v2.fourCount+v2.sixCount);
        return i;
    }
}
