/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ismael Moreno
 */
@Entity
@Table(name = "productos_vendidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosVendidos.findAll", query = "SELECT p FROM ProductosVendidos p")
    , @NamedQuery(name = "ProductosVendidos.findByIdProductoVendido", query = "SELECT p FROM ProductosVendidos p WHERE p.idProductoVendido = :idProductoVendido")
    , @NamedQuery(name = "ProductosVendidos.findByCantidad", query = "SELECT p FROM ProductosVendidos p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProductosVendidos.findByPrecioVenta", query = "SELECT p FROM ProductosVendidos p WHERE p.precioVenta = :precioVenta")
    , @NamedQuery(name = "ProductosVendidos.findByCategoria", query = "SELECT p FROM ProductosVendidos p WHERE p.categoria = :categoria")})
public class ProductosVendidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProductoVendido")
    private Integer idProductoVendido;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioVenta")
    private Float precioVenta;
    @Column(name = "categoria")
    private String categoria;
    @JoinColumn(name = "codigoProducto", referencedColumnName = "codigo")
    @ManyToOne
    private Producto codigoProducto;

    public ProductosVendidos() {
    }

    public ProductosVendidos(Integer idProductoVendido) {
        this.idProductoVendido = idProductoVendido;
    }

    public Integer getIdProductoVendido() {
        return idProductoVendido;
    }

    public void setIdProductoVendido(Integer idProductoVendido) {
        this.idProductoVendido = idProductoVendido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Producto getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Producto codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductoVendido != null ? idProductoVendido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosVendidos)) {
            return false;
        }
        ProductosVendidos other = (ProductosVendidos) object;
        if ((this.idProductoVendido == null && other.idProductoVendido != null) || (this.idProductoVendido != null && !this.idProductoVendido.equals(other.idProductoVendido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProductosVendidos[ idProductoVendido=" + idProductoVendido + " ]";
    }
    
}
