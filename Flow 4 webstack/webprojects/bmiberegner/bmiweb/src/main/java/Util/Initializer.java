package Util;

import FunctionLayer.Info;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Sport;

import java.util.List;

public class Initializer {

    private static List<Sport> sportList = null;
    private static List<Info> infoList=null;

    public static void initSportList(){
        try {
            sportList = LogicFacade.getAllSports();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void initInfoList(){
        try {
            infoList = LogicFacade.getAllInfos();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Sport> getSportList() {
        if(sportList ==null){
            try {
                sportList = LogicFacade.getAllSports();
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sportList;
    }

    public static List<Info> getInfoList() {
        if(infoList ==null){
            try {
                infoList = LogicFacade.getAllInfos();
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
        return infoList;
    }
}
