import com.opencsv.bean.CsvBindByName;

public class BatsmanCSV {
    //POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s
    @CsvBindByName(column = "Avg", required = true)
    public double battingAverage;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "4s", required = true)
    public int fourCount;

    @CsvBindByName(column = "6s", required = true)
    public int sixCount;

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;
    @Override
    public String toString() {
        return "BatsmanCSV{" +
                "Avg='" + battingAverage + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", 4s='" + fourCount + '\'' +
                ", 6s='" + sixCount + '\'' +
                ", PLAYER='" + playerName + '\'' +
                ", Runs='" + runs + '\'' +
                '}';
    }
}
