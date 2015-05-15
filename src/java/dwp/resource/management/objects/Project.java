/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwp.resource.management.objects;

import java.time.LocalDate;

/**
 *
 * @author 10071639
 */
public class Project {
    
    private int projectID;
    private String name;
    private int totalHours;
    private String locationID;
    private String phase;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public Project(int projID, String name, int totalHours, String locationID, String phase, LocalDate startDate, LocalDate endDate){
        projectID = projID;
        this.name = name;
        this.totalHours = totalHours;
        this.locationID = locationID;
        this.phase = phase;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * @return the projectID
     */
    public int getProjectID() {
        return projectID;
    }

    /**
     * @param projectID the projectID to set
     */
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    /**
     * @return the projectName
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the projectName to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the projectTotalHours
     */
    public int getTotalHours() {
        return totalHours;
    }

    /**
     * @param totalHours the projectTotalHours to set
     */
    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    /**
     * @return the locationID
     */
    public String getLocationID() {
        return locationID;
    }

    /**
     * @param locationID the locationID to set
     */
    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    /**
     * @return the phase
     */
    public String getPhase() {
        return phase;
    }

    /**
     * @param phase the phase to set
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }

    public LocalDate getStartDate() {
       return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
