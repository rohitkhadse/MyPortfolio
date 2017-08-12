package com.myportfolio;

/**
 * Created by User on 8/12/17.
 */

public class SkillItem {
    private String name;
    private int image;

    public SkillItem(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
