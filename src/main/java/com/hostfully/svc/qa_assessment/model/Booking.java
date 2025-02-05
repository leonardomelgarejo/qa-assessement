package com.hostfully.svc.qa_assessment.model;

public class Booking {

    private String id;
    private String startDate;
    private String endDate;
    private String status;
    private Guest guest;
    private String propertyId;

    private Booking(BookingBuilder builder){
        this.id = builder.id;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.status = builder.status;
        this.guest = builder.guest;
        this.propertyId = builder.propertyId;
    }

    public String getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public Guest getGuest() {
        return guest;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public static BookingBuilder builder(){return new BookingBuilder();}

    public static class BookingBuilder {
        private String id;
        private String startDate;
        private String endDate;
        private String status;
        private Guest guest;
        private String propertyId;

        public BookingBuilder id(String id){
            this.id = id;
            return this;
        }

        public BookingBuilder startDate(String startDate){
            this.startDate = startDate;
            return this;
        }

        public BookingBuilder endDate(String endDate){
            this.endDate = endDate;
            return this;
        }

        public BookingBuilder status(String status){
            this.status = status;
            return this;
        }

        public BookingBuilder guest(Guest guest){
            this.guest = guest;
            return this;
        }

        public BookingBuilder propertyId(String propertyId){
            this.propertyId = propertyId;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }

    }

}
