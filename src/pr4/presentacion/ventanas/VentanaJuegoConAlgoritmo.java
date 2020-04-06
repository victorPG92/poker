package pr4.presentacion.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pr4.FactSAImpJuegoConAlgoritmo;
import pr4.FactSAImpJuegoNormal;
import pr4.presentacion.controlador.ApplicationController;
import pr4.presentacion.controlador.EnumComandos;

@SuppressWarnings("serial")
public class VentanaJuegoConAlgoritmo extends JFrame {
	
	private static VentanaJuegoConAlgoritmo ventana; 
	

	public static VentanaJuegoConAlgoritmo obtenerInstancia() {

		if (ventana == null)
			ventana = new VentanaJuegoConAlgoritmo();

		return ventana;
	}

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JLabel lblMano = new JLabel("Mano");
	private Tapete canvas;
	private JTextField txtBote;
	private JTextField txtStackRobot;
	private JTextField txtManoBanca;
	private JTextField txtManoRobot;
	private JTextField txtNumManosGanadas;
	private JTextField txtNumManosPerdidas;
	private JTextField txtNumManosEmpatadas;
	private JTextField txtNumManosAbandonadas;
	
	private JButton botonJugar;
	private JButton btnSalir;
	
	private JLabel lblBote;
	private JLabel lblStackRobot;
	private JLabel lblCartasComunes;
	private JLabel lblFlop;
	private JLabel lblTurn;
	private JLabel lblRiver;
	private JLabel lblCartasBanca;
	private JLabel lblCartasRobot;
	private JLabel lblManoBanca;
	private JLabel lblManoRobot;
	private JLabel lblNumManosGanadas;
	private JLabel lblNumManosPerdidas;
	private JLabel lblNumManosEmpatadas;
	private JLabel lblNumManosAbandonadas;
	private JLabel lblProbabilidad;
	
	
	private JLabel lblResultado;
	
	private JButton btnVerResultado;
	
	private JButton btnVolverAjugar;

