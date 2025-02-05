package com.hostfully.svc.qa_assessment.model;

public class Guest {
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    private Guest(GuestBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public static GuestBuilder builder(){
        return new GuestBuilder();
    }


    public static class GuestBuilder {
        private String firstName;
        private String lastName;
        private String dateOfBirth;

        public GuestBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public GuestBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public GuestBuilder dateOfBirth(String dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Guest build(){
            return new Guest(this);
        }
    }
}
