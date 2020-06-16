package cn.edu.lingnan.entity;

import java.io.Serializable;

/**
 * (Player)实体类
 *
 * @author makejava
 * @since 2020-06-12 19:42:54
 */
public class Player implements Serializable {
    private static final long serialVersionUID = -92555343925789619L;
    
    private Integer playerId;
    
    private String playerName;
    
    private Integer playerHeight;
    
    private Integer playerWeight;
    
    private Integer playerAveScore;
    
    private Integer playerAveRebound;
    
    private Integer playerAveAssist;
    
    private Integer playerTimes;
    
    private String playerTeam;
    
    private Integer playerNumber;


    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(Integer playerHeight) {
        this.playerHeight = playerHeight;
    }

    public Integer getPlayerWeight() {
        return playerWeight;
    }

    public void setPlayerWeight(Integer playerWeight) {
        this.playerWeight = playerWeight;
    }

    public Integer getPlayerAveScore() {
        return playerAveScore;
    }

    public void setPlayerAveScore(Integer playerAveScore) {
        this.playerAveScore = playerAveScore;
    }

    public Integer getPlayerAveRebound() {
        return playerAveRebound;
    }

    public void setPlayerAveRebound(Integer playerAveRebound) {
        this.playerAveRebound = playerAveRebound;
    }

    public Integer getPlayerAveAssist() {
        return playerAveAssist;
    }

    public void setPlayerAveAssist(Integer playerAveAssist) {
        this.playerAveAssist = playerAveAssist;
    }

    public Integer getPlayerTimes() {
        return playerTimes;
    }

    public void setPlayerTimes(Integer playerTimes) {
        this.playerTimes = playerTimes;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

}