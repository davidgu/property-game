/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package property_game;
import java.io.Serializable;
import java.awt.Color;
import java.util.*;
import java.io.*;

/**
 *
 * @author David
 */
public class Game implements Serializable{
    
    private int GAME_BOARD_HEIGHT;
    private int GAME_BOARD_WIDTH;
    private double TAX_RATE;
    private int STARTING_PLAYER_BALANCE;
    private int MINIMUM_BLOCK_QUANTITY;
    private int MAXIMUM_BLOCK_QUANTITY;
    private double BLOCK_FACTOR_MINIMUM;
    private double BLOCK_FACTOR_MAXIMUM;
    private int MINIMUM_HOUSE_PRICE;
    private int MAXIMUM_HOUSE_PRICE;
    
    private double[] blockFactors;
    private int playerNumber;   //Used to assign player numbers as well as keep track of current player.
    private House activeHouse;
    private Player currentPlayer;
    private boolean buttonStatus;
    
    private ArrayList<ArrayList<House>> houseList;
    private ArrayList<Player> playerList;
    
    private javax.swing.JButton[][] buttons;
    private Color[] buttonColors;

    Game(int GAME_BOARD_HEIGHT, int GAME_BOARD_WIDTH, double TAX_RATE, int STARTING_PLAYER_BALANCE, int MINIMUM_BLOCK_QUANTITY, int MAXIMUM_BLOCK_QUANTITY, //Constructor, takes all data at construction
            double BLOCK_FACTOR_MINIMUM, double BLOCK_FACTOR_MAXIMUM, int MINIMUM_HOUSE_PRICE, int MAXIMUM_HOUSE_PRICE, double[] blockFactors, int playerNumber, House activeHouse, Player currentPlayer, 
            boolean buttonStatus, ArrayList<ArrayList<House>> houseList, ArrayList<Player> playerList, javax.swing.JButton[][] buttons, Color[] buttonColors ){
        
        this.GAME_BOARD_HEIGHT = GAME_BOARD_HEIGHT;
        this.GAME_BOARD_WIDTH = GAME_BOARD_WIDTH;
        this.TAX_RATE = TAX_RATE;
        this.STARTING_PLAYER_BALANCE = STARTING_PLAYER_BALANCE;
        this.MINIMUM_BLOCK_QUANTITY = MINIMUM_BLOCK_QUANTITY;
        this.MAXIMUM_BLOCK_QUANTITY = MAXIMUM_BLOCK_QUANTITY;
        this.BLOCK_FACTOR_MINIMUM = BLOCK_FACTOR_MINIMUM;
        this.BLOCK_FACTOR_MAXIMUM = BLOCK_FACTOR_MAXIMUM;
        
        this.blockFactors = blockFactors;
        this.playerNumber = playerNumber;   //Used to assign player numbers as well as keep track of current player.
        this.activeHouse = activeHouse;
        this.currentPlayer = currentPlayer;
        this.buttonStatus = buttonStatus;
        
        this.houseList = houseList;
        this.playerList = playerList;
    
        this.buttons = buttons;
        this.buttonColors = buttonColors;
        
    }
    
    public void saveGame(){ //Saves game into savegame.dat
        try{
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("savegame.dat"));
        output.writeObject(this);
        output.flush();
        output.close();
        }
        catch(Exception e){
            System.out.println(e.getClass().getName());
        }
    }
    
    //Accessor methods
    public int getGAME_BOARD_HEIGHT(){
        return GAME_BOARD_HEIGHT;
    }
    public int getGAME_BOARD_WIDTH(){
        return GAME_BOARD_WIDTH;
    }
    public double getTAX_RATE(){
        return TAX_RATE;
    }
    public int getSTARTING_PLAYER_BALANCE(){
        return STARTING_PLAYER_BALANCE;
    }
    public int getMINIMUM_BLOCK_QUANTITY(){
        return MINIMUM_BLOCK_QUANTITY;
    }
    public int getMAXIMUM_BLOCK_QUANTITY(){
        return MAXIMUM_BLOCK_QUANTITY;
    }
    public double getBLOCK_FACTOR_MINIMUM(){
        return BLOCK_FACTOR_MINIMUM;
    }
    public double getBLOCK_FACTOR_MAXIMUM(){
        return BLOCK_FACTOR_MAXIMUM;
    }
    public int getMINIMUM_HOUSE_PRICE(){
        return MINIMUM_HOUSE_PRICE;
    }
    public int getMAXIMUM_HOUSE_PRICE(){
        return  MAXIMUM_HOUSE_PRICE;
    }
    public double[] getBlockFactors(){
        return blockFactors;
    }
    public int getPlayerNumber(){
        return playerNumber;
    }
    public House getActiveHouse(){
        return activeHouse;
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public boolean getButtonStatus(){
        return buttonStatus;
    }    
    public ArrayList<ArrayList<House>> getHouseList(){
        return houseList;
    }
    public ArrayList<Player> getPlayerList(){
        return playerList;
    }
    public javax.swing.JButton[][] getButtons(){
        return buttons;
    }
    public Color[] getButtonColors(){
        return buttonColors;
    }

}
    