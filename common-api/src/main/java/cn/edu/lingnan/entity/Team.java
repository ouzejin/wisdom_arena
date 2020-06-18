package cn.edu.lingnan.entity;


import cn.edu.lingnan.annotation.Id;
import cn.edu.lingnan.annotation.Table;

import java.util.Date;
import java.io.Serializable;

/**
 * (Team)实体类
 *
 * @author makejava
 * @since 2020-06-12 16:46:34
 */
@Table("matchsys.team")
public class Team implements Serializable {
    @Id
    private String teamName;
    
    private String teamPassword;
    
    private String teamEmail;
    
    private String teamPhone;
    
    private String teamCaptain;
    
    private Integer teamCount;
    
    private String teamCoach;
    
    private Date teamRegDate;
    
    private Date teamLastLoginDate;
    
    private Object teamWin;
    
    private Object teamLose;

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamPassword='" + teamPassword + '\'' +
                ", teamEmail='" + teamEmail + '\'' +
                ", teamPhone='" + teamPhone + '\'' +
                ", teamCaptain='" + teamCaptain + '\'' +
                ", teamCount=" + teamCount +
                ", teamCoach='" + teamCoach + '\'' +
                ", teamRegDate=" + teamRegDate +
                ", teamLastLoginDate=" + teamLastLoginDate +
                ", teamWin=" + teamWin +
                ", teamLose=" + teamLose +
                '}';
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamPassword() {
        return teamPassword;
    }

    public void setTeamPassword(String teamPassword) {
        this.teamPassword = teamPassword;
    }

    public String getTeamEmail() {
        return teamEmail;
    }

    public void setTeamEmail(String teamEmail) {
        this.teamEmail = teamEmail;
    }

    public String getTeamPhone() {
        return teamPhone;
    }

    public void setTeamPhone(String teamPhone) {
        this.teamPhone = teamPhone;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public void setTeamCaptain(String teamCaptain) {
        this.teamCaptain = teamCaptain;
    }

    public Integer getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(Integer teamCount) {
        this.teamCount = teamCount;
    }

    public String getTeamCoach() {
        return teamCoach;
    }

    public void setTeamCoach(String teamCoach) {
        this.teamCoach = teamCoach;
    }

    public Date getTeamRegDate() {
        return teamRegDate;
    }

    public void setTeamRegDate(Date teamRegDate) {
        this.teamRegDate = teamRegDate;
    }

    public Date getTeamLastLoginDate() {
        return teamLastLoginDate;
    }

    public void setTeamLastLoginDate(Date teamLastLoginDate) {
        this.teamLastLoginDate = teamLastLoginDate;
    }

    public Object getTeamWin() {
        return teamWin;
    }

    public void setTeamWin(Object teamWin) {
        this.teamWin = teamWin;
    }

    public Object getTeamLose() {
        return teamLose;
    }

    public void setTeamLose(Object teamLose) {
        this.teamLose = teamLose;
    }

}