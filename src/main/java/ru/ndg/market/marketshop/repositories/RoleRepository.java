package ru.ndg.market.marketshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.ndg.market.marketshop.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByTitle(String title);
}
