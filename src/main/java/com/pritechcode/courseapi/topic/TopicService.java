package com.pritechcode.courseapi.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    
    @Autowired TopicRepository topicRepository;
    
    // private List<Topic> topics = new ArrayList<>(Arrays.asList(
    //     new Topic("1","spring boot","java based framework"),
    //     new Topic("2","express js","nodejs based framework"),
    //     new Topic("3","laravel","php based framework")
    // ));

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
        .forEach(topics::add);
        
        return topics;
    }

    public Optional<Topic> getTopic(String id){
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic){
        // topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
        // for(int i=0; i <topics.size(); i++){
        //     Topic t = topics.get(i);
        //     if(t.getId().equals(id)){
        //         topics.set(i, topic);
        //         return;
        //     }
        // }
    }

    public void deleteTopic(String id) {
        // return topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
