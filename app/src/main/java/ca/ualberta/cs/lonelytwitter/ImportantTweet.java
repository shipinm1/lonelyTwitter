/*
 * Copyright (c) Team X. University of Alberta.
 */
/**
 * ImportantTweet
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
 * Controller for Tweets
 *
 * @author shipin
 * @version 1.0
 * @see NormalTweet
 * @see Tweet
 * @since 1.0
 *
 */

public class ImportantTweet extends Tweet implements Tweetable {

    /**
     * Constructs of ImportantTweet Object
     * @param message Tweet messages
     */

    public ImportantTweet(String message){
        super(message);
    }

    public ImportantTweet(String message, Date date) {
        super(message, date);
    }


    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
