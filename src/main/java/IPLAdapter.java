import censusanalyser.CSVBuilderFactory;
import censusanalyser.ICSVBuilder;
import com.opencsv.bean.CsvToBean;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

abstract class IPLAdapter {
    abstract Map<String, CricketLeagueDTO> loadIPLData(String... csvFilePath);
    public <E>Map<String, CricketLeagueDTO> loadIPLData(Class<E> className, String csvFilePath) {
        Map<String, CricketLeagueDTO> iplMap=new HashMap<>();
        CsvToBean<E> csvToBean;
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
            ICSVBuilder icsvBuilder= CSVBuilderFactory.createBuilder();
            Iterator<E> iplRecord=icsvBuilder.getCSVIterator(reader,className);

            Iterable<E> stateCodeCSV= ()-> iplRecord;
            if(className.getName().equals("BatsmanCSV")){
                StreamSupport.stream(stateCodeCSV.spliterator(),false)
                        .map(BatsmanCSV.class::cast)
                        .forEach(code->iplMap.put(code.playerName,new CricketLeagueDTO(code)));}
            if(className.getName().equals("BowlerCSV")){
                StreamSupport.stream(stateCodeCSV.spliterator(),false)
                        .map(BowlerCSV.class::cast)
                        .forEach(code->iplMap.put(code.playerNameBow,new CricketLeagueDTO(code)));}
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
