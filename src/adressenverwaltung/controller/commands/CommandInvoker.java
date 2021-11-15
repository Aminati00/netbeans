/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller.commands;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author marco
 */
public class CommandInvoker 
{
  private HashMap<Object, CommandInterface> commands;
  private Stack<CommandInterface> undoStack;
  
  public CommandInvoker()
  {
    commands = new HashMap<>();
    undoStack = new Stack<>();
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
      undoStack.push(commands.get(key));
    }
  }
  
  public void undoCommand()
  {
    if (!undoStack.empty())
    {
      undoStack.pop().undo();
    }
  }
  
  public void clearUndoStack()
  {
    undoStack.clear();
  }
  
}
