/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller.commands;

import adressenverwaltung.model.AdressenverwaltungModel;
import adressenverwaltung.view.AdressenverwaltungView;
import java.util.Stack;

/**
 *
 * @author marco
 */
public class CommandAdd implements CommandInterface
{
  private AdressenverwaltungView view;
  private AdressenverwaltungModel model;
  private Stack<Integer> rowStack;
  
  public CommandAdd(AdressenverwaltungView view, AdressenverwaltungModel model)
  {
    this.view = view;
    this.model = model;
    rowStack = new Stack<>();
  }

  @Override
  public void execute()
  {
    model.eintragHinzufuegen();
    int row = model.getRowCount() -1;
    rowStack.push(row);
  }

  @Override
  public void undo()
  {
    model.eintragLoeschen(rowStack.pop());
  }

  @Override
  public boolean isUndoable()
  {
    return true;
  }
}
