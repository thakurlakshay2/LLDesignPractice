package MultiLevelCacheSystem.model;

public class ReadResponse {
    String value;
    Double totalTime;

    public ReadResponse(String value, Double totalTime) {
        this.value = value;
        this.totalTime = totalTime;
    }

    public Double getTotalTime(){
        return this.totalTime;
    }

    public String getValue(){
        return this.value;
    }
}
