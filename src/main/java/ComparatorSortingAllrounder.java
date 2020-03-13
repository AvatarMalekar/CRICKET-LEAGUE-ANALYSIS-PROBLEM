import java.util.Comparator;

public class ComparatorSortingAllrounder implements Comparator<CricketLeagueDTO> {

    @Override
    public int compare(CricketLeagueDTO v1, CricketLeagueDTO v2) {
        int i = 0;
        if(v1.mostWicket!=0)
            i=(v1.mostWicket*v1.runs)-(v2.mostWicket*v2.runs);
        return i;
    }
}