	/**
	 * Create the frame.
	 */
	public VentanaJuegoConAlgoritmo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 1796, 1573); //ubicacion y tamanio de la pantalla
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.LIGHT_GRAY);
		
		canvas = new Tapete();
		canvas.setBounds(150, 40,1100,491);
		contentPane.add(canvas);
	
		botonJugar = new JButton("Juega robot");
		botonJugar.addActionListener(new ListenerCartasAzar(canvas));
		botonJugar.setBounds(4, 10, 110, 30); 
		contentPane.add(botonJugar);
		
		btnVerResultado = new JButton("VER RESULTADO");
		btnVerResultado.setBounds(4, 226, 130, 23);
		contentPane.add(btnVerResultado);
		btnVerResultado.setVisible(false);
		
		btnVolverAjugar = new JButton("VOLVER A JUGAR");
		btnVolverAjugar.setBounds(610, 558, 135, 23);
		contentPane.add(btnVolverAjugar);
		btnVolverAjugar.setVisible(false);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(610, 610, 135, 23);
		contentPane.add(btnSalir);
		btnSalir.setVisible(true);
		
		lblBote = new JLabel("Bote");
		lblBote.setBounds(150, 558, 46, 14);
		contentPane.add(lblBote);
		
		lblStackRobot = new JLabel("Stack Robot");
		lblStackRobot.setBounds(150, 580, 89, 14);
		contentPane.add(lblStackRobot);
		
		lblManoBanca = new JLabel("Mano Banca");
		lblManoBanca.setBounds(150, 620, 89, 14);
		contentPane.add(lblManoBanca);
		lblManoBanca.setVisible(false);
		
		lblManoRobot = new JLabel("Mano Robot");
		lblManoRobot.setBounds(150, 642, 89, 14);
		contentPane.add(lblManoRobot);
		lblManoRobot.setVisible(false);
		
		lblNumManosGanadas = new JLabel("Numero manos ganadas");
		lblNumManosGanadas .setBounds(900, 558, 150, 14);
		contentPane.add(lblNumManosGanadas );
		lblNumManosGanadas .setVisible(true);
		
		lblNumManosPerdidas = new JLabel("Numero manos perdidas");
		lblNumManosPerdidas.setBounds(900, 580, 150, 14);
		contentPane.add(lblNumManosPerdidas);
		lblNumManosPerdidas.setVisible(true);
		
		lblNumManosEmpatadas = new JLabel("Numero manos empatadas");
		lblNumManosEmpatadas.setBounds(900, 602, 170, 14);
		contentPane.add(lblNumManosEmpatadas);
		lblNumManosEmpatadas.setVisible(true);
		
		lblNumManosAbandonadas = new JLabel("Numero manos abandonadas");
		lblNumManosAbandonadas.setBounds(900, 624, 170, 14);
		contentPane.add(lblNumManosAbandonadas);
		lblNumManosAbandonadas.setVisible(true);
		
		lblProbabilidad = new JLabel("probabilidad...");
		lblProbabilidad.setBounds(500, 558, 1000, 14);
		contentPane.add(lblProbabilidad);
		lblProbabilidad.setVisible(false);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(233, 670, 400, 14);
		contentPane.add(lblResultado);
		lblResultado.setVisible(false);
		
		/*lblStackBanca = new JLabel("Stack Banca");
		lblStackBanca.setBounds(150, 609, 89, 14);
		contentPane.add(lblStackBanca);*/
		
		lblCartasBanca = new JLabel("Cartas banca");
		lblCartasBanca.setBounds(50, 357, 89, 14);
		contentPane.add(lblCartasBanca);
		
		lblCartasRobot = new JLabel("Cartas robot");
		lblCartasRobot.setBounds(50, 471, 89, 14);
		contentPane.add(lblCartasRobot);
		
		lblCartasComunes = new JLabel("Cartas comunes");
		lblCartasComunes.setBounds(50, 122, 100, 14);
		contentPane.add(lblCartasComunes);
		lblCartasComunes.setVisible(true);
		
		lblFlop = new JLabel("|------------------------Flop------------------------|");
		lblFlop.setBounds(150, 26, 300, 14);
		contentPane.add(lblFlop);
		lblFlop.setVisible(false);
		
		lblTurn = new JLabel("|-----Turn-----|");
		lblTurn.setBounds(372, 26, 100, 14);
		contentPane.add(lblTurn);
		lblTurn.setVisible(false);
		
		lblRiver = new JLabel("|----River----|");
		lblRiver.setBounds(445, 26, 100, 14);
		contentPane.add(lblRiver);
		lblRiver.setVisible(false);

		txtBote = new JTextField();
		txtBote.setEditable(false);
		txtBote.setBounds(235, 555, 86, 20);
		contentPane.add(txtBote);
		txtBote.setColumns(10);
		
		txtStackRobot = new JTextField();
		txtStackRobot.setEditable(false);
		txtStackRobot.setBounds(235, 577, 86, 20);
		contentPane.add(txtStackRobot);
		txtStackRobot.setColumns(10);
		
		txtManoBanca = new JTextField();
		txtManoBanca.setEditable(false);
		txtManoBanca.setBounds(235, 641, 200, 20);
		contentPane.add(txtManoBanca);
		txtManoBanca.setColumns(10);
		txtManoBanca.setVisible(false);
		
		txtManoRobot = new JTextField();
		txtManoRobot.setEditable(false);
		txtManoRobot.setBounds(235, 619, 200, 20);
		contentPane.add(txtManoRobot);
		txtManoRobot.setColumns(10);
		txtManoRobot.setVisible(false);
		
		txtNumManosGanadas = new JTextField();
		txtNumManosGanadas.setText("0");
		txtNumManosGanadas.setEditable(false);
		txtNumManosGanadas.setBounds(1082, 555, 86, 20);
		contentPane.add(txtNumManosGanadas);
		txtNumManosGanadas.setColumns(10);
		txtNumManosGanadas.setVisible(true);
		
		txtNumManosPerdidas = new JTextField();
		txtNumManosPerdidas.setText("0");
		txtNumManosPerdidas.setEditable(false);
		txtNumManosPerdidas.setBounds(1082, 577, 86, 20);
		contentPane.add(txtNumManosPerdidas);
		txtNumManosPerdidas.setColumns(10);
		txtNumManosPerdidas.setVisible(true);
		
		txtNumManosEmpatadas = new JTextField();
		txtNumManosEmpatadas.setText("0");
		txtNumManosEmpatadas.setEditable(false);
		txtNumManosEmpatadas.setBounds(1082, 599, 86, 20);
		contentPane.add(txtNumManosEmpatadas);
		txtNumManosEmpatadas.setColumns(10);
		txtNumManosEmpatadas.setVisible(true);
		
		txtNumManosAbandonadas = new JTextField();
		txtNumManosAbandonadas.setText("0");
		txtNumManosAbandonadas.setEditable(false);
		txtNumManosAbandonadas.setBounds(1082, 621, 86, 20);
		contentPane.add(txtNumManosAbandonadas);
		txtNumManosAbandonadas.setColumns(10);
		txtNumManosAbandonadas.setVisible(true);
		
		addLis();
		
	}
	
	public JLabel getLblResultado() 
	{
		
		return lblResultado;
	
	}

	public void setLblResultado(JLabel lblResultado) 
	{
		
		this.lblResultado = lblResultado;
	
	}


	public void addLis()
	{
	
		botonJugar.addActionListener(new ActionListener()
		{

			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent arg0)
			{
				
				//FactSAImpJuegoConAlgoritmo.dameSA().getM().inicia();
				//FactSAImpJuegoConAlgoritmo.dameSA().juega();
				
				
			
				if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getEstado() == 1){ //flop
					
					if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().sePuedeApostar(2)) {
						
						if(!FactSAImpJuegoConAlgoritmo.dameSA().apuestaFlop()) {
						
							//abandono y hay que pasar a perder lo apostado
							
							FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().perder();
							
						} else {
						
							//hacer lo que se tenga que hacer.. mostrar cosas en la interfaz.. etc
							
							lblFlop.setVisible(true);
							lblProbabilidad.setVisible(true);
							
						}
					
					} else {
						
						System.out.println("no hay dinero suficiente flop");
						JOptionPane.showMessageDialog(null, "No tienes suficientes fondos para seguir apostando \n\n                              GAME OVER");
						setVisible(false);
						System.exit(0);
						
					}
								
				} else if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getEstado() == 2){ //turn
					
					if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().sePuedeApostar(1)) {
						
						if(!FactSAImpJuegoConAlgoritmo.dameSA().apuestaTurn()) {
						
							//abandono y hay que pasar a perder lo apostado
							
							FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().perder();
							
						} else {
						
							//hacer lo que se tenga que hacer.. mostrar cosas en la interfaz.. etc
							
							lblTurn.setVisible(true);
							lblProbabilidad.setVisible(true);
							
						}
					
					} else {
						
						System.out.println("no hay dinero suficiente turn");
						JOptionPane.showMessageDialog(null, "No tienes suficientes fondos para seguir apostando \n\n                              GAME OVER");
						setVisible(false);
						System.exit(0);
						
					}
					
				} else if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getEstado() == 3){ //river
					
					if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().sePuedeApostar(1)) {
						
						if(!FactSAImpJuegoConAlgoritmo.dameSA().apuestaRiver()) {
						
							//abandono y hay que pasar a perder lo apostado
							
							FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().perder();
							
						} else {
						
							//hacer lo que se tenga que hacer.. mostrar cosas en la interfaz.. etc
							
							lblRiver.setVisible(true);
							lblProbabilidad.setVisible(true);
							
						}
					
					} else {
						
						System.out.println("no hay dinero suficiente river '\n'GAME OVER");
						JOptionPane.showMessageDialog(null, "No tienes suficientes fondos para seguir apostando \n\n                              GAME OVER");
						setVisible(false);
						System.exit(0);
						
					}
					
				}
				
				//pierde lo que haya apostado en cualquier momento si se ha rendido
				
				if(!FactSAImpJuegoConAlgoritmo.dameSA().getM().apostarFlop || !FactSAImpJuegoConAlgoritmo.dameSA().getM().apostarInicial || !FactSAImpJuegoConAlgoritmo.dameSA().getM().apostarRiver || !FactSAImpJuegoConAlgoritmo.dameSA().getM().apostarTurn)
				{
					
					FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().setNumJugadasAbandonadas(FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().getNumJugadasAbandonadas() + 1);
					txtNumManosAbandonadas.setText(Integer.toString(FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().getNumJugadasAbandonadas()));
					
					//getLblResultado().setText("Abandono - pierde robot " + getTxtBote().getText());
					
					if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getEstado() == 1) {
						
						getLblResultado().setText("Abandono en el preflop - pierde robot " + getTxtBote().getText());
						
					} else if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getEstado() == 2) {
						
						getLblResultado().setText("Abandono en el flop - pierde robot " + getTxtBote().getText());
						
					} else if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getEstado() == 3) {
						
						getLblResultado().setText("Abandono en el turn - pierde robot " + getTxtBote().getText());

					}
					
					FactSAImpJuegoNormal.dameSA().perder();
					
					botonJugar.setVisible(false);	
					
					JOptionPane.showMessageDialog(null, "EL ROBOT ACABA DE RETIRARSE Y POR TANTO PERDI� LO APOSTADO :s");
					
					lblResultado.setVisible(true);
					lblProbabilidad.setVisible(false);
					btnVolverAjugar.setVisible(true);
					
					FactSAImpJuegoConAlgoritmo.dameSA().getM().getJ().perder();
					FactSAImpJuegoConAlgoritmo.dameSA().actualizaVentana();
			
				}
				
				if(FactSAImpJuegoConAlgoritmo.dameSA().getM().getEstado() == 4) {
					
					btnVerResultado.setVisible(true);
					botonJugar.setVisible(false);
					
				}
			}	
		});
		
		btnVerResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            	ApplicationController.obtenerInstancia().handleRequest(EnumComandos.VER_RESULTADO_JUEGO_CON_ALGORITMO, null);
                
                btnVerResultado.setVisible(false);
            	btnVolverAjugar.setVisible(true);
            	lblManoBanca.setVisible(true);
            	lblManoRobot.setVisible(true);
            	txtManoBanca.setVisible(true);
            	txtManoRobot.setVisible(true);
            	lblResultado.setVisible(true);
				lblProbabilidad.setVisible(false);
            	
            }
        });
	
		btnVolverAjugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            	canvas.setMostrarBanca(false);
            	
            	if(getTxtStackRobot().getText().compareTo("0 �") == 0) {
            		
					JOptionPane.showMessageDialog(null, "No tienes suficientes fondos para seguir jugando \n\n                           GAME OVER");
					setVisible(false);
					System.exit(0);

            	} else {
            		
            		ApplicationController.obtenerInstancia().handleRequest(EnumComandos.VOLVER_A_JUGAR_OTRA_MANO_JUEGO_CON_ALGORITMO, null);
                    
                    botonJugar.setVisible(true);
                    
                    lblFlop.setVisible(false);
                    lblTurn.setVisible(false);
                    lblRiver.setVisible(false);
                    lblCartasComunes.setVisible(true);
                    btnVolverAjugar.setVisible(false);
                    lblManoBanca.setVisible(false);
                    lblManoRobot.setVisible(false);
                	txtManoBanca.setVisible(false);
                	txtManoRobot.setVisible(false);
                	lblResultado.setVisible(false);
            		
            	}      
            }
        });
		
		btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
					System.exit(0);

            }
        });

	}
	
	public JTextField getTxtManoBanca() {
		return txtManoBanca;
	}


	public void setTxtManoBanca(JTextField txtManoBanca) {
		this.txtManoBanca = txtManoBanca;
	}


	public JTextField getTxtManoRobot() {
		return txtManoRobot;
	}


	public void setTxtManoRobot(JTextField txtManoRobot) {
		this.txtManoRobot = txtManoRobot;
	}


	public Tapete getCanvas() {
		return canvas;	}
	public void setCanvas(Tapete canvas) {
		this.canvas = canvas;	}
	public JTextField getTxtBote() {
		return txtBote;	}
	public JTextField getTxtStackRobot() {
		return txtStackRobot;	}

	public JTextField getTxtNumManosGanadas() {
		return txtNumManosGanadas;
	}


	public void setTxtNumManosGanadas(JTextField txtNumManosGanadas) {
		this.txtNumManosGanadas = txtNumManosGanadas;
	}

	public JTextField getTxtNumManosPerdidas() 
	{
		
		return txtNumManosPerdidas;
	
	}

	public void setTxtNumManosPerdidas(JTextField txtNumManosPerdidas)
	{
		
		this.txtNumManosPerdidas = txtNumManosPerdidas;
	
	}

	public JTextField getTxtNumManosEmpatadas()
	{
		
		return txtNumManosEmpatadas;
	
	}

	public void setTxtNumManoseEmpatadas(JTextField txtNumManoseEmpatadas)
	{
		
		this.txtNumManosEmpatadas = txtNumManoseEmpatadas;
	
	}


	public JLabel getLblProbabilidad() {
		return lblProbabilidad;
	}


	public void setLblProbabilidad(JLabel lblProbabilidad) {
		this.lblProbabilidad = lblProbabilidad;
	}
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuegoConAlgoritmo frame = new VentanaJuegoConAlgoritmo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
