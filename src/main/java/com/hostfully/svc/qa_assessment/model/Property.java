package com.hostfully.svc.qa_assessment.model;

import com.hostfully.svc.qa_assessment.enums.CountryCode;

public class Property {

    private String id;
    private String alias;
    private String countryCode;
    private String createdAt;

    private Property(PropertyBuilder builder){
        this.id = builder.id;
        this.alias = builder.alias;
        this.countryCode = builder.countryCode;
        this.createdAt = builder.createdAt;
    }

    public String getId(){
        return id;
    }

    public String getAlias(){
        return alias;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public static PropertyBuilder builder(){
        return new PropertyBuilder();
    }

    public static class PropertyBuilder {
        private String id;
        private String alias;
        private String countryCode;
        private String createdAt;

        public PropertyBuilder id(String id){
            this.id = id;
            return this;
        }

        public PropertyBuilder alias(String alias){
            this.alias = alias;
            return this;
        }

        public PropertyBuilder countryCode(String countryCode){
            this.countryCode = countryCode;
            return this;
        }

        public PropertyBuilder createdAt(String createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public Property build(){
            return new Property(this);
        }
    }
}
