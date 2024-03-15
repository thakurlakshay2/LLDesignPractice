package Cache_LLD.cache.exceptions;

public class StorageFullException extends  RuntimeException{
    public StorageFullException() {
        super("Cache storage is now full");
    }
}
