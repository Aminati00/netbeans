/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller.commands;

import java.util.HashMap;

/**
 *
 * @author marco
 */
public class CommandInvoker 
{
  private HashMap<Object, CommandInterface> commands;
  
  public CommandInvoker()
  {
    commands = new HashMap<>();
  }
  
  public void addCommand(Object key, CommandInterface value)
  {
    commands.put(key, value);
  }
  
  public void executeCommand(Object key)
  {
    commands.get(key).execute();
    if (commands.get(key).isUndoable())
    {
      //undoStack.push(commands.get(key));
    }
  }
  
  public void undoCommand()
  {
//    if (!undoStack.empty())
//    {
//      undoStack.pop().undo();
//    }
  }
  
  
}
