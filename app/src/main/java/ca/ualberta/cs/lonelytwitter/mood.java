package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by shipin1 on 9/14/17.
 */

public abstract class mood {
    private Date date;

    public Date getDate(){
        return date;
    }

    public void setDate(Date d){
        date = d;
    }

    public abstract String moods();
}
