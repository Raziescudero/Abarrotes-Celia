/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ismael Moreno
 */
@Entity
@Table(name = "corte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corte.findAll", query = "SELECT c FROM Corte c")
    , @NamedQuery(name = "Corte.findByIdCorte", query = "SELECT c FROM Corte c WHERE c.idCorte = :idCorte")
    , @NamedQuery(name = "Corte.findByFechaCorte", query = "SELECT c FROM Corte c WHERE c.fechaCorte = :fechaCorte")
    , @NamedQuery(name = "Corte.findByTotal", query = "SELECT c FROM Corte c WHERE c.total = :total")})
public class Corte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCorte")
    private Integer idCorte;
    @Column(name = "fechaCorte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCorte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Float total;

    public Corte() {
    }

    public Corte(Integer idCorte) {
        this.idCorte = idCorte;
    }

    public Integer getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(Integer idCorte) {
        this.idCorte = idCorte;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorte != null ? idCorte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corte)) {
            return false;
        }
        Corte other = (Corte) object;
        if ((this.idCorte == null && other.idCorte != null) || (this.idCorte != null && !this.idCorte.equals(other.idCorte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Corte[ idCorte=" + idCorte + " ]";
    }
    
}
