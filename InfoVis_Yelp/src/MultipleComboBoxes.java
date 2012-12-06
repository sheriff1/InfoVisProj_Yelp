import java.awt.event.*;
import javax.swing.*;
 
public class MultipleComboBoxes {
   private static final String[] DATA_A = {"0", "1", "2", "3"};
   private static final String[] DATA_B = {"A", "B", "C", "D"};
    
   private JPanel mainPanel = new JPanel();
    
   // combo boxes declared as class level variables 
   private JComboBox comboA = new JComboBox(DATA_A);
   private JComboBox comboB = new JComboBox(DATA_B);
    
   public MultipleComboBoxes() {
      JButton getSelectionBtn = new JButton("Get Selection");
       
      getSelectionBtn.addActionListener(new ActionListener() {
          
         public void actionPerformed(ActionEvent e) {
             
            // in the button's action listener, use the references to both 
            // combo boxes to get the selected items
            Object itemA = comboA.getSelectedItem();
            Object itemB = comboB.getSelectedItem();
             
            String optionString = "comboA: " + itemA.toString() + "\n" +
                    "comboB: " + itemB.toString();
            JOptionPane.showMessageDialog(mainPanel, optionString);
         }
      });
       
      mainPanel.add(comboA);
      mainPanel.add(comboB);
      mainPanel.add(getSelectionBtn);
   }
 
   public JComponent getComponent() {
      return mainPanel;
   }
 
   private static void createAndShowUI() {
      JFrame frame = new JFrame("MultipleComboBoxes");
      frame.getContentPane().add(new MultipleComboBoxes().getComponent());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
 
   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}