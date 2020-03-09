import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
    private static final String BATSMAN_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    @Test
    public void givenIPLRecordData_WhenSortedOnAvg_ShouldReturnSortedResult() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.AVERAGE);
        BatsmanCSV[] censusCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals(83.2,censusCsv[censusCsv.length-1].battingAverage,0.00);
    }
}
