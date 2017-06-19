package customer.manager.service;

import customer.manager.model.User;
import customer.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public boolean create(User user) {
        User result = getByName(user.getName());
        if (!repository.exists(result.getId())) {
            repository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User getByName(String name) {
        return repository.findAll().stream()
                .filter(user -> user.getName()
                        .equals(name)).findFirst().get();
    }
}
