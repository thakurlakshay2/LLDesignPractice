package MultiLevelCacheSystem.service;

import MultiLevelCacheSystem.model.ReadResponse;
import MultiLevelCacheSystem.model.StatsResponse;
import MultiLevelCacheSystem.model.WriteResponse;
import MultiLevelCacheSystem.provider.ILevelCache;
import MultiLevelCacheSystem.provider.MultiLevelCache;

import java.util.ArrayList;
import java.util.List;

public class CacheService {
    private final ILevelCache multiLevelCache;
    private final List<Double> lastReadTimes;
    private final List<Double> lastWriteTimes;
    private final int lastCount;

    public CacheService(final MultiLevelCache multiLevelCache, int lastCount) {
        this.multiLevelCache = multiLevelCache;
        this.lastReadTimes = new ArrayList<>(lastCount);
        this.lastWriteTimes = new ArrayList<>(lastCount);
        this.lastCount = lastCount;
    }
    public WriteResponse set(final String key,final String value){
        final WriteResponse writeResponse=multiLevelCache.set(key,value);
        addTimes(lastWriteTimes,writeResponse.getTimeTaken());
        return writeResponse;
    }

    public ReadResponse get(final String key){
        final ReadResponse readResponse=multiLevelCache.get(key);
        addTimes(lastReadTimes,readResponse.getTotalTime());
        return readResponse;
    }
    public StatsResponse stats(){
        return new StatsResponse(getAvgReadTime(),getAvgWriteTime(),multiLevelCache.getUsages());
    }

    private  Double getAvgReadTime(){
        return getSum(lastReadTimes)/lastReadTimes.size();
    }

    private Double getAvgWriteTime(){
        return getSum(lastWriteTimes)/lastWriteTimes.size();
    }

    private void addTimes(List<Double> times,Double time){
        if(times.size()==this.lastCount){
            times.remove(0);
        }
        times.add(time);
    }
    private Double getSum(List<Double> times){
        Double sum=0.0;
        for(Double time:times){
            sum+=time;
        }

        return sum;
    }
}
