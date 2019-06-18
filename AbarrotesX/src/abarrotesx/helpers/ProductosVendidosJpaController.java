/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesx.helpers;

import abarrotesx.helpers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Producto;
import modelo.ProductosVendidos;

/**
 *
 * @author Ismael Moreno
 */
public class ProductosVendidosJpaController implements Serializable {

    public ProductosVendidosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ProductosVendidosJpaController(){
        this.emf = Persistence.createEntityManagerFactory("AbarrotesXPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductosVendidos productosVendidos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto codigoProducto = productosVendidos.getCodigoProducto();
            if (codigoProducto != null) {
                codigoProducto = em.getReference(codigoProducto.getClass(), codigoProducto.getCodigo());
                productosVendidos.setCodigoProducto(codigoProducto);
            }
            em.persist(productosVendidos);
            if (codigoProducto != null) {
                codigoProducto.getProductosVendidosCollection().add(productosVendidos);
                codigoProducto = em.merge(codigoProducto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductosVendidos productosVendidos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductosVendidos persistentProductosVendidos = em.find(ProductosVendidos.class, productosVendidos.getIdProductoVendido());
            Producto codigoProductoOld = persistentProductosVendidos.getCodigoProducto();
            Producto codigoProductoNew = productosVendidos.getCodigoProducto();
            if (codigoProductoNew != null) {
                codigoProductoNew = em.getReference(codigoProductoNew.getClass(), codigoProductoNew.getCodigo());
                productosVendidos.setCodigoProducto(codigoProductoNew);
            }
            productosVendidos = em.merge(productosVendidos);
            if (codigoProductoOld != null && !codigoProductoOld.equals(codigoProductoNew)) {
                codigoProductoOld.getProductosVendidosCollection().remove(productosVendidos);
                codigoProductoOld = em.merge(codigoProductoOld);
            }
            if (codigoProductoNew != null && !codigoProductoNew.equals(codigoProductoOld)) {
                codigoProductoNew.getProductosVendidosCollection().add(productosVendidos);
                codigoProductoNew = em.merge(codigoProductoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productosVendidos.getIdProductoVendido();
                if (findProductosVendidos(id) == null) {
                    throw new NonexistentEntityException("The productosVendidos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductosVendidos productosVendidos;
            try {
                productosVendidos = em.getReference(ProductosVendidos.class, id);
                productosVendidos.getIdProductoVendido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productosVendidos with id " + id + " no longer exists.", enfe);
            }
            Producto codigoProducto = productosVendidos.getCodigoProducto();
            if (codigoProducto != null) {
                codigoProducto.getProductosVendidosCollection().remove(productosVendidos);
                codigoProducto = em.merge(codigoProducto);
            }
            em.remove(productosVendidos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductosVendidos> findProductosVendidosEntities() {
        return findProductosVendidosEntities(true, -1, -1);
    }

    public List<ProductosVendidos> findProductosVendidosEntities(int maxResults, int firstResult) {
        return findProductosVendidosEntities(false, maxResults, firstResult);
    }

    private List<ProductosVendidos> findProductosVendidosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductosVendidos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ProductosVendidos findProductosVendidos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductosVendidos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductosVendidosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductosVendidos> rt = cq.from(ProductosVendidos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
