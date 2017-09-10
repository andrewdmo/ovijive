package com.clash.beans;

import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

public class RequestBean {

    public String timeStamp;

    private String userIp;

    public RequestBean() {
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Model addAttribute(String s, Object o) {
        return null;
    }

    public Model addAttribute(Object o) {
        return null;
    }

    public Model addAllAttributes(Collection<?> collection) {
        return null;
    }

    public Model addAllAttributes(Map<String, ?> map) {
        return null;
    }

    public Model mergeAttributes(Map<String, ?> map) {
        return null;
    }

    public boolean containsAttribute(String s) {
        return false;
    }

    public Map<String, Object> asMap() {
        return null;
    }

// Constructor RequestBean

}//class


//    public static void addAttribute(String status, int status1) {
//    }
//}

//    Bean should have Gets, Sets and NO-ARG constructor:

