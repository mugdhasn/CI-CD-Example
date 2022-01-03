package com.mg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.db.TopicRepository;
import com.mg.model.Topic;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepostiory;
	
//	private List<Topic> topics = new ArrayList<>( Arrays.asList(new Topic("A1", "Topic name 1", "asdf"),
//			new Topic("A2", "topic name 2", "xcvb"),
//			new Topic("A3", "topic name 3", "asdfefd")));

	public List<Topic> getAllTopics() {
		//return topics;
		List<Topic>topics=new ArrayList<>();
		topicRepostiory.findAll().forEach(topics::add);
		return topics;
	}

//	public Topic getTopic(String tid) {
// 
//		
//		//return topics.stream().filter(m -> m.getId().equals(id)).findFirst().get();
//		//Topic topic= topicRepostiory.findAll().stream().filter(m -> m.getId().equals(id)).findFirst().get();
//	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		//topics.add(topic);
		topicRepostiory.save(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
//		// TODO Auto-generated method stub
//		for(int i=0;i<topics.size();i++) {
//			Topic m=topics.get(i);
//			if(m.getId().equals(id)) {
//				topics.set(i, topic); //at that id setting this new topic in payload/req body
//				return ;
//			}
//		}
		topicRepostiory.save(topic);
		
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(m->m.getId().equals(id)); //predicate interface method
		topicRepostiory.deleteById(id);
	}
}
