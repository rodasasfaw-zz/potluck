package com.example.demo.security;

import com.example.demo.Model.AppUser;
import com.example.demo.Model.PledgedItem;
import com.example.demo.Model.Role;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRoleName("ADMIN");
        Role userRole = roleRepository.findByRoleName("USER");


        AppUser user1 = new AppUser("rod","pass");
        user1.setRoles(Arrays.asList(userRole));
        appUserRepository.save(user1);

        AppUser user2 = new AppUser("ephi", "pass");
        user2.setRoles(Arrays.asList(userRole));
        appUserRepository.save(user2);


        AppUser user3 = new AppUser("sol", "pass" );
        user3.setRoles(Arrays.asList(adminRole));
        appUserRepository.save(user3);

        PledgedItem item = new PledgedItem("piza", "food", 3);
        itemRepository.save(item);
        PledgedItem item2 = new PledgedItem("pie", "dessert", 4);
        itemRepository.save(item2);
        PledgedItem item3 = new PledgedItem("coke", "drink", 5);
        itemRepository.save(item3);






    }

}
