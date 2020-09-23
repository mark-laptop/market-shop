package ru.ndg.market.marketshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ndg.market.marketshop.model.Role;
import ru.ndg.market.marketshop.repositories.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByTitle(String title) {
        return roleRepository.findByTitle(title);
    }
}
