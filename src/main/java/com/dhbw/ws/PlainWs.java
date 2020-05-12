package com.dhbw.ws;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * The type Plain ws.
 */
@Path("/")
public class PlainWs {

    //Vorlage einer blanken Funktion
    @GET
    @Path("/plain/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFoo(@PathParam("name") String name) {
        return name;
    }


    private static String longURLArray[] = new String[100];
    private static String aliasArray[] = new String[100];
    private static int amount = 0;

    static HashMap<String, String> connection = new HashMap<String, String>();

    //Final Methods with RestAPI-Endpoint

    /**
     * Propose alias string.
     *
     * @return the string
     */
    @GET
    @Path("/alias")
    @Produces(MediaType.APPLICATION_JSON)
    public static String proposeAlias() {
        return "{\"alias\":\"" + genAlias() + "\"}";
    }

    /**
     * Submit input string.
     *
     * @param longURLInput the long url input
     * @param aliasInput   the alias input
     * @deprecated
     */
    @GET
    @Path("/submit/{longURL}/{alias}")
    @Consumes(MediaType.TEXT_PLAIN)
    public static void submitInputOLD1(@PathParam("longURL") String longURLInput, @PathParam("alias") String aliasInput) {
        longURLArray[amount] = longURLInput;
        aliasArray[amount] = aliasInput;
        amount += 1;
        System.out.println("You've inserted the URL " + longURLArray[amount - 1] + " with the Alias " + aliasArray[amount - 1]);
    }

    /**
     * Submit input string.
     *
     * @deprecated
     */
    @POST
    @Path("/submit")
    @Consumes(MediaType.TEXT_PLAIN)
    public static void submitInputOLD2() {
        //longURLArray[amount] = longURLInput;
     //   aliasArray[amount] = aliasInput;
        amount += 1;
        System.out.println("You've inserted the URL " + longURLArray[amount - 1] + " with the Alias " + aliasArray[amount - 1]);
    }

    @POST
    @Path("/convert")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public static void submitInput(@FormParam("longURLInput") String longURLInput,
                                 @FormParam("aliasInput") String aliasInput) {
        /*longURLArray[amount] = longURLInput;
        aliasArray[amount] = aliasInput;
        amount += 1;
        System.out.println("You've inserted the URL " + longURLArray[amount - 1] + " with the Alias " + aliasArray[amount - 1]);
        String outputString = "http://localhost:8080/api/short/" + aliasArray[amount - 1];*/
        String result = longURLInput.replaceFirst("^(http[s]?://www\\.|http[s]?://|www\\.)","");
        System.out.println(result);
        connection.put(aliasInput, result);
    }

    /**
     * Redirect string.
     *
     * @param alias the alias
     * @return the string
     */
    @GET
    @Path("/short/{alias}")
    @Produces(MediaType.TEXT_HTML)
    public static String redirect(@PathParam("alias") String alias ) {
        System.out.println("You've requested alias " + alias);
       // int i = searchAlias(alias);
        //System.out.println("Position of the URL in the Array " + i);
        //return "<script>\nwindow.location = \"//" + longURLArray[i] + "\";\n</script>";
        return "<script>\nwindow.location = \"//" + connection.get(alias) + "\";\n</script>";
    }

    /**
     * Delete.
     *
     * @param alias the alias
     */
    @DELETE
    @Path("/delete/{alias}")
    @Consumes(MediaType.TEXT_PLAIN)
    public static void delete(@PathParam("alias") String alias) {
        connection.remove(alias);
        System.out.println("You have deleted " + alias);
        //int index = searchAlias(alias);
        /*for (int i = amount - 1; i >= index; i--) {
            String a = aliasArray[i];
            String b = aliasArray[i-1];
            aliasArray[i] = null;
            aliasArray[i-1] = a;
        }
        amount -= 1;*/
        //aliasArray[index] = null;
        //longURLArray[index] = null;
    }

    /**
     * Delete all.
     */
    @DELETE
    @Path("/delete/all")
    @Consumes(MediaType.TEXT_PLAIN)
    public static void deleteAll() {
        connection.clear();
        System.out.println("You have deleted all connections");
    }


    /**
     * Gets table.
     *
     * @return the table
     */
    @GET
    @Path("/table")
    @Produces(MediaType.TEXT_HTML)
    public static String getTable() {

        StringBuffer sbs = new StringBuffer();

        Iterator it = connection.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();

            sbs.append("<tr>\n<td>");
            sbs.append(pair.getValue());
            sbs.append("</td>\n<td>");
            sbs.append("http://localhost:8080/api/short/" + pair.getKey() + "</td>\n</tr>\n");

           // it.remove(); // avoids a ConcurrentModificationException
        }



        /*for (int i = 0; i < amount; i++) {
            sbs.append("<tr>\n<td>");
            sbs.append(longURLArray[i]);
            sbs.append("</td>\n<td>");
            sbs.append("http://localhost:8080/api/short/" + aliasArray[i] + "</td>\n</tr>\n");
        }*/

        String st = sbs.toString();
        System.out.println("Table sent");
        return st;
    }

    /**
     * Search alias int.
     *
     * @param alias the alias
     * @return the int
     */
    public static int searchAlias(String alias) {
        boolean found = false;
        int i = 0;
        while (!found) {
            if (aliasArray[i].equals(alias)) {
                found = true;
            } else {
                i += 1;
            }
        }
        return i;
    }

    /**
     * Gen alias string.
     *
     * @return the string
     */
    public static String genAlias() {
        // Generates a 4 digit alias consisting of letters and numbers
        String alias = "";
        String AlphaNumericString = "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        for (int i = 0; i < 4; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            alias += AlphaNumericString.charAt(index);
        }

        for (int j = 0; j < aliasArray.length; j++) {
            if (alias.equals(aliasArray[j])) {
                System.out.print("alias exists already");
                genAlias();
            }
        }
        return alias;
    }

}