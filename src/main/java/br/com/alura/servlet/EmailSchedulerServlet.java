package br.com.alura.servlet;

import br.com.alura.entity.EmailScheduling;
import br.com.alura.service.EmailSchedulerService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("emails")
public class EmailSchedulerServlet extends HttpServlet {

  @Inject
  EmailSchedulerService service;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try (final PrintWriter writer = resp.getWriter()) {
      service.list().forEach(result -> writer.println("Os emails disponíveis são: " + result.getEmail()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    try (final BufferedReader reader = req.getReader()) {
      final String[] email = reader.readLine().split(",");
      EmailScheduling scheduling = new EmailScheduling();
      scheduling.setEmail(email[0]);
      scheduling.setSubject(email[1]);
      scheduling.setMessage(email[2]);
      service.add(scheduling);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
