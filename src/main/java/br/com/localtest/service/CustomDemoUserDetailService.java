package br.com.localtest.service;

import br.com.localtest.model.DemoUser;
import br.com.localtest.repository.DemoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomDemoUserDetailService implements UserDetailsService {
    private final DemoUserRepository demoUserRepository;

    @Autowired
    public CustomDemoUserDetailService(DemoUserRepository demoUserRepository) {
        this.demoUserRepository = demoUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        DemoUser demoUser = Optional.ofNullable(demoUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new User(demoUser.getUsername(),
                demoUser.getPassword(),
                demoUser.isAdmin() ? authorityListAdmin : authorityListUser);
    }
}
