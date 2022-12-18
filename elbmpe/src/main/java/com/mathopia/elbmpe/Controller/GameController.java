
package com.mathopia.elbmpe.Controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.mathopia.elbmpe.Entity.GameEntity;
import com.mathopia.elbmpe.Service.GameService;



@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:3000")

public class GameController {
    
    @Autowired
    GameService gserv;
    
    //Create Student Record
    @PostMapping("/postCreate")
    public GameEntity createGame(@RequestBody GameEntity game) {
        return gserv.createGame(game);
    }
    
    //Read all records
    @GetMapping("/getAllGames")
    public List<GameEntity> getAllGames(){
        return gserv.getAllGames();
    }
    
    //Read GameTitle
    @GetMapping("/getByGameTitle/{gameTitle}")
    public GameEntity findByGameTitle(@RequestParam String gameTitle) {
        return gserv.findByGameTitle(gameTitle);
    }
    @GetMapping("/getByGameID/{gameID}")
    public GameEntity findByGameID(@PathVariable int gameID) {
        return gserv.findByGameID(gameID);
  
    }
    
    //Update Record
    @PutMapping("/putGame")

    public GameEntity putGame(@RequestParam int gameID,@RequestBody GameEntity newGameDetails) throws Exception{
        return gserv.putGame(gameID, newGameDetails);
    }
    
    //Delete Record
    @DeleteMapping("/deleteGame/{gameID}")
    public String deleteGame(@PathVariable int gameID) {
        return gserv.deleteGame(gameID);
    }
}
