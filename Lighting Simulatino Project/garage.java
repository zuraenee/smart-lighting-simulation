import javax.swing.*;
import java.awt.*;
import java.util.*;
public class garage extends room
{
    protected double minfc, maxfc, medfc;
    protected double minlux, maxlux, medlux;
    protected double value = 0;
    public garage (){
        minfc = 5;
        medfc = 7;
        maxfc = 10;
        minlux=minfc*conversion;
        medlux=medfc*conversion;
        maxlux=maxfc*conversion;
    }
    
    public double getFCORLUX(String unit, String brightness){
        if (unit == "feet"){
            if (brightness == "min"){
                 value = minfc;
            }
            else if (brightness == "medium"){
                value =  medfc;
            }
            else if (brightness == "max"){
                value =  maxfc;
            }
        }
        else{
            if (brightness == "min"){
                value = minlux;
            }
            else if (brightness == "medium"){
                value = medlux;
            }
            else if (brightness == "max"){
                value =  maxlux;
            }
        }
        return value;
    }
}
    

