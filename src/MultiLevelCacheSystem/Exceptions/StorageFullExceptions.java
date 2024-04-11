package MultiLevelCacheSystem.Exceptions;

public class StorageFullExceptions extends RuntimeException {

    public StorageFullExceptions() {
        super("Storage is full");
    }
}
