package br.edu.ifms.frame1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.edu.ifms.frame1.model.User;

@Repository
public class UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    //SELECT * FROM TB_USER
    public List<User> findAll() {
        var users = new ArrayList<User>();
        users.add(new User(UUID.randomUUID(), "Mauricio", "sir.Mau@gmail.com"));
        users.add(new User(UUID.randomUUID(), "Galadriel", "sir.Gal@gmail.com"));
        users.add(new User(UUID.randomUUID(), "Elrond", "sir.Elr@gmail.com"));
        users.add(new User(UUID.randomUUID(), "Gil-Galad", "sir.Gil@gmail.com"));
        logger.info("Listing the Users!");

        return users;
    }   
}
