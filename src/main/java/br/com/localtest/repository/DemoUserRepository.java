package br.com.localtest.repository;

import br.com.localtest.model.DemoUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DemoUserRepository extends PagingAndSortingRepository<DemoUser, Long> {
    DemoUser findByUsername(String username);
}
