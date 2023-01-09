import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
public class HinzufuegenGUI
{
    /**In dieser Klasse können neue Schüler des Internats manuell hinzugefügt werden.**/
    
    /**Persönliche Daten des Schülers**/
    /**Nachname des Kindes**/ 
      JTextField nachname = new JTextField("Nachname des Schülers");
    
    /**Vorname des Kindes**/
      JTextField vorname = new JTextField("Vorname des Schülers");
     
    /**Geburtsdatum des Kindes**/
      JLabel txtGeburtsdatum = new JLabel("Geburtsdatum des Schülers");
      JButton geburtstagButton = new JButton("Get Date");
      SpinnerDateModel GebSpinMod = new SpinnerDateModel();
      JSpinner geburtsdatum = new JSpinner(GebSpinMod);
      
      
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
      JLabel txtKlasse = new JLabel(" momentane Klassenstufe"); 
      Integer[] Klasse = {1, 2, 3 ,4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
      JComboBox klasse = new JComboBox(Klasse);
      
    /**Wahlpflichtkurs**/
      //Nur auf die gymnasialen Klassen 9 - 10 bezogen
      String[] Wahlpflichtkurs = {"Wahlpflichtkurs (nur gymansiale Klassen 9-10)","undefiniert","Biologie","Informatik","Kunst","Musik","NaWi","Spanisch","Theater"};
      JComboBox wahlpflichtkurs = new JComboBox(Wahlpflichtkurs);
      
    /**Schul Beitrittsdatum**/
      JLabel txtKLSBeitrittDatum= new JLabel(" Beitrittsdatum der KLS"); 
      JButton beitrittButton = new JButton("Get Date");
      SpinnerDateModel BeiSpinMod = new SpinnerDateModel();
      JSpinner KLSBeitrittDatum = new JSpinner(BeiSpinMod);
      
    /**Zimmer im Internat**/
      JLabel txtZimmer = new JLabel(" Ort und Zimmernummer");
      String[] ZimmerOrt = {"Haus im Park (ab 6 Jahren)", "Gartenhaus (ab 12 Jahren)", "Dachetage (ab 14 Jahren)"};
      JComboBox zimmerOrt = new JComboBox(ZimmerOrt);
      Integer[] ZimmerNr = {1,2,3,4,5};
      JComboBox zimmerNr = new JComboBox(ZimmerNr);    
      
    /**Förderbedarf**/
      JLabel txtFoerderbedarf = new JLabel(" Förderbedarf?");
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

      //Das Fenster wird an die y_achsen Höhe des Bildschirms angepasst
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      
      private JButton add;
    
      private JLabel platzhalter;
        
      private JLabel anhang1;
      private JLabel anhang2;
    
    public HinzufuegenGUI()
    {
        window = new JFrame("Schüler zur Datenbank hinzufügen");
        window.setSize(450,screenSize.height);
        window.setLocationRelativeTo(null);
        panel.setBackground(Color.LIGHT_GRAY);
        
        
        /**Elemente zum Panel im Border Layout hinzufügen**/
        /**Persönliche Daten des Schülers LINE_START**/
        
        panel.add(nachname, BorderLayout.LINE_START);
        nachname.setPreferredSize(new Dimension(382, 20));
        panel.add(vorname, BorderLayout.LINE_START);
        vorname.setPreferredSize(new Dimension(382, 20));
 
            /**Geburtsdatum des Kindes**/
        panel.add(txtGeburtsdatum, BorderLayout.LINE_START);
        txtGeburtsdatum.setPreferredSize(new Dimension(382, 20));
        geburtsdatum.setValue(new Date());
        geburtsdatum.setEditor(new JSpinner.DateEditor(geburtsdatum,"dd.MM.yyyy"));
        panel.add(geburtsdatum, BorderLayout.LINE_START);
        geburtsdatum.setPreferredSize(new Dimension(382, 20));
        
        panel.add(strasse, BorderLayout.LINE_START);
        strasse.setPreferredSize(new Dimension(382, 20));
        panel.add(hausnummer, BorderLayout.LINE_START);
        hausnummer.setPreferredSize(new Dimension(382, 20));
        panel.add(postleitzahl, BorderLayout.LINE_START);
        postleitzahl.setPreferredSize(new Dimension(382, 20));
        panel.add(ort, BorderLayout.LINE_START);
        ort.setPreferredSize(new Dimension(382, 20));
        
        
        /**Persönliche Schul- und Internatsdaten des Schülers LINE_START**/
        panel.add(schultyp, BorderLayout.LINE_START);
        schultyp.setPreferredSize(new Dimension(382, 20));
        panel.add(txtKlasse, BorderLayout.LINE_START);
        txtKlasse.setPreferredSize(new Dimension(382, 20));
        panel.add(klasse, BorderLayout.LINE_START);
        klasse.setPreferredSize(new Dimension(382, 20));
        panel.add(wahlpflichtkurs, BorderLayout.LINE_START);
        wahlpflichtkurs.setPreferredSize(new Dimension(382, 20));
        
            /**Beitrittsdatum der KLS des Kindes**/
        panel.add(txtKLSBeitrittDatum, BorderLayout.LINE_START);
        txtKLSBeitrittDatum.setPreferredSize(new Dimension(382, 20));
        KLSBeitrittDatum.setValue(new Date());
        KLSBeitrittDatum.setEditor(new JSpinner.DateEditor(KLSBeitrittDatum,"dd.MM.yyyy"));
        panel.add(KLSBeitrittDatum, BorderLayout.LINE_START);
        KLSBeitrittDatum.setPreferredSize(new Dimension(382, 20));
        
        
        panel.add(txtZimmer, BorderLayout.LINE_START);
        txtZimmer.setPreferredSize(new Dimension(382, 20));
        panel.add(zimmerOrt, BorderLayout.LINE_START);
        zimmerOrt.setPreferredSize(new Dimension(382, 20));
        panel.add(zimmerNr, BorderLayout.LINE_START);
        zimmerNr.setPreferredSize(new Dimension(382, 20));
        panel.add(txtFoerderbedarf, BorderLayout.LINE_START);
        txtFoerderbedarf.setPreferredSize(new Dimension(382, 20));
        panel.add(foerderbedarf, BorderLayout.LINE_START);
        foerderbedarf.setPreferredSize(new Dimension(382, 20));
        
        /**Anmerkungen CENTER**/
        anmerkungen.setPreferredSize(new Dimension(382, 200));
        panel.add(anmerkungen, BorderLayout.CENTER);
        
        
        /**Daten des Erziehungsberechtigten des Schülers LINE_END*/
        panel.add(EBNachname, BorderLayout.LINE_END);
        EBNachname.setPreferredSize(new Dimension(382, 20));
        panel.add(EBVorname, BorderLayout.LINE_END);
        EBVorname.setPreferredSize(new Dimension(382, 20));
        panel.add(EBStrasse, BorderLayout.LINE_END);
        EBStrasse.setPreferredSize(new Dimension(382, 20));
        panel.add(EBHausnummer, BorderLayout.LINE_END);
        EBHausnummer.setPreferredSize(new Dimension(382, 20));
        panel.add(EBPostleitzahl, BorderLayout.LINE_END);
        EBPostleitzahl.setPreferredSize(new Dimension(382, 20));
        panel.add(EBOrt, BorderLayout.LINE_END);
        EBOrt.setPreferredSize(new Dimension(382, 20));
        panel.add(EBEmail, BorderLayout.LINE_END);
        EBEmail.setPreferredSize(new Dimension(382, 20));
        panel.add(EBTelefon, BorderLayout.LINE_END);
        EBTelefon.setPreferredSize(new Dimension(382, 20));
        panel.add(EBHandy, BorderLayout.LINE_END);
        EBHandy.setPreferredSize(new Dimension(382, 20));
        
        
       
        platzhalter = new JLabel(" ");
        platzhalter.setPreferredSize(new Dimension(382, 20));
        panel.add(platzhalter, BorderLayout.PAGE_END);
        
        
         /** INSERT Knopf **/
         add = new JButton("Fertig");
         add.setPreferredSize(new Dimension(382, 20));
         panel.add(add, BorderLayout.PAGE_END);
         add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) { 
              String variableNachname = nachname.getText();
              String variableVorname = vorname.getText();
              
              JSpinner.DateEditor gebDe=(JSpinner.DateEditor)geburtsdatum.getEditor();
              String variableGeburstdatum=gebDe.getFormat().format(geburtsdatum.getValue());
              
              String variableStrasse = strasse.getText();
              String variableHausnummer = hausnummer.getText();
              String variablePostleitzahl = postleitzahl.getText();
              String variableOrt = ort.getText();
              String variableSchultyp = schultyp.getSelectedItem().toString();
              String variableKlasse = klasse.getSelectedItem().toString();
              String variableWahlpflichtkurs = wahlpflichtkurs.getSelectedItem().toString();
              
              JSpinner.DateEditor beiDe=(JSpinner.DateEditor)KLSBeitrittDatum.getEditor();
              String variableKLSBeitrittDatum = beiDe.getFormat().format(KLSBeitrittDatum.getValue());
              
              String variableZimmerOrt = zimmerOrt.getSelectedItem().toString();
              String variableZimmerNr = zimmerNr.getSelectedItem().toString();
              String variableFoerderbedarf = foerderbedarf.getSelectedItem().toString();
              String variableAnmerkungen = anmerkungen.getText();
              
              
              String variableEBNachname = EBNachname.getText();
              String variableEBVorname = EBNachname.getText();
              String variableEBStrasse = EBStrasse.getText();
              String variableEBHausnummer = EBHausnummer.getText();
              String variableEBPostleitzahl = EBPostleitzahl.getText();
              String variableEBOrt = EBOrt.getText();
              String variableEBEmail = EBEmail.getText();
              String variableEBTelefon = EBTelefon.getText();
              String variableEBHandy = EBHandy.getText();
  
              
              datenKind = 
              variableNachname+", "
              +variableVorname+", "
              +variableGeburstdatum+", "
              +variableStrasse+", "
              +variableHausnummer+", "
              +variablePostleitzahl+", "
              +variableOrt+", "
              
              +variableSchultyp+", "
              +variableKlasse+", "
              +variableWahlpflichtkurs+", "
              +variableKLSBeitrittDatum+", "
              +variableFoerderbedarf+", "
              +variableAnmerkungen;
              
              
              datenEltern = 
              variableEBNachname+", "
              +variableEBVorname+", "
              +variableEBStrasse+", "
              +variableEBHausnummer+", "
              +variableEBPostleitzahl+", "
              +variableEBOrt+", "
              +variableEBEmail+", "
              +variableEBTelefon+", "
              +variableEBHandy;

              System.out.println(datenKind);
              System.out.println(datenEltern);
              
                                                          
            }
           });
         
         
        /**Weitere Designelemente PAGE_END**/
 
        anhang1 = new JLabel("Bitte alle Textfelder ausfüllen!");
        panel.add(anhang1, BorderLayout.PAGE_END);
        anhang1.setPreferredSize(new Dimension(382, 20));
        
        anhang2 = new JLabel("Alle vorherigen Eingaben ersetzen.");
        panel.add(anhang2, BorderLayout.PAGE_END);
        anhang2.setPreferredSize(new Dimension(382, 20));

        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
