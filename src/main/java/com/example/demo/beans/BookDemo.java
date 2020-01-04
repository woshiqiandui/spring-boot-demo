package com.example.demo.beans;


import java.util.Date;

public class BookDemo {
    private String id;
    private String name;
    private String writer;
    private String ISBN;
    private String publisher;
    private Date checkInDate;
    private Date publishDate;
    private Double price;
    private String type;
    private String simpleInfo;
    private Double rent;
    private String other;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSimpleInfo() {
        return simpleInfo;
    }

    public void setSimpleInfo(String simpleInfo) {
        this.simpleInfo = simpleInfo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publisher='" + publisher + '\'' +
                ", checkInDate=" + checkInDate +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", simpleInfo='" + simpleInfo + '\'' +
                ", rent=" + rent +
                ", other='" + other + '\'' +
                '}';
    }
}
