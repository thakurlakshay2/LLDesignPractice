package MessageQueue.public_interface;

import MessageQueue.Handlers.TopicHandler;
import MessageQueue.Model.Message;
import MessageQueue.Model.Topic;
import MessageQueue.Model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
    private final Map<String, TopicHandler> topicHandlers;

    public Queue(){
        this.topicHandlers=new HashMap<>();
    }

    public Topic createTopic(final String topicName){
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler= new TopicHandler(topic);
        System.out.println("Created topic: "+ topicHandler);
        return topic;
    }

    public void subscribe(final ISubscriber subscriber, final Topic topic){
        topic.addSubscriber(new TopicSubscriber(subscriber));;
        System.out.println(subscriber.getId()+"subscriber to topic: "+ topic.getTopicName());
    }

    public void publish(final Topic topic, final Message message){
        topic.addMessage(message);
        System.out.println(message.getMsg()+" published to topic: "+ topic.getTopicName());
        new Thread(()-> topicHandlers.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(final Topic topic, final ISubscriber subscriber, final Integer newOffset){
        for(TopicSubscriber topicSubscriber: topic.getSubscribers()){
            if(topicSubscriber.getSubscriber().equals(subscriber)){
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId()+" offset reset to:"+ newOffset);
                new Thread(()-> topicHandlers.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();

            }
        }
    }
}
