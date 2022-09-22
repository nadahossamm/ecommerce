//package com.example.ecommerce.Entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//
////package com.example.ecommerce.Entity;
////
////import lombok.AllArgsConstructor;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////
////import javax.persistence.Entity;
////import javax.persistence.*;
////
//////https://www.youtube.com/watch?v=MgOJmWMSTuQ&list=PLzXSm2gSfuPJc2sSAmmud6TLpx0H7otyd
////@Entity
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////@Table(name = "user")
////public class User {
////    @Id
////    @GeneratedValue(strategy= GenerationType.AUTO)
////
////    private Long id;
////    private String username;
////    private String password;
////    private String email;
////    private int number;
////}
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private  Long id;
//    @Column(name = "user_name",nullable = false,unique = true)
//    private String userName;
//    @Column(name = "password")
//    private String password;
//
//}