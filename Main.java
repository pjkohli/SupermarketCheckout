package com.prabhjot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        //Promotion Text - "Buy 3 for 2"
        Product product1 = new Product(1,"Pringles 200g", (float) 1.99,"Type1");
        list.add(product1);

        //Promotion Text - "Buy 2 for 1.50"
        Product product2 = new Product(2,"Banana chips 500g",(float) 1.00,"Type2");
        product2.setSpecialPrice((float) 1.50);
        list.add(product2);

        //Promotion Text - "Free Product" , Buy 5 get 2 500 ml free
        Product product3 = new Product(3,"Coca Cola 500ml",(float) 1.00,"Type5");
        product3.setQuantitiesFree(2);
        list.add(product3);

        //Promotion Text - "Buy 5 get 2 500 ml free"
        Product product4 = new Product(4,"Coca Cola 2L",(float) 2.00,"Type3");
        product4.setQuantitiesToBuy(5);
        product4.setQuantitiesFree(2);
        product4.setFreeProduct(product3);
        list.add(product4);

        //Promotion Text - "Buy any 3 for 2"
        Product product5 = new Product(5,"Coriander 80g",(float) 1.00,"Type4");
        list.add(product5);

        //Promotion Text - "Buy any 3 for 2"
        Product product6 = new Product(6,"Parsley 80g",(float) 1.50,"Type4");
        list.add(product6);

        //Promotion Text - "Buy any 3 for 2"
        Product product7 = new Product(7,"Basil 80g",(float) 2.50,"Type4");
        list.add(product7);

        //Promotion Text - "No promotion"
        Product product8 = new Product(8,"Butter",(float) 2.00,"Type6");
        list.add(product8);

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter number of items bought:");
        int n = reader.nextInt();
        int id[] = new int[n];
        int quantity[] = new int[n];
        float priceList[] = new float[n];
        int toGet[] = new int[n];
        int freeId[] = new int[n];
        int quantityList[] = new int[n];
        float price;
        float grandTotalPrice = 0;
        int toBuy;
        int i,k=0,z=0;
        int divisor,remainder;
        int counterForType4=0;
        for(i=0;i<n;i++) {
            System.out.println("Enter product id and quantity:");
            id[i] = reader.nextInt();
            quantity[i] = reader.nextInt();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getProductId() == id[i]) {
                    price = list.get(j).getPrice();
                    System.out.println("The original price of "+id[i]+" is: " + price);
                    if (list.get(j).getPromotionType() == "Type3") {
                        toBuy = list.get(j).getQuantitiesToBuy();
                        grandTotalPrice += price * quantity[i];
                        toGet[z] = (quantity[i] / toBuy) * list.get(j).getQuantitiesFree();
                        freeId[z] = list.get(j).getFreeProduct().getProductId();
                        z++;
                    }
                }
            }
        }
        for(i=0;i<n;i++) {
            for(int j=0;j< list.size();j++) {
                if(list.get(j).getProductId() == id[i]){
                    price = list.get(j).getPrice();
                    if(list.get(j).getPromotionType() == "Type1"){
                        divisor = quantity[i]/3;
                        remainder = quantity[i]%3;
                        grandTotalPrice += price*((divisor*2)+remainder);
                    } else if(list.get(j).getPromotionType() == "Type2"){
                        divisor = quantity[i]/2;
                        remainder = quantity[i]%2;
                        float specialPrice = list.get(j).getSpecialPrice();
                        grandTotalPrice += (divisor*specialPrice)+(remainder*price);
                    } else if(list.get(j).getPromotionType() == "Type4"){
                        counterForType4 +=quantity[i];
                        priceList[k]=price;
                        quantityList[k]=quantity[i];
                        k++;
                    } else if(list.get(j).getPromotionType() == "Type5"){
                        if(z==0){
                            grandTotalPrice += quantity[i] * price;
                        }
                        else {
                            for (int l = 0; l < z; l++) {
                                if (freeId[l] == id[i]) {
                                    if (quantity[i] >= toGet[l]) {
                                        grandTotalPrice += (quantity[i] - toGet[l]) * price;
                                    }
                                }
                            }
                        }
                    } else if(list.get(j).getPromotionType() == "Type6"){
                        grandTotalPrice += price*quantity[i];
                    }
                }
            }
        }
        float big =0;
        int loc = -1;
        int counter = 0;
        int totalCounter;
        if (!(counterForType4<3)){
            totalCounter = ((counterForType4/3)*2)+(counterForType4%3);
        }else totalCounter = counterForType4;
        while(counter<totalCounter){
            for(i=0;i<k;i++){
                if(big<priceList[i]){
                    big=priceList[i];
                    loc = i;
                }
            }
            priceList[loc]=0;
            if((totalCounter-counter)>quantityList[loc]){
                counter+=quantityList[loc];
                grandTotalPrice += big*quantityList[loc];
            }else {
                grandTotalPrice += big*(totalCounter-counter);
                counter=totalCounter;
            }
            big =0;
        }
        System.out.println("GrandTotal is: " + grandTotalPrice);
    }
}
