/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preksha.moviescrud.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Preksha
 */
@Entity
@Table(name = "ASSIGNMENT_MOVIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssignmentMovie.findAll", query = "SELECT a FROM AssignmentMovie a"),
    @NamedQuery(name = "AssignmentMovie.findById", query = "SELECT a FROM AssignmentMovie a WHERE a.id = :id"),
    @NamedQuery(name = "AssignmentMovie.findByTitle", query = "SELECT a FROM AssignmentMovie a WHERE a.title = :title"),
    @NamedQuery(name = "AssignmentMovie.findByDirector", query = "SELECT a FROM AssignmentMovie a WHERE a.director = :director"),
    @NamedQuery(name = "AssignmentMovie.findByCategory", query = "SELECT a FROM AssignmentMovie a WHERE a.category = :category")})
public class AssignmentMovie implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 200)
    @Column(name = "DIRECTOR")
    private String director;
    @Size(max = 200)
    @Column(name = "CATEGORY")
    private String category;
    @Lob
    @Column(name = "POSTER")
    private byte[] poster;

    public AssignmentMovie() {
    }

    public AssignmentMovie(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssignmentMovie)) {
            return false;
        }
        AssignmentMovie other = (AssignmentMovie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "preksha.moviescrud.entities.AssignmentMovie[ id=" + id + " ]";
    }
    
}
