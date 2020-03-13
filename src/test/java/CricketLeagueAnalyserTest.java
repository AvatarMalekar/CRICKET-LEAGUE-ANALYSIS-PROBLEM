import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
    private static final String BATSMAN_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String BOWLER_CSV_FILE_PATH ="./src/test/resources/IPL2019FactsheetMostWkts.csv";

    CricketLeagueAnalyser cricketLeagueAnalyser;
    @Before
    public void setUp() throws Exception {
        cricketLeagueAnalyser=new CricketLeagueAnalyser();
    }

    @Test
    public void givenIPLRecordData_WhenSortedOnAvg_ShouldReturnSortedResult() {

        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.AVERAGE);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals("Shreyas Iyer",iplCsv[iplCsv.length-1].playerName);
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

    @Test
    public void givenIPLRBowlingRecordData_WhenSortedOnBasisOfStriking_Rate_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BOWLING,BOWLER_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.STRIKE_RATE_OF_BOWLER);
        BowlerCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BowlerCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham",iplCsv[iplCsv.length-1].playerNameBow);
    }

    @Test
    public void givenIPLRBowlingRecordData_WhenSortedOnBasisOfEconomy_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BOWLING,BOWLER_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.ECONOMY_RATE);
        BowlerCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BowlerCSV[].class);
        Assert.assertEquals("Ben Cutting",iplCsv[iplCsv.length-1].playerNameBow);
    }

    @Test
    public void givenIPLRBowlingRecordData_WhenSortedOnBasisOfFourAndFiveWicketCountWithStrikeRate_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BOWLING,BOWLER_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.STRIKE_RATE_WITH_FOUR_FIVE_WICKETS);
        BowlerCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BowlerCSV[].class);
        Assert.assertEquals("Lasith Malinga",iplCsv[iplCsv.length-1].playerNameBow);
    }

    @Test
    public void givenIPLRBowlingRecordData_WhenSortedOnBasisOfAvaerageAndStrikeRate_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BOWLING,BOWLER_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.AVERAGE_WITH_STRIKE_OF_BOWLERS);
        BowlerCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BowlerCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham",iplCsv[iplCsv.length-1].playerNameBow);
    }

    @Test
    public void givenIPLRBowlingRecordData_WhenSortedOnBasisOfMostWicketAndAverage_ShouldReturn_PlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BOWLING,BOWLER_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.MOST_WICKETS_WITH_AVERAGE);
        BowlerCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BowlerCSV[].class);
        Assert.assertEquals("Imran Tahir",iplCsv[iplCsv.length-1].playerNameBow);
    }

    @Test
    public void givenIPLbowling_And_Batting_RecordData_WhenSortedOnBasisOfBattingAndBowlingAverage_ShouldReturnPlayerName() {
        CricketLeagueAnalyser cricketLeagueAnalyser=new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH,BOWLER_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.BEST_AVERAGE_ALLROUNDER);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals("Krishnappa Gowtham",iplCsv[iplCsv.length-1].playerName);
    }

    @Test
    public void givenIPLbowling_And_Batting_RecordData_WhenSortedOnBasisOfRunsAndWickets_ShouldReturnPlayerName() {
        cricketLeagueAnalyser.loadIPLData(CricketLeagueAnalyser.RecordType.BATTING,BATSMAN_CSV_FILE_PATH,BOWLER_CSV_FILE_PATH);
        String sortedIPLData=cricketLeagueAnalyser.getSortedIPLData(CricketLeagueAnalyser.RecordSort.ALLROUNDER);
        BatsmanCSV[] iplCsv=new Gson().fromJson(sortedIPLData,BatsmanCSV[].class);
        Assert.assertEquals("Hardik Pandya",iplCsv[iplCsv.length-1].playerName);
    }
}
