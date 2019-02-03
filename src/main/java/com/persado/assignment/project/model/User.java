package com.persado.assignment.project.model;

// Created by Anagnostakis *\n \*/

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "firstname")
        private String firstname;

        @Column(name = "lastname")
        private String lastname;

        @Column(name = "address")
        private String address;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getFirstname() {
                return firstname;
        }

        public void setFirstname(String firstname) {
                this.firstname = firstname;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }
}


