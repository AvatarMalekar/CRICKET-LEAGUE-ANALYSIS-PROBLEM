import java.util.Comparator;

public class ComparatorSortingForWicket implements Comparator<CricketLeagueDTO> {
    @Override
    public int compare(CricketLeagueDTO v1, CricketLeagueDTO v2) {
        int i=(v1.fourWicket+v1.fiveWicket) - (v2.fourWicket+v2.fiveWicket);
        return i;
    }
}
