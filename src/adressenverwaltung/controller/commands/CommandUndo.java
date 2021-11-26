/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller.commands;

import adressenverwaltung.model.AdressenverwaltungModel;
import adressenverwaltung.view.AdressenverwaltungView;

/**
 *
 * @author marco
 */
public class CommandUndo implements CommandInterface
{
  private AdressenverwaltungView view;
  private AdressenverwaltungModel model;
  
  public CommandUndo(AdressenverwaltungView view, AdressenverwaltungModel model)
  {
    this.view = view;
    this.model = model;
    
  }

  @Override
  public void execute()
  {
  }

  @Override
  public void undo()
  {
  }

  @Override
  public boolean isUndoable()
  {
    return false;
  }
}
