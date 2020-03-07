import com.opencsv.bean.CsvBindByName;

public class BatsmanCSV {

    @CsvBindByName(column = "Avg", required = true)
    public String battingAverage;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;


    @CsvBindByName(column = "4s", required = true)
    public int fourCount;

    @CsvBindByName(column = "6s", required = true)
    public double sixCount;

    @Override
    public String toString() {
        return "BatsmanCSV{" +
                "Avg='" + battingAverage + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", 4s='" + fourCount + '\'' +
                ", 6s='" + sixCount + '\'' +
                '}';
    }
}
