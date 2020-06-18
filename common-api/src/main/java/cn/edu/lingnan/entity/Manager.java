package cn.edu.lingnan.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Manager)实体类
 *
 * @author makejava
 * @since 2020-06-12 15:13:30
 */
public class Manager implements Serializable {
    private static final long serialVersionUID = -90068522910327195L;
    
    private Integer managerId;
    
    private String managerName;
    
    private String managerSex;
    
    private Date managerRegDate;
    
    private Date managerLastLoginDate;
    
    private String managerPassword;

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", managerName='" + managerName + '\'' +
                ", managerSex='" + managerSex + '\'' +
                ", managerRegDate=" + managerRegDate +
                ", managerLastLoginDate=" + managerLastLoginDate +
                ", managerPassword='" + managerPassword + '\'' +
                '}';
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerSex() {
        return managerSex;
    }

    public void setManagerSex(String managerSex) {
        this.managerSex = managerSex;
    }

    public Date getManagerRegDate() {
        return managerRegDate;
    }

    public void setManagerRegDate(Date managerRegDate) {
        this.managerRegDate = managerRegDate;
    }

    public Date getManagerLastLoginDate() {
        return managerLastLoginDate;
    }

    public void setManagerLastLoginDate(Date managerLastLoginDate) {
        this.managerLastLoginDate = managerLastLoginDate;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

}