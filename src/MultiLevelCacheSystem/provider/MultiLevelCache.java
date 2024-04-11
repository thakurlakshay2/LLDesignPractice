package MultiLevelCacheSystem.provider;

import MultiLevelCacheSystem.model.LevelCacheData;
import MultiLevelCacheSystem.model.ReadResponse;
import MultiLevelCacheSystem.model.WriteResponse;

import java.util.Collections;
import java.util.List;

public class MultiLevelCache implements ILevelCache {
    private  final LevelCacheData levelCacheData;
    private final CacheProvider cacheProvider;

    private final ILevelCache next;

    public MultiLevelCache(LevelCacheData levelCacheData, CacheProvider cacheProvider, ILevelCache next) {
        this.levelCacheData = levelCacheData;
        this.cacheProvider = cacheProvider;
        this.next = next;
    }

    @Override
    public WriteResponse set(String key,String value){
        Double curTime=0.0;
        String curLevelValue= cacheProvider.get(key);
        curTime+=levelCacheData.getReadTime();
        if(!value.equals(curLevelValue)){
            cacheProvider.put(key,value);
            curTime+=levelCacheData.getWriteTime();
        }
        curTime+=next.set(key,value).getTimeTaken();
        return new WriteResponse(curTime);
    }

    // L1 -> L2 -> L3 -> L4
    @Override
    public ReadResponse get(String key){
        Double curTime=0.0;
        String curLevelValue= cacheProvider.get(key);
        curTime+=levelCacheData.getReadTime();

        if(curLevelValue==null){
            ReadResponse nextResponse=next.get(key);

            curTime+=nextResponse.getTotalTime();
            curLevelValue= nextResponse.getValue();
            if(curLevelValue!=null){
                cacheProvider.put(key,curLevelValue);
                curTime+=levelCacheData.getWriteTime();
            }

        }

        return new ReadResponse(curLevelValue,curTime);
    }

    public List<Double> getUsages(){
        final List<Double> usages;
        if(next==null){
            usages= Collections.emptyList();
        }else{
            usages=next.getUsages();
        }
        usages.add(0,cacheProvider.getCurrentUsage());
        return usages;
    }



}
