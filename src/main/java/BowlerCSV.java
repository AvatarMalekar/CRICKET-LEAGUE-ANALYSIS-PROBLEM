import com.opencsv.bean.CsvBindByName;
//POS,PLAYER,Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w,
public class BowlerCSV {
    @CsvBindByName(column = "Avg", required = true)
    public double bowlingAverage;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRateBow;

    @CsvBindByName(column = "Econ", required = true)
    public double economy;

    @CsvBindByName(column = "4w", required = true)
    public int fourWicket;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWicket;

    @CsvBindByName(column = "Runs", required = true)
    public int runsBow;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerNameBow;

    @Override
    public String toString() {
        return "BowlerCSV{" +
                "Avg='" + bowlingAverage + '\'' +
                ", SR='" + strikeRateBow + '\'' +
                ", Econ='" + economy + '\'' +
                ", 4w='" + fourWicket + '\'' +
                ", 5w='" + fiveWicket + '\'' +
                ", Runs='" + runsBow + '\'' +
                ", Wkts='" + wickets + '\'' +
                ", PLAYER='" + playerNameBow + '\'' +
                '}';
    }
}
