package com.dhbw.ws;

/**
 * The type Short url.
 */
public class shortURL {

    //Variables
    private String varShortURL;
    private String alias;


    //Constructor & Factory
    /**
     * @param alias
     */
    private shortURL(String alias) {
        this.alias = alias;
        this.varShortURL = genShortURL(alias);
    }

    //Methods
    //Factory Method
    /**
     * Create short url short url.
     *
     * @param alias the alias
     * @return a new Object of type shortURL
     */
    public static shortURL createShortURL(String alias) {
        return new shortURL(alias);
    }

    /**
     * Gen short url string.
     *
     * @param alias the alias
     * @return the string
     */
    public String genShortURL(String alias) {
        return "http://localhost:8080/api/short/" + alias;
    }

    //Getter

    /**
     * Gets var short url.
     *
     * @return the varShortURL
     */
    public String getVarShortURL() {
        return varShortURL;
    }

    /**
     * Gets alias.
     *
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    //Setter

    /**
     * Sets var short url.
     *
     * @param varShortURL the varShortURL to set
     */
    public void setVarShortURL(String varShortURL) {
        this.varShortURL = varShortURL;
    }

    /**
     * Sets alias.
     *
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}