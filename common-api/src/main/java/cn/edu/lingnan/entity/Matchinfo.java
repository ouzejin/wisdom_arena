package cn.edu.lingnan.entity;


import cn.edu.lingnan.annotation.Id;
import cn.edu.lingnan.annotation.Table;

import java.io.Serializable;

/**
 * (Matchinfo)实体类
 *
 * @author makejava
 * @since 2020-06-13 10:35:34
 */
@Table("matchsys.matchinfo")
public class Matchinfo implements Serializable {
    @Id
    private Integer matchinfoBattleId;
    
    private String matchinfoTeamName;
    
    private String matchinfoPlayerName;
    
    private Integer matchinfoScore;
    
    private Integer matchinfoRebound;
    
    private Integer matchinfoAssist;


    public Integer getMatchinfoBattleId() {
        return matchinfoBattleId;
    }

    public void setMatchinfoBattleId(Integer matchinfoBattleId) {
        this.matchinfoBattleId = matchinfoBattleId;
    }

    public String getMatchinfoTeamName() {
        return matchinfoTeamName;
    }

    public void setMatchinfoTeamName(String matchinfoTeamName) {
        this.matchinfoTeamName = matchinfoTeamName;
    }

    public String getMatchinfoPlayerName() {
        return matchinfoPlayerName;
    }

    public void setMatchinfoPlayerName(String matchinfoPlayerName) {
        this.matchinfoPlayerName = matchinfoPlayerName;
    }

    public Integer getMatchinfoScore() {
        return matchinfoScore;
    }

    public void setMatchinfoScore(Integer matchinfoScore) {
        this.matchinfoScore = matchinfoScore;
    }

    public Integer getMatchinfoRebound() {
        return matchinfoRebound;
    }

    public void setMatchinfoRebound(Integer matchinfoRebound) {
        this.matchinfoRebound = matchinfoRebound;
    }

    public Integer getMatchinfoAssist() {
        return matchinfoAssist;
    }

    public void setMatchinfoAssist(Integer matchinfoAssist) {
        this.matchinfoAssist = matchinfoAssist;
    }

}