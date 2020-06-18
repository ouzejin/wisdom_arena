package cn.edu.lingnan.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Request)实体类
 *
 * @author makejava
 * @since 2020-06-14 16:27:39
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 384177245125198036L;
    
    private Integer requestId;
    
    private Date requestTime;
    
    private String requestNameOne;
    
    private String requestNameTwo;

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", requestTime=" + requestTime +
                ", requestNameOne='" + requestNameOne + '\'' +
                ", requestNameTwo='" + requestNameTwo + '\'' +
                '}';
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestNameOne() {
        return requestNameOne;
    }

    public void setRequestNameOne(String requestNameOne) {
        this.requestNameOne = requestNameOne;
    }

    public String getRequestNameTwo() {
        return requestNameTwo;
    }

    public void setRequestNameTwo(String requestNameTwo) {
        this.requestNameTwo = requestNameTwo;
    }

}