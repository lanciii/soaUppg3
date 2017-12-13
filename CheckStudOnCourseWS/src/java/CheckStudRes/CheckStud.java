/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckStudRes;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 */
@Path("CheckStud")
public class CheckStud {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CheckStud
     */
    public CheckStud() {
    }

    /**
     * Retrieves representation of an instance of CheckStudRes.CheckStud
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@QueryParam("studentID") String studentID, @QueryParam("appCode") String appCode) {

        
        ArrayList<AppCode> appCodeList = new ArrayList<>();
        // Populerar hårdkodade anmälningskoder
        String[] appCodes = 
            { "D0031NH17", "D0031NV18", "D0031NH18",
              "D0023EH17", "D0023EV18", "D0023EH18",
              "D0007NH17", "D0007NV18", "D0007NH18"
            };
        for(int i = 0; i < appCodes.length; i++){
            appCodeList.add(new AppCode(appCodes[i]));
        }
        
        // Anropar metod som kollar om studenter är registrerade på kurs
        for(int j = 0; j < appCodeList.size(); j++){
            if(appCodeList.get(j).getAppCode().equals(appCode)){
                return appCodeList.get(j).checkStudOnCourse(studentID);
            }
        }
        return "Invalid";
    }    

}
