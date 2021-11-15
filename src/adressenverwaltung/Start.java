/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung;

import adressenverwaltung.controller.CommandController;
import adressenverwaltung.controller.UndoController;
import adressenverwaltung.controller.commands.CommandInvoker;
import adressenverwaltung.model.AdressenverwaltungModel;
import adressenverwaltung.view.AdressenverwaltungView;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author marco
 */
public class Start 
{
  public Start()
  {
    AdressenverwaltungView view = new AdressenverwaltungView();
    AdressenverwaltungModel model = new AdressenverwaltungModel();
    view.getTbleAdressenverwaltung().setModel(model);
    CommandInvoker invoker = new CommandInvoker();
    CommandController ctrlCommand = new CommandController(view, model, invoker);
    UndoController ctrUndo = new UndoController(view, model, invoker);
    
    ctrlCommand.registerEvents();
    ctrlCommand.registerCommands();
    
    ctrUndo.registerEvents();
    ctrUndo.registerCommands();
    
    
    view.setVisible(true);
  }

  public static void main(String[] args) 
  {
    try    
    {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }    
    catch (Exception ex)    
    {
      JOptionPane.showMessageDialog(null, ex.toString());
    }
    
    new Start();
  }

}
