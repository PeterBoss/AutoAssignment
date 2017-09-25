/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PeterBoss
 */
@Entity
@Table(name = "solution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solution.findAll", query = "SELECT s FROM Solution s"),
    @NamedQuery(name = "Solution.findByUserId", query = "SELECT s FROM Solution s WHERE s.solutionPK.userId = :userId"),
    @NamedQuery(name = "Solution.findByAssignmentId", query = "SELECT s FROM Solution s WHERE s.solutionPK.assignmentId = :assignmentId"),
    @NamedQuery(name = "Solution.findByTimeSpent", query = "SELECT s FROM Solution s WHERE s.timeSpent = :timeSpent"),
    @NamedQuery(name = "Solution.findByNumberOfErrors", query = "SELECT s FROM Solution s WHERE s.numberOfErrors = :numberOfErrors"),
    @NamedQuery(name = "Solution.findByRating", query = "SELECT s FROM Solution s WHERE s.rating = :rating")})
public class Solution implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolutionPK solutionPK;
    @Column(name = "\"time spent\"")
    @Temporal(TemporalType.TIME)
    private Date timeSpent;
    @Column(name = "\"number of errors\"")
    private Integer numberOfErrors;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "\"rating\"")
    private BigDecimal rating;
    @JoinColumn(name = "\"assignment id\"", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Assignment assignment;
    @JoinColumn(name = "\"user id\"", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Solution() {
    }

    public Solution(SolutionPK solutionPK) {
        this.solutionPK = solutionPK;
    }

    public Solution(int userId, int assignmentId) {
        this.solutionPK = new SolutionPK(userId, assignmentId);
    }

    public SolutionPK getSolutionPK() {
        return solutionPK;
    }

    public void setSolutionPK(SolutionPK solutionPK) {
        this.solutionPK = solutionPK;
    }

    public Date getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Date timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Integer getNumberOfErrors() {
        return numberOfErrors;
    }

    public void setNumberOfErrors(Integer numberOfErrors) {
        this.numberOfErrors = numberOfErrors;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solutionPK != null ? solutionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solution)) {
            return false;
        }
        Solution other = (Solution) object;
        if ((this.solutionPK == null && other.solutionPK != null) || (this.solutionPK != null && !this.solutionPK.equals(other.solutionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Solution[ solutionPK=" + solutionPK + " ]";
    }
    
}
