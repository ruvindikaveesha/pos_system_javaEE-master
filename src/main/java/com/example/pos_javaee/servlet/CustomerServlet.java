package com.example.pos_javaee.servlet;

import com.example.pos_javaee.dto.CustomerDto;
import com.example.pos_javaee.service.ServiceFactory;
import com.example.pos_javaee.service.custom.CustomerService;
import com.example.pos_javaee.service.util.ServiceTypes;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/customer-manager")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService;
    private Jsonb jsonb;

    @Override
    public void init() throws ServletException {
        customerService = ServiceFactory.getInstance().getService(ServiceTypes.CUSTOMER_SERVICE);
        jsonb = JsonbBuilder.create();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do-get");
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {
            try {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(req.getParameter("id"));
                CustomerDto view = customerService.view(customerDto);
                if (view != null) {
                    System.out.println("Customer exists");
                    String json = JsonbBuilder.create().toJson(view);  // Convert the customerDto to JSON using JSON-B (Yasson)
                    resp.setContentType("application/json");
                    PrintWriter writer = resp.getWriter();
                    writer.print(json);
                    writer.flush();
                    writer.close();
                } else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Customer is not exists");
                }
            } catch (RuntimeException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do-post");
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {
            try {
                CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);

                boolean save = customerService.save(customerDto);
                if (save) {
                    resp.setStatus(HttpServletResponse.SC_OK);
                    System.out.println("Data saved successfully.");
                } else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to save data.");
                }
            } catch (RuntimeException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do-put");
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {
            try {
                CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);

                boolean update = customerService.update(customerDto);
                if (update) {
                    resp.setStatus(HttpServletResponse.SC_OK);
                    System.out.println("Data updated successfully.");
                } else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update data.");
                }
            } catch (RuntimeException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do-delete");
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {
            try {
                CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);
                boolean delete = customerService.delete(customerDto);
                if (delete) {
                    resp.setStatus(HttpServletResponse.SC_OK); // 200 status code for success
                    System.out.println("Data deleted successfully.");
                } else {
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete data.");
                }
            } catch (RuntimeException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            }
        }
    }

}
