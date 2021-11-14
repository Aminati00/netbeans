/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller;

import adressenverwaltung.controller.commands.CommandInvoker;
import adressenverwaltung.controller.commands.CommandOpen;
import adressenverwaltung.controller.commands.CommandSave;
import adressenverwaltung.model.AdressenverwaltungModel;
import adressenverwaltung.view.AdressenverwaltungView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author marco
 */
public class CommandController implements ActionListener
{
  private AdressenverwaltungView view;
  private AdressenverwaltungModel model;
  private CommandInvoker invoker;
  
  public CommandController(AdressenverwaltungView view, AdressenverwaltungModel model, CommandInvoker invoker)
  {
    this.view = view;
    this.model = model;
    this.invoker = invoker;
  }
  
  public void registerEvents()
  {
    view.getBtnOpen().addActionListener(this);
    view.getMnuOpen().addActionListener(this);
    view.getPmOpen().addActionListener(this);

    view.getBtnSave().addActionListener(this);
    view.getMnuSave().addActionListener(this);
    view.getPmSave().addActionListener(this);
  }
  
  public void registerCommands()
  {
    CommandOpen cmdOpen = new CommandOpen(view, model);
    CommandSave cmdSave = new CommandSave(view, model);
    
    invoker.addCommand(view.getMnuOpen(), cmdOpen);
    invoker.addCommand(view.getBtnOpen(), cmdOpen);
    invoker.addCommand(view.getPmOpen(), cmdOpen);

    invoker.addCommand(view.getMnuSave(), cmdSave);
    invoker.addCommand(view.getBtnSave(), cmdSave);
    invoker.addCommand(view.getPmSave(), cmdSave);
  }

  /**
   * Polymorphismus!!!! zur Entscheidung welche Aktion durchgeführt wird
   * @param evt evt.getSource liefert Eventquelle als key für Hashmap im Invoker
   */
  @Override
  public void actionPerformed(ActionEvent evt)
  {
    Object key = evt.getSource();
    invoker.executeCommand(key);
  }
}
