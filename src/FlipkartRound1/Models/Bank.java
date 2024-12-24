package FlipkartRound1.Models;

import java.util.UUID;

public class Bank {
    private final String id;
    private final String name;
    private boolean serverActive;

    public Bank(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.serverActive=true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isServerActive() {
        return serverActive;
    }

    public void setServerActive(boolean serverActive) {
        this.serverActive = serverActive;
    }
}
