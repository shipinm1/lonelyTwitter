/*
 * Copyright (c) Team X. University of Alberta.
 */
/**
 * Tweet
 *
 * Version 1.0
 *
 * September 28 2017
 *
 * Copyright (c) Team x, CMPUT 301, University of Alberta.
 */


package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a Tweet
 *
 * @author shipin
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 *
 */

public abstract class Tweet {

    private String message;
    private Date date;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Constructs Tweet object
     *
     * @param message tweet message
     * @param date tweet date
     */

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    /**
     * Sets tweet messages
     *
     * @param message Tweet message
     * @throws TweetTooLongException
     */



    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    public String getMessage(){
        return this.message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
