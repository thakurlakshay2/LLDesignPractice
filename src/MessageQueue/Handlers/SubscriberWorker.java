package MessageQueue.Handlers;

import MessageQueue.Model.Message;
import MessageQueue.Model.Topic;
import MessageQueue.Model.TopicSubscriber;

public class SubscriberWorker implements Runnable {
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }


    @Override
    public void run(){
        synchronized (topicSubscriber){
            do{
                int cutOffSet=topicSubscriber.getOffset().get();
                while (cutOffSet>=topic.getMessages().size()){
                    topicSubscriber.wait();
                }
                Message message=topic.getMessages().get(cutOffSet);
                topicSubscriber.getSubscriber().consume(message);

                //we cannot  just increment here since subscriber offset can we reset while it is consuming.
                //So only reset if it was previous one
                topicSubscriber.getOffset().compareAndSet(cutOffSet,cutOffSet+1);
            }while (true);
        }
    }

    synchronized public void wakeUpIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }
}
