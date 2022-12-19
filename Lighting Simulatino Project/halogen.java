import javax.swing.*;
import java.awt.*;
import java.util.*;
public class halogen extends bulb
{
    public halogen(){
        this.totalwatts = 100;
    }
    public double getTotalWatts(double lumens){
        if (lumens <= 300){
            totalwatts = 25; 
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 500 && lumens >= 301){
            totalwatts = 35; 
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 700 && lumens >= 501){
            totalwatts = 50; 
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 1000 && lumens >= 701){
            totalwatts = 65;
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 1250 && lumens >= 1001){
            totalwatts = 100; 
            lumensperwatts = lumens/totalwatts;
        }
        else if (lumens <= 2000 && lumens >= 1251){
            totalwatts = 125; 
            lumensperwatts = lumens/totalwatts;
        }
        else {
            totalwatts = 200;
            lumensperwatts = lumens/300;
        }
        return totalwatts;
    }
}
