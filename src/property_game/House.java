/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package property_game;

import java.io.Serializable;

/**
 *
 * @author David
 */

//implements Serializable so it can be written to file.
public class House implements Serializable{ 
    private int block;
    private int price;
    private final String coordinate;
    private final String boardName;
    private Player owner;
    
    House(String coordinate, String boardName){
        this.coordinate = coordinate;
        this.boardName = boardName;
    }
    //Set and get methods
    public void setBlock(int block){
        this.block = block;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public void setOwner(Player player){
        this.owner = player;
    }
    
    public int getBlock(){
        return block;
    }
    
    public int getPrice(){
        return price;
    }
    
    public String getCoordinate(){
        return coordinate;
    }
    
    public String getBoardName(){
        return boardName;
    }
    
    public Player getOwner(){
        return owner;
    }
    
    //Updates house prices. Takes blockFactor, uses it to help calculate updated house price.
    public void updateHousePrice(double blockFactor){
        double houseChangeFactor;
        int priceChange;
        houseChangeFactor = (Math.random()*0.15)-0.075;
        houseChangeFactor = (Math.round((houseChangeFactor)*1000.0))/1000.0; 
        houseChangeFactor +=blockFactor;    //Positive blockFactor results in positive house price increase over time. Negative results decrease over time.
        priceChange = (int)(price * houseChangeFactor);
        System.out.println(priceChange);
        price += priceChange;
    }
}
