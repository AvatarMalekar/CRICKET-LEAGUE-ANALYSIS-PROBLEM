import java.util.Comparator;

public class ComparatorSortingForBestAverageOfAllrounder implements Comparator<CricketLeagueDTO> {

    @Override
    public int compare(CricketLeagueDTO v1, CricketLeagueDTO v2) {
        double i=(v1.battingAverage+v2.bowlingAverage);
        return (int)i;
    }
}
