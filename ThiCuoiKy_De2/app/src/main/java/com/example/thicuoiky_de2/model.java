package com.example.thicuoiky_de2;

public class model {
    private int Id;
    private  String Product;
    private  String Price;
    private  String Note;
    private  String Curency;
    private  String Time;
    private  String local;

    public  model()
    {

    }
    public model(int id, String product, String price, String note, String curency, String time, String local) {
        Id = id;
        Product = product;
        Price = price;
        Note = note;
        Curency = curency;
        Time = time;
        this.local = local;
    }
    public model( String product, String price, String note, String curency, String time, String local) {

        Product = product;
        Price = price;
        Note = note;
        Curency = curency;
        Time = time;
        this.local = local;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getCurency() {
        return Curency;
    }

    public void setCurency(String curency) {
        Curency = curency;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
