package com.example.test2.Auth;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser>selectApplicationUserEmail(String email);
}
