package com.dhbw.ws;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Long url.
 */
public class longURL {

    //Variables
    private String varLongURL;
    public static List<longURL> entriesLongURL = new ArrayList<>();


    //Constructor & Factory
    /**
     * @param varLongURL
     */
    private longURL(String varLongURL) {
        this.varLongURL = varLongURL;
    }

    //Methods

    /**
     * Create long url long url.
     *
     * @param varLongURL the var long url
     * @return a new Object of type longURL
     */
    public static longURL createLongURL(String varLongURL) {
        return new longURL(varLongURL);
    }

    //Getter

    /**
     * Gets var long url.
     *
     * @return the varLongURL
     */
    public String getVarLongURL() {
        return varLongURL;
    }

    //Setter

    /**
     * Sets var long url.
     *
     * @param varLongURL the varLongURL to set
     */
    public void setVarLongURL(String varLongURL) {
        this.varLongURL = varLongURL;
    }
}