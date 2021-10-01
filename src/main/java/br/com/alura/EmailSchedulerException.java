package br.com.alura;

public class EmailSchedulerException extends RuntimeException {
  public EmailSchedulerException(String message) {
    super(message);
  }

  public EmailSchedulerException(String message, Throwable cause) {
    super(message, cause);
  }
}
