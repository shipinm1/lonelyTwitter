package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by gsp on 2017/9/15.
 */

public class Happymood extends mood{
    public Happymood(){
        this.setDate(new Date());
    }

    public Happymood(Date date){
        this.setDate(date);
    }

    public String moods(){
        return "-Happy- at " + this.getDate();
    }
}
