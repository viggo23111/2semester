package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resultat extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        double height=0.0;
        double weight=0.0;

        try {
            height = Double.parseDouble(request.getParameter("height"));
            weight = Double.parseDouble(request.getParameter("weight"));
        }catch (Exception e){
            throw new LoginSampleException("Du skal indtaste et tal som højde og vægt");
        }
        double bmi=Util.BmiHelperFunctions.calcBmi(height,weight);
        String category=Util.BmiHelperFunctions.findCategory(bmi);
        String gender=request.getParameter("gender");

        int sport=0;
        try {
            sport = Integer.parseInt(request.getParameter("sport"));
        }catch (Exception e){
            throw new LoginSampleException("Fejl i sport parameter");
        }
        String[] infos= request.getParameterValues("info");
        List<String> infoList = null;
        if(infos !=null){
            infoList = Arrays.asList(infos);
        }
        for (String s : infoList) {
            System.out.println(s);
        }
        String bmiDec= String.format("%.2f",bmi);
        request.setAttribute("height",height);
        request.setAttribute("weight",weight);
        request.setAttribute("bmi",bmiDec);
        request.setAttribute("kategori",category);
        request.setAttribute("gender",gender);
        request.setAttribute("sport",sport);
        request.setAttribute("infos",infoList);
        LogicFacade.insertBmiItem(height,weight,category,bmi,gender,sport,infoList);
        return "resultat";
    }
}
