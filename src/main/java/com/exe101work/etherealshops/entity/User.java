//package com.exe101work.etherealshops.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.Instant;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String name;
//
//    @NotBlank(message = "email không được để trống")
//    private String email;
//
//    @NotBlank(message = "username không được để trống")
//    private String username;
//
//    @NotBlank(message = "password không được để trống")
//    private String password;
//
//    private int age;
//
//    private String phoneNumber;
//
//    private String address;
//
//    @Column(columnDefinition = "MEDIUMTEXT")
//    private String refreshToken;
//
//    private Instant createdAt;
//    private Instant updatedAt;
//    private String createdBy;
//    private String updatedBy;

//@PrePersist
//public void handleBeforeCreate() {
//    this.createdBy = SecurityUtil.getCurrentUserLogin().isPresent() == true
//            ? SecurityUtil.getCurrentUserLogin().get()
//            : "";
//
//    this.createdAt = Instant.now();
//}
//
//@PreUpdate
//public void handleBeforeUpdate() {
//    this.updatedBy = SecurityUtil.getCurrentUserLogin().isPresent() == true
//            ? SecurityUtil.getCurrentUserLogin().get()
//            : "";
//
//    this.updatedAt = Instant.now();
//}
//}
