/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turkish.text.to.code;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import static java.util.Map.entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths; 
import javax.swing.*;
import java.io.FileWriter;

/**
 *
 * @author omera
 */
public class mainScreen extends javax.swing.JFrame {
    Set<String> set = new HashSet<>();
    Set<String> formSentences = new HashSet<>();
    int totalId = 0;
    
    
    
    Map<String, String> colors = Map.ofEntries(
        entry("sari", "yellow"),
        entry("kirmizi", "red"),
        entry("yesil", "green"),
        entry("mavi", "blue"),
        entry("siyah", "black"),
        entry("beyaz", "white"),
        entry("pembe", "pink"),
        entry("gri", "gray"),
        entry("mor", "purple"),
        entry("turuncu", "orange"),
        entry("kahverengi", "brown"),
        entry("lacivert", "navy"),
        entry("turkuaz", "aqua"),
        entry("kestane", "maroon"),
        entry("sahra", "tan"),
        entry("sari-yesil", "chartreuse"),
        entry("pembe-mavi", "periwinkle"),
        entry("lacivert-yesil", "teal"),
        entry("siyah-beyaz", "silver"),
        entry("kahverengi-yesil", "olive"),
        entry("kirmizi-sari", "orange"),
        entry("gri-mavi", "slate"),
        entry("kahverengi-gri", "taupe"),
        entry("pembe-kirmizi", "magenta"),
        entry("lacivert-mavi", "indigo"),
        entry("yesil-sari", "lime"),
        entry("siyah-gri", "charcoal"),
        entry("kahverengi-sari", "goldenrod"),
        entry("kirmizi-yesil", "vermilion"),
        entry("gri-yesil", "seagreen"),
        entry("kahverengi-kirmizi", "rust"),
        entry("pembe-sari", "coral"),
        entry("lacivert-kirmizi", "crimson"),
        entry("yesil-mavi", "mint"),
        entry("siyah-sari", "sable"),
        entry("kahverengi-mavi", "cobalt"),
        entry("kirmizi-mavi", "cerulean"),
        entry("gri-kirmizi", "raspberry"),
        entry("kahverengi-pembe", "mauve"),
        entry("sari-mavi", "sky"),
        entry("yesil-siyah", "ebony"),
        entry("kirmizi-siyah", "onyx")
    );

    String generalColor = " #f2f2f2";
    String imageInfo = "";
    int idCounter = 0;
    boolean radioFlag = false;
    boolean dropFlag = false;
    ArrayList<String> radioButtons = new ArrayList<>();
    String radioOrDropText = "";
    
    
    
    
    
