/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckStudRes;

import java.util.ArrayList;

/**
 */
public class AppCode {
    
    private String AppCode;
    private ArrayList<String> studentList = new ArrayList<>();
    
    // Constructor med hårdkodade studentID (samma för alla kurser i det här fallet)
    public AppCode(String appCode){
        this.AppCode = appCode;
        String[] students = {"rijo", "krkj", "maka"};
        
        for(int i = 0; i < students.length; i++){
            studentList.add(students[i]);
        }
    }

    // Kollar om student finns på kurs
    public String checkStudOnCourse(String studentID){
        
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).equals(studentID)){
                return "Valid";
            }
        }
        return "Invalid";
    }
    
    public String getAppCode(){
        return this.AppCode;
    }
}
