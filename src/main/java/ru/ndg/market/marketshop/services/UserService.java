package ru.ndg.market.marketshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ndg.market.marketshop.model.Role;
import ru.ndg.market.marketshop.model.User;
import ru.ndg.market.marketshop.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleService roleService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public List<User> findAlluser() {
        return userRepository.findAll();
    }

    public User getuserById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.orElseGet(User::new);
    }

    public void updateUser(User user) {
        String titleRole = user.getRole().getTitle();
        Role role = roleService.findRoleByTitle(titleRole);
        user.setRole(role);
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void addUser(User user, Role role) {
        String titleRole = role.getTitle();
        Role findRole = roleService.findRoleByTitle(titleRole);
        user.setRole(findRole);
        userRepository.save(user);
    }
}
