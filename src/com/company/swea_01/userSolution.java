package com.company.swea_01;

import java.util.ArrayList;
import java.util.Collections;

class UserSolution
{
    private ArrayList<Order> maesu, maedo, contract;
    private int mNumber = 1;

    class Order implements Comparable<Order>{
        private int mStock, mNumber, mQuantity, mPrice;
        public Order(int mNumber, int mStock, int mQuantity, int mPrice){
            this.mStock= mStock;
            this.mNumber = mNumber;
            this.mQuantity = mQuantity;
            this.mPrice = mPrice;
        }
        public int getmStock() {    return mStock;       }
        public void setmStock(int mStock) {     this.mStock = mStock;        }
        public int getmNumber() {       return mNumber;        }
        public void setmNumber(int mNumber) {        this.mNumber = mNumber;        }
        public int getmQuantity() {          return mQuantity;        }
        public void setmQuantity(int mQuantity) {          this.mQuantity = mQuantity;        }
        public int getmPrice() {          return mPrice;        }
        public void setmPrice(int mPrice) {          this.mPrice = mPrice;        }

        @Override
        public int compareTo(Order o) {
            if(o.mPrice < this.mPrice){
                return 1;
            }else if(o.mPrice > this.mPrice){
                return -1;
            }
            return 0;
        }
    }

    public void init()
    {
        this.maesu = new ArrayList<>();
        this.maedo = new ArrayList<>();
        this.contract = new ArrayList<>();
    }

    public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        if(!this.maedo.isEmpty()) {
            Collections.sort(this.maedo);
            for (int i =0; i<this.maedo.size(); i++){
                if(this.maedo.get(i).getmStock() == mStock && this.maedo.get(i).getmPrice() < mPrice) {
                    int rQuantity = this.maedo.get(i).getmQuantity() - mQuantity;
                        if( rQuantity < 0 ) {
                            this.contract.add(new Order(this.maedo.get(i).getmNumber(),mStock, Math.abs(rQuantity), this.maedo.get(i).getmPrice()));
                            this.maedo.remove(i);
                            this.maesu.add(new Order(mNumber,mStock,Math.abs(rQuantity),mPrice));
                            return Math.abs(rQuantity);
                        } else if (rQuantity > 0 ){
                            this.maedo.get(i).setmQuantity(rQuantity);
                            this.contract.add(new Order(this.maedo.get(i).getmNumber(),mStock, rQuantity, this.maedo.get(i).getmPrice()));
                            return 0;
                        } else {
                            this.contract.add(new Order(this.maedo.get(i).getmNumber(),mStock, mQuantity, this.maedo.get(i).getmPrice()));
                            this.maedo.remove(i);
                            return 0;
                        }
                    }
                }
            }
        else {
            mNumber = this.mNumber;
            this.mNumber++;
            this.maesu.add(new Order(mNumber, mStock, mQuantity, mPrice));
            return mQuantity;
        }
        return mQuantity;
    }

    public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        if(!this.maesu.isEmpty()) {
            Collections.sort(this.maesu);
            for (int i =0; i<this.maesu.size(); i++){
                if(this.maesu.get(i).getmStock() == mStock && this.maesu.get(i).getmPrice() > mPrice) {
                    int rQuantity = this.maesu.get(i).getmQuantity() - mQuantity;
                    if( rQuantity < 0 ) {
                        this.contract.add(new Order(this.maesu.get(i).getmNumber(),mStock, Math.abs(rQuantity), this.maesu.get(i).getmPrice()));
                        this.maesu.remove(i);
                        this.maedo.add(new Order(mNumber,mStock,Math.abs(rQuantity),mPrice));
                        return Math.abs(rQuantity);
                    } else if (rQuantity > 0 ){
                        this.maesu.get(i).setmQuantity(rQuantity);
                        this.contract.add(new Order(this.maesu.get(i).getmNumber(),mStock, rQuantity, this.maesu.get(i).getmPrice()));
                        return 0;
                    } else {
                        this.contract.add(new Order(this.maesu.get(i).getmNumber(),mStock, mQuantity, this.maesu.get(i).getmPrice()));
                        this.maesu.remove(i);
                        return 0;
                    }
                }
            }
        }
        else {
            mNumber = this.mNumber;
            this.mNumber++;
            this.maedo.add(new Order(mNumber, mStock, mQuantity, mPrice));
            return mQuantity;
        }
        return mQuantity;
    }

    public void cancel(int mNumber)
    {
        for(Order order : this.maedo){
            if(order.getmNumber() == mNumber) {
                this.maedo.remove(order);
                break;
            }
        }
        for (Order order2 : this.maesu){
            if(order2.getmNumber() == mNumber) {
                this.maesu.remove(order2);
                break;

            }
        }
    }

    public int bestProfit(int mStock)
    {
        ArrayList<Order> stock = new ArrayList<>();
        for (int i =0; i < this.contract.size(); i++){
            if(this.contract.get(i).getmStock() == mStock ){
                stock.add(this.contract.get(i));
            }
        }
        Collections.sort(stock);
        if(stock.size() < 3 ) return 0;
        else {
            int diff;
            int maxDiff = stock.get(0).getmPrice();
            for(int j = 1; j < stock.size(); j++){
                diff = Math.abs(stock.get(j-1).getmPrice() - stock.get(j).getmPrice());
                if(diff > maxDiff) maxDiff = diff;
            }
            return maxDiff;
        }
    }
}