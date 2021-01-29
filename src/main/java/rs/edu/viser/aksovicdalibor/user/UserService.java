package rs.edu.viser.aksovicdalibor.user;


import org.springframework.stereotype.Service;


@Service
public interface UserService {
    void save(User user);
    void login(String username, String password);
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);
}
