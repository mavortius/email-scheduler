package br.com.alura.mdb;

import br.com.alura.EmailSchedulerException;
import br.com.alura.entity.EmailScheduling;
import br.com.alura.service.EmailSchedulerService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/EmailMQ"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class EmailSchedulingMDB implements MessageListener {

  @Inject
  EmailSchedulerService schedulerService;

  @Override
  public void onMessage(Message message) {
    try {
      final EmailScheduling body = message.getBody(EmailScheduling.class);
      schedulerService.send(body);
    } catch (JMSException e) {
      e.printStackTrace();
      throw new EmailSchedulerException(e.getMessage(), e);
    }
  }
}
