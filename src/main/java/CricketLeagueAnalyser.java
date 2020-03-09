import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser<E> {
    public enum RecordType{
        BATTING,BOWLING;
    }
    public enum RecordSort{
        AVERAGE,STRIKE_RATE,FOUR,SIX,PLAYER_NAME,FOUR_SIX_COUNT,FOUR_SIX_COUNT_WITH_AVERAGE;
    }
    List<CricketLeagueDTO> iplList;
    Map<String,CricketLeagueDTO> iplMap=null;
    HashMap<RecordSort, Comparator<CricketLeagueDTO>> mapOfSortValues=null;

    public CricketLeagueAnalyser() {
        iplList=new ArrayList<>();
        iplMap=new HashMap<>();
        mapOfSortValues=new HashMap<>();
        this.mapOfSortValues.put(RecordSort.AVERAGE,Comparator.comparing(batmanCSV->batmanCSV.battingAverage));
        this.mapOfSortValues.put(RecordSort.STRIKE_RATE,Comparator.comparing(batmanCSV->batmanCSV.strikeRate));
        this.mapOfSortValues.put(RecordSort.FOUR_SIX_COUNT,Comparator.comparing(batmanCSV->batmanCSV.sixAndFourCount));
        this.mapOfSortValues.put(RecordSort.FOUR_SIX_COUNT_WITH_AVERAGE,Comparator.comparing(batmanCSV->batmanCSV.fourSixCountAndAverage));
    }

    public int loadIPLData(RecordType batting, String csvFilePath) {
        iplMap= IPLAdapterFactory.getIPLAdapter(batting,csvFilePath);
        iplList=iplMap.values().stream().collect(Collectors.toList());
        return iplMap.size();
    }

    private void sort(Comparator<CricketLeagueDTO> iplCSVComparator) {
        for(int i=0;i<iplList.size()-1;i++){
            for(int j=0;j<iplList.size()-i-1;j++){
                CricketLeagueDTO record1=iplList.get(j);
                CricketLeagueDTO record2=iplList.get(j+1);
                if(iplCSVComparator.compare(record1,record2)>0){
                    iplList.set(j,record2);
                    iplList.set(j+1,record1);
                }
            }
        }
    }

    public String getSortedIPLData(RecordSort onBasisOf) {
        if(iplMap.size()==0 || iplList==null){
            throw new CricketLeagueAnalyserException(CricketLeagueAnalyserException.ExceptionType.NO_IPL_DATA); }
        Comparator<CricketLeagueDTO> iplCSVComparator=this.mapOfSortValues.get(onBasisOf);
        this.sort(iplCSVComparator);
        String json=new Gson().toJson(iplList);
        return json;
    }

}



