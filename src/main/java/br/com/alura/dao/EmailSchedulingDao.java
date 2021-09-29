package br.com.alura.dao;

import br.com.alura.entity.EmailScheduling;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmailSchedulingDao {

  @PersistenceContext
  EntityManager entityManager;

  public List<EmailScheduling> list() {
    return entityManager.createQuery("select es from EmailScheduling es", EmailScheduling.class).getResultList();
  }

  public void add(EmailScheduling scheduling) {
    entityManager.persist(scheduling);
  }
}
