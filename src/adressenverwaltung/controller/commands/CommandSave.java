/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller.commands;

import adressenverwaltung.model.AdressenverwaltungModel;
import adressenverwaltung.view.AdressenverwaltungView;
import java.io.File;
//import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Nutzt den Polymorphismus Implementiert das Command-Design-Pattern Funktion:
 * Öffnen und Einlesen einer Textdatei
 *
 * @author le
 * @see CommandInterface
 */
public class CommandSave implements CommandInterface
{

  private AdressenverwaltungView view;
  private AdressenverwaltungModel model;
  

  public CommandSave(AdressenverwaltungView view, AdressenverwaltungModel model)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    view.getFcDatei().setCurrentDirectory(new File(model.getLastFolder()));
    JFileChooser fc = view.getFcDatei();
    int choice = fc.showSaveDialog(view);
    if (choice == JFileChooser.APPROVE_OPTION)
    {     
      File datei = view.getFcDatei().getSelectedFile();
      String dateiname = datei.getAbsolutePath();
      view.getLblStatus().setText("File:" + dateiname);
      model.setLastFolder(datei.getParent());
      
      try
      {
        model.datenSpeichern(datei);
      }
      catch(Exception ex)
      {
        String ausgabe = "Fehlermeldung: Konnte Datei nicht speichern";
        JOptionPane.showMessageDialog(view, ausgabe);        
      }
    
    }
    //zeile = new Zeile();
    //view.getTbleAdressenverwaltung().setValueAt("Command SAVE not implemented",0,0);
  }

  
  @Override
  public void undo()
  {
    
  }

  /**
   *
   * @return true falls Kommando sinnvoll rückgängig gemacht werden kann
   */
  @Override
  public boolean isUndoable()
  {
    return false;
  }
}
