/*
 * Copyright (c) Team X. University of Alberta.
 */
/**
 * NormalTweet
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
 * Create a ArrayList of Tweets
 *
 * @author shipin
 * @version 1.0
 * @see Tweet
 * @see ImportantTweet
 * @since 1.0
 *
 */

public class NormalTweet extends Tweet {
    /**
     * Constructs NormalTweet object
     * @param message Tweet messages
     */

    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }

}
