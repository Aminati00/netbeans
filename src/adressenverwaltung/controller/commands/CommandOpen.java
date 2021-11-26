/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller.commands;

import adressenverwaltung.model.AdressenverwaltungModel;
import adressenverwaltung.view.AdressenverwaltungView;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Nutzt den Polymorphismus Implementiert das Command-Design-Pattern Funktion:
 * Öffnen und Einlesen einer Textdatei
 *
 * @author le
 * @see CommandInterface
 */
public class CommandOpen implements CommandInterface
{

  private AdressenverwaltungView view;
  private AdressenverwaltungModel model;

  public CommandOpen(AdressenverwaltungView view, AdressenverwaltungModel model)
  {
    this.view = view;
    this.model = model;
  }

  @Override
  public void execute()
  {
    //Preferences
    view.getFcDatei().setCurrentDirectory(new File(model.getLastFolder()));
    JFileChooser fc = view.getjFileChooser1();
    int choice = fc.showOpenDialog(view);
    
    if (choice == JFileChooser.APPROVE_OPTION)
    {
      //model.getLastPath();
      File f = fc.getSelectedFile();
      view.getLblStatus().setText("File: " + f.getAbsolutePath());
      model.setLastFolder(f.getParent()); 
      
      try
      {
        model.datenLesen(f);
        //view.getTbleAdressenverwaltung().setModel(model);
        
      }
      catch (Exception ex)
      {
        JOptionPane.showMessageDialog(view, ex.toString());
      }
//      String text = model.getValueAt(choice, choice);
//      view.getTaEdit().setText(text);
    }
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

