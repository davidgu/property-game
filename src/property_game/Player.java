/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package property_game;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author David
 */

//implements Serializable so it can be written to file.
public class Player implements Serializable{
    private final String playerName;
    private int playerBalance;
    private int playerNumber;   //will need to change once players are removed 
    private ArrayList<House> playerHouses = new ArrayList<>();
    
    
    Player(String playerName, int playerBalance, int playerNumber){
        this.playerName = playerName;
        this.playerBalance = playerBalance;
        this.playerNumber = playerNumber;
    }
    
    public boolean buyHouse(House house){   //Player buys house object
        int housePrice = house.getPrice();
        if(housePrice <= playerBalance){
            playerBalance -= housePrice;
            playerHouses.add(house);
            house.setOwner(this);
            return true;
        }
        else{
            return false;
        }
    }
    
    public void sellHouse(House house){ //Player sells house object
        int housePrice = house.getPrice();
            playerBalance += housePrice;
            playerHouses.remove(house);
            house.setOwner(null);
    }
    
    public String getName(){
        return playerName;
    }
    
    public int getBalance(){
        return playerBalance;
    }
    
    public int getNumber(){
        return playerNumber;
    }
    
    public ArrayList getAllHouses(){
        return playerHouses;
    }
    
    public void setBalance(int balance){
        playerBalance = balance;
    }
    
    public void clearHouses(){  //Used when player is bankrupt. Removes player ownership from all owned houses.
        for(int i = 0; i<playerHouses.size(); i++){
            playerHouses.get(i).setOwner(null);
        }
    }
        
}
