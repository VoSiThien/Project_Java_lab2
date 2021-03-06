/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424073_lab2;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class MenuMain extends javax.swing.JFrame {

    /**
     * Creates new form MenuMain
     */
    static private processVMain pro = new processVMain();
    private JButton jbt1;
    private JButton jbt2;
    private JButton jbt3;
    private JButton jbt4;
    private JButton jbt5;
    private JButton jbt6;
    private JButton jbt7;
    private JButton jbt8;
    private JButton jbt9;
    private JButton jbt10;
    private JButton jbtqs11;
    private JButton jbtLoad;

    private JPanel jpanel1;
    private JPanel jpanel2;
    private JPanel jpanel3;
    private JPanel jpanel4;
    private JPanel jpanel5;

    private JLabel jlabel1;
    private JLabel jlabel2;
    private JLabel jlabel3;
    private JLabel jlabelRandom;
    private JLabel jlabelRandom2;
    private JLabel jlabelqs1;

    private JTextField jtext1;
    private JTextField jtext2;
    private JTextField jtext3;

    private JTable jtable1;
    private JScrollPane jsc1;
    private DefaultTableModel model;

    private JDialog jdialog1;
    private JDialog jdialog2;
    private JDialog jdialog3;
    private JDialog jdialog4;
    private JList jlist1;
    
    private JRadioButton jradio1;
    private JRadioButton jradio2;
    private JRadioButton jradio3;
    private JRadioButton jradio4;

    public MenuMain() {
        initComponents();
        this.Myinit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void Myinit() {
        this.jtext2 = new JTextField();
        this.jtext3 = new JTextField();
        this.setSize(750, 600);
        this.setTitle("Menu");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                pro.saveData();
                e.getWindow().dispose();
            }
        });

        //==================== panel
        this.jpanel1 = new JPanel();
        this.jpanel1.setPreferredSize(new Dimension(720, 120));
        this.jpanel1.setBackground(Color.lightGray);
        this.jpanel1.setLayout(null);

        this.jpanel2 = new JPanel();
        this.jpanel2.setPreferredSize(new Dimension(700, 300));
        this.jpanel2.setBackground(Color.BLUE);
        this.jpanel2.setLayout(new GridLayout(1,1));

        this.jpanel3 = new JPanel();
        this.jpanel3.setPreferredSize(new Dimension(720, 180));
        this.jpanel3.setBackground(Color.lightGray);
        this.jpanel3.setLayout(null);

        this.jpanel4 = new JPanel();
        this.jpanel4.setPreferredSize(new Dimension(720, 150));
        this.jpanel4.setBackground(Color.lightGray);
        this.jpanel4.setLayout(new FlowLayout());

        this.jpanel5 = new JPanel();
        this.jpanel5.setPreferredSize(new Dimension(720, 180));
        this.jpanel5.setBackground(Color.lightGray);
        this.jpanel5.setLayout(new FlowLayout());

        //======================= add to panel
        this.jpanel4.add(this.jpanel1);
        this.jpanel5.add(this.jpanel3);

        this.add(this.jpanel4, BorderLayout.NORTH);
        this.add(this.jpanel2, BorderLayout.CENTER);
        this.add(this.jpanel5, BorderLayout.SOUTH);
        // =======================================Panel 1 head
        this.jbt1 = new JButton();
        this.jbt1.setText("Search Slang");
        this.jbt1.setBounds(100, 70, 140, 30);
        this.jbt1.setActionCommand("jbt1");
        this.jbt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSlang();
            }
        });
        this.jpanel1.add(this.jbt1);

        this.jbt2 = new JButton();
        this.jbt2.setText("Search definition");
        this.jbt2.setBounds(250, 70, 130, 30);
        this.jbt2.setActionCommand("jbt2");
        this.jbt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchDefinition();
            }
        });
        this.jpanel1.add(this.jbt2);
        
        this.jbtLoad = new JButton();
        this.jbtLoad.setText("Load");
        this.jbtLoad.setBounds(10, 70, 80, 30);
        this.jbtLoad.setActionCommand("jbtLoad");
        this.jbtLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                long startTime = System.currentTimeMillis();
