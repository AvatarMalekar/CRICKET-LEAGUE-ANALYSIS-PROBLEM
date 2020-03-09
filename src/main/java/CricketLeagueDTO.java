public class CricketLeagueDTO {
    public  double battingAverage;
    public double strikeRate;
    public int fourCount;
    public int sixCount;
    public String playerName;
    public int runs;

    public CricketLeagueDTO(BatsmanCSV csvObj) {
        this.battingAverage =  csvObj.battingAverage;
        this.strikeRate =  csvObj.strikeRate;
        this.fourCount =  csvObj.fourCount;
        this.sixCount =  csvObj.sixCount;
        this.playerName =  csvObj.playerName;
        this.runs=csvObj.runs;
    }


}
