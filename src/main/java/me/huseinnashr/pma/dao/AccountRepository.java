package me.huseinnashr.pma.dao;

import org.springframework.data.repository.CrudRepository;

import me.huseinnashr.pma.entities.UserAccount;

public interface AccountRepository extends CrudRepository<UserAccount, Long> {

}