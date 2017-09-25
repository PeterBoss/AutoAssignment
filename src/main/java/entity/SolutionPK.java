/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author PeterBoss
 */
@Embeddable
public class SolutionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "user id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "assignment id")
    private int assignmentId;

    public SolutionPK() {
    }

    public SolutionPK(int userId, int assignmentId) {
        this.userId = userId;
        this.assignmentId = assignmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) assignmentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolutionPK)) {
            return false;
        }
        SolutionPK other = (SolutionPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.assignmentId != other.assignmentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SolutionPK[ userId=" + userId + ", assignmentId=" + assignmentId + " ]";
    }
    
}
