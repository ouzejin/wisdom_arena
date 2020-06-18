package cn.edu.lingnan.entity;


import cn.edu.lingnan.annotation.Id;
import cn.edu.lingnan.annotation.Table;
import java.util.Date;
import java.io.Serializable;

/**
 * (Battle)实体类
 *
 * @author makejava
 * @since 2020-06-14 17:41:44
 */
@Table("matchsys.battle")
public class Battle implements Serializable {
    @Id
    private Integer battleId;
    
    private Date battleTime;
    
    private String battleNameOne;
    
    private Integer battleScoreOne;
    
    private String battleNameTwo;
    
    private Integer battleScoreTwo;
    
    private String battleWinTeam;
    
    private Integer battleStatus;

    @Override
    public String toString() {
        return "Battle{" +
                "battleId=" + battleId +
                ", battleTime=" + battleTime +
                ", battleNameOne='" + battleNameOne + '\'' +
                ", battleScoreOne=" + battleScoreOne +
                ", battleNameTwo='" + battleNameTwo + '\'' +
                ", battleScoreTwo=" + battleScoreTwo +
                ", battleWinTeam='" + battleWinTeam + '\'' +
                ", battleStatus=" + battleStatus +
                '}';
    }

    public Integer getBattleId() {
        return battleId;
    }

    public void setBattleId(Integer battleId) {
        this.battleId = battleId;
    }

    public Date getBattleTime() {
        return battleTime;
    }

    public void setBattleTime(Date battleTime) {
        this.battleTime = battleTime;
    }

    public String getBattleNameOne() {
        return battleNameOne;
    }

    public void setBattleNameOne(String battleNameOne) {
        this.battleNameOne = battleNameOne;
    }

    public Integer getBattleScoreOne() {
        return battleScoreOne;
    }

    public void setBattleScoreOne(Integer battleScoreOne) {
        this.battleScoreOne = battleScoreOne;
    }

    public String getBattleNameTwo() {
        return battleNameTwo;
    }

    public void setBattleNameTwo(String battleNameTwo) {
        this.battleNameTwo = battleNameTwo;
    }

    public Integer getBattleScoreTwo() {
        return battleScoreTwo;
    }

    public void setBattleScoreTwo(Integer battleScoreTwo) {
        this.battleScoreTwo = battleScoreTwo;
    }

    public String getBattleWinTeam() {
        return battleWinTeam;
    }

    public void setBattleWinTeam(String battleWinTeam) {
        this.battleWinTeam = battleWinTeam;
    }

    public Integer getBattleStatus() {
        return battleStatus;
    }

    public void setBattleStatus(Integer battleStatus) {
        this.battleStatus = battleStatus;
    }

}