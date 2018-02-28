package com.example.demo.security;

import com.example.demo.Model.AppUser;
import com.example.demo.Model.Role;
import com.example.demo.UserRepository;
import com.example.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {

    private AppUserRepository appUserRepository;

    public SSUserDetailsService(AppUserRepository userRepository){
        this.appUserRepository= userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            AppUser myUser = appUserRepository.findByUsername(username);
            if(myUser == null){
                return null;
            }
            return new org.springframework.security.core.userdetails.User(myUser.getUsername(), myUser.getPassword(), getAuthorities(myUser));
        } catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(AppUser appuser){
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role: appuser.getRoles()){
            GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(role.getRoleName());
            authorities.add(grantedAuthority);
        }
        return authorities;

    }

}
