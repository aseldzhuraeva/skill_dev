package skill_dev.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import skill_dev.models.entities.CurrentUser;
import skill_dev.models.entities.User;
import skill_dev.services.CurrentUserService;
import skill_dev.services.UserService;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService, CurrentUserService {
    private final UserService userService;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username).orElseThrow(() -> new IllegalArgumentException("there is not found user with that username"));
        return new CurrentUser(user);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken || authentication == null) {
            return null;
        }
        String currentPrincipalName = authentication.getName();
        return loadUserByUsername(currentPrincipalName).getUser();
    }
}
