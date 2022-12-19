import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.*;
import java.awt.Color;

public class product implements ActionListener
{
    String[] colours = {"pink", "blue", "yellow", "red", "black"};
    //String[] valueofarray = {"50 watts", "100 watts", "150 watts", "200 wats"};
    JButton button = new JButton("");
    int valueofarray;
    String valueofarraytext;
    double lumens=0;
    int widthval, lengthval;
    //creation of all components of the product page    
    //array panel
    JButton[][] buttonarray = new JButton[8][8];
    JButton buttontest = new JButton();
    //bottom panel
    ImageIcon informationIcon = new ImageIcon("/bulb.jpeg"); 
    JButton goBackToCalc = new JButton("<   Go back to Calculator");
    JButton reset = new JButton("reset");
    //reset.setIcon(resetIcon);
    JButton information = new JButton();
    JButton finish = new JButton("finish    >");
    JLabel lumensCounter = new JLabel("null");
    
    //mid panel
    JLabel totalLumenInPanel = new JLabel("CALL OUT FROM CALC CLASS");
    JLabel sentenceInPanel = new JLabel(" lumens are needed to illuminate a ");
    JLabel totalRoomSizeInPanel = new JLabel("CALL OUT FROM CALC CLASS");
    JLabel measurementUnitUsedInPanel = new JLabel("CALL OUT FROM CALC CLASS");
    JLabel sentenceInPanel2 = new JLabel(" square room, and using an ");
    JLabel bulbUsedInPanel = new JLabel("CALL OUT FROM CALC CLASS");
    JLabel sentenceInPanel3 = new JLabel(" or ");
    JLabel lumensperwattsInPanel = new JLabel("CALL OUT FROM CALC CLASS");
    JLabel sentenceInPanel4 = new JLabel(" a power of ");
    JLabel totalwattsInPanel = new JLabel("CALL OUT FROM CALC CLASS");
    JLabel sentenceInPanel5 = new JLabel(" watts is used");

    //colour of array
    Color first = new Color(243, 30, 80);
    Color second = new Color(234,56,120);
    
    Font customFont = new Font("SansSerif ", Font.PLAIN, 20);
    //customFont.setBackground(Color.pink);
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
    
    public product(){
        //Base frame for the page
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //$$TEST
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter width of room : ");
        int width = keyboard.nextInt();
        System.out.println("enter length of room : ");
        int length = keyboard.nextInt();
        widthval = width;
        lengthval = length;
        //Base panels for the page
        JPanel arraypanel = new JPanel(new GridLayout(width,length));
        arraypanel.setBackground(Color.black);
        arraypanel.setPreferredSize(new Dimension(750,350));
        JPanel midpanel = new JPanel(); //panel for the arrays
        midpanel.setBackground(Color.gray);
        midpanel.setPreferredSize(new Dimension(750,100));
        JPanel bottompanel = new JPanel(new GridBagLayout()); //panel for the buttons
        bottompanel.setBackground(Color.pink);
        bottompanel.setPreferredSize(new Dimension(750,50));
        
        //adding the panels into the frame using gridbaglayout
        frame.add(arraypanel, BorderLayout.NORTH);
        frame.add(midpanel, BorderLayout.CENTER);
        frame.add(bottompanel, BorderLayout.SOUTH);
        frame.setSize(750,550);
        
        totalLumenInPanel.setFont(customFont);
        sentenceInPanel.setFont(customFont);
        totalRoomSizeInPanel.setFont(customFont);
        measurementUnitUsedInPanel.setFont(customFont);
        sentenceInPanel2.setFont(customFont);
        bulbUsedInPanel.setFont(customFont);
        sentenceInPanel3.setFont(customFont);
        lumensperwattsInPanel.setFont(customFont);
        sentenceInPanel4.setFont(customFont);
        totalwattsInPanel.setFont(customFont);
        sentenceInPanel5.setFont(customFont);
        
        //add all the buttons into the each panels
        addItem(bottompanel, goBackToCalc, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(bottompanel, reset, 1, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(bottompanel, information, 2, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(bottompanel, finish, 3, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        //addItem(midpanel, buttontest, 3, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, totalLumenInPanel, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, sentenceInPanel, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, totalRoomSizeInPanel, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, measurementUnitUsedInPanel, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, sentenceInPanel2, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, bulbUsedInPanel, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, sentenceInPanel3, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, lumensperwattsInPanel, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, sentenceInPanel4, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, totalwattsInPanel, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);
        addItem(midpanel, sentenceInPanel5, 0, 0, GridBagConstraints.CENTER, 1, GridBagConstraints.BOTH);

        //actionlistener for all the buttons that does an action
        
        
        JButton[][] buttonarray = new JButton[width][length];        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                buttonarray[i][j] = new JButton();
                arraypanel.add(buttonarray[i][j]);
                buttonarray[i][j].addActionListener(this);
            }
        }
        
        reset.addActionListener(this);
        information.addActionListener(this);
        finish.addActionListener(this);
        goBackToCalc.addActionListener(this);
        
        
        first = buttontest.getBackground();
        
        frame.setResizable(false);//frame will not be allowed to be resized by user
        frame.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(buttonarray)){  
         //  alternativecalculator hm = new alternativecalculator();
         //   lumens = hm.getLumens();
          //  System.out.println(lumens);
          System.out.println("I AM PRESSED");
            /**
            for (int i=0; i<colours.length; i=+1){
                if (colours[i] == "pink"){
                    valueofarray = 50;
                    lumens = lumens-valueofarray;
                    valueofarraytext = "50 watts";
                }
                else if (colours[i] == "yellow"){
                    valueofarray = 100;
                    lumens = lumens-valueofarray;
                    valueofarraytext = "50 watts";
                }
                else if (colours[i] == "blue"){
                    valueofarray = 150;
                    lumens = lumens-valueofarray;
                    valueofarraytext = "50 watts";
                }
                else if (colours[i] == "red"){
                    valueofarray = 200;
                    lumens = lumens-valueofarray;
                    valueofarraytext = "50 watts";
                }
                else if (colours[i] == "black"){
                    valueofarray = 200;
                    lumens = lumens-valueofarray;
                    valueofarraytext = "50 watts";
                }
            }
            **/
        }
    }
}




