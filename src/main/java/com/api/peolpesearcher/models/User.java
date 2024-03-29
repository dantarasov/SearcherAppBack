package com.api.peolpesearcher.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(	name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name"),
                @UniqueConstraint(columnNames = "email")
        })

public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(nullable = false, updatable = false)
        private Long id;
        private String name;
        private String gender;
        private String email;
        private String password;
        private String phone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User() {}

    public User( String name, String gender, String email, String password, String phone) {
            this.name = name;
            this.gender = gender;
            this.email = email;
            this.password = password;
            this.phone = phone;
        }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override

        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", gender='" + gender + '\'' +
                    ", phone='" + phone + '\'' +

                    '}';
        }
    }
