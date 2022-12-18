
package com.mathopia.elbmpe.Service;



import java.util.List;
import java.util.NoSuchElementException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.mathopia.elbmpe.Entity.GameEntity;
import com.mathopia.elbmpe.Repository.GameRepository;



@Service
public class GameService {
    
    @Autowired
    GameRepository grepo;
    
    //Create Record
    public GameEntity createGame(GameEntity game) {
        return grepo.save(game);
    }
    
    //Read all records
    public List<GameEntity> getAllGames(){
        return grepo.findAll();
    }
    
    // Search by gameTitle
    public GameEntity findByGameTitle(String gameTitle) {
        if (grepo.findByGameTitle(gameTitle) != null)
            return grepo.findByGameTitle(gameTitle);
        else
            return null;
        
    }
    // Search by gameID
    public GameEntity findByGameID(int gameID) {
        if (grepo.findByGameID(gameID) != null)
            return grepo.findByGameID(gameID);
        else
            return null;
        
    }
    
    // Update GameDetails
    public GameEntity putGame(int gameID, GameEntity newGameDetails) throws Exception{
    	GameEntity game = new GameEntity();
        
        try {
            
            //Step 1 search the ID Number of the student
            game = grepo.findById(gameID).get(); //find by ID
            
            //Step 2 update record
            game.setGameTitle(newGameDetails.getGameTitle());
            game.setGameInstruction(newGameDetails.getGameInstruction());
            game.setGameSource(newGameDetails.getGameSource());
            
            //Step 3 Save Information and return the value
            return grepo.save(game);
        }catch(NoSuchElementException nex) {
            throw new Exception(" ID Number " + gameID + "Does Not Exist!");
        }
    }
    
    //Delete Game
    public String deleteGame(int gameID) {
        String msg;
        
        if (grepo.findById(gameID) !=null) { // Find the record
            grepo.deleteById(gameID);        // Delete the Record
            
            msg = "Game ID Number" + gameID + "Is Successfully Deleted!";
        }
        else
            msg = "Game ID Number" + gameID + "Is Not Found!";
        
        return msg;
    }
    



}