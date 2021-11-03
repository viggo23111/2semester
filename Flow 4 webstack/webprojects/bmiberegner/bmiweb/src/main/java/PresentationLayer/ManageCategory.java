package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import Util.BmiHelperFunctions;
import Util.Initializer;
import com.mysql.cj.log.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageCategory extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String removeId = request.getParameter("removebtn");
        String editId = request.getParameter("editbtn");
        String action =request.getParameter("action");
        if(removeId!=null){
            action="remove";
        }else if(editId!=null){
            action="edit";
        }else if (action!=null){
            action="update";
        }
        switch(action){
            case "remove":
                LogicFacade.deleteSport(Integer.parseInt(removeId));
                Initializer.initSportList();
                request.getServletContext().setAttribute("sportList", Initializer.getSportList());
                return "categories";
            case "edit":
                request.setAttribute("editId",editId);
                Initializer.initSportList();
                request.setAttribute("sport", BmiHelperFunctions.findSportCategoryById(Integer.parseInt(editId)));
                return "editCategory";
            case "update":
                int editIntID= Integer.parseInt(request.getParameter("sportId"));
                System.out.println(editIntID);
                String categoryText = request.getParameter("category");
                LogicFacade.updateSport(editIntID,categoryText);
                Initializer.initSportList();
                request.getServletContext().setAttribute("sportList", Initializer.getSportList());
                return "categories";
            default: return "categories";
        }
    }
}
