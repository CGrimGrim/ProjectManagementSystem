/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwp.resource.management.objects;

/**
 *
 * @author 10071639
 */
public class User {
    private int userID;
    private String username;
    private String password;
    private boolean[] permissions = new boolean[3];
    
    public User(int userID, String uname, String pword, boolean read, boolean update, boolean write){
        this.userID = userID;
        username = uname;
        password = pword;
        permissions[0] = read;
        permissions[1] = update;
        permissions[2] = write;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the permissions
     */
    public boolean[] getPermissions() {
        return permissions;
    }

    /**
     * @param permissions the permissions to set
     */
    public void setPermissions(boolean[] permissions) {
        this.permissions = permissions;
    }
    
    
    
}
