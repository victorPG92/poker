package pr4.presentacion.ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;




public class VentanaSimulacion2 extends javax.swing.JFrame implements KeyListener {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private javax.swing.JButton btnSimular;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private static javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextField jTextFieldBote;
  private javax.swing.JTextField jTextFieldVueltas;  
  private static VentanaSimulacion2 ventanaSimulacion2; 
  private JTextField textFieldDetener;

    public static VentanaSimulacion2 obtenerInstancia() {

        if (ventanaSimulacion2 == null)
            ventanaSimulacion2 = new VentanaSimulacion2();

        return ventanaSimulacion2;
    }

  
    public VentanaSimulacion2() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Simulacion"); 
        setBackground(Color.BLACK);
        getContentPane().setBackground(Color.GRAY.brighter());;
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnSimular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBote = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldVueltas = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        jTextArea1.setColumns(200);
        jTextArea1.setRows(50);
        jScrollPane1.setViewportView(jTextArea1);
        btnSimular.setText("Simular");
        jLabel1.setText("Bote inicial");
        jTextFieldBote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBoteActionPerformed(evt);
            }
        });
        
        jTextFieldBote.addFocusListener(new FocusListener() {
          public void focusLost(FocusEvent e) {
             setMsj("");
             }
          public void focusGained(FocusEvent e) {
             // No hacemos nada
          }
       });
        
        jTextFieldVueltas.addFocusListener(new FocusListener() {
          public void focusLost(FocusEvent e) {
             setMsj("");
             }
          public void focusGained(FocusEvent e) {
             // No hacemos nada
          }
       });
        
        

        jTextFieldVueltas.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              jTextFieldBoteActionPerformed(evt); 
              
          }
      });

        jLabel2.setText("Numero de Iteraciones");
        
        JLabel lblPararSimulacionEn = new JLabel();
        lblPararSimulacionEn.setText("Parar simulacion en Manos");
        
        textFieldDetener = new JTextField();
        textFieldDetener.addFocusListener(new FocusListener() {
          public void focusLost(FocusEvent e) {
             setMsj("");
             }
          public void focusGained(FocusEvent e) {
             // No hacemos nada
          }
       });
        
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button.setText("SALIR");
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
          	
				System.exit(0);

          }
      });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(27)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(button, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(53)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jTextFieldBote, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1)
        				.addComponent(btnSimular))
        			.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jTextFieldVueltas, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2)
        						.addComponent(textFieldDetener, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
        					.addGap(14))
        				.addComponent(lblPararSimulacionEn, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(25)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jTextFieldBote, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jTextFieldVueltas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(6)))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(btnSimular)
        					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblPararSimulacionEn)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textFieldDetener, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(12)))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(19)
        					.addComponent(button)))
        			.addGap(23))
        );
        getContentPane().setLayout(layout);

        pack();
            jTextFieldBote.addKeyListener(this); 
            jTextFieldVueltas.addKeyListener(this);
            textFieldDetener.addKeyListener(this);
            
      btnSimular.addActionListener(new ActionListener()
        {
          
            public void actionPerformed(ActionEvent arg0)
            {
                if ((jTextFieldBote.getText().compareTo("") != 0) && (jTextFieldVueltas.getText().compareTo("") != 0) && (textFieldDetener.getText().compareTo("") != 0) 

                        &&  (Integer.parseInt(jTextFieldBote.getText())>10 && Integer.parseInt(jTextFieldVueltas.getText()) > 10 && Integer.parseInt(textFieldDetener.getText()) > 10) ) { 
//                        ApplicationController.obtenerInstancia().handleRequest(EnumComandos.SIMULAR, null);
                			//setMsj("Calculando: . . . .");
                      pr4.Simular sim=new pr4.Simular(Integer.parseInt(jTextFieldBote.getText()),Integer.parseInt(jTextFieldVueltas.getText()),Integer.parseInt(textFieldDetener.getText())); 
                      setMsj(sim.simula());
                      
                    } 
                 else {
                    JOptionPane.showMessageDialog(null, "Para poder simular, antes debe introducir un bote inicial, numero de iteraciones y el punto de interrupcion de la simulacion cada n manos con un valor mayor o igual a 10");
                }
            }
        });
    }                     

    private void jTextFieldBoteActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaSimulacion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSimulacion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSimulacion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSimulacion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
          @Override public void run(){
    

                new VentanaSimulacion2().setVisible(true);
            }
        });
    }
    public static void setMsj(String msj) {
    	 jTextArea1.setText(msj);
       
    }
    @SuppressWarnings("static-access")
    @Override 
      public void keyTyped(KeyEvent e) { 

        int k = (int) e.getKeyChar(); 

        if(k >= 1 && k <= 47 || k >= 58 && k <= 950 && (k != e.VK_BACK_SPACE)) { 
            e.consume();
                  //  JOptionPane.showMessageDialog(null, "No puede ingresar Letras ni caracteres!", "Error Datos", JOptionPane.ERROR_MESSAGE);
        } 
      }
 
    @Override
    public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
    }
}
