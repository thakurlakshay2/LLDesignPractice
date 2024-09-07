package MessageQueue.public_interface;

import MessageQueue.Model.Message;

public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
