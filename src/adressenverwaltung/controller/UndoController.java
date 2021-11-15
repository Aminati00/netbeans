/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller;

import adressenverwaltung.controller.commands.CommandInvoker;
import adressenverwaltung.controller.commands.CommandUndo;
import adressenverwaltung.model.AdressenverwaltungModel;
import adressenverwaltung.view.AdressenverwaltungView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author marco
 */

public class UndoController implements ActionListener
{
  private AdressenverwaltungView view;
  private AdressenverwaltungModel model;
  private CommandInvoker invoker;
  
  public UndoController(AdressenverwaltungView view, AdressenverwaltungModel model, CommandInvoker invoker)
  {
    this.view = view;
    this.model = model;
    this.invoker = invoker;
    
  }
  
  public void registerCommands()
  {
    CommandUndo cmdUndo = new CommandUndo(view, model);
    
    invoker.addCommand(view.getMnuUndo(), cmdUndo);
    invoker.addCommand(view.getBtnUndo(), cmdUndo);
    invoker.addCommand(view.getPmUndo(), cmdUndo);
  }
  
  public void registerEvents()
  {
    view.getBtnUndo().addActionListener(this);
    view.getMnuUndo().addActionListener(this);
    view.getPmUndo().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent evt)
  {
    invoker.undoCommand();
  }
}
