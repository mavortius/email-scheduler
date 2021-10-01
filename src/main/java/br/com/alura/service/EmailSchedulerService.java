package br.com.alura.service;

import br.com.alura.dao.EmailSchedulingDao;
import br.com.alura.entity.EmailScheduling;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class EmailSchedulerService {
  private static final Logger LOGGER = Logger.getLogger(EmailSchedulerService.class.getName());

  @Inject
  EmailSchedulingDao dao;

  public List<EmailScheduling> list() {
    return dao.list();
  }

  public List<EmailScheduling> listUnscheduled() {
    return dao.listUnscheduled();
  }

  public void add(EmailScheduling scheduling) {
    scheduling.setScheduled(false);
    dao.add(scheduling);
  }

  public void schedule(EmailScheduling scheduling) {
    scheduling.setScheduled(true);
    dao.update(scheduling);
  }

  public void send(EmailScheduling scheduling) {
    try {
      Thread.sleep(5000);
      LOGGER.info("Email of user " + scheduling.getEmail() + " was sent.");
    } catch (InterruptedException e) {
      LOGGER.log(Level.SEVERE, "Error trying send email: {0}", e.getMessage());
      Thread.currentThread().interrupt();
    }
  }
}
