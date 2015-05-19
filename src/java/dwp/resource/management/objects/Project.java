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
    private double totalHours;
    private String locationName;
    private String phase;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public Project(int projID, String name, double totalHours, String locationID, String phase, LocalDate startDate, LocalDate endDate){
        projectID = projID;
        this.name = name;
        this.totalHours = totalHours;
        this.locationName = locationID;
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
    public double getTotalHours() {
        return totalHours;
    }

    /**
     * @param totalHours the projectTotalHours to set
     */
    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param LocationName the locationName to set
     */
    public void setLocationName(String LocationName) {
        this.locationName = LocationName;
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
