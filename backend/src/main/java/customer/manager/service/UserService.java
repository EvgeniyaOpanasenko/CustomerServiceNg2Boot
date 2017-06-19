package customer.manager.service;

import customer.manager.model.User;

public interface UserService {
    boolean create(User user);
    User getByName(String name);
}
