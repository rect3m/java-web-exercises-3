package com.bobocode.web.controller;

import com.bobocode.dao.AccountDao;
import com.bobocode.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that handles requests related to accounts.
 */
@RestController
@RequestMapping("/accounts")
public class AccountRestController {

    private final AccountDao accountDao;

    @Autowired
    public AccountRestController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    // 3. Handles GET request to fetch all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }

    // 4. Handles GET request to fetch account by id
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable long id) {
        return accountDao.findById(id);
    }

    // 5. Handles POST request to save a new account and returns it, status 201 - CREATED
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return accountDao.save(account);
    }

    // 6. Handles PUT request to update account, status 204 - NO CONTENT
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@PathVariable long id, @RequestBody Account account) {
        if (account.getId() != null && !account.getId().equals(id)) {
            throw new IllegalStateException("Account ID in the path and request body do not match");
        }
        account.setId(id); // Set the correct ID to ensure update
        accountDao.save(account);
    }

    // 7. Handles DELETE request to remove an account by id, status 204 - NO CONTENT
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable long id) {
        Account account = accountDao.findById(id);
        accountDao.remove(account);
    }
}
