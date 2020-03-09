import java.util.HashMap;
import java.util.Map;

public class BatmanIPLAdapter extends IPLAdapter{

    @Override
    Map<String,CricketLeagueDTO> loadIPLData(String... csvFilePath) {
        Map<String,CricketLeagueDTO> iplMap=new HashMap<>();
        iplMap=super.loadIPLData(BatsmanCSV.class,csvFilePath[0]);
        if(csvFilePath.length==1)
            return iplMap;
        return null;
    }
    }

