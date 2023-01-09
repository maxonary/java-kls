import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.LayoutManager.*;
import java.awt.Color.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.Date;
import java.text.*;

public class HinzufuegenGUI extends DBHelper
{
    /**In dieser Klasse können neue Schüler des Internats manuell hinzugefügt werden.**/
    
    /**Persönliche Daten des Schülers**/
    /**Nachname des Kindes**/ 
      JTextField nachname = new JTextField("Nachname des Schülers");
    
    /**Vorname des Kindes**/
      JTextField vorname = new JTextField("Vorname des Schülers");
     
    /**Geburtsdatum des Kindes**/
      JLabel txtGeburtsdatum = new JLabel("Geburtsdatum des Schülersindes");
      JButton geburtstagButton = new JButton("Get Date");
      SpinnerDateModel GebSpinMod = new SpinnerDateModel();
      JSpinner geburtsdatum = new JSpinner(GebSpinMod);
      
      class geburtstagHandler implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            JSpinner.DateEditor de=(JSpinner.DateEditor)geburtsdatum.getEditor();
            String okDate=de.getFormat().format(geburtsdatum.getValue());
            System.out.println(okDate);
        }
    }
      
      
      
    /**Straße**/
      JTextField strasse = new JTextField("Straße des Schülers");
    
    /**Hausnummer**/
      JTextField hausnummer = new JTextField("Hausnummer");
    
    /**Postleitzahl**/ 
      JTextField postleitzahl = new JTextField("PLZ des Schülers");
    
    /**Ort**/
      JTextField ort = new JTextField("Wohnort des Schülers");
    
    
    /**Persönliche Schul- und Internatsdaten des Schülers**/
    /**Schultyp**/
      String[] Schultyp = {"Schultyp (bitte Auswählen)","Grundschule", "Gymnasium", "Sekudarschule", "Oberstufe"};
      JComboBox schultyp = new JComboBox(Schultyp);
    
    /**Klasse**/
      JLabel txtKlasse = new JLabel("momentane Klassenstufe"); 
      Integer[] Klasse = {1, 2, 3 ,4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
      JComboBox klasse = new JComboBox(Klasse);
      
    /**Wahlpflichtkurs**/
      //Nur auf die gymnasialen Klassen 9 - 10 bezogen
      String[] Wahlpflichtkurs = {"Wahlpflichtkurs (nur gymansiale Klassen 9-10)","undefiniert","Biologie","Informatik","Kunst","Musik","NaWi","Spanisch","Theater"};
      JComboBox wahlpflichtkurs = new JComboBox(Wahlpflichtkurs);
      
    /**Schul Beitrittsdatum**/
      JLabel txtKLSBeitrittDatum= new JLabel("Beitrittsdatum der KLS"); 
      JButton beitrittButton = new JButton("Get Date");
      SpinnerDateModel BeiSpinMod = new SpinnerDateModel();
      JSpinner KLSBeitrittDatum = new JSpinner(BeiSpinMod);
      
      class beitrittHandler implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            JSpinner.DateEditor de=(JSpinner.DateEditor)KLSBeitrittDatum.getEditor();
            String okDate=de.getFormat().format(KLSBeitrittDatum.getValue());
            System.out.println(okDate);
        }
    }
      
      
    /**Zimmer im Internat**/
      JLabel txtZimmer = new JLabel("Ort und Zimmernummer");
      String[] ZimmerOrt = {"Haus im Park (ab 6 Jahren)", "Gartenhaus (ab 12 Jahren)", "Dachetage (ab 14 Jahren)"};
      JComboBox zimmerOrt = new JComboBox(ZimmerOrt);
      Integer[] ZimmerNr = {1,2,3,4,5};
      JComboBox zimmerNr = new JComboBox(ZimmerNr);    
      
    /**Förderbedarf**/
      JLabel txtFoerderbedarf = new JLabel("Förderbedarf?");
      String[] Foerderbedarf = {"Nein", "Ja"};
      JComboBox foerderbedarf = new JComboBox(Foerderbedarf);
    
    
    /**Daten des Erziehungsberechtigten des Schülers (bitte nur einen Erziehungsberechtigten eintragen)**/
    /**Nachname des Erziehungsberechtigten**/
      JTextField EBNachname = new JTextField("Nachname eines Erzehiungsberechtigten");
    
    /**Vorname des Erziehungsberechtigten**/
      JTextField EBVorname = new JTextField("Vorname des Erzehiungsberechtigten");
    
    /**Straße**/
      JTextField EBStrasse = new JTextField("Straße des Erzehiungsberechtigten");
    
    /**Hausnummer**/
      JTextField EBHausnummer = new JTextField("Hausnummer des Erzehiungsberechtigten");
    
    /**Postleitzahl**/
      JTextField EBPostleitzahl = new JTextField("PLZ des Erzehiungsberechtigten");
    
    /**Ort**/
      JTextField EBOrt = new JTextField("Wohnort des Erzehiungsberechtigten");
    
    /**E-Mail des Erziehungsberechtigten**/
      JTextField EBEmail = new JTextField("E-Mail des Erzehiungsberechtigten");
    
    /**Festnetztelefonnummer des Erziehungsberechtigten**/
      JTextField EBTelefon = new JTextField("Festnetztelefonnummer des Erziehungsberechtigten");
    
    /**Mobiltelefon- / Handynummer des Erziehungsberechtigten**/
      JTextField EBHandy = new JTextField("Mobiltelefon- / Handynummer des Erziehungsberechtigten");
    
      
    /**Anmerkungen zum Schüler**/
      JTextField anmerkungen = new JTextField("Anmerkungen...");
    
    
    /**Designelemente für Swing / weitere Variablen**/
      public String datenKind;
      public String datenEltern;
    
      private JFrame window;
      JPanel panel = new JPanel();
    
      
      private JButton add;
    
      private JLabel platzhalter;
        
      private JLabel anhang1;
      private JLabel anhang2;
    
    
    public HinzufuegenGUI()
    {
        window = new JFrame("Schüler zur Datenbank hinzufügen");
        window.setSize(700,400);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.WHITE);
        
        /**Elemente zum Panel im Border Layout hinzufügen**/
        /**Persönliche Daten des Schülers LINE_START**/
        
        panel.add(nachname, BorderLayout.LINE_START);
        panel.add(vorname, BorderLayout.LINE_START);
 
            /**Geburtsdatum des Kindes**/
        panel.add(txtGeburtsdatum, BorderLayout.LINE_START);
        geburtstagButton.addActionListener(new geburtstagHandler());
        panel.add(geburtstagButton, BorderLayout.LINE_START);
        geburtsdatum.setValue(new Date());
        geburtsdatum.setEditor(new JSpinner.DateEditor(geburtsdatum,"dd.MM.yyyy"));
        panel.add(geburtsdatum, BorderLayout.LINE_START);
        
        panel.add(strasse, BorderLayout.LINE_START);
        panel.add(hausnummer, BorderLayout.LINE_START);
        panel.add(postleitzahl, BorderLayout.LINE_START);
        panel.add(ort, BorderLayout.LINE_START);
        
        
        /**Persönliche Schul- und Internatsdaten des Schülers CENTER**/
        panel.add(schultyp, BorderLayout.CENTER);
        panel.add(txtKlasse, BorderLayout.CENTER);
        panel.add(klasse, BorderLayout.CENTER);
        panel.add(wahlpflichtkurs, BorderLayout.CENTER);
        
            /**Beitrittsdatum der KLS des Kindes**/
        panel.add(txtKLSBeitrittDatum, BorderLayout.CENTER);
        beitrittButton.addActionListener(new beitrittHandler());
        panel.add(beitrittButton, BorderLayout.CENTER);
        KLSBeitrittDatum.setValue(new Date());
        KLSBeitrittDatum.setEditor(new JSpinner.DateEditor(KLSBeitrittDatum,"dd.MM.yyyy"));
        panel.add(KLSBeitrittDatum, BorderLayout.CENTER);
        
        
        panel.add(txtZimmer, BorderLayout.CENTER);
        panel.add(zimmerOrt, BorderLayout.CENTER);
        panel.add(zimmerNr, BorderLayout.CENTER);
        panel.add(txtFoerderbedarf, BorderLayout.CENTER);
        panel.add(foerderbedarf, BorderLayout.CENTER);
        
 
        /**Daten des Erziehungsberechtigten des Schülers LINE_EDND*/
        panel.add(EBNachname, BorderLayout.LINE_END);
        panel.add(EBVorname, BorderLayout.LINE_END);
        panel.add(EBStrasse, BorderLayout.LINE_END);
        panel.add(EBHausnummer, BorderLayout.LINE_END);
        panel.add(EBPostleitzahl, BorderLayout.LINE_END);
        panel.add(EBOrt, BorderLayout.LINE_END);
        panel.add(EBEmail, BorderLayout.LINE_END);
        panel.add(EBTelefon, BorderLayout.LINE_END);
        panel.add(EBHandy, BorderLayout.LINE_END);
        
        
        /**Anerkungen PAGE_END**/
        anmerkungen.setPreferredSize(new Dimension(380, 200));
        panel.add(anmerkungen, BorderLayout.PAGE_END);
       

         /** INSERT Knopf **/
         /**add = new JButton("Fertig");
         add.setPreferredSize(new Dimension(372, 20));
         panel.add(add);
         add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) { 
              String variableSchultyp = schultyp.getSelectedItem().toString();
              //String variableDatum = datum.getText();
              String variablePrioritaet = klasse.getSelectedItem().toString();
              String variableAnmerkungen = anmerkungen.getText();
              
            //  datenKind = variableSchultyp+", "+variableDatum+", "+variablePrioritaet+" ,"+variableAnmerkungen;

              System.out.println(datenKind);
              
              
                                                          
            }
           });
           
        platzhalter = new JLabel(" ");
        platzhalter.setPreferredSize(new Dimension(370, 20));
        panel.add(platzhalter);
        **/
        
        anhang1 = new JLabel("Bitte alle Textfelder ausfüllen!");
        panel.add(anhang1);
        anhang2 = new JLabel("Alle vorherigen Eingaben ersetzen.");
        panel.add(anhang2);
        
        window.add(panel);
        window.setVisible(true);
    }
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            HinzufuegenGUI tdate = new HinzufuegenGUI();
        }
        });
    }
     
}
