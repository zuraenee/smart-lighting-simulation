import javax.swing.*;
import java.awt.*;
import java.util.*;
public class incandescent extends bulb
{
    public incandescent(){
        this.totalwatts = 100;
    }
    public double getTotalWatts(double lumens){
         if (lumens <= 300){
            totalwatts = 30; 
        }
        else if (lumens <= 500 && lumens >= 301){
            totalwatts = 40; 
        }
        else if (lumens <= 700 && lumens >= 501){
            totalwatts = 60; 
        }
        else if (lumens <= 1000 && lumens >= 701){
            totalwatts = 75;
        }
        else if (lumens <= 1250 && lumens >= 1001){
            totalwatts = 120; 
        }
        else if (lumens <= 2000 && lumens >= 1251){
            totalwatts = 250; 
        }
        else {
            totalwatts = 300;
        }
        return totalwatts;
    }
}
