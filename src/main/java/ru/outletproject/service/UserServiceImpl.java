package ru.outletproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.outletproject.LoggedUser;
import ru.outletproject.model.User;
import ru.outletproject.repository.datajpa.DataJpaUserRepositoryImpl;
import ru.outletproject.to.UserTo;
import ru.outletproject.util.exception.ExceptionUtil;
import ru.outletproject.util.exception.NotFoundException;

import java.util.List;
import java.util.Objects;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private DataJpaUserRepositoryImpl repository;

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public User save(User user) {
        Objects.requireNonNull(user);
        return repository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id),id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Objects.requireNonNull(email, "Email must not be empty");
        return ExceptionUtil.check(repository.getByEmail(email), email);
    }

    @Cacheable("users")
    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void update(User user) {
        Objects.requireNonNull(user);
        repository.save(user);

    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void update(UserTo userTo) {
        Objects.requireNonNull(userTo);
        User newUser = get(userTo.getId());
        repository.save(newUser);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void evictCache() {
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void enable(int id, boolean enable) {
        User user = get(id);
        user.setEnabled(enable);
        repository.save(user);
    }

    @Override
    public LoggedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = repository.getByEmail(email.toLowerCase());
        if (u == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new LoggedUser(u);
    }
}
