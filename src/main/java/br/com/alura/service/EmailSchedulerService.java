package br.com.alura.service;

import br.com.alura.dao.EmailSchedulingDao;
import br.com.alura.entity.EmailScheduling;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class EmailSchedulerService {

  @Inject
  EmailSchedulingDao dao;

  public List<EmailScheduling> list() {
    return dao.list();
  }

  public void add(EmailScheduling scheduling) {
    scheduling.setScheduled(false);
    dao.add(scheduling);
  }
}
