public class CricketLeagueDTO {
    public  double battingAverage;
    public double strikeRate;
    public int fourCount;
    public int sixCount;
    public String playerName;
    public int runs;

    public double bowlingAverage;
    public double strikeRateBow;
    public double economy;
    public int fourWicket;
    public int fiveWicket;
    public int runsBow;
    public int wickets;
    public String playerNameBow;


    public CricketLeagueDTO(BatsmanCSV csvObj) {
        this.battingAverage =  csvObj.battingAverage;
        this.strikeRate =  csvObj.strikeRate;
        this.fourCount =  csvObj.fourCount;
        this.sixCount =  csvObj.sixCount;
        this.playerName =  csvObj.playerName;
        this.runs=csvObj.runs;
    }

    public CricketLeagueDTO(BowlerCSV csvObj) {
        this.bowlingAverage = csvObj.bowlingAverage;
        this.strikeRateBow = csvObj.strikeRateBow;
        this.economy = csvObj.economy;
        this.fourWicket = csvObj.fourWicket;
        this.fiveWicket = csvObj.fiveWicket;
        this.runsBow = csvObj.runsBow;
        this.wickets = csvObj.wickets;
        this.playerNameBow = csvObj.playerNameBow;
    }
}
