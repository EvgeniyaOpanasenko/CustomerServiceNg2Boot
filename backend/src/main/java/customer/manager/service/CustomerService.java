package customer.manager.service;


import customer.manager.model.Customer;

import java.util.List;

public interface CustomerService {
    void create(Customer customer);
    Customer getIteById(long id);
    Customer getByName(String name);
    List<Customer> getAllCustomer();
    Customer updateCustomer(Customer customer);
    void delete(long id);
}
