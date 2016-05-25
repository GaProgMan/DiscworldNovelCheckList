package com.gaprogman.dwcheck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by JayTizzle on 25/05/2016.
 */

public class BookService {

    public static final SimpleDateFormat ISO_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public Book getDefaultEntry() {
        return new Book() {
            {
                id = 0;
                title = "The Colour of Magic";
                isbn = "0-86140-324-X";
                try {
                    releaseDate = ISO_FORMAT.parse("1983-11-24");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                coverUrl = "http://wiki.lspace.org/mediawiki/images/c/c9/Cover_The_Colour_Of_Magic.jpg";
                synopsis = "On a world supported on the back of a giant turtle (sex unknown), a gleeful, explosive, wickedly eccentric expedition sets out. There's an avaricious but inept wizard, a naive tourist whose luggage moves on hundreds of dear little legs, dragons who only exist if you believe in them, and of course THE EDGE of the planet ...";
                hasRead = false;
                lastReadDate = null;
                readCount = 0;
            }
        };
    }
}
