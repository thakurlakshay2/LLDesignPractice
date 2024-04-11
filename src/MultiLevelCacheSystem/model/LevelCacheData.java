package MultiLevelCacheSystem.model;


public class LevelCacheData {
    int readTime;
    int writeTime;

    public int getReadTime(){
        return this.readTime;
    }
    public int getWriteTime(){
        return this.writeTime;
    }
}
