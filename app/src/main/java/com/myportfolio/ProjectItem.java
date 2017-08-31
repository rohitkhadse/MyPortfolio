package com.myportfolio;

/**
 * Created by User on 8/30/17.
 */

public class ProjectItem {

    private String pname;
    private String pdetail;

    public ProjectItem(String pname, String pdetail) {
        this.pname = pname;
        this.pdetail = pdetail;
    }

    public ProjectItem(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdetail() {
        return pdetail;
    }

    public void setPdetail(String pdetail) {
        this.pdetail = pdetail;
    }
}