//                long endTime = System.currentTimeMillis();
//                System.out.println("Total execution time: " + (endTime - startTime));
                String[] columnNames = {"Slang Word", "Definition"};
                Object[][] data = pro.getMapkey();
                addTable(jtable1, columnNames, data);
            }
        });
        this.jpanel1.add(this.jbtLoad);

        this.jbt3 = new JButton();
        this.jbt3.setText("Hitory");
        this.jbt3.setBounds(500, 20, 140, 30);
        this.jbt3.setActionCommand("jbt3");
        this.jbt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListHistory();
            }
        });
        this.jpanel1.add(this.jbt3);

        this.jbt4 = new JButton();
        this.jbt4.setText("Reset");
        this.jbt4.setBounds(500, 70, 140, 30);
        this.jbt4.setActionCommand("jbt4");
        this.jbt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset();
            }
        });
        this.jpanel1.add(this.jbt4);

        this.jlabel1 = new JLabel("T??? kh??a");
        this.jlabel1.setBounds(20, 20, 60, 30);
        this.jpanel1.add(this.jlabel1);

        this.jtext1 = new JTextField();
        this.jtext1.setBounds(100, 20, 280, 30);
        this.jpanel1.add(this.jtext1);

        // =============================================Panel 2 table
        this.jtable1 = new JTable();
        this.jtable1.setPreferredScrollableViewportSize(new Dimension(700, 290));
        this.jtable1.setFillsViewportHeight(true);
        this.jsc1 = new JScrollPane(this.jtable1);
        this.jpanel2.add(this.jsc1);
        String[] columnNames = {"Slang Word", "Definition"};
        Object[][] data = pro.getMapkey();
        this.addTable(jtable1, columnNames, data);

        jtable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                click_row_table();
            }
        });

        // ========================Panel 3 Add, edit, delete, question
        this.jbt5 = new JButton();
        this.jbt5.setText("Add");
        this.jbt5.setBounds(20, 100, 140, 30);
        this.jbt5.setActionCommand("jbt5");
        this.jbt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSlang();
            }
        });
        this.jpanel3.add(this.jbt5);

        this.jbt6 = new JButton();
        this.jbt6.setText("Edit");
        this.jbt6.setBounds(165, 100, 140, 30);
        this.jbt6.setActionCommand("jbt6");
        this.jbt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSlang();
            }
        });
        this.jpanel3.add(this.jbt6);

        this.jbt7 = new JButton();
        this.jbt7.setText("Delete");
        this.jbt7.setBounds(310, 100, 140, 30);
        this.jbt7.setActionCommand("jbt7");
        this.jbt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleted();
            }
        });
        this.jpanel3.add(this.jbt7);

        this.jtext2.setBounds(100, 10, 280, 30);
        this.jpanel3.add(this.jtext2);

        
        this.jtext3.setBounds(100, 50, 280, 30);
        this.jpanel3.add(this.jtext3);

        this.jlabel2 = new JLabel("Slang word:");
        this.jlabel2.setBounds(10, 10, 80, 30);
        this.jpanel3.add(this.jlabel2);

        this.jlabel3 = new JLabel("Definition:");
        this.jlabel3.setBounds(10, 50, 80, 30);
        this.jpanel3.add(this.jlabel3);

        this.jbt8 = new JButton();
        this.jbt8.setText("Random slang");
        this.jbt8.setBounds(480, 10, 200, 30);
        this.jbt8.setActionCommand("jbt8");
        this.jbt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomSlang();
            }
        });
        this.jpanel3.add(this.jbt8);

        this.jbt9 = new JButton();
        this.jbt9.setText("question slang");
        this.jbt9.setBounds(480, 55, 200, 30);
        this.jbt9.setActionCommand("jbt9");
        this.jbt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionSlang();
            }
        });
        this.jpanel3.add(this.jbt9);

        this.jbt10 = new JButton();
        this.jbt10.setText("question definition");
        this.jbt10.setBounds(480, 100, 200, 30);
        this.jbt10.setActionCommand("jbt10");
        this.jbt10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionDefinition();
            }
        });
        this.jpanel3.add(this.jbt10);
    }

    public void addTable(JTable tb, String[] col, Object[][] data) {
        model = new DefaultTableModel(data, col);
        this.jtable1.removeAll();
        tb.setModel(model);
        deleteText();
    }

    public void searchSlang() {
        
        String[] col = {"Slang Word", "Definition"};
        String key = this.jtext1.getText().toString();
        Object[][] data = pro.SearchSlang(key);
        this.addTable(jtable1, col, data);
    }

    public void searchDefinition() {
        
        String[] col = {"Slang Word", "Definition"};
        String value = this.jtext1.getText().toString();
        Object[][] data = pro.SearchDefinition(value);
        this.addTable(jtable1, col, data);
    }

    public void ListHistory() {
        JPanel panelHIS = new JPanel(new GridLayout(1,1));
        jdialog1 = new JDialog(this, "History");
        jdialog1.setSize(500, 500);
        jdialog1.setLocationRelativeTo(null);
        jdialog1.setModal(true);
        jdialog1.setLayout(new GridLayout(1,1));

        ArrayList<String> lh = pro.ListHistory();
        DefaultListModel<String> l1 = new DefaultListModel<>();
        for (String l : lh) {
            l1.addElement(l);
        }
        JList<String> list = new JList<>(l1);
        list.setPreferredSize(new Dimension(470, 500));
//
//        JScrollPane scrollPane = new JScrollPane(list,
//                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        scrollPane.setPreferredSize(new Dimension(480, 450));
        
        panelHIS.add(scrollPane);
        jdialog1.add(panelHIS);
        jdialog1.setVisible(true);
        
    }

    public void reset() {
        int c = pro.reset();
        if (c == 0) {
            JOptionPane.showMessageDialog(this, "Reset success!!!");
            deleteText();
            String[] columnNames = {"Slang Word", "Definition"};
            Object[][] data = null;
            addTable(jtable1, columnNames, data);
        } else {
            JOptionPane.showMessageDialog(this, "Reset fail!!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    public void randomSlang() {
        jdialog2 = new JDialog(this, "Ramdom slang word");
        jdialog2.setSize(400, 200);
        jdialog2.setLocationRelativeTo(null);
        jdialog2.setModal(true);
        jdialog2.setLayout(null);
        SlangWord slang = pro.ramdomSlang();
        jlabelRandom = new JLabel("Slang word: " + slang.getSlang());
        jlabelRandom.setBounds(10, 40, 300, 20);
        jlabelRandom2 = new JLabel("Definition: " + slang.getDefinition());
        jlabelRandom2.setBounds(10, 60, 600, 20);
        jdialog2.add(this.jlabelRandom);
        jdialog2.add(this.jlabelRandom2);
        jdialog2.setBackground(Color.white);
        jdialog2.setVisible(true);
    }
    public void questionSlang(){
        java.util.List<String> l = new ArrayList<String>();
        l = pro.questionSlang();
        String check = l.get(5).toString();
        jdialog3 = new JDialog(this, "Question slang word");
        jdialog3.setSize(600, 400);
        jdialog3.setLocationRelativeTo(null);
        jdialog3.setModal(true);
        jdialog3.setLayout(null);
        
        this.jlabelqs1 = new JLabel("choose the correct definition of slang: " + l.get(4));
        this.jlabelqs1.setBounds(100, 30, 300, 20);
        
        this.jradio1 = new JRadioButton(l.get(0));
        this.jradio1.setBounds(100, 80, 500, 20);
        
        this.jradio2 = new JRadioButton(l.get(1));
        this.jradio2.setBounds(100, 130, 500, 20);
        
        this.jradio3 = new JRadioButton(l.get(2));
        this.jradio3.setBounds(100, 180, 500, 20);
        
        this.jradio4 = new JRadioButton(l.get(3));
        this.jradio4.setBounds(100, 230, 500, 20);
        
        this.jbtqs11 = new JButton("Done");
        this.jbtqs11.setBounds(230, 280, 150, 30);
        this.jbtqs11.setActionCommand("jbtqs11");
        this.jbtqs11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkanswer(check);
            }
        });
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(jradio1);
        bg.add(jradio2);
        bg.add(jradio3);
        bg.add(jradio4);
        
        jdialog3.add(this.jlabelqs1);
        jdialog3.add(this.jradio1);
        jdialog3.add(this.jradio2);
        jdialog3.add(this.jradio3);
        jdialog3.add(this.jradio4);
        jdialog3.add(this.jbtqs11);
        jdialog3.setVisible(true);        
    }
    
    public void questionDefinition(){
        java.util.List<String> l = new ArrayList<String>();
        l = pro.questionDefinition();
        String check = l.get(5).toString();
        jdialog3 = new JDialog(this, "Question definition");
        jdialog3.setSize(600, 400);
        jdialog3.setLocationRelativeTo(null);
        jdialog3.setModal(true);
        jdialog3.setLayout(null);
        
        this.jlabelqs1 = new JLabel("choose the correct slang of definition: " + l.get(4));
        this.jlabelqs1.setBounds(100, 30, 500, 20);
        
        this.jradio1 = new JRadioButton(l.get(0));
        this.jradio1.setBounds(100, 80, 300, 20);
        
        this.jradio2 = new JRadioButton(l.get(1));
        this.jradio2.setBounds(100, 130, 300, 20);
        
        this.jradio3 = new JRadioButton(l.get(2));
        this.jradio3.setBounds(100, 180, 300, 20);
        
        this.jradio4 = new JRadioButton(l.get(3));
        this.jradio4.setBounds(100, 230, 300, 20);
        
        this.jbtqs11 = new JButton("Done");
        this.jbtqs11.setBounds(230, 280, 150, 30);
        this.jbtqs11.setActionCommand("jbtqs11");
        this.jbtqs11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkanswer(check);
            }
        });
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(jradio1);
        bg.add(jradio2);
        bg.add(jradio3);
        bg.add(jradio4);
        
        jdialog3.add(this.jlabelqs1);
        jdialog3.add(this.jradio1);
        jdialog3.add(this.jradio2);
        jdialog3.add(this.jradio3);
        jdialog3.add(this.jradio4);
        jdialog3.add(this.jbtqs11);
        
        jdialog3.setVisible(true);        
    }
    
    public void checkanswer(String answer) {
        if (jradio1.isSelected() && answer.equals(jradio1.getText())) {
            int optionType = JOptionPane.CLOSED_OPTION;
            int result = JOptionPane.showConfirmDialog(jdialog3, "right answer!!!", "Congratulations", optionType);
            if (result == JOptionPane.OK_OPTION) {
                jdialog3.setVisible(false);
            }

        } else if (jradio2.isSelected() && answer.equals(jradio2.getText())) {
            int optionType = JOptionPane.CLOSED_OPTION;
            int result = JOptionPane.showConfirmDialog(jdialog3, "right answer!!!", "Congratulations", optionType);
            if (result == JOptionPane.OK_OPTION) {
                jdialog3.setVisible(false);
            }
        } else if (jradio3.isSelected() && answer.equals(jradio3.getText())) {
            int optionType = JOptionPane.CLOSED_OPTION;
            int result = JOptionPane.showConfirmDialog(jdialog3, "right answer!!!", "Congratulations", optionType);
            if (result == JOptionPane.OK_OPTION) {
                jdialog3.setVisible(false);
            }
        } else if (jradio4.isSelected() && answer.equals(jradio4.getText())) {
            int optionType = JOptionPane.CLOSED_OPTION;
            int result = JOptionPane.showConfirmDialog(jdialog3, "right answer!!!", "Congratulations", optionType);
            if (result == JOptionPane.OK_OPTION) {
                jdialog3.setVisible(false);
            }
        } else {
            //JOptionPane.showMessageDialog(jdialog3, "wrong answer!!!", "Warning",JOptionPane.WARNING_MESSAGE);
            int optionType = JOptionPane.CLOSED_OPTION;
            int result = JOptionPane.showConfirmDialog(jdialog3, "wrong answer!!!", "Warning", optionType);
            if (result == JOptionPane.OK_OPTION) {
                jdialog3.setVisible(false);
            }
        }
    }
    
    public void addSlang(){
        String key = this.jtext2.getText();
        String value = this.jtext3.getText();
        int check = pro.addSlang(key, value);
        if(check == 0){
            JOptionPane.showMessageDialog(this, "Add compalte!!!");
            deleteText();
        } else {
            int optionType = JOptionPane.YES_NO_CANCEL_OPTION;
            int result = JOptionPane.showConfirmDialog(this, "Select yes : Overwrite\nselect no : Duplicate", "Warning", optionType);
            if (result == JOptionPane.YES_OPTION) {
                pro.OverWrite(key, value);
            }
            if (result == JOptionPane.NO_OPTION) {
                pro.Duplicate(key, value);
            }
        }
    }
    
    public void deleted() {
        if (this.jtable1.getSelectedRows().length != 0) {
            int[] row = this.jtable1.getSelectedRows();
            String key = this.jtable1.getValueAt(row[0], 0).toString();
            int check = 1;
            int optionType = JOptionPane.OK_CANCEL_OPTION;
            int result = JOptionPane.showConfirmDialog(this, "Confirm deletion", "Warning", optionType);
            if (result == JOptionPane.OK_OPTION) {
                check = pro.deleted(key);
            }
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Delete complate");
                this.model.removeRow(row[0]);
                deleteText();
            } else {
                JOptionPane.showMessageDialog(this, "Delete fail!!!", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select slang from table!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void editSlang() {
        if (this.jtable1.getSelectedRows().length != 0) {
            int[] row = this.jtable1.getSelectedRows();
            String key = this.jtable1.getValueAt(row[0], 0).toString();
            String newkey = this.jtext2.getText();
            String newvalue = this.jtext3.getText();
            int check = pro.edit(key, newkey, newvalue);
            if (check == 0) {
                JOptionPane.showMessageDialog(this, "Edit complate");
            } else {
                JOptionPane.showMessageDialog(this, "Edit fail, Slang word already exist", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select slang from table!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void click_row_table() {
        if (this.jtable1.getSelectedRows().length != 0) {
            int[] row = this.jtable1.getSelectedRows();
            this.jtext2.setText(this.jtable1.getValueAt(row[0], 0).toString());
            this.jtext3.setText(this.jtable1.getValueAt(row[0], 1).toString());
        }
        else{
            deleteText();
        }
    }
    
    public void deleteText(){
        this.jtext2.setText("");
        this.jtext3.setText("");
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuMain().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
