package com.melardev.spring.shoppingcartweb;

import java.util.List;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.melardev.spring.shoppingcartweb.models.Role;
import com.melardev.spring.shoppingcartweb.models.User;
import com.melardev.spring.shoppingcartweb.repository.RolesRepository;
import com.melardev.spring.shoppingcartweb.repository.UsersRepository;


//@Component
public class ShoppDepart implements CommandLineRunner {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired 
    private UsersRepository uRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public void run(String... args) {

        Role r = new Role();
        r.setName("ADMIN_AND_USER");

        Role r1 = new Role();
        r1.setName("USER");

        Role r2 = new Role();
        r.setName("ROLE_ADMIN");

        Role r3 = new Role();
        r1.setName("ROLE_USER");

       rolesRepository.save(r);
       rolesRepository.save(r1);
       rolesRepository.save(r2);
       rolesRepository.save(r3);
        List<Role> roles  = (List<Role>) rolesRepository.findAll();
        

      

        User user = new User("ayoub1", "smayen22", "ayoubsmayen@gmail.com",
        "auyubsmayen", passwordEncoder.encode("password"), roles);

        
       
        
        uRepository.save(user);
     


    }
    
}
