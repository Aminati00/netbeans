/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller.commands;

import adressenverwaltung.model.AdressenverwaltungModel;
import adressenverwaltung.view.AdressenverwaltungView;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author marco
 */
public class CommandDelete implements CommandInterface
{
  
  private AdressenverwaltungView view;
  private AdressenverwaltungModel model;
  private ArrayList<String> delValue;
  private Stack<ArrayList<String>> delValueStack;
  private Stack<Integer> rowStack;
  
  public CommandDelete(AdressenverwaltungView view, AdressenverwaltungModel model) 
  {
    this.view = view;
    this.model = model;
    delValue = new ArrayList<>();
    delValueStack = new Stack<>();
    rowStack = new Stack<>();
  }

  @Override
  public void execute()
  {
    int row = view.getTbleAdressenverwaltung().getSelectedRow();
    
    if(row == -1)
    {
      row = view.getTbleAdressenverwaltung().getRowCount() -1;
    }
    
    if(row >= 0)
    {
      delValue = new ArrayList<>();
      
      for(int i = 0; i < model.getColumnCount(); i++)
      {
        delValue.add(model.getValueAt(row, i).toString());
      }
      
      delValueStack.push(delValue);
      rowStack.push(row);
      model.eintragLoeschen(row);
    }
  }

  @Override
  public void undo()
  {
    if(!rowStack.empty() && !delValueStack.empty())
    {
      model.eintragHinzufuegen(rowStack.pop(), delValueStack.pop());
    }
  }

  @Override
  public boolean isUndoable()
  {
    return true;
  }
}
