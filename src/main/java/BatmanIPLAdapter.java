import censusanalyser.CSVBuilderFactory;
import censusanalyser.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class BatmanIPLAdapter extends IPLAdapter{

    @Override
    public Map<String,CricketLeagueDTO> loadIPLData(String... csvFilePath) {
        Map<String,CricketLeagueDTO> iplMap=new HashMap<>();
        iplMap=super.loadIPLData(BatsmanCSV.class,csvFilePath[0]);
        if(csvFilePath.length==1)
            return iplMap;
        return this.loadIPLData(iplMap,csvFilePath[1]);
    }
    private Map<String, CricketLeagueDTO> loadIPLData(Map<String, CricketLeagueDTO> iplMap, String path) {
        try(Reader reader = Files.newBufferedReader(Paths.get(path));) {
            ICSVBuilder icsvBuilder= CSVBuilderFactory.createBuilder();
            Iterator<BowlerCSV> codeIterator=icsvBuilder.getCSVIterator(reader,BowlerCSV.class);
            Iterable<BowlerCSV> iplNameCSV= ()-> codeIterator;
            StreamSupport.stream(iplNameCSV.spliterator(),false)
                    .filter(iplNameCsv -> iplMap.get(iplNameCsv.playerNameBow)!=null)
                    .forEach(code-> {
                        iplMap.get(code.playerNameBow).bowlingAverage = code.bowlingAverage;
                        iplMap.get(code.playerNameBow).mostWicket=code.wickets;
                    });
            return iplMap;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
        catch (IllegalStateException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
    }

