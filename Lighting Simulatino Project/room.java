public class room
{
    protected double width, length, height;
    protected String unit;
    protected double conversion;
    protected double minfc, medfc, maxfc;
    protected double minlux, medlux, maxlux;
    public room(){
        conversion = 0.0929030;
        minfc=0;
        medfc=0;
        maxfc=0;
    }
    
    public int getArea(int width, int length){
        return width * length;
    }
    
    //this is an alternate to each getMin() methods in every subclasses, however if i do this.
    //the value of the minfc is 0, following the top;
    protected double value = 0;
    public double getALL(String unit, String brightness){
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
