package pl.kubiak.studia.uz.auth.dtos;

import pl.kubiak.studia.uz.auth.models.User;

public class UserDTO {
    private Long clientId;
    private int expiry;
    private String name;
    private String secret;
    private String token;

    public UserDTO buildDto(User user) {
        if(user != null) {
            this.setClientId(user.getClientId());
            this.setExp(user.getExp());
            this.setName(user.getName());
            this.setSecret(user.getSecret());
            this.setToken(user.getToken());
        }
        return this;
    }

    public User toEntity() {
        User user = new User();
        user.setClientId(this.getClientId());
        user.setExp(this.getExp());
        user.setName(this.getName());
        user.setSecret(this.getSecret());
        user.setToken(this.getToken());
        return user;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public int getExp() {
        return expiry;
    }

    public void setExp(int expiry) {
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
