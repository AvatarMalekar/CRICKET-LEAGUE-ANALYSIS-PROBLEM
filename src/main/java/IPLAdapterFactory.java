import java.util.Map;

public class IPLAdapterFactory {

    public static Map<String, CricketLeagueDTO> getIPLAdapter(CricketLeagueAnalyser.RecordType recordType, String... csvFilePath) {
        if(recordType.equals(CricketLeagueAnalyser.RecordType.BATTING))
            return new BatmanIPLAdapter().loadIPLData(csvFilePath);
        if(recordType.equals(CricketLeagueAnalyser.RecordType.BOWLING))
            return new BowlerIPLAdapter().loadIPLData(csvFilePath);
        else
            throw new CricketLeagueAnalyserException("Incorrect Type", CricketLeagueAnalyserException.ExceptionType.INVALID_TYPE_IN_IPL);
    }
}
