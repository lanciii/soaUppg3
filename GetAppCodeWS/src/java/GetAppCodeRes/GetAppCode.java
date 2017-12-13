/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetAppCodeRes;

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
 *
 * @author richa
 */
@Path("GetAppCode")
public class GetAppCode {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GetAppCode
     */
    public GetAppCode() {
    }
    
    public void simulateAppCodes(){
        
    }
    
    /**
     * Retrieves representation of an instance of GetAppCodeRes.GetAppCode
     * @return an instance of java.lang.String
     */
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@QueryParam("kurskod") String kurskod, @QueryParam("termin") String termin) {

        // Simulerar anmälningskoder genom att slå ihop kurskod+termin
        // Möjliga kurskoder: D0031N, D0023E, D0007N
        // Möjliga terminer: H17, V18, H18
        ArrayList<String>  appCodes = new ArrayList<>();
        String[] kurskoder = {"D0031N", "D0023E", "D0007N"};
        String[] terminer = {"H17","V18", "H18"};
        
        for(int i = 0; i < kurskoder.length; i++){
            for(int j = 0; j < terminer.length; j++){
                appCodes.add(kurskoder[i]+terminer[j]);
            }
        }
        
        // Hämtar kurskod från vår lista och returnerar
        for(int i = 0; i < appCodes.size(); i++){
            if(appCodes.get(i).equals(kurskod+termin)){
                return kurskod+termin;
            }
        }
        return "Invalid";
    }
}
