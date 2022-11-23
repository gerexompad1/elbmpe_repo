package com.mathopia.elbmpe.Controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.mathopia.elbmpe.Entity.TopicEntity;
import com.mathopia.elbmpe.Service.TopicService;



@RestController
@RequestMapping("/topic")
public class TopicController {
    
    @Autowired
    TopicService tpserv;
    
    //Create Topic Record
    @PostMapping("/postTopic")
    public TopicEntity createTopic(@RequestBody TopicEntity topic) {
        return tpserv.createTopic(topic);
    }
    
    //Read all records
    @GetMapping("/getAllTopic")
    public List<TopicEntity> getAllTopic(){
        return tpserv.getAllTopic();
    }
    
    //Read Title
    @GetMapping("/getByTitle")
    public TopicEntity findByTitle(@RequestParam String title) {
        return tpserv.findByTitle(title);
    }
    
    //Update Record
    @PutMapping("/putTopic")
    public TopicEntity putTopic(@RequestParam int id,@RequestBody TopicEntity newTopicDetails) throws Exception{
        return tpserv.putTopic(id, newTopicDetails);
    }
    
    //Delete Record
    @DeleteMapping("/deleteTopic/{id}")
    public String deleteTopic(@PathVariable int id) {
        return tpserv.deleteTopic(id);
    }
}