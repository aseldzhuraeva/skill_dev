package skill_dev.models.entities;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;


public class CurrentUser extends User {
    private skill_dev.models.entities.User user;

    public CurrentUser(skill_dev.models.entities.User user){
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Long getId(){
        return user.getId();
    }

    public String getUsername(){
        return user.getUsername();
    }

    public skill_dev.models.entities.User getUser(){
        return user;
    }
}
