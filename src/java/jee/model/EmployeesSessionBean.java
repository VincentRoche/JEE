/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.model;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jacques
 */
@Stateless
public class EmployeesSessionBean {

    @PersistenceContext(unitName = "Practice4_JPAPU")
    private EntityManager em;

    public Collection<Employees> getEmployees() {
        Query q = em.createQuery("SELECT e FROM Employees e");
        return q.getResultList();

    }

    public Collection<Credentials> getUsers() {
        Query q = em.createQuery("SELECT c FROM Credentials c");
        return q.getResultList();

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
