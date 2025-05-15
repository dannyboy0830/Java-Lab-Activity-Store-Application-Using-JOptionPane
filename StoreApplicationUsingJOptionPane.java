/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package store.application.using.joptionpane;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PALOMO_CPE121
 */
public class StoreApplicationUsingJOptionPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Map<Integer, Item> itemList = new HashMap<>();
        itemList.put(1, new Item("Bread", 2.00));
        itemList.put(2, new Item("Milk", 1.50));
        itemList.put(3, new Item("Eggs", 3.00));
        itemList.put(4, new Item("Rice", 1.00));
        itemList.put(5, new Item("Coffee", 5.00));

      
        StringBuilder itemDisplay = new StringBuilder("Welcome to the Store!\n\n");
        for (Map.Entry<Integer, Item> entry : itemList.entrySet()) {
            Item item = entry.getValue();
            itemDisplay.append(entry.getKey()).append(". ").append(item.getName()).append(" - $").append(String.format("%.2f", item.getPrice())).append("\n");
        }
        itemDisplay.append("\n");
        JOptionPane.showMessageDialog(null, itemDisplay.toString(), "Available Items", JOptionPane.INFORMATION_MESSAGE);

       
        while (true) {
            double totalCost = 0;
            Map<Integer, Integer> quantities = new HashMap<>(); 

            
            while (true) {
                try {
                    String itemInput = JOptionPane.showInputDialog("Enter the NUMBER of the item you wish to buy (or type 'done' to finish):");
                    if (itemInput == null || itemInput.equalsIgnoreCase("done")) { 
                        break; 
                    }

                    int itemNumber = Integer.parseInt(itemInput);

                    if (itemList.containsKey(itemNumber)) {
                        Item selectedItem = itemList.get(itemNumber);

                        String quantityInput = JOptionPane.showInputDialog("Enter quantity for " + selectedItem.getName() + ":");
                        if (quantityInput == null)
                        {
                            break;
                        }
                        int quantity = Integer.parseInt(quantityInput);
                        if(quantity <= 0)
                        {
                            JOptionPane.showMessageDialog(null, "Quantity must be greater than 0.  Please try again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                            continue;
                        }

                        quantities.put(itemNumber, quantity); 
                        totalCost += selectedItem.getPrice() * quantity;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid item number. Please try again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number or 'done'.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }

            
            if (quantities.isEmpty())
            {
                if (JOptionPane.showConfirmDialog(null, "Do you want to make another purchase?", "Another Purchase?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Thank you for visiting!");
                    return;
                }
                else
                {
                    continue;
                }
            }
            JOptionPane.showMessageDialog(null, "Total amount: $" + String.format("%.2f", totalCost), "Total Cost", JOptionPane.INFORMATION_MESSAGE);

            double change = 0;
            double cash = 0;
            while (true) {
                try {
                    String cashInput = JOptionPane.showInputDialog("Enter cash amount:");
                    if(cashInput == null)
                    {
                        cash = 0;
                        break;
                    }
                    cash = Double.parseDouble(cashInput);

                    if (cash < totalCost) {
                        JOptionPane.showMessageDialog(null, "Insufficient cash. Please enter a higher amount.", "Insufficient Cash", JOptionPane.ERROR_MESSAGE);
                    } else {
                        change = cash - totalCost;
                        break; 
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (cash == 0)
            {
                if (JOptionPane.showConfirmDialog(null, "Do you want to make another purchase?", "Another Purchase?", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Thank you for visiting!");
                    return;
                }
                else
                {
                    continue;
                }
            }

            JOptionPane.showMessageDialog(null, "Change: $" + String.format("%.2f", change), "Change", JOptionPane.INFORMATION_MESSAGE);

            
            int anotherPurchase = JOptionPane.showConfirmDialog(null, "Do you want to make another purchase?", "Another Purchase?", JOptionPane.YES_NO_OPTION);
            if (anotherPurchase == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for visiting!");
                break; // Exit the outer loop
            }
            
        }
    }
    
    
    static class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
    
    
}