    /**
     * Creates new form mainScreen
     */
    public mainScreen() {
        initComponents();
        try {
            var lines = Files.readAllLines(Paths.get("invalidSentences.txt"));
            for(String line:lines) {
                //System.out.println(line);
                set.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            var lines = Files.readAllLines(Paths.get("formSentences.txt"));
            for(String line:lines) {
                //System.out.println(line);
                formSentences.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String putSpaceBeforeBigLetter(String s){
        StringBuilder str = new StringBuilder();
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)-'A' >=0 && s.charAt(i)-'Z'<=0)
                str.append(" ");
            str.append(s.charAt(i));
        }
        
        return str.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOfRequest = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textAreaOfRequest.setColumns(20);
        textAreaOfRequest.setRows(5);
        jScrollPane1.setViewportView(textAreaOfRequest);

        jButton1.setText("Convert to User Interface");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(335, 335, 335))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList<String> reducer(String[] arr){
        ArrayList<String> result = new ArrayList<>();
        String fixText = "";
        boolean isFixText = false;
        for(String s : arr){
            s.replaceAll(" ", "");
            s.replaceAll("\n", "");

            if(s.startsWith("\n")){
                s = s.substring(1);
            }
            if(s.length() == 0) continue;
            
            if(!set.contains(s)){
                if(isFixText){
                    if(s.endsWith("\"")){
                        fixText += s.substring(0,s.length()-1);
                        isFixText = false;
                        result.add(fixText);
                        System.out.println(fixText);
                        fixText = "";
                    }else if(s.endsWith("(")){
                        fixText += s.substring(0,s.length()-2);
                        isFixText = false;
                        radioOrDropText = "        <p>"+ fixText+"</p>\n        <div class=\"checkAndRadio\">\n";
                        radioFlag = true;
                        System.out.println(fixText);
                        fixText = "";
                    }
                    else if(s.endsWith("[")){
                        fixText += s.substring(0,s.length()-2);
                        isFixText = false;
                        radioOrDropText = "        <p>"+ fixText+"</p>\n        <div class=\"checkAndRadio\">\n";
                        dropFlag = true;
                        System.out.println(fixText);
                        fixText = "";
                    }
                    else{
                        fixText+= s+" ";
                    }
                }
                else if(s.startsWith("\"")){
                    
                    if(!s.endsWith("\"")){
                        fixText += s.substring(1)+" ";
                        isFixText = true;
                    }
                    else{
                        result.add(s.substring(1,s.length()-1));
                        System.out.println(s.substring(1,s.length()-1));
                    }
                                        
                }
                else if(radioFlag && !s.equals(")")){ 
                    radioOrDropText += "            <input type=\"radio\" id=\""+ idCounter +"\" name=\""+radioButtons.size()+"\" >\n" +
                    "               <label for=\""+ idCounter++ +"\">"+s+"</label>\n                <br>\n";
                }
                else if(dropFlag && !s.equals("]")){
                    radioOrDropText += "            <input type=\"checkbox\" id=\""+ idCounter +"\" name=\""+radioButtons.size()+"\" >\n" +
                    "               <label for=\""+ idCounter++ +"\">"+s+"</label>        \n                <br>\n";
                }
                else if(colors.containsKey(s)){
                    generalColor = colors.get(s);
                    System.out.println(s+" -> "+generalColor);

                }
                else if(s.startsWith("resim") || s.startsWith("fotograf")){
                    if(s.startsWith("resim")){
                        imageInfo = s.substring(5);
                        System.out.println(s.substring(5));
                    }
                    else{
                        imageInfo = s.substring(8);
                        System.out.println(s.substring(8));
                    }
                }
                else if(s.charAt(s.length()-1) == '('){
                    radioOrDropText = "<p>"+ s.substring(0, s.length()-1)+"</p>\n";
                    radioFlag = true;
                    
                }
                else if(s.charAt(s.length()-1) == '['){
                    radioOrDropText = "<p>"+ s.substring(0, s.length()-1)+"</p>\n";
                    dropFlag = true;
                }
                else if( s.equals(")") ){
                    
                    result.add("Radio");
                    System.out.println("Radio");
                    radioOrDropText+="        </div>\n";
                    radioFlag = false;
                    radioButtons.add(radioOrDropText);
                }
                else if( s.equals("]") ){
                    result.add("Drop");
                    System.out.println("Drop");
                    radioOrDropText+="        </div>\n";
                    dropFlag = false;
                    radioButtons.add(radioOrDropText);
                }
                else{
                    if(formSentences.contains(s)){
                        String temp = putSpaceBeforeBigLetter(s.substring(0, 1).toUpperCase() + s.substring(1));
                        result.add(temp);
                        System.out.println(temp);
                    }
                    else{
                        var yesOrNo = JOptionPane.showConfirmDialog(null, "\""+s+"\" forma eklenecek mi ?");
                        if (yesOrNo == 0) {
                          JOptionPane.showMessageDialog(null, "Forma eklendi");
                           try {
                                FileWriter writer = new FileWriter("formSentences.txt", true);
                                writer.write(s+"\n");
                                writer.close();
                                System.out.println("Text appended to file successfully.");
                                String temp = putSpaceBeforeBigLetter(s.substring(0, 1).toUpperCase() + s.substring(1));
                                result.add(temp);
                                System.out.println(temp);
                                formSentences.add(s);

                            } catch (IOException e) {
                                System.out.println("An error occurred while appending text to the file.");
                                e.printStackTrace();
                            }
                        }
                        if (yesOrNo == 1) { 
                          JOptionPane.showMessageDialog(null, "Forma eklenmedi yardimlariniz icin tesekkurler");
                          
                          try {
                                FileWriter writer = new FileWriter("invalidSentences.txt", true);
                                writer.write(s+"\n");
                                writer.close();
                                System.out.println("Text appended to file successfully.");
                                set.add(s);

                            } catch (IOException e) {
                                System.out.println("An error occurred while appending text to the file.");
                                e.printStackTrace();
                            }
                          
                        }
                        if (yesOrNo == 2) { 
                          JOptionPane.showMessageDialog(null, "Forma eklenmedi.");
                        }
                    }
                    
                }
                
            }
            

        }
        
        return result;
            
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[] words = textAreaOfRequest.getText().split(" ");
        File yourFile = new File("result.html");
        File yourFile2 = new File("result1.html");
        File yourFile3 = new File("result2.html");
        ArrayList<String> reducedText = reducer(words);
        int radioCounter = 0;
        int idStart = idCounter;
        int tempIdStart = idCounter;
        
        try { 
            yourFile.createNewFile(); // if file already exists will do nothing 
            FileOutputStream oFile = new FileOutputStream(yourFile, false);
            PrintStream printStream = new PrintStream(oFile);
            printStream.print("<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "<style>\n" +
                                "input[type=text], select {\n" +
                                "  width: 100%;\n" +
                                "  padding: 12px 20px;\n" +
                                "  margin: 8px 0;\n" +
                                "  display: inline-block;\n" +
                                "  border: 1px solid #ccc;\n" +
                                "  border-radius: 4px;\n" +
                                "  box-sizing: border-box;\n" +
                                "}\n" +
                                "img {"+
                                "  display: block;\n"+
                                "  margin-left: auto;\n"+
                                "  margin-right: auto;\n"+
                                "  width: 50%;\n"+
                                "  border-radius: 50%;\n"+
                                "}\n"+
                                "\n" +
                                "input[type=submit] {\n" +
                                "  width: 100%;\n" +
                                "  background-color: #4CAF50;\n" +
                                "  color: white;\n" +
                                "  padding: 14px 20px;\n" +
                                "  margin: 8px 0;\n" +
                                "  border: none;\n" +
                                "  border-radius: 4px;\n" +
                                "  cursor: pointer;\n" +
                                "}\n" +
                                "\n" +
                                "input[type=submit]:hover {\n" +
                                "  background-color: #45a049;\n" +
                                "}\n" +
                                "\n" +
                                "div {\n" +
                                "  border-radius: 5px;\n" +
                                "  background-color: "+generalColor+";\n" +
                                "  padding: 20px;\n" +
                                "}\n" +
                                "</style>\n" +
                                "<body>\n" +
                                "\n" +
                                "\n" +
                                "<div>\n" +
                                "  <form >");
            
            
            
            // Our things will be added to here
            if(imageInfo.length()!=0){
                printStream.print("\n        <img src=\"./images/"+imageInfo+".jpg"+"\" alt=\""+imageInfo+"\">\n");
            }
            
            for(String s : reducedText){
                if(s.equals("Radio")){
                    printStream.print(radioButtons.get(radioCounter++));
                    //radioButtons.remove(0);
                }
                else if(s.equals("Drop")){
                    printStream.print(radioButtons.get(radioCounter++));
                    //radioButtons.remove(0);
                }
                else{
                    printStream.print("\n<label for=\""+s+"\">"+s+"</label>\n" +
                                  "<input type=\"text\" id=\""+idCounter++ +"\" name=\""+s+"\" placeholder=\"" +s+"\">");
                }
           }
            
            
            
            
            
            printStream.print("<input id=\"submit\" type=\"submit\" value=\"Gonder\">\n" +
                                "  </form>\n" +
                                "</div>\n" +
                                "\n" +
                                "<script src=\"https://cdn.jsdelivr.net/npm/file-saver@2.0.2/dist/FileSaver.min.js\"></script>"+
                                "<script src=\"./main.js\"></script>"+
                                "</body>\n" +
                                "</html>");


            printStream.close();
            
            
            
            
            //Result2
            radioCounter = 0;
            yourFile2.createNewFile(); // if file already exists will do nothing 
            FileOutputStream oFile2 = new FileOutputStream(yourFile2, false);
            PrintStream printStream2 = new PrintStream(oFile2);
            printStream2.print("<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "<style>\n" +
                                
                                "   img {\n"+
                                "       display: block;\n"+
                                "       margin-left: auto;\n"+
                                "       margin-right: auto;\n"+
                                "       width: 50%;\n"+
                                "       border-radius: 50%;\n"+
                                "   }\n"+
                                "\n" +
                                "   label {\n" +
                                "       font-size: 1.2em;\n" +
                                "       font-weight: bold;\n" +
                                "       margin-right: 10px;\n" +
                                "   }\n" +
                                "\n" +
                                "   input[type=\"text\"], input[type=\"email\"], input[type=\"password\"] {\n" +
                                "       padding: 10px;\n" +
                                "       font-size: 1.2em;\n" +
                                "       margin-bottom: 20px;\n" +
                                "       border-radius: 5px;\n" +
                                "       border: 1px solid gray;\n" +
                                "   }\n" +
                                "\n" +
                                "   input[type=\"submit\"] {\n" +
                                "       background-color: blue;\n" +
                                "       color: white;\n" +
                                "       padding: 10px 20px;\n" +
                                "       border-radius: 5px;\n" +
                                "       border: none;\n" +
                                "       cursor: pointer;\n" +
                                "   }"+
                            
                                "\n" +
                                "   input[type=submit]:hover {\n" +
                                "       background-color: darkblue;\n" +
                                "   }\n" +
                                "\n" +
                                "   div {\n" +
                                "       border-radius: 5px;\n" +
                                "       display:flex;\n"+
                                "       align-items: center;\n"+
                                "       justify-content: center;\n"+
                                
                                "       width: 100%;\n"+
                                "       padding: 20px;\n" +
                                "   }\n" +
                                "   .formdiv {\n" +
                                "       border-radius: 5px;\n" +
                                "       display:flex;\n"+
                                "       align-items: center;\n"+
                                "       justify-content: center;\n"+
                                "       background-color: "+generalColor+";\n" +
                                "       width: 60%;\n"+
                                "       padding: 20px;\n" +
                                "   }\n" +
                                "   form {\n" +
                                "       display:flex;\n"+

                                "       align-items: center;\n"+
                                "       justify-content: center;\n"+
                                "       flex-direction: column;\n"+
                                "   }\n" +
                                "   .checkAndRadio{\n" +
                                "       display:flex;\n" +
                                "       align-items: center;\n" +
                                "       justify-content: center;\n" +
                                "   }"+
                                "</style>\n" +
                                "<body>\n" +
                                "\n" +
                                "\n" +
                                "<div>\n" +
                                "<div class= \"formdiv\">\n" +
                                "  <form >");
            
            
            
            // Our things will be added to here
            if(imageInfo.length()!=0){
                printStream2.print("\n        <img src=\"./images/"+imageInfo+".jpg"+"\" alt=\""+imageInfo+"\">\n");
            }
            
            for(String s : reducedText){
                if(s.equals("Radio")){
                    printStream2.print(radioButtons.get(radioCounter++));
                    //radioButtons.remove(0);
                }
                else if(s.equals("Drop")){
                    printStream2.print(radioButtons.get(radioCounter++));
                    //radioButtons.remove(0);
                }
                else{
                    printStream2.print("\n        <label for=\""+s+"\">"+s+"</label>\n" +
                                  "        <input type=\"text\" id=\""+tempIdStart++ +"\" name=\""+s+"\" placeholder=\"" +s+"\"> \n        <br/>");
                }
           }
            
            
            
            
            
            printStream2.print("        <input id=\"submit\" type=\"submit\" value=\"Gonder\">\n" +
                                "   </form>\n" +
                                "</div>\n" +
                                "</div>\n" +
                                "\n" +
                                "<script src=\"https://cdn.jsdelivr.net/npm/file-saver@2.0.2/dist/FileSaver.min.js\"></script>"+
                                "<script src=\"./main.js\"></script>"+
                                "</body>\n" +
                                "</html>");


            printStream2.close();
            
            
            
            
            
            tempIdStart = idStart;
            //Result3
            radioCounter = 0;
            yourFile3.createNewFile(); // if file already exists will do nothing 
            FileOutputStream oFile3 = new FileOutputStream(yourFile3, false);
            PrintStream printStream3 = new PrintStream(oFile3);
            printStream3.print("<!DOCTYPE html>\n" +
                                "<html>\n" +
                                "<style>\n" +
                                "   input {\n" +
                                "       caret-color: red;\n" +
                                "   }\n" +
                                "\n" +
                                "   body {\n" +
                                "       margin: 0;\n" +
                                "       width: 100vw;\n" +
                                "       height: 100%;\n" +
                                "       background: #ecf0f3;\n" +
                                "       display: flex;\n" +
                                "       align-items: center;\n" +
                                "       text-align: center;\n" +
                                "       justify-content: center;\n" +
                                "       place-items: center;\n" +
                                "       overflow: auto;\n" +
                                "       font-family: poppins;\n" +
                                "   }\n" +
                                "\n" +
                                    "   img {\n"+
                                "       display: block;\n"+
                                "       margin-left: auto;\n"+
                                "       margin-right: auto;\n"+
                                "       width: 50%;\n"+
                                "       border-radius: 50%;\n" +
                                "       box-sizing: border-box;\n" +
                                "       box-shadow: 7px 7px 10px #cbced1, -7px -7px 10px white;\n" +
                                "   }\n"+
                                "   .checkAndRadio{\n" +
                                "       display:flex;\n" +
                                "       align-items: center;\n" +
                                "       justify-content: center;\n" +
                                "       box-sizing: none;\n" +
                                "   }"+
                                "   .container {\n" +
                                "       position: relative;\n" +
                                "       width: 500px;\n" +
                                "       height: 100%;\n" +
                                "       border-radius: 20px;\n" +
                                "       padding: 40px;\n" +
                                "       box-sizing: border-box;\n" +
                                "       background: "+generalColor+";\n" +
                                "       box-shadow: 14px 14px 20px #cbced1, -14px -14px 20px white;\n" +
                                "   }\n" +
                                "\n" +
                                "\n" +
                                "   .inputs {\n" +
                                "       text-align: left;\n" +
                                "       margin-top: 30px;\n" +
                                "   }\n" +
                                "\n" +
                                "   label, input, button {\n" +
                                "       display: block;\n" +
                                "       width: 100%;\n" +
                                "       padding: 0;\n" +
                                "       border: none;\n" +
                                "       outline: none;\n" +
                                "       box-sizing: border-box;\n" +
                                "   }\n" +
                                "\n" +
                                "   label {\n" +
                                "       margin-bottom: 4px;\n" +
                                "   }\n" +
                                "\n" +
                                "   label:nth-of-type(2) {\n" +
                                "       margin-top: 12px;\n" +
                                "   }\n" +
                                "\n" +
                                "   input::placeholder {\n" +
                                "       color: gray;\n" +
                                "   }\n" +
                                "\n" +
                                "   input {\n" +
                                "       background: #ecf0f3;\n" +
                                "       padding: 10px;\n" +
                                "       padding-left: 20px;\n" +
                                "       height: 50px;\n" +
                                "       font-size: 14px;\n" +
                                "       border-radius: 50px;\n" +
                                "       box-shadow: inset 6px 6px 6px #cbced1, inset -6px -6px 6px white;\n" +
                                "   }\n" +
                                "\n" +
                                "   button {\n" +
                                "       color: white;\n" +
                                "       margin-top: 20px;\n" +
                                "       background: #1DA1F2;\n" +
                                "       height: 40px;\n" +
                                "       border-radius: 20px;\n" +
                                "       cursor: pointer;\n" +
                                "       font-weight: 900;\n" +
                                "       box-shadow: 6px 6px 6px #cbced1, -6px -6px 6px white;\n" +
                                "       transition: 0.5s;\n" +
                                "   }\n" +
                                "\n" +
                                "   button:hover {\n" +
                                "       box-shadow: none;\n" +
                                "   }"+
                               
                                "</style>\n" +
                                "<body>\n" +
                                "\n" +
                                "\n" +
                                "<div class=\"container\">\n" +
                                "  <div class=\"inputs\">");
            
            
            
            // Our things will be added to here
            if(imageInfo.length()!=0){
                printStream3.print("\n        <img src=\"./images/"+imageInfo+".jpg"+"\" alt=\""+imageInfo+"\">\n");
            }
            
            for(String s : reducedText){
                if(s.equals("Radio")){
                    printStream3.print(radioButtons.get(radioCounter++));
                    //radioButtons.remove(0);
                }
                else if(s.equals("Drop")){
                    printStream3.print(radioButtons.get(radioCounter++));
                    //radioButtons.remove(0);
                }
                else{
                    printStream3.print("\n        <label for=\""+s+"\">"+s+"</label>\n" +
                                  "        <input type=\"text\" id=\""+tempIdStart++ +"\" name=\""+s+"\" placeholder=\"" +s+"\"> \n        <br/>");
                }
           }
            
            
            
            
            
            printStream3.print("        <button id=\"submit\" type=\"submit\">Gonder</button>\n" +
                                "   </div>\n" +
                                "</div>\n" +
                                "\n" +
                                "</body>\n" +
                                "<script src=\"https://cdn.jsdelivr.net/npm/file-saver@2.0.2/dist/FileSaver.min.js\"></script>\n"+
                                "<script src=\"./main.js\"></script>\n"+
                                "</html>"); 


            printStream3.close();
            
            
            
            
            
            try {
                FileWriter writer = new FileWriter("totalNumber.txt");
                writer.write(Integer.toString(idCounter));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
             
            System.out.println("Total "+idCounter+" input and label created");
            idCounter = 0;
            
            
            
            
            
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) {
            Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaOfRequest;
    // End of variables declaration//GEN-END:variables
}
