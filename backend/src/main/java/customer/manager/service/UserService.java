package customer.manager.service;

import customer.manager.model.User;

public interface UserService {
    void create(User user);
    User getByName(String name);
}
