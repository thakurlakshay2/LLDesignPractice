package MessageQueue.Model;

import MessageQueue.public_interface.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {
    private  final AtomicInteger offset;   //used to handle multithreading cases
    private final ISubscriber subscriber;

    public TopicSubscriber( ISubscriber subscriber) {
        this.offset = new AtomicInteger(0);
        this.subscriber = subscriber;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }

    public AtomicInteger getOffset() {
        return offset;
    }
}
