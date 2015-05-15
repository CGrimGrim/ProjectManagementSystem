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
public class ProjectMember extends Employee {

    
    private double hoursCommitted;
    
    public ProjectMember(int employeeID, String fname, String lname, LocalDate startDat, LocalDate endDat, String contactNum, String contractType, double contractHours, double hoursCommitted) {
        super(employeeID, fname, lname, startDat, endDat, contactNum, contractType, contractHours);
        this.hoursCommitted = hoursCommitted;
    }

    /**
     * @return the hoursCommitted
     */
    public double getHoursCommitted() {
        return hoursCommitted;
    }

    /**
     * @param hoursCommitted the hoursCommitted to set
     */
    public void setHoursCommitted(double hoursCommitted) {
        this.hoursCommitted = hoursCommitted;
    }
    
    
    
}
