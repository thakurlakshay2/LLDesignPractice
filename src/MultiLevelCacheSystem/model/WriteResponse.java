package MultiLevelCacheSystem.model;

public class WriteResponse {
    Double timeTaken;

    public WriteResponse(Double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Double getTimeTaken(){
      return   this.timeTaken;
    }
}
