package br.com.alura.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="email_scheduling")
public class EmailScheduling implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private String subject;
  private String message;
  private Boolean scheduled;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Boolean getScheduled() {
    return scheduled;
  }

  public void setScheduled(Boolean scheduled) {
    this.scheduled = scheduled;
  }

  @Override
  public String toString() {
    return "EmailScheduling{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", subject='" + subject + '\'' +
            ", message='" + message + '\'' +
            ", scheduled=" + scheduled +
            '}';
  }
}
