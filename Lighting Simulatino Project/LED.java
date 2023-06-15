import javax.swing.*;
import java.awt.*;
import java.util.*;
public class LED extends bulb
{
    protected double lumens = 0;
    protected double totalwatts = 0;
    protected double lumensperwatts = 0;
    
    public LED(){
        this.totalwatts = 10;
    }
    public double getTotalWatts(double lumens){
        if (lumens <= 300){
            totalwatts = 4; 
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 500 && lumens >= 301){
            totalwatts = 5; 
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 700 && lumens >= 501){
            totalwatts = 7; 
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 1000 && lumens >= 701){
            totalwatts = 10;
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 1250 && lumens >= 1001){
            totalwatts = 13; 
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 2000 && lumens >= 1251){
            totalwatts = 20; 
            lumensperwatts = lumens/totalwatts;
        }
        else {
            totalwatts = 30;
            lumensperwatts = lumens/300;
        }
        return totalwatts;
    }
    
}
