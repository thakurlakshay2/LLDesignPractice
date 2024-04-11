package MultiLevelCacheSystem.provider;

import MultiLevelCacheSystem.model.ReadResponse;
import MultiLevelCacheSystem.model.WriteResponse;

import java.util.List;

public interface ILevelCache {
    WriteResponse set(String key,String value);
    ReadResponse get(String key);
    List<Double> getUsages();
}
