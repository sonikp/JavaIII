package assignment3module3BKUP;

import javax.swing.JTable;

abstract class Observer {
    protected InventoryProgramModel subject;
//    public abstract void update();
    public abstract JTable update();
}