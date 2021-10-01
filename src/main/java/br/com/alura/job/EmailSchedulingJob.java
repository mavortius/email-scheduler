package br.com.alura.job;

import br.com.alura.service.EmailSchedulerService;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.logging.Logger;

@Singleton
public class EmailSchedulingJob {
  private static final Logger LOGGER = Logger.getLogger(EmailSchedulingJob.class.getName());

  @Inject
  EmailSchedulerService service;

  @Schedule(hour = "*", minute = "*", second = "*/10")
  public void sendEmail() {
    LOGGER.info("Verifying scheduling...");
    service.listUnscheduled().forEach(email -> {
      service.send(email);
      service.schedule(email);
    });
  }
}
