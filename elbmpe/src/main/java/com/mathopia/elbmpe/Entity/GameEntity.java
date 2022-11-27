package com.mathopia.elbmpe.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_game")
public class GameEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gameID;
	
	private String gameTitle;
	private String gameInstruction;
	private String gameSource;
	
	public GameEntity() {
		
	}

	public GameEntity(int gameID, String gameTitle, String gameInstruction, String gameSource) {
		super();
		this.gameID = gameID;
		this.gameTitle = gameTitle;
		this.gameInstruction = gameInstruction;
		this.gameSource = gameSource;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getGameInstruction() {
		return gameInstruction;
	}

	public void setGameInstruction(String gameInstruction) {
		this.gameInstruction = gameInstruction;
	}

	public String getGameSource() {
		return gameSource;
	}

	public void setGameSource(String gameSource) {
		this.gameSource = gameSource;
	}
	
	
	
	
}
