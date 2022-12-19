import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.*;
import java.awt.Color;
public class alternativecalculator implements ActionListener
//implements ActionroomTypeListeners
{
    //Below are Instances Variables :
    double area = 0; //this is to calculate areaofroom
    double lumens = 0; //this is the total value of lumens
    double illuminance = 0; //this is the illumination intensity according to selected room 
    double widthvalue, lengthvalue; //this is to get value for area from textfields
    String brightness = ""; //this is to get value of illumination intensity
    double totalwatts = 0;
    String unitSelected = ""; //this is to get the unit selected from measurement units button
    double lumensperwatts = 0; //this is how much a bulb generates lumens
    double areaAndIlluminance =0; 
    double FCORLUX = 0; //this is the value of footcandle or lux needed in a room
    String ROOMCHOSEN = "";
    String BULBCHOSEN = "";
    //Below are components of the calculator :
    JLabel title = new JLabel("LUMENS CALCULATOR");
    JLabel selectRoomType = new JLabel("Select Room Type ");
    JLabel measurementUnit = new JLabel("Measurement Unit");
    JLabel width = new JLabel("Insert Width size");
    JLabel length = new JLabel("Insert Length size");
    JLabel illuminationintensity = new JLabel("Illumination Intensity");
    JLabel sentenceInPanel = new JLabel(" Lumens ");
    JLabel totalLumenInPanel = new JLabel("0");
    JLabel sentenceInPanel2 = new JLabel("are required to illuminate your bedroom of ");
    JLabel typeofbulb = new JLabel("Type of bulb");
    JLabel totalRoomSizeInPanel = new JLabel(" ");
    JLabel measurementUnitUsedInPanel = new JLabel("");
    JLabel sentenceInPanel3 = new JLabel("square");
    JButton calculate = new JButton("Calculate");
    JTextField widthtf = new JTextField(7);
    JTextField lengthtf = new JTextField(7);
    JRadioButton feet = new JRadioButton("Feet");
    JRadioButton meters = new JRadioButton("Meters");
    JRadioButton bright = new JRadioButton("Bright");
    JRadioButton dim = new JRadioButton("Dim");
    JRadioButton medium = new JRadioButton("Medium");
    String[] bulbtype = {"Incandescent bulb", "LED bulb", "Halogen bulb"};
    JComboBox<String> bulbTypeList = new JComboBox<>(bulbtype);
    String[] roomtype = {"Bedroom", "Kitchen", "Living Room", "Bathroom", "Office","Garage","Hallway"};
    JComboBox<String> roomTypeList = new JComboBox<>(roomtype);
    
    //this variable is for actionperformed
    String roomOperation = new String();
    String bulbOperation = new String();
    
    
    //Below are the fonts :
    Font customFont = new Font("SansSerif ", Font.PLAIN, 27);
    Font customFont2 = new Font("SansSerif ", Font.PLAIN, 15);
    //Below are the layout of the calculator using GridBagLayout
    private void addItem(JPanel panel, JComponent c, int x, int y, int align, int horzspan, int fill){
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridy = y;
        gc.gridx = x;
        gc.gridy = y;
        gc.weightx = 100;
        gc.weighty = 100;
        gc.anchor = align;
        gc.gridwidth = horzspan;
        gc.gridheight = 1;
        gc.fill = fill;
        gc.insets = new Insets(0,0,0,0);
        panel.add(c,gc);
    }
    
    public alternativecalculator(){
        
     
        //Below is the frame base of calculator
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,450);
        frame.setVisible(true);
        frame.setBackground(Color.red);
        
        //Below are the panels that consists in the calculator
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(750,350));
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.pink);
        panel2.setPreferredSize(new Dimension(750,50));
        frame.add(panel,BorderLayout.NORTH);
        frame.add(panel2);
        //Below are the button groups for the radio buttons ("measurement unit" and "illumination intensity")
        //illumination intensity radio buttons
        ButtonGroup illuminationIntensityGroup = new ButtonGroup();
        illuminationIntensityGroup.add(dim);
        illuminationIntensityGroup.add(medium);
        illuminationIntensityGroup.add(bright);
        //measurement unit radio buttons
        ButtonGroup measurementUnitGroup = new ButtonGroup();
        measurementUnitGroup.add(meters);
        measurementUnitGroup.add(feet);
        
        //Below are the actionroomTypeListener for each buttons and combo boxes and radio buttons
        dim.addActionListener(this);
        medium.addActionListener(this);
        bright.addActionListener(this);
        meters.addActionListener(this);
        feet.addActionListener(this);
        calculate.addActionListener(this);
        bulbTypeList.addActionListener(this);
        roomTypeList.addActionListener(this);
        
        //Below are the components font's
        title.setFont(customFont);
        selectRoomType.setFont(customFont2);
        measurementUnit.setFont(customFont2);
        roomTypeList.setFont(customFont2);
        width.setFont(customFont2);
        length.setFont(customFont2);
        illuminationintensity.setFont(customFont2);
        feet.setFont(customFont2);
        meters.setFont(customFont2);
        widthtf.setFont(customFont2);
        lengthtf.setFont(customFont2);
        dim.setFont(customFont2);
        bright.setFont(customFont2);
        medium.setFont(customFont2);
        calculate.setFont(customFont2);
        
        //Below are the GridBagLayout components layout of the calculator
        addItem(panel, title, 1, 0, GridBagConstraints.CENTER, 5, GridBagConstraints.BOTH);
        addItem(panel, selectRoomType, 0, 2, GridBagConstraints.CENTER, 3, GridBagConstraints.BOTH);
        addItem(panel, roomTypeList, 3, 2, GridBagConstraints.CENTER, 4, GridBagConstraints.BOTH);
        addItem(panel, measurementUnit, 0, 1, GridBagConstraints.CENTER, 3, GridBagConstraints.BOTH);
        addItem(panel, feet, 3, 1, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(panel, meters, 4, 1, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(panel, width, 0, 3, GridBagConstraints.EAST, 1, GridBagConstraints.BOTH);
        addItem(panel, widthtf, 1, 3, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(panel, length, 3, 3, GridBagConstraints.EAST, 1, GridBagConstraints.BOTH);        
        addItem(panel, lengthtf, 4, 3, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);      
        addItem(panel, illuminationintensity, 0, 4, GridBagConstraints.CENTER, 2, GridBagConstraints.BOTH);
        addItem(panel, bright, 4, 4, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(panel, dim, 2, 4, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(panel, medium, 3, 4, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(panel, calculate, 1, 7, GridBagConstraints.CENTER, 3, GridBagConstraints.BOTH);
        addItem(panel, typeofbulb, 0, 5, GridBagConstraints.CENTER, 2, GridBagConstraints.BOTH);
        addItem(panel, bulbTypeList, 2, 5, GridBagConstraints.CENTER, 3, GridBagConstraints.BOTH);
        addItem(panel2, sentenceInPanel, 0, 0, GridBagConstraints.CENTER, 4, GridBagConstraints.BOTH);
        addItem(panel2, totalLumenInPanel, 0, 0, GridBagConstraints.CENTER, 4, GridBagConstraints.BOTH);
        addItem(panel2, sentenceInPanel2, 0, 0, GridBagConstraints.CENTER, 4, GridBagConstraints.BOTH);
        addItem(panel2, totalRoomSizeInPanel, 0, 0, GridBagConstraints.CENTER, 4, GridBagConstraints.BOTH);
        addItem(panel2, measurementUnitUsedInPanel, 0, 0, GridBagConstraints.CENTER, 4, GridBagConstraints.BOTH);
        addItem(panel2, sentenceInPanel3, 0, 0, GridBagConstraints.CENTER, 4, GridBagConstraints.BOTH);
        frame.setVisible(true);
    }
    
    //not sure
    public void getWidthValue(){
        widthvalue = Double.parseDouble(widthtf.getText());
        if (widthvalue == 0){
            System.out.println("INPUT WIDTH");
        }
    }
    public void getLengthValue(){
        lengthvalue = Double.parseDouble(lengthtf.getText());
    }
    
    
    public void actionPerformed (ActionEvent ae){
        //Below is the actionroomTypeListener for illumination intensity radio buttons
        if (ae.getSource().equals(dim)){
            brightness = "min";
        }
        if (ae.getSource().equals(medium)){
            brightness = "medium";
        }
        if (ae.getSource().equals(bright)){
            brightness = "max";
        }
        
        //Below is the measurement unit for inherited room constructors
        if (ae.getSource().equals(feet)){
            unitSelected = "feet";
        }
        if (ae.getSource().equals(meters)){
            unitSelected = "meters";
        }
        
        //Below is the roomtype combobox
         if (ae.getSource().equals(roomTypeList)){
            String selectedroom = (String)roomTypeList.getSelectedItem();
            switch(selectedroom){
                case"Kitchen":
                roomOperation = "KITCHEN";
                break;
                
                case"Living Room":
                roomOperation = "LIVINGROOM";
                break;
                
                case"Hallway":
                roomOperation = "HALLWAY";
                break;
                
                case"Office":
                roomOperation = "OFFICE";
                break;
                
                case"Garage":
                roomOperation = "GARAGE";
                break;
                
                case"Bedroom":
                roomOperation = "BEDROOM";
                break;
                
                case"Bathroom":
                roomOperation = "BATHROOM";
                break;
            }
        }
        
        //Below is the bulbtype list
        if (ae.getSource().equals(bulbTypeList)){
            String selectedbulb = (String)bulbTypeList.getSelectedItem();
            switch (selectedbulb){
                case "Incandescent bulb":
                bulbOperation = "INCANDESCENT";
                break;
                
                case "LED bulb":
                bulbOperation = "LED";
                break;
                
                case "Halogen bulb":
                bulbOperation = "HALOGEN";
                break;
            }
        }
        
        if (ae.getSource().equals(calculate)){
            getWidthValue();
            getLengthValue();
            if (roomOperation == "KITCHEN"){
                kitchen roomKitchen = new kitchen();
                FCORLUX = roomKitchen.getFCORLUX(unitSelected, brightness);
                //System.out.println(FCORLUX);
            }
            else if(roomOperation == "LIVINGROOM"){
                livingroom roomLivingRoom = new livingroom();
                FCORLUX = roomLivingRoom.getFCORLUX(unitSelected, brightness);
                //System.out.println(FCORLUX);
            }
            else if (roomOperation == "OFFICE"){
                office roomOffice = new office();
                FCORLUX = roomOffice.getFCORLUX(unitSelected, brightness);
                //System.out.println(FCORLUX);
            }
            else if (roomOperation == "GARAGE"){
                garage roomGarage = new garage();
                FCORLUX = roomGarage.getFCORLUX(unitSelected, brightness);
                //System.out.println(FCORLUX);
            }
            else if (roomOperation == "HALLWAY"){
                hallway roomHallway = new hallway();
                FCORLUX = roomHallway.getFCORLUX(unitSelected, brightness);
                //System.out.println(FCORLUX);
            }
            else if (roomOperation == "BEDROOM"){
                bedroom roomBedroom = new bedroom();
                FCORLUX = roomBedroom.getFCORLUX(unitSelected, brightness);
                //System.out.println(FCORLUX);
            }
            else if (roomOperation == "BATHROOM"){
                bathroom roomBathroom = new bathroom();
                FCORLUX = roomBathroom.getFCORLUX(unitSelected, brightness);
                //System.out.println(FCORLUX);
            }
            area = widthvalue * lengthvalue;
            System.out.println("------------------------------");
            System.out.println("area of room is : " + area);
            System.out.println("footcandle or lux is : " + FCORLUX);
            lumens = area * FCORLUX;
            //put lumens into panel by strLumen = lumens.getParseString;
            System.out.println("lumens is :");
            System.out.println("area x FCORLUX : " + lumens);
            totalLumenInPanel.setText(String.valueOf(lumens));
            measurementUnitUsedInPanel.setText(String.valueOf(unitSelected));
            totalRoomSizeInPanel.setText(String.valueOf(area));
            if (bulbOperation == "LED"){
                LED bulbled = new LED();
                totalwatts = bulbled.getTotalWatts(lumens);
            }
            else if (bulbOperation == "INCANDESCENT"){
                incandescent bulbincandescent = new incandescent();
                totalwatts = bulbincandescent.getTotalWatts(lumens);
            }
            else if (bulbOperation == "HALOGEN"){
                halogen bulbhalogen = new halogen();
                totalwatts = bulbhalogen.getTotalWatts(lumens);
            }
            System.out.println("Total watts : " + totalwatts);
            System.out.println("bulb chosen : " + bulbOperation);
            lumensperwatts = lumens/totalwatts;
            System.out.println("lumens per watts : " + lumensperwatts);
        }
        

    }
    
    public double getLumens(){
        return lumens;
    }
}
    
