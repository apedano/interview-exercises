package ch6.builderPattern;

import java.util.Date;

/**
 * Created by Alex on 03/08/2017.
 */
public class Car {
    //mandatory field
    private String manufacturer;
    //mandatory field
    private String model;
    private int costructionYear;
    private int cc;
    private String alimentation;
    private Date immatricolationDate;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getCostructionYear() {
        return costructionYear;
    }

    public int getCc() {
        return cc;
    }

    public String getAlimentation() {
        return alimentation;
    }

    public static class Builder {
        private String manufacturerb;
        private String modelb;
        private int costructionYearb = 0;
        private int ccb;
        private String alimentationb;
        private Date immatricolationDateb;

        public Builder manufacturer(String manufacturer){
            this.manufacturerb = manufacturer;
            return this;
        }

        public Builder model(String model){
            this.modelb = model;
            return this;
        }

        public Builder costructionYear(int costructionYear){
            this.costructionYearb = costructionYear;
            return this;
        }

        public Builder cc(int cc){
            this.ccb = cc;
            return this;
        }

        public Builder alimentation(String alimentation){
            this.alimentationb = alimentation;
            return this;
        }

        public Builder immatricolationDate(Date immatricolationDate){
            this.immatricolationDateb = immatricolationDate;
            return this;
        }

        public Car build(){
            Car out = new Car();
            //mandatory field
            out.manufacturer = this.manufacturerb;
            //mandatory field
            out.model = this.modelb;
            out.costructionYear = this.costructionYearb;
            out.cc = this.ccb;
            out.alimentation = this.alimentationb;
            out.immatricolationDate = this.immatricolationDateb;
            if(manufacturerb == null || modelb == null){
                throw new IllegalStateException("Builder cannot be executed: mandatory fields missing");
            }
            return out;
        }
    }
}


