import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
    private static final String BATSMAN_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String BOWLER_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostWkts.csv";
    @Test
    public void givenIPLRecordData_WhenSortedOnAvg_ShouldReturnSortedResult() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.AVERAGE);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals(83.2,iplCsv[iplCsv.length-1].battingAverage,0.00);
    }

    @Test
    public void givenIPLRecordData_WhenSortedOnStrikeRate_ShouldReturnSortedResult() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.STRIKE_RATE);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals("Ishant Sharma",iplCsv[iplCsv.length-1].playerName);
    }

    @Test
    public void givenIPLRecordData_WhenSortedOnBasisOfFOurSixCount_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.FOUR_SIX_COUNT);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals("Andre Russell",iplCsv[iplCsv.length-1].playerName);
    }

    @Test
    public void givenIPLRecordData_WhenSortedOnBasisOfFOurSixCountAndStrikeRate_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.FOUR_SIX_COUNT_WITH_AVERAGE);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals("Andre Russell",iplCsv[iplCsv.length-1].playerName);
    }

    @Test
    public void givenIPLRecordData_WhenSortedOnBasisOfAverageStrikeRate_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.AVERAGE_WITH_STRIKE_RATE);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals("MS Dhoni",iplCsv[iplCsv.length-1].playerName);
    }

    @Test
    public void givenIPLRecordData_WhenSortedOnBasisOfAverageAndMaxRuns_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.RUNS_AND_AVERAGE);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals("David Warner ",iplCsv[iplCsv.length-1].playerName);
    }

    @Test
    public void givenIPLRBowlingRecordData_WhenSortedOnBasisOfAverage_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BOWLING,BOWLER_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.AVERAGE);
        BowlerCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BowlerCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham",iplCsv[iplCsv.length-1].playerNameBow);
    }
}
