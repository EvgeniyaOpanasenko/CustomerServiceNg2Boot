package customer.manager.controller;

import customer.manager.model.Customer;
import customer.manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomerById(@RequestParam("id") String id) {
        Customer Customer = customerService.getIteById(Integer.parseInt(id));
        return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
    }

    @GetMapping("/all-customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> list = (List<Customer>) customerService.getAllCustomer();
        return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer,
                                               UriComponentsBuilder builder) {
        boolean flag = customerService.create(customer);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/Customer?id={id}")
                .buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @DeleteMapping("customer")
    public ResponseEntity<Void> deleteCustomer(@RequestParam("id") String id) {
        customerService.delete(Long.parseLong(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
