/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adressenverwaltung.controller;

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
  
  public UndoController(AdressenverwaltungView view, AdressenverwaltungModel model)
  {
    this.view = view;
    this.model = model;
  }
  
  public void registerEvents()
  {
    view.getBtnSave().addActionListener(this);
    view.getMnuSave().addActionListener(this);
    //view.getPmSave().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent evt)
  {
//    view.getTaEdit().append("SAVE\n");
  }
}
