package com.jcompress.ui;
import java.awt.EventQueue;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jcompress.compressions.CompressionChooser;
import com.jcompress.core.Compressor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import com.jcompress.core.CompressorRunner;

public class FileSelector extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JFileChooser fc = new JFileChooser();
JFileChooser dc = new JFileChooser();
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;


   public FileSelector(String title)
   {
      super(title);
      
      
      
	  fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      JPanel pnl = new JPanel();
      pnl.setLayout(new GridLayout(10, 100));
      
      JLabel lblNewLabel = new JLabel("JCompress");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      pnl.add(lblNewLabel);
      
      ActionListener al;

      JButton btn = new JButton("Select Input");
     
      al = new ActionListener()
           {
              public void actionPerformed(ActionEvent ae)
              {
                 switch (fc.showOpenDialog(FileSelector.this))
                 {
                    case JFileChooser.APPROVE_OPTION:
                      /* JOptionPane.showMessageDialog(FileSelector.this, "Selected: "+
                                                     fc.getSelectedFile(),
                                                     "FCDemo",
                                                     JOptionPane.OK_OPTION);*/
                       textField.setText(fc.getSelectedFile().getAbsolutePath().toString());
                       
                       break;

                    case JFileChooser.CANCEL_OPTION:
                      /* JOptionPane.showMessageDialog(FileSelector.this, "Cancelled",
                                                     "FCDemo",
                                                     JOptionPane.OK_OPTION);*/
                       break;
                 
                    case JFileChooser.ERROR_OPTION:
                       JOptionPane.showMessageDialog(FileSelector.this, "Error",
                                                     "FCDemo",
                                                     JOptionPane.OK_OPTION);
                 }
              }
           };
      
           btn.addActionListener(al);
           pnl.add(btn);

           textField = new JTextField();
           pnl.add(textField);
           textField.setColumns(10);

     
      setContentPane(pnl);
      
	  dc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

      
      
      JButton btnNewButton = new JButton("Select Output Destination");
      btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
            switch (dc.showOpenDialog(FileSelector.this))
            {
               case JFileChooser.APPROVE_OPTION:
                  /*JOptionPane.showMessageDialog(FileSelector.this, "Selected: "+
                                                dc.getSelectedFile(),
                                                "FCDemo",
                                                JOptionPane.OK_OPTION);*/
                  textField_1.setText(dc.getSelectedFile().getAbsolutePath().toString());
                  
                  break;

               case JFileChooser.CANCEL_OPTION:
                  /*JOptionPane.showMessageDialog(FileSelector.this, "Cancelled",
                                                "FCDemo",
                                                JOptionPane.OK_OPTION);*/
                  break;
            
               case JFileChooser.ERROR_OPTION:
                  JOptionPane.showMessageDialog(FileSelector.this, "Error",
                                                "FCDemo",
                                                JOptionPane.OK_OPTION);
            }
      	}
      });
      pnl.add(btnNewButton);
      
      textField_1 = new JTextField();
      pnl.add(textField_1);
      textField_1.setColumns(10);
      
      //JLabel lblSetOutputFilename = new JLabel("Set Output Filename");
      //lblSetOutputFilename.setHorizontalAlignment(SwingConstants.CENTER);
      //pnl.add(lblSetOutputFilename);
      
     // textField_2 = new JTextField();
      //pnl.add(textField_2);
      //textField_2.setColumns(10);
      
      
      final JComboBox<Object> comboBox = new JComboBox<Object>();
      comboBox.addItem("zip");
      comboBox.addItem("bz2");
      comboBox.addItem("tar");
      comboBox.addItem("gzip");
      
      
      pnl.add(comboBox);
      
      JButton btnCompress = new JButton("Compress!");
      btnCompress.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {

      		CompressorRunner a = new CompressorRunner();
      		a.MakeItSo(textField.getText(), comboBox.getSelectedItem().toString(), textField_1.getText());
      		
     
    		JOptionPane.showMessageDialog(FileSelector.this, "Compress Complete",
                    "FCDemo",
                    JOptionPane.INFORMATION_MESSAGE);
      		
      	}
      });
      pnl.add(btnCompress);
      
      pack();
      setVisible(true);
   }

   public static void main(String[] args)
   {
      Runnable r = new Runnable()
                   {
                      public void run()
                      {
                         new FileSelector("FileChooser Demo");
                      }
                   };
      EventQueue.invokeLater(r);
   }
}