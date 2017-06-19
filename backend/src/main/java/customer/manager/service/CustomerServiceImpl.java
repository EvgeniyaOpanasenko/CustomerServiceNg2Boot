package customer.manager.service;

import customer.manager.model.Customer;
import customer.manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public void create(Customer customer) {
        repository.save(customer);
    }

    @Override
    public Customer getIteById(long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer getByName(String name) {
        return getAllCustomer().stream()
                .filter(c -> c.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {

        if (!repository.exists(customer.getId())) {
            throw new NoSuchElementException("Customer not found exception");
        } else {
            Customer result = repository.getOne(customer.getId());
            result.setName(customer.getName());
            result.setPhone(customer.getPhone());
            result.setAddress(customer.getPhone());
            result.setId(customer.getId());
            repository.save(result);
        }
        return customer;
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
