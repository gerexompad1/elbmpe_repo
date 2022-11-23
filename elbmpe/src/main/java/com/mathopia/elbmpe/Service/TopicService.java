package com.mathopia.elbmpe.Service;



import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mathopia.elbmpe.Entity.TopicEntity;
import com.mathopia.elbmpe.Repository.TopicRepository;



@Service
public class TopicService {
    
    @Autowired
    TopicRepository trepo;
    
    //Create Record
    public TopicEntity createTopic(TopicEntity topic) {
        return trepo.save(topic);
    }
    
    //Read all records
    public List<TopicEntity> getAllTopic(){
        return trepo.findAll();
    }
    
    // Search by Title
    public TopicEntity findByTitle(String title) {
        if (trepo.findByTitle(title) != null)
            return trepo.findByTitle(title);
        else
            return null;
        
    }
    
    // Update Topic
    public TopicEntity putTopic(int id, TopicEntity newTopicDetails) throws Exception{
        TopicEntity topic = new TopicEntity();
        
        try {
            
            //Step 1 search the ID Number of the student
            topic = trepo.findById(id).get(); //find by ID
            
            //Step 2 update record
            topic.setTitle(newTopicDetails.getTitle());
            topic.setLearningG(newTopicDetails.getLearningG());
            topic.setVidSource(newTopicDetails.getVidSource());
            //Step 3 Save Information and return the value
            return trepo.save(topic);
        }catch(NoSuchElementException nex) {
            throw new Exception(" ID Number " + id + "Does Not Exist!");
        }
    }
    
    //Delete Record
    public String deleteTopic(int id) {
        String msg;
        
        if (trepo.findById(id) !=null) { // Find the record
            trepo.deleteById(id);        // Delete the Record
            
            msg = "Topic ID Number " + id + " Is Successfully Deleted!";
        }
        else
            msg = "Topic ID Number " + id + " Is Not Found!";
        
        return msg;
    }
    



}
