package Util;

import FunctionLayer.Sport;

import java.util.List;

public class BmiHelperFunctions {
    public static Double calcBmi(Double height, Double weight){

        return weight/(height*height)*100*100;
    }

    public static String findCategory(Double bmi){
        String kategori="";
        if(bmi<18.5){
            kategori="Undervægtig";
        }else if (bmi>30){
            kategori="Svært overvægtig";
        }else if (bmi<25){
            kategori="Normalvægtig";
        }else{
            kategori="Overvægtig";
        }
        return kategori;
    }

    public static Sport findSportCategoryById(int id){
        List<Sport> sportList = Initializer.getSportList();
        for (Sport sport : sportList) {
            if(sport.getSports_id() ==id){
                return sport;
            }
        }
        return null;
    }
}
