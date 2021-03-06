
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author malya
 */
public class ReceiptAfter extends javax.swing.JFrame {

    /**
     * Creates new form ReceiptAfter
     */
    ArrayList<ReceiptPrint> m=null;
    String username=null;
    DefaultTableModel model=null;
    private static ReceiptAfter ref=null;
    private ReceiptAfter(String username) 
    {
        initComponents();
        this.username=username;
        m=Database.fetchReceipt();
        
        model=(DefaultTableModel)tablerecord.getModel();
        if(m.size()>5)
        {
            for(int i=m.size();i>m.size()-5;i--)
            {
                model.addRow(new Object[]{m.get(i).getReceipt_no(),m.get(i).getMname(),m.get(i).getAmount(),m.get(i).getDate()});
            }
        }
        else
        {
            for(int i=0;i<m.size();i++)
            {
                model.addRow(new Object[]{m.get(i).getReceipt_no(),m.get(i).getMname(),m.get(i).getAmount(),m.get(i).getDate()});
            }
        }
    }
    
    
    public static ReceiptAfter getObj(String username)
    {
        if(ref==null)
        {
            ref=new ReceiptAfter(username);
            return ref;
        }
        else
            return ref;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablerecord = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(250, 40));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablerecord.setFont(new java.awt.Font("Benguiat Bk BT", 1, 14)); // NOI18N
        tablerecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SrNo.", "Medicine Name", "Total Amount", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablerecord.setRowHeight(30);
        tablerecord.getTableHeader().setResizingAllowed(false);
        tablerecord.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablerecord);
        if (tablerecord.getColumnModel().getColumnCount() > 0) {
            tablerecord.getColumnModel().getColumn(0).setMinWidth(150);
            tablerecord.getColumnModel().getColumn(0).setPreferredWidth(150);
            tablerecord.getColumnModel().getColumn(0).setMaxWidth(150);
            tablerecord.getColumnModel().getColumn(2).setMinWidth(150);
            tablerecord.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablerecord.getColumnModel().getColumn(2).setMaxWidth(150);
            tablerecord.getColumnModel().getColumn(3).setMinWidth(100);
            tablerecord.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablerecord.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, 812, 340));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Benguiat Bk BT", 1, 20)); // NOI18N
        jButton1.setText("Go");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 367, 99, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 410));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ref=null;
        dispose();
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row=tablerecord.getSelectedRow();
        int rcptno=(int)model.getValueAt(row, 0);
        String mname="";
        String str_amt="";
        String str_quantity="";
        double amount=0;
        for(int i=0;i<m.size();i++)
        {
            if(rcptno==m.get(i).getReceipt_no())
            {
                mname=m.get(i).getMname();
                str_amt=m.get(i).getTotal_amount();
                str_quantity=m.get(i).getStr_quantity();
                amount=m.get(i).getAmount();
            }
        }
        
        new Receipt(mname,str_amt,str_quantity,amount,username).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablerecord;
    // End of variables declaration//GEN-END:variables
}
