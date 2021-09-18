package ua.leshik.financexxl.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.leshik.financexxl.model.Role;
import ua.leshik.financexxl.model.User;

import javax.persistence.Id;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class CustomUserDetails implements UserDetails {

    private Integer id;
    private String login;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public CustomUserDetails(Integer id,String login, String password, Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static CustomUserDetails fromUserToCustomUserDetails(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().toString()))
                .collect(Collectors.toList());

        return new CustomUserDetails(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                authorities);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return  true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUserDetails that = (CustomUserDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, grantedAuthorities);
    }
}
