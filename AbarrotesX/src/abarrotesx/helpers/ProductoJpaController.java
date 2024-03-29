/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abarrotesx.helpers;

import abarrotesx.helpers.exceptions.NonexistentEntityException;
import abarrotesx.helpers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Venta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Producto;
import modelo.ProductosVendidos;

/**
 *
 * @author Ismael Moreno
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ProductoJpaController(){
        this.emf = Persistence.createEntityManagerFactory("AbarrotesXPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) throws PreexistingEntityException, Exception {
        if (producto.getVentaCollection() == null) {
            producto.setVentaCollection(new ArrayList<Venta>());
        }
        if (producto.getProductosVendidosCollection() == null) {
            producto.setProductosVendidosCollection(new ArrayList<ProductosVendidos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Venta> attachedVentaCollection = new ArrayList<Venta>();
            for (Venta ventaCollectionVentaToAttach : producto.getVentaCollection()) {
                ventaCollectionVentaToAttach = em.getReference(ventaCollectionVentaToAttach.getClass(), ventaCollectionVentaToAttach.getIdVenta());
                attachedVentaCollection.add(ventaCollectionVentaToAttach);
            }
            producto.setVentaCollection(attachedVentaCollection);
            Collection<ProductosVendidos> attachedProductosVendidosCollection = new ArrayList<ProductosVendidos>();
            for (ProductosVendidos productosVendidosCollectionProductosVendidosToAttach : producto.getProductosVendidosCollection()) {
                productosVendidosCollectionProductosVendidosToAttach = em.getReference(productosVendidosCollectionProductosVendidosToAttach.getClass(), productosVendidosCollectionProductosVendidosToAttach.getIdProductoVendido());
                attachedProductosVendidosCollection.add(productosVendidosCollectionProductosVendidosToAttach);
            }
            producto.setProductosVendidosCollection(attachedProductosVendidosCollection);
            em.persist(producto);
            for (Venta ventaCollectionVenta : producto.getVentaCollection()) {
                Producto oldCodigoProductoOfVentaCollectionVenta = ventaCollectionVenta.getCodigoProducto();
                ventaCollectionVenta.setCodigoProducto(producto);
                ventaCollectionVenta = em.merge(ventaCollectionVenta);
                if (oldCodigoProductoOfVentaCollectionVenta != null) {
                    oldCodigoProductoOfVentaCollectionVenta.getVentaCollection().remove(ventaCollectionVenta);
                    oldCodigoProductoOfVentaCollectionVenta = em.merge(oldCodigoProductoOfVentaCollectionVenta);
                }
            }
            for (ProductosVendidos productosVendidosCollectionProductosVendidos : producto.getProductosVendidosCollection()) {
                Producto oldCodigoProductoOfProductosVendidosCollectionProductosVendidos = productosVendidosCollectionProductosVendidos.getCodigoProducto();
                productosVendidosCollectionProductosVendidos.setCodigoProducto(producto);
                productosVendidosCollectionProductosVendidos = em.merge(productosVendidosCollectionProductosVendidos);
                if (oldCodigoProductoOfProductosVendidosCollectionProductosVendidos != null) {
                    oldCodigoProductoOfProductosVendidosCollectionProductosVendidos.getProductosVendidosCollection().remove(productosVendidosCollectionProductosVendidos);
                    oldCodigoProductoOfProductosVendidosCollectionProductosVendidos = em.merge(oldCodigoProductoOfProductosVendidosCollectionProductosVendidos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducto(producto.getCodigo()) != null) {
                throw new PreexistingEntityException("Producto " + producto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getCodigo());
            Collection<Venta> ventaCollectionOld = persistentProducto.getVentaCollection();
            Collection<Venta> ventaCollectionNew = producto.getVentaCollection();
            Collection<ProductosVendidos> productosVendidosCollectionOld = persistentProducto.getProductosVendidosCollection();
            Collection<ProductosVendidos> productosVendidosCollectionNew = producto.getProductosVendidosCollection();
            Collection<Venta> attachedVentaCollectionNew = new ArrayList<Venta>();
            for (Venta ventaCollectionNewVentaToAttach : ventaCollectionNew) {
                ventaCollectionNewVentaToAttach = em.getReference(ventaCollectionNewVentaToAttach.getClass(), ventaCollectionNewVentaToAttach.getIdVenta());
                attachedVentaCollectionNew.add(ventaCollectionNewVentaToAttach);
            }
            ventaCollectionNew = attachedVentaCollectionNew;
            producto.setVentaCollection(ventaCollectionNew);
            Collection<ProductosVendidos> attachedProductosVendidosCollectionNew = new ArrayList<ProductosVendidos>();
            for (ProductosVendidos productosVendidosCollectionNewProductosVendidosToAttach : productosVendidosCollectionNew) {
                productosVendidosCollectionNewProductosVendidosToAttach = em.getReference(productosVendidosCollectionNewProductosVendidosToAttach.getClass(), productosVendidosCollectionNewProductosVendidosToAttach.getIdProductoVendido());
                attachedProductosVendidosCollectionNew.add(productosVendidosCollectionNewProductosVendidosToAttach);
            }
            productosVendidosCollectionNew = attachedProductosVendidosCollectionNew;
            producto.setProductosVendidosCollection(productosVendidosCollectionNew);
            producto = em.merge(producto);
            for (Venta ventaCollectionOldVenta : ventaCollectionOld) {
                if (!ventaCollectionNew.contains(ventaCollectionOldVenta)) {
                    ventaCollectionOldVenta.setCodigoProducto(null);
                    ventaCollectionOldVenta = em.merge(ventaCollectionOldVenta);
                }
            }
            for (Venta ventaCollectionNewVenta : ventaCollectionNew) {
                if (!ventaCollectionOld.contains(ventaCollectionNewVenta)) {
                    Producto oldCodigoProductoOfVentaCollectionNewVenta = ventaCollectionNewVenta.getCodigoProducto();
                    ventaCollectionNewVenta.setCodigoProducto(producto);
                    ventaCollectionNewVenta = em.merge(ventaCollectionNewVenta);
                    if (oldCodigoProductoOfVentaCollectionNewVenta != null && !oldCodigoProductoOfVentaCollectionNewVenta.equals(producto)) {
                        oldCodigoProductoOfVentaCollectionNewVenta.getVentaCollection().remove(ventaCollectionNewVenta);
                        oldCodigoProductoOfVentaCollectionNewVenta = em.merge(oldCodigoProductoOfVentaCollectionNewVenta);
                    }
                }
            }
            for (ProductosVendidos productosVendidosCollectionOldProductosVendidos : productosVendidosCollectionOld) {
                if (!productosVendidosCollectionNew.contains(productosVendidosCollectionOldProductosVendidos)) {
                    productosVendidosCollectionOldProductosVendidos.setCodigoProducto(null);
                    productosVendidosCollectionOldProductosVendidos = em.merge(productosVendidosCollectionOldProductosVendidos);
                }
            }
            for (ProductosVendidos productosVendidosCollectionNewProductosVendidos : productosVendidosCollectionNew) {
                if (!productosVendidosCollectionOld.contains(productosVendidosCollectionNewProductosVendidos)) {
                    Producto oldCodigoProductoOfProductosVendidosCollectionNewProductosVendidos = productosVendidosCollectionNewProductosVendidos.getCodigoProducto();
                    productosVendidosCollectionNewProductosVendidos.setCodigoProducto(producto);
                    productosVendidosCollectionNewProductosVendidos = em.merge(productosVendidosCollectionNewProductosVendidos);
                    if (oldCodigoProductoOfProductosVendidosCollectionNewProductosVendidos != null && !oldCodigoProductoOfProductosVendidosCollectionNewProductosVendidos.equals(producto)) {
                        oldCodigoProductoOfProductosVendidosCollectionNewProductosVendidos.getProductosVendidosCollection().remove(productosVendidosCollectionNewProductosVendidos);
                        oldCodigoProductoOfProductosVendidosCollectionNewProductosVendidos = em.merge(oldCodigoProductoOfProductosVendidosCollectionNewProductosVendidos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = producto.getCodigo();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            Collection<Venta> ventaCollection = producto.getVentaCollection();
            for (Venta ventaCollectionVenta : ventaCollection) {
                ventaCollectionVenta.setCodigoProducto(null);
                ventaCollectionVenta = em.merge(ventaCollectionVenta);
            }
            Collection<ProductosVendidos> productosVendidosCollection = producto.getProductosVendidosCollection();
            for (ProductosVendidos productosVendidosCollectionProductosVendidos : productosVendidosCollection) {
                productosVendidosCollectionProductosVendidos.setCodigoProducto(null);
                productosVendidosCollectionProductosVendidos = em.merge(productosVendidosCollectionProductosVendidos);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }
    

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
