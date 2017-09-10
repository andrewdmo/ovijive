package com.clash.beans;

import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

//Should be Bean but cant annotate:

public class RequestBean {

    private final Model RequestBean = new Model() {

        @Override
        public Model addAttribute(String s, Object o) {
            return null;
        }

        @Override
        public Model addAttribute(Object o) {
            return null;
        }

        @Override
        public Model addAllAttributes(Collection<?> collection) {
            return null;
        }

        @Override
        public Model addAllAttributes(Map<String, ?> map) {
            return null;
        }

        @Override
        public Model mergeAttributes(Map<String, ?> map) {
            return null;
        }

        @Override
        public boolean containsAttribute(String s) {
            return false;
        }

        @Override
        public Map<String, Object> asMap() {
            return null;
        }
    };// Model RequestBean

    public static void addAttribute(String status, int status1) {
    }
}

//    Bean should have Gets, Sets and NO-ARG constructor:
