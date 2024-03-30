package phuongHoaXuan;

import java.util.Arrays;

public class DinhBoLinh {
    // Có access modifier là Private thì chỉ được phép sử dụng trong class chứa nó
    //variable/ property
    private String expresso;
    // Default( chỉ cho phép các class cùng package dùng được)
    String Capuchino;
    // protected (chỉ cho phép kế thừa mới dùng được)
    protected String cherry;
    //Getter/Setter
        //method / Function
    private String getExpresso(){
        return expresso;
    }
    public String catimor;
    String getCapuchino(){
        return Capuchino;
    }
    protected String getCherry(){
        return cherry;
    }
    public String getCatimor(){
        return catimor;
    }

    public  static  String monokai;
    public static void main(String[] args) {
        DinhBoLinh dinhbolinh = new DinhBoLinh();
        dinhbolinh.expresso = "Cfe";
        System.out.println(dinhbolinh.getExpresso());
        dinhbolinh.Capuchino = "Capuchino";
        System.out.println(dinhbolinh.getCapuchino());
        dinhbolinh.cherry = "chery";
        System.out.println(dinhbolinh.getCherry());
        dinhbolinh.catimor = "catimor";
        System.out.println(dinhbolinh.getCatimor());
    }
}
