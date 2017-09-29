/*
 * Copyright (c) Team X. University of Alberta.
 */
/**
 * Tweetable
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
 *
 *
 * @author shipin
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 *
 */

public interface Tweetable {
    String getMessage();
    Date getDate();
}
