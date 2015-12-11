package com.archive.jordiie.onboardingscreen;

import org.json.JSONObject;

/**
 * Created by jordiie on 11/12/15.
 */
public class CourseRef {
    private String CLASS_NUMBER;
    private String COURSE_CODE;
    private String COURSE_TITLE;
   // private Attendance COURSE_ATTENDANCE;
    private JSONObject COURSE_JSON;

    public CourseRef(){
    }

    public CourseRef(JSONObject object){
        COURSE_JSON = object;

    }

    public void setCLASS_NUMBER(String value) {
        this.CLASS_NUMBER = value;
    }

    public void setCOURSE_CODE(String value) {
        this.COURSE_CODE = value;
    }

    public void setCOURSE_TITLE(String value) {
        this.COURSE_TITLE = value;
    }

    /*public void setCOURSE_ATTENDANCE(Attendance value) {
        this.COURSE_ATTENDANCE = value;
    }*/

    public void setJson(JSONObject value) {
        this.COURSE_JSON = value;
    }

    public String getCLASS_NUMBER() {
        return this.CLASS_NUMBER;
    }

    public String getCOURSE_CODE() {
        return this.COURSE_CODE;
    }

    public String getCOURSE_TITLE() {
        return this.COURSE_TITLE;
    }

    /*public Attendance getCOURSE_ATTENDANCE() {
        return this.COURSE_ATTENDANCE;
    }*/

    public JSONObject getCOURSE_JSON() {
        return COURSE_JSON;
    }

}
