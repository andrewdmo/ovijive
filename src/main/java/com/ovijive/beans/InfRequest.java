package com.ovijive.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfRequest {

    public enum Status {
        SUCCESS, ERROR
    }

    public String timeStamp;

    private String userIp;

//    public infRequest() {
//
//    }



// Constructor RequestBean

}//class


//    public static void addAttribute(String status, int status1) {
//    }
//}

//    Bean should have Gets, Sets and NO-ARG constructor:

