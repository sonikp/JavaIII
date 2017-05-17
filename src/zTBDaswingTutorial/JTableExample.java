package zTBDaswingTutorial;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

 

/*
 * A basic swing example with JTable
 */

 

public class JTableExample {

 

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello Swing");

         

        // Set data inside the table
        String[][] data = {{"100", "CD", "Black Diamond", "Angie Stone", "LS5784", "5"}, {"101", "CD", "Fly In The Hand", "Alice Russell", "TBM345984", "3"}, 
        		{"300", "DVD", "Star Wars - Complete Saga", "Lucas Films", "024543742180", "2"}, {"500", "BOOK", "The Hobbit", "J. R. R. Tolkien", "9780788789823", "2"}};
        String[] column = {"itemNum", "itemType", "title", "artist", "productCode", "quantity"};
        
         

        // Create JTable
        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);      

         

        frame.add(sp);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        System.out.println("Data\t: " + data[1][0]);
        System.out.println("Data\t: " + data[1][1]);
        System.out.println("Data\t: " + data[1][2]);
        System.out.println("Data\t: " + data[1][3]);
        System.out.println("Data\t: " + data[1][4]);

    }

 

}