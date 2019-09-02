/**
 * 
 */
package com.springboot.demo.jackson.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author IGEN
 *
 */
public class User  {

    private int id;
    
    private String message;
    
    private Date sendTime;
    
    private String NodeName;
    
    private List<Integer> intList;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(int id, String message, Date sendTime) {
        super();
        this.id = id;
        this.message = message;
        this.sendTime = sendTime;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the sendTime
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * @param sendTime the sendTime to set
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * @return the nodeName
     */
    public String getNodeName() {
        return NodeName;
    }

    /**
     * @param nodeName the nodeName to set
     */
    public void setNodeName(String nodeName) {
        this.NodeName = nodeName;
    }

    /**
     * @return the intList
     */
    public List<Integer> getIntList() {
        return intList;
    }

    /**
     * @param intList the intList to set
     */
    public void setIntList(List<Integer> intList) {
        this.intList = intList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", message=" + message + ", sendTime=" + sendTime + ", nodeName=" + NodeName
                + ", intList=" + intList + "]";
    }
    
    
}
