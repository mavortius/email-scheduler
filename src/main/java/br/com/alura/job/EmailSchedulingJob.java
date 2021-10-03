package br.com.alura.job;

import br.com.alura.service.EmailSchedulerService;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.logging.Logger;

@Singleton
public class EmailSchedulingJob {
  private static final Logger LOGGER = Logger.getLogger(EmailSchedulingJob.class.getName());

  @Inject
  EmailSchedulerService service;

  @Inject
  @JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
  JMSContext jmsContext;

  @Resource(mappedName = "java:/jms/queue/EmailMQ")
  Queue emailQueue;

  @Schedule(hour = "*", minute = "*", second = "*/10")
  public void sendEmail() {
    LOGGER.info("Verifying scheduling...");
    service.listUnscheduled().forEach(email -> {
      jmsContext.createProducer().send(emailQueue, email);
      service.schedule(email);
    });
  }
}
