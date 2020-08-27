package it.si2001.testlogin.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserCredential {

    @NotNull(message="{user.email.notNull}")
    private String email;

    @NotNull(message = "{user.password.notNull}")
    @Size(min = 1, max = 16, message = "{user.password.size}")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
