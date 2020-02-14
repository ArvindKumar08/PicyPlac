import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class PicyPlac extends JFrame{
    JButton button, button1 ;
    JLabel label, label1, label2, label3, label4,label5;
    JTextField textfield1, textfield2, textfield3, textfield4, textfield5, textfield6, textfield7, textfield8, textfield9;
    String datefield, text, dateio;
    int getValue, lno;
    JTextField date;

    
    public PicyPlac(){
        super("Simple Plate Checker");
        button = new JButton("Browse");
        button.setBounds(300,300,100,40);
        label = new JLabel();
        label.setBounds(10,10,670,250);
        add(button);
        add(label);

        button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    JFileChooser file = new JFileChooser();
                    file.setCurrentDirectory(new File(System.getProperty("user.home")));
                    //filter the files
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpeg","jpg","gif","png");
                    file.addChoosableFileFilter(filter);
                    int result = file.showSaveDialog(null);
                    //if the user click on save in Jfilechooser
                    if(result == JFileChooser.APPROVE_OPTION){
                        File selectedFile = file.getSelectedFile();
                        String path = selectedFile.getAbsolutePath();
                        label.setIcon(ResizeImage(path));
                    }
                    //if the user click on save in Jfilechooser

                    else if(result == JFileChooser.CANCEL_OPTION){
                        System.out.println("No File Select");
                    }
                }
            });

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700,700);
        setVisible(true);
    }

    // Method to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    
    
    {

        label1 = new JLabel();
        label1.setBounds(280,353,222,26);
        label1.setEnabled(true);
        label1.setText("Please Input Plate # Above");
        label1.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(141,400,554,43);
        label4.setEnabled(true);
        label4.setText("If Plate Number consists of only 6 digits, leave the FIRST as BLANK or X");
        label4.setVisible(true);

        textfield1 = new JTextField();
        textfield1.setBounds(50,450,40,40);
        textfield1.setEnabled(true);
        textfield1.setText("X");
        textfield1.setVisible(true);

        textfield2 = new JTextField();
        textfield2.setBounds(140,450,40,40);
        textfield2.setEnabled(true);
        textfield2.setText("X");
        textfield2.setVisible(true);

        textfield3 = new JTextField();
        textfield3.setBounds(240,450,40,40);
        textfield3.setEnabled(true);
        textfield3.setText("X");
        textfield3.setVisible(true);

        textfield4 = new JTextField();
        textfield4.setBounds(340,450,40,40);
        textfield4.setEnabled(true);
        textfield4.setText("0");
        textfield4.setVisible(true);

        textfield5 = new JTextField();
        textfield5.setBounds(430,450,40,40);
        textfield5.setEnabled(true);
        textfield5.setText("0");
        textfield5.setVisible(true);

        textfield6 = new JTextField();
        textfield6.setBounds(520,450,40,40);
        textfield6.setEnabled(true);
        textfield6.setText("0");
        textfield6.setVisible(true);

        Integer value = new Integer(0);
        Integer min = new Integer(0);
        Integer max = new Integer(9);
        Integer step = new Integer(1);
        SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);
        JSpinner LastNo = new JSpinner(model);
        LastNo.setBounds(600,450,40,40);
        int lno = model.getNumber().intValue();
        add(LastNo);

        label3 = new JLabel();
        label3.setBounds(222,509,138,36);
        label3.setEnabled(true);
        label3.setText("The day today is:");
        label3.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(175,562,350,31);
        label2.setEnabled(true);
        label2.setText("Check if the plate number can legally drive today");
        label2.setVisible(true);

        {
            date= new JTextField();
            date.setBounds (338,509,168,35);
            Date now = new Date();

            SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); 
            simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
            date.setText(simpleDateformat.format(now));

            String dateio = date.getText();

        }

        label5 = new JLabel();
        label5.setBounds(218,642,90,35);
        label5.setEnabled(true);
        label5.setText("It is");
        label5.setVisible(true);

        textfield9 = new JTextField();
        textfield9.setBounds(261,642,165,34);
        textfield9.setEnabled(true);
        textfield9.setText("");
        textfield9.setVisible(true);

       
        {
            button1 = new JButton("CHECK!");
            button1.setBounds(299,593,90,35);
            textfield9 = new JTextField();
            textfield9.setBounds(261,642,165,34);
            textfield9.setEnabled(true);
            textfield9.setVisible(true);
            add(button1);
            add(textfield9);

            button1.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

           
                        if(lno == (('1')) && (dateio.equals("Monday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('2') ) && (dateio.equals("Monday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('3') ) && (dateio.equals("Tuesday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('4') ) && (dateio.equals("Tuesday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('5') ) && (dateio.equals("Wednesday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('6') ) && (dateio.equals("Wednesday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('7') ) && (dateio.equals("Thursday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('8') ) && (dateio.equals("Thursday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('9') ) &&  (dateio.equals("Friday"))) {
                            textfield9.setText("Illegal");
                        } else if ((lno == ('0') ) &&  (dateio.equals("Friday"))) {
                            textfield9.setText("Illegal");
                        } else {
                            textfield9.setText("Legal");

                        }
                    }
                });

        
       
        }
    }

    {

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(button1);
        add(textfield1);
        add(textfield2);
        add(textfield3);
        add(textfield4);
        add(textfield5);
        add(textfield6);
        add(textfield9);
        add (date);

  
    }


    public void main(String[] args){
        new PicyPlac();

    }
    
}
