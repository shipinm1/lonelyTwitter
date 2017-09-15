package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by gsp on 2017/9/15.
 */

public class Sadmood extends mood{
    public Sadmood(){
        this.setDate(new Date());
    }

    public Sadmood(Date date){
        this.setDate(date);
    }

    public String moods(){
        return "-Sad- at " + this.getDate();
    }
}

