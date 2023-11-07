package libreria.com;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import entities.Datos;
import utilities.Constants;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyFrame extends JFrame  {
	
	//llamo a la conection, conexion
	private static Connection conexion;
	//llamo a los datos
	private static Datos datos = new Datos();
	private static JTable  tabla1;
	private static int listSeleccionado;
	private static JScrollPane jsp;
	   
	 public MyFrame( ArrayList<Datos> lista)
	    {
		 try {
			conexion = Conexion.obtener();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		 //---------------------------------------------ICONO------------------------------------------------
		 //icono nuevo, para la pantalla (detalle de color :) )
		 ImageIcon ImageIcon = new ImageIcon("resources/icono1.png");
	        Image image = ImageIcon.getImage();
	        this.setIconImage(image);
	        
	        //-------------------------------------TITULO DE LA VENTANA-----------------------------------------
	        setTitle("Libreria"); //Establece el titulo de la ventana principal 
	        setBounds(300, 90, 900, 600); //Establece la posicion y el tamañoo de la ventana principal. 
	        setDefaultCloseOperation(EXIT_ON_CLOSE); //Establece el comportamiento de cierre de la ventana principal.

	        
	        
	        //----------------------------------------TAMAÑO DEL PANEL----------------------------------------
	        //Un panel es un contenedor que se utiliza para organizar y colocar componentes, como botones, etiquetas, campos de texto, etc.
	        
	        JPanel panel = new JPanel(); //Crea un nuevo panel dentro de la ventana principal
	        panel.setBounds(5,250,900,200);
	        //(x,y, ancho, alto)
	        
	        //le carga todos los componentes al panel
	        //Llama a un metodo llamado "placeComponents" para agregar componentes al panel.
	        placeComponents(panel, lista);
	        //sumamos al frame (la pantalla principal) el panel 
	        add(panel);
           
	        // Hace visible la ventana principal y todos sus componentes
	     	 setVisible(true);
	    }


	 //---------------------------------------------DISEÑO DEL PANEL--------------------------------------------------
   private static void placeComponents(JPanel panel, ArrayList<Datos> lista)
		{
		panel.setLayout(null); //Establece el diseño del panel como nulo, lo que significa que los componentes se pueden posicionar de forma manual usando coordenadas absolutas.
		
		//ETIQUETAS DE TEXTO
		JLabel userLabel1 = new JLabel("Titulo"); 
		userLabel1.setBounds(10,20,80,25); 
		panel.add(userLabel1);
		JLabel userLabel2 = new JLabel("Autor");
		userLabel2.setBounds(10,50,100,25);
		panel.add(userLabel2);
		JLabel userLabel3 = new JLabel("Cant. Paginas");
		userLabel3.setBounds(10,80,80,25);
		panel.add(userLabel3);
		JLabel userLabel4 = new JLabel("Editorial");
		userLabel4.setBounds(10,110,80,25);
		panel.add(userLabel4);
		JLabel userLabel5 = new JLabel("Año Edicion");
		userLabel5.setBounds(10,140,80,25);
		panel.add(userLabel5);
		JLabel userLabel6 = new JLabel("Genero");
		userLabel6.setBounds(10,170,80,25);
		panel.add(userLabel6);
		
		
		//------------------------------------------CAMPO DE RELLENO--------------------------------------------
		//donde se cargan los datos
		JTextField titulo = new JTextField(100);//(100) cantidad de caracteres que puedo ingresar
		titulo.setBounds(100,20,165,25);
		panel.add(titulo);

		//campo de relleno del Autor
		JTextField autor = new JTextField(100);
		autor.setBounds(100,50,200,25);
		panel.add(autor);
		
		//Campo de relleno de Pagina
	 
		JTextField pagina = new JTextField(100);
		pagina.setBounds(100,80,165,25);
		panel.add(pagina);
		
		//Campo de relleno de editorial
		JTextField editorial = new JTextField(100);
		editorial.setBounds(100,110,165,25);
		panel.add(editorial);

		//campo de relleno de año
		JTextField edicion = new JTextField(100);
		edicion.setBounds(100,140,165,25);
		panel.add(edicion);
		
//		edicion.addKeyListener (
//				new KeyListener() {
//					
//					@Override
//					public void keyTyped(KeyEvent e) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//					@Override
//					public void keyReleased(KeyEvent e) {
//						// TODO Auto-generated method stub
//						int key = e.getKeyCode();
//						boolean numeros = key >= 48 && key <= 57;
//				        
//					    if (!numeros)
//					    {
//					        e.consume();
//					    }
//					}
//					
//					@Override
//					public void keyPressed(KeyEvent e) {
//						// TODO Auto-generated method stub
//						
//					}
//				});
				
		//campo de relleno de genero
		 JComboBox<String> comboGenero = new JComboBox<String>();
	     comboGenero.setBounds(100,170,165,25);
	     comboGenero.addItem("");
	     comboGenero.addItem("CUENTO");
	     comboGenero.addItem("COMEDIA");
	     comboGenero.addItem("FICCION");
	     comboGenero.addItem("POLITICA");
	     comboGenero.addItem("BIOGRAFIA");
	     comboGenero.addItem("HISTORIA");
	     comboGenero.addItem("AVENTURA");				     
	     comboGenero.addItem("ENSEÑANZA");
	     comboGenero.addItem("ANATOMIA");
	     comboGenero.addItem("ROMANCE");
	     comboGenero.addItem("NARRACION");
	     comboGenero.addItem("DRAMATICO");
	     comboGenero.addItem("LIRICO");
	     comboGenero.addItem("FANTASIA");
	     comboGenero.addItem("NOVELA");
	     comboGenero.addItem("TEATRAL");
	     comboGenero.addItem("EPOPEYA");
	     comboGenero.addItem("POEMA");
	     comboGenero.addItem("FABULA");
	     comboGenero.addItem("LEYENDA");
	     comboGenero.addItem("INFORMATIVO");
	     
	    
		 panel.add(comboGenero);
		
		
		 String str[] = { "1.Listar Autores existentes", "2.Listar Libros Existentes", "3.Listar Libros "
					+ "de un genero determinado", "4.Listar libros" + " por Autor Determinado", 
					"5. Listar Libros" + " por editorial", "6. Listar Libros" + " por editorial en rango de años", 
					"7. Listar Autores" + " por editorial", "8. Listar Libros Por Año", "9. Listar Libros "+ "por letra del apellido de los autores" };
				
		//Listados
		JList listado = new JList(str);
		listado.setBounds(350, 20, 290, 160);
		listado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		listado.addListSelectionListener(new ListSelectionListener() {
			@Override
					public void valueChanged(ListSelectionEvent e) {
				      if (!e.getValueIsAdjusting()) {
						 listSeleccionado = listado.getSelectedIndex();
	//					System.out.println(listSeleccionado);
				      }
					}
		});
		
		panel.add(listado);		
		
		//--------------------------------------BOTONES-------------------------------------------//
		//Bpton "Nuevo"
		JButton nuevoButton = new JButton("Nuevo");
		nuevoButton.setBounds(10, 250, 80, 25);
		panel.add(nuevoButton);
			
				
		//Boton "Listar"
		JButton listarButton = new JButton("Listar");
		listarButton.setBounds(650, 20, 80, 25);
		panel.add(listarButton);
			
		//Cuando se presiona boton Listar
		listarButton.addActionListener(e->{
			if(listSeleccionado !=-1) {
				// Crear una nueva ventana JFrame para mostrar los listados
				JFrame frameListados = new JFrame();
				frameListados.setTitle("Listados"); 
				frameListados.setBounds(300, 90, 600, 500); 
	
				 JPanel panel1 = new JPanel(); //Crea un nuevo panel dentro de la ventana principal
			     panel1.setBounds(300,90,400,200);
			     panel1.setLayout(null); 
				
			     JButton cerrarButton = new JButton("Cerrar");
				 cerrarButton.setBounds(10, 400, 80, 25);
				
				 cerrarButton.addActionListener(new ActionListener() {
				  
					@Override
					public void actionPerformed(ActionEvent e) {
						frameListados.dispose();			//cierra la ventana al precionar el boton cerrar		
					}
				});

				 jsp = new JScrollPane(); //agrega barras de desplazamiento a un componente que puede contener más contenido del que se puede mostrar en el área visible.
				  
				 switch ( listSeleccionado) {
				//Listado de Autores
				 case 0:
					     DefaultTableModel tabla = new DefaultTableModel();
						 JTable  tablaListados = new JTable();		
						
					  //se pone al scroll la tabla 1 (Esto permite agregar la capacidad de desplazamiento a la tabla si hay mÃ¡s filas o columnas de las que se pueden mostrar en la ventana)
						 jsp.setBounds( 10, 50, 400, 200 ); //Posicion y tamaÃ±o (x,y,alto y ancho)
					     jsp.setViewportView(tablaListados);
					     
						  listadoActores(tablaListados, jsp, tabla);
					    
						 
					 break;
					 
					//listado de libros
				  case 1:
					
					     DefaultTableModel tabla0 = new DefaultTableModel();
						 JTable  tablaListados0 = new JTable();		
						
					 
						 jsp.setBounds( 10, 50, 400, 200 ); 
					     jsp.setViewportView(tablaListados0);
					     
						  listadoLibros(tablaListados0, jsp, tabla0);
					 break;
				  case 2:
					  //Listado segun genero
					   
					     JComboBox<String> comboGenero1 = new JComboBox<String>();
					     comboGenero1.setBounds(10, 10, 100, 20 );
					     comboGenero1.addItem("COMEDIA");
					     comboGenero1.addItem("FICCION");
					     comboGenero1.addItem("POLITICA");
					     comboGenero1.addItem("BIOGRAFIA");
					     comboGenero1.addItem("HISTORIA");
					     comboGenero1.addItem("AVENTURA");				     
					     comboGenero1.addItem("ENSEÑANZA");
					     comboGenero1.addItem("ANATOMIA");
					     comboGenero1.addItem("ROMANCE");
					     comboGenero1.addItem("NARRACION");
					     comboGenero1.addItem("DRAMATICO");
					     comboGenero1.addItem("LIRICO");
					     comboGenero1.addItem("FANTASIA");
					     comboGenero1.addItem("NOVELA");
					     comboGenero1.addItem("TEATRAL");
					     comboGenero1.addItem("EPOPEYA");
					     comboGenero1.addItem("POEMA");
					     comboGenero1.addItem("FABULA");
					     comboGenero1.addItem("LEYENDA");
					     comboGenero1.addItem("INFORMATIVO");
					       
					   
					     JButton buscarButton = new JButton("Buscar");
					     buscarButton.setBounds(200, 10, 80, 25);
					     					
					     
					     panel1.add(comboGenero1);
					     panel1.add(buscarButton);
					     
					     JTable  tablaListados1 = new JTable();
					     
					     listadoLibrosXGenero(buscarButton,comboGenero1, tablaListados1);
					     
						  //se pone al scroll la tabla 1 (Esto permite agregar la capacidad de desplazamiento a la tabla si hay mÃ¡s filas o columnas de las que se pueden mostrar en la ventana)
					      jsp.setBounds( 10, 150, 400, 200 ); 
					      jsp.setViewportView(tablaListados1);
					    break; 
				  
					//lista libros por autor
				  case 3:
					  JLabel userLabelAutor = new JLabel("Autor");
						userLabelAutor.setBounds(20,20,80,25);
						
					  JTextField autor1 = new JTextField(100);
						autor1.setBounds(70,20,200,25);
						
						
						JButton buscar1Button = new JButton("Buscar");
					     buscar1Button.setBounds(320, 20, 80, 25);
					     					
					     panel1.add(userLabelAutor);
					     panel1.add(autor1);
					     panel1.add(buscar1Button);
					     JTable  tablaListados2 = new JTable();
					     
					     listadoLibrosPorAutor( autor1, buscar1Button, tablaListados2);
					     jsp.setBounds( 10, 150, 400, 200 ); //Posicion y tamaÃ±o (x,y,alto y ancho)
					      jsp.setViewportView(tablaListados2);
					 break;
					 
					 //lista libros por editorial
				  case 4:
					  JLabel userLabelEditorial = new JLabel ("Editorial");
					  userLabelEditorial.setBounds(20,20,80,25);
					  
					  JTextField editorial1 = new JTextField(100);
						editorial1.setBounds(70,20,200,25);
						
						
						
						JButton buscar2Button = new JButton("Buscar");
					     buscar2Button.setBounds(320, 20, 80, 25);
					     					
					     panel1.add(userLabelEditorial);
					     panel1.add(buscar2Button);
					     panel1.add(editorial1);
					     JTable  tablaListados3 = new JTable();
					     
					     listadoLibrosPorEditorial(editorial1, buscar2Button, tablaListados3);
					     jsp.setBounds( 10, 150, 400, 200 ); //Posicion y tamaÃ±o (x,y,alto y ancho)
					      jsp.setViewportView(tablaListados3);
						 break;
						 
				//lista libros por rango de años de una editorial determinada
				  case 5:
					  JLabel userLabelDesde = new JLabel("AÑO: Desde:");
						userLabelDesde.setBounds(90,110,80,25);
						
						  JLabel userLabelHasta = new JLabel("Hasta:");
							userLabelHasta.setBounds(230,110,80,25);
							
							JLabel userLabelEditorial7 = new JLabel ("  Editorial:");
							userLabelEditorial7.setBounds(100,50,80,25);
							
					  JTextField anio1 = new JTextField(4);
						anio1.setBounds(170,110,50,25);
						
						JTextField anio2 = new JTextField(4);
						anio2.setBounds(270,110,50,25);
						
						 JTextField editorial3 = new JTextField(100);
							editorial3.setBounds(170,50,200,25);
							
						
						JButton buscar3Button = new JButton("Buscar");
					     buscar3Button.setBounds(360, 110, 80, 25);
						
					     panel1.add(anio1);
					     panel1.add(anio2);
					     panel1.add(userLabelEditorial7);
					     panel1.add(editorial3);
					     panel1.add(buscar3Button);
					     panel1.add(userLabelDesde);
					     panel1.add(userLabelHasta);
					    
					     JTable  tablaListados4 = new JTable();
					     
					     listadoLibrosRangoAño(anio1, anio2, editorial3, buscar3Button, tablaListados4);
					     jsp.setBounds( 55, 150, 400, 200 ); 
					      jsp.setViewportView(tablaListados4);
						 break;
						 
					//listar autores por editorial
				  case 6:
					  JLabel userLabelEdi = new JLabel("Editorial");
						userLabelEdi.setBounds(20,20,80,25);
						
					  JTextField editorial2 = new JTextField(100);
						editorial2.setBounds(70,20,200,25);
						
						JButton buscar4Button = new JButton("Buscar");
					     buscar4Button.setBounds(320, 20, 80, 25);
					     					
					     
					     panel1.add(editorial2);
					     panel1.add(buscar4Button);
					     panel1.add(userLabelEdi);
					     JTable  tablaListados5 = new JTable();
					     
					     listadoAutoresPorEditorial(editorial2, buscar4Button, tablaListados5);
					     jsp.setBounds( 10, 150, 400, 200 ); 
					      jsp.setViewportView(tablaListados5);
						 break;
						 
					//listar libros por año
				  case 7:
					  JLabel userLabelAnio = new JLabel("Año");
						userLabelAnio.setBounds(20,20,80,25);
						
					  JTextField anioEdicion = new JTextField(100);
						anioEdicion.setBounds(70,20,200,25);
						panel.add(anioEdicion);
						
						JButton buscar5Button = new JButton("Buscar");
					     buscar5Button.setBounds(320, 20, 80, 25);
					     					
					     
					     panel1.add(anioEdicion);
					     panel1.add(buscar5Button);
					     panel1.add(userLabelAnio);
					     JTable  tablaListados6 = new JTable();
					     
					    
					     listadoLibroPorAnio (anioEdicion, buscar5Button, tablaListados6);
					     jsp.setBounds( 10, 150, 400, 200 ); 
					      jsp.setViewportView(tablaListados6);
					  
						 break;
						 
					//Busca Autor Por Letra Del Apellido
				  case 8:
					  
					  JLabel userLabelLetra = new JLabel("Letra");
						userLabelLetra.setBounds(20,20,80,25);
						
					  JTextField letra = new JTextField(1);
						letra.setBounds(70,20,200,25);
	
						JButton buscar6Button = new JButton("Buscar");
						buscar6Button.setBounds(320, 20, 80, 25);

						 panel1.add(letra);
					     panel1.add(buscar6Button);
					     panel1.add(userLabelLetra);
					     JTable  tablaListados7 = new JTable();
					     
					    
					     buscarAutorPorLetraDelApellido(letra, buscar6Button, tablaListados7);
					     jsp.setBounds( 10, 150, 400, 200 ); 
					      jsp.setViewportView(tablaListados7);
						 break;
				
						 
				  default:
					  break;
				 }
				
			
			     
				 panel1.add(jsp);
				 panel1.add(cerrarButton);
				 frameListados.add(panel1);
				 frameListados.setVisible(true);
			}
		});
		
		//LISTADO 10: Buscar por palabra en el titulo
		
		//Boton " Buscar por libro"
		JButton buscarButton = new JButton("Buscar Libro");
		buscarButton.setBounds(400, 250, 130, 25);
		panel.add(buscarButton);
				
		buscarButton.addActionListener(e->{
			try {
				buscarLibro(titulo.getText(),"UNO");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		   
		
		//boton limpiar
		JButton clearButton = new JButton("Limpiar");
		clearButton.setBounds(100, 250, 80, 25);
		panel.add(clearButton);  
		//ejecucion del boton LIMPIAR
		clearButton.addActionListener(e -> {   
			titulo.setText("");
			autor.setText("");
			pagina.setText("");
			editorial.setText("");
			edicion.setText("");
			comboGenero.setSelectedIndex(0);
			
			try {
				buscarLibro("","TODOS");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				});
		
		//boton de borrar
		JButton borrarButton = new JButton("Eliminar");
		borrarButton.setBounds(190, 250, 80, 25);
		panel.add(borrarButton);
		 
		//boton de modificar
		JButton modificarButton = new JButton("Modificar");
		modificarButton.setBounds(280, 250, 110, 25);
		panel.add(modificarButton);
		
		

		//-------------------------------------CREACION DE LA TABLA--------------------------------//
		tabla1 = new JTable();
		
		//Scroll
		JScrollPane  jsp = new JScrollPane(tabla1);
		jsp.setBounds( 10, 300, 800, 200 ); 
		
		//se define un modelo de datos que hay en la tabla
		// Este modelo se utilizarÃ¡ para agregar y manipular los datos de la tabla
		DefaultTableModel tabla = new DefaultTableModel();
	
		//-------------------------------ACCION BOTON NUEVO DE LA TABLA---------------------------------//
		
		//pasarlo por parametros lo de la conexion
		 nuevoButton.addActionListener(e -> {   
			 try {
						
				datos.setTitulo(titulo.getText());
				datos.setAutor(autor.getText());
				datos.setPaginas(Integer.valueOf(pagina.getText()));
				datos.setEditorial(editorial.getText());
				datos.setAnioedicion(Integer.valueOf(edicion.getText()));
				datos.setGenero( String.valueOf(comboGenero.getSelectedItem()));
				
				int	id = altaLibro(datos);
				
				datos.setIdlibro(id);
				
				
				 //a la fila de la tabla le cargamos los campos que tenemos en los text
					Object[] rowData = {titulo.getText(), autor.getText(), pagina.getText(),editorial.getText(),
							edicion.getText(),  String.valueOf(comboGenero.getSelectedItem()), id};     
					
					tabla.addRow(rowData); //le agrego una fila a la tabla y le cargo los datos 
					tabla1.repaint();
				      // Limpiar los campos de texto despues de la modificacion
        	        titulo.setText("");
        	        autor.setText("");
        	        pagina.setText("");
        	        editorial.setText("");
        	        edicion.setText("");
        	        comboGenero.setSelectedIndex(0);
        	        buscarLibro("","TODOS");
        	        
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				});

	         String[] fila = new String[7];//el 7es por los campos y se almacenan los datos de cada fila
	         
	         //se agregan las columnas de la tabla
	         tabla.addColumn("Titulo");
	         tabla.addColumn("Autor");
	         tabla.addColumn("Cant. Paginas");
	         tabla.addColumn("Editorial");
	         tabla.addColumn("Año Edicion");
	         tabla.addColumn("Genero");
	         tabla.addColumn("ID");
	        
	         
	         //agrega las finas al modelo de datos de la tabla
	         //recorro la lista de los datos
	         for(int f = 0; f < lista.size(); f++){ //el f se incrementa de a 1
	        	 fila[0] = lista.get(f).getTitulo();
	        	 fila[1] = lista.get(f).getAutor();
	        	 fila[2] = lista.get(f).getPaginas().toString();
	        	 fila[3] = lista.get(f).getEditorial();
	        	 fila[4] = lista.get(f).getAnioedicion().toString();
	        	 fila[5] = lista.get(f).getGenero();
	        	 fila[6] = lista.get(f).getIdlibro().toString();
	        	 
	        	 //le sumo el modelo a cada una d elas filas, y desp le carga el modelo a la tabla 1 
	        	 tabla.addRow(fila);
	         }
	     //Se establece el modelo de datos en la tabla1
	         tabla1.setModel(tabla);

	         
	         //Centra los datos de la columna
	         DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	         cellRenderer.setHorizontalAlignment(JLabel.CENTER);
	         //ponemos q el dato aparezca centrado en la 2 y 4, q son de int
	         tabla1.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
	         tabla1.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        
	         //scroll setea lo que tengo vista a la tabla
	         jsp.setViewportView(tabla1);
	         
	         //-----------------------------ACCION BOTON BORRAR ALGO DE LA TABLA-----------------------------//
	       //accion boton borrar
	         borrarButton.addActionListener(e -> {     
	 			// Remove the selected row from the model   
	 			int selectedRow = tabla1.getSelectedRow();    
	 			if(selectedRow>0) {
	 				titulo.setText("");
					autor.setText("");
					pagina.setText("");
					editorial.setText("");
					edicion.setText("");
					comboGenero.setSelectedIndex(0);
 		    	    eliminarLibro(tabla1.getModel().getValueAt(selectedRow, 6).toString());
	 			}
	 			else
	 			  JOptionPane.showMessageDialog(null, "Debe seleccionar un libro");
 		    	
	         });
	 		
	         //metodo de que la seleccion va a ser simple. 
	         //permite seleccionar un registro en la tabla
	         tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //"SINGLE_SELECTION", lo que significa que solo se puede seleccionar una Ãºnica fila a la vez.
	       
	         //lo q va a hacer cuando yo selecciono un registro
	         ListSelectionModel selectionModel = tabla1.getSelectionModel();
	         selectionModel.addListSelectionListener(e -> {   //ListSelectionListener al modelo de selecciÃ³n. Esto significa que se ejecutarÃ¡ el cÃ³digo dentro de las llaves {} cada vez que se seleccione una fila en la tabla.
//	        	 if (!e.getValueIsAdjusting()) {        
	        		 int selectedRow = tabla1.getSelectedRow();
	        		 if(selectedRow != -1) {
		                 titulo.setText(tabla1.getModel().getValueAt(selectedRow, 0).toString());
		                 autor.setText(tabla1.getModel().getValueAt(selectedRow, 1).toString());
		                 pagina.setText(tabla1.getModel().getValueAt(selectedRow, 2).toString());
		                 editorial.setText(tabla1.getModel().getValueAt(selectedRow, 3).toString());
		                 edicion.setText(tabla1.getModel().getValueAt(selectedRow, 4).toString());	                 
		                 comboGenero.setSelectedItem(tabla1.getModel().getValueAt(selectedRow, 5).toString().toUpperCase());
	        		 }
//	        		  }
	        	 });
	         

	         //----------------------------------ACCION BOTON MODIFICAR ALGO DE LA TABLA-----------------------------------
	         modificarButton.addActionListener(e -> {
	        	    int selectedRow = tabla1.getSelectedRow(); // Obtener la fila seleccionada en la tabla
	        	    if (selectedRow != -1) { // Verificar si se ha seleccionado una fila
	        	        // Obtener los valores de los campos de texto
	        	        String nuevoTitulo = titulo.getText();
	        	        String nuevoAutor = autor.getText();
	        	        String nuevaPagina = pagina.getText();
	        	        String nuevaEditorial = editorial.getText();
	        	        String nuevaEdicion = edicion.getText();
	        	        String nuevoGenero =  String.valueOf(comboGenero.getSelectedItem());
	        	        
	        	        // Modificar los valores en el modelo de la tabla
	        	        tabla1.getModel().setValueAt(nuevoTitulo, selectedRow, 0);
	        	        tabla1.getModel().setValueAt(nuevoAutor, selectedRow, 1);
	        	        tabla1.getModel().setValueAt(nuevaPagina, selectedRow, 2);
	        	        tabla1.getModel().setValueAt(nuevaEditorial, selectedRow, 3);
	        	        tabla1.getModel().setValueAt(nuevaEdicion, selectedRow, 4);
	        	        tabla1.getModel().setValueAt(nuevoGenero, selectedRow, 5);
	        	        
	        	        datos.setAnioedicion(Integer.valueOf(nuevaEdicion));
	        	        datos.setAutor(nuevoAutor);
	        	        datos.setEditorial(nuevaEditorial);
	        	        datos.setGenero(nuevoGenero);
	        	        datos.setPaginas(Integer.valueOf(nuevaPagina));
	        	        datos.setTitulo(nuevoTitulo);
	        	        
	       	        // Limpiar los campos de texto despues de la modificacion
	        	        titulo.setText("");
	        	        autor.setText("");
	        	        pagina.setText("");
	        	        editorial.setText("");
	        	        edicion.setText("");
	        	        comboGenero.setSelectedIndex(0);
	        	        
	        	        modificarLibro(datos, tabla1.getModel().getValueAt(selectedRow, 6).toString());
	        	        //Mensaje de confirmacion de la modificacion
//	        	        JOptionPane.showMessageDialog(null, "Se modificó el registro");
	        	    }
	        	});

	        
	         //suma al panel el scroll
	        
	     	panel.add(jsp); //Se agrega el JScrollPane (que contiene la tabla) al panel. Esto permite mostrar la tabla dentro del panel de la interfaz grÃ¡fica
	}
   
 //-------------------------------------------------------------METODO MODIFICAR---------------------------------
private static void modificarLibro(Datos model, String selectedRow) {
		// TODO Auto-generated method stub
	 try {
		 PreparedStatement pstmt;
		 //Alta libro en la base de datos
		 pstmt = conexion.prepareStatement(Constants.SQL_UPDATE_LIBRO);
	
		 pstmt.setString(1, model.getTitulo());
		 pstmt.setInt(2, model.getPaginas());
		 pstmt.setInt(3, model.getAnioedicion());
		 pstmt.setString(4, model.getEditorial());
		 pstmt.setString(5, model.getGenero());
		 pstmt.setString(6, model.getAutor());
		 pstmt.setInt(7,Integer.valueOf(selectedRow));
		 
		 int row = pstmt.executeUpdate();
		
		 
	 if (row > 0) {
		 
		 	         //Mensaje de confirmacion del alta
	        JOptionPane.showMessageDialog(null, "El libro ha sido modificado correctamente.");
     } else {
    	 JOptionPane.showMessageDialog(null, "El libro NO ha sido modificado correctamente.");
     }
     pstmt.close();
	 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}





//----------------------------------------LISTADOS----------------------------------------------------
   //LISTADO 1= CASE 0 = Listado de Actores existentes
   private static void listadoActores(JTable tablaListados, JScrollPane jsp, DefaultTableModel tabla) {
	   try {
	     ArrayList<Datos> lista = new ArrayList<>();
	  
	     tabla.addColumn("Nombre Apellido Autor");
	     
	     PreparedStatement pstmt;	
		
		 pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_AUTORES);		
	
		 ResultSet rs= pstmt.executeQuery(); 
		 while(rs.next()) //se recorre del resultset, 
		 {
			 //se obtienen los valores de las columnas, con Int o String segun el tipo de dato
			 datos = new Datos();
			 datos.setAutor(rs.getString(1));
			 lista.add(datos);
		  }
		 String[] fila = new String[1];
		   //agrega las fiLAS modelo de datos de la tabla
	       //recorro la lista de los datos
	       for(int f = 0; f < lista.size(); f++){ //el f se incrementa de a 1
	      	 fila[0] = lista.get(f).getAutor();
	      	 
	      	 //le sumo el modelo a cada una d elas filas, y desp le carga el modelo a la tabla 1 
	      	 tabla.addRow(fila);
	       }
	       //Se establece el modelo de datos en la tabla1
	       tablaListados.setModel(tabla);
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
 //LISTADO 2; CASE 1 = Listado de Libros existentes
   private static void listadoLibros(JTable tablaListados0, JScrollPane jsp, DefaultTableModel tabla0) {
	   try {
	     ArrayList<Datos> lista = new ArrayList<>();
	  
	     tabla0.addColumn("Titulos");
	     
	     PreparedStatement pstmt;	
		 pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_LIBROS);		
	
		 ResultSet rs= pstmt.executeQuery(); 
		 while(rs.next()) //se recorre del resultset, 
		 {
			 
			 datos = new Datos();
			 datos.setTitulo(rs.getString(1));
			 lista.add(datos);
		  }
		 String[] fila = new String[1];
		  
	       for(int f = 0; f < lista.size(); f++){ 
	      	 fila[0] = lista.get(f).getTitulo();

	      	 tabla0.addRow(fila);
	       }
	   
	       tablaListados0.setModel(tabla0);
	   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
   //LISTADO 3: CASE 2 = Listado de libros existentes segun el genero
   private static void listadoLibrosXGenero( JButton buscarButton, JComboBox<String> comboGenero1,
		   JTable tablaListados1 ) {

		  	//Boton dentro del panel para buscar por genero		     
		   buscarButton.addActionListener(e ->
		   {
			   try {  
			     //Creo el modelo de datos para la tabla
			     DefaultTableModel tablanew = new DefaultTableModel();
			     
			     //se agregan las columnas de la tabla
			     tablanew.addColumn("Titulo");
			     tablanew.addColumn("Autor");
			     tablanew.addColumn("Cant. Paginas");
			     tablanew.addColumn("Editorial");
			     tablanew.addColumn("Año Edicion");
			  
			     //cargo en generoSeleccionado el valor del item seleccionado en el combo
			     String generoSeleccionado =  String.valueOf(comboGenero1.getSelectedItem());
			     
			     PreparedStatement pstmt;
				
			     ArrayList<Datos> lista = new ArrayList<>();
			     
				//Consulta por genero, pasando por parametro el item del combo
				 pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_X_GENERO);
				 pstmt.setString(1, generoSeleccionado);
				
				 ResultSet rs= pstmt.executeQuery(); 
				 while(rs.next())  
				  {
					//se obtienen los valores de las columnas, con Int o String segun el tipo de dato
						 datos = new Datos();
						 datos.setTitulo(rs.getString(1));
						 datos.setAutor(rs.getString(2));
						 datos.setPaginas(rs.getInt(3));
						 datos.setAnioedicion(rs.getInt(4));
						 datos.setEditorial(rs.getString(5));
						 
						 lista.add(datos);
				  }
				 
				String[] fila = new String[5];
				   //agrega las finas al modelo de datos de la tabla
				   //recorro la lista de los datos
				   for(int f = 0; f < lista.size(); f++){ 	      
				      	 fila[0] = lista.get(f).getTitulo();
			        	 fila[1] = lista.get(f).getAutor();
			        	 fila[2] = lista.get(f).getPaginas().toString();
			        	 fila[3] = lista.get(f).getEditorial();
			        	 fila[4] = lista.get(f).getAnioedicion().toString();
			        			      	 
			        	 //le sumo el modelo a cada una d elas filas, y desp le carga el modelo a la tabla 1 
			        	 tablanew.addRow(fila);
				    }
				   
				 //Se establece el modelo de datos en la tabla1
			       tablaListados1.setModel(tablanew);
		       } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		       	      
		   });
   }
   
   //LISTADO 4: CASE 3: listado de libro por autor determinado 
   private static void listadoLibrosPorAutor( JTextField autor1, JButton buscar1Button, JTable tablaListados2) {
		// TODO Auto-generated method stub
		     
	   buscar1Button.addActionListener(e ->
	   {
	   try {
		     ArrayList<Datos> lista = new ArrayList<>();
		  
		
		     DefaultTableModel tablanew = new DefaultTableModel();
		     
		     tablanew.addColumn("Titulo");
		     tablanew.addColumn("Autor");
		     tablanew.addColumn("Cant. Paginas");
		     tablanew.addColumn("Editorial");
		     tablanew.addColumn("Año Edicion");
		     tablanew.addColumn("Genero");
		     PreparedStatement pstmt;	
			
		     String autorIngresado = autor1.getText().toUpperCase();
		     pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_X_AUTOR);		
		     pstmt.setString(1, "%"+ autorIngresado +"%");
		
			 ResultSet rs= pstmt.executeQuery(); 
			 while(rs.next()) 
			 {
 
				 datos = new Datos();
				 datos.setTitulo(rs.getString(1));
				 datos.setAutor(rs.getString(2));
				 datos.setPaginas(rs.getInt(3));
				 datos.setAnioedicion(rs.getInt(4));
				 datos.setEditorial(rs.getString(5));
				 datos.setGenero(rs.getString(6));
				 
				 lista.add(datos);
			  }
			 String[] fila = new String[6];

		       for(int f = 0; f < lista.size(); f++){ 
		    	   fila[0] = lista.get(f).getTitulo();
		        	fila[1] = lista.get(f).getAutor();
		        	fila[2] = lista.get(f).getPaginas().toString();
		        	 fila[3] = lista.get(f).getEditorial();
		        	 fila[4] = lista.get(f).getAnioedicion().toString();
		        	 fila[5] = lista.get(f).getGenero();

		        	 tablanew.addRow(fila);
		       }

		       tablaListados2.setModel(tablanew);
		   } catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
	   
   });
   
   }
   
   
   //LISTADO 5 CASE 4 = LISTA D ELIBROS POR EDITORIAL DETERMINADA 
   private static void listadoLibrosPorEditorial(JTextField editorial1, JButton buscar2Button, JTable tablaListados3) {
	    buscar2Button.addActionListener(e -> {
	        try {
	            ArrayList<Datos> lista = new ArrayList<>();

	            // Creo el modelo de datos para la tabla
	            DefaultTableModel tablanew = new DefaultTableModel();
	            tablanew.addColumn("Titulo");
	            tablanew.addColumn("Autor");
	            tablanew.addColumn("Paginas");
	            tablanew.addColumn("Año");
	            tablanew.addColumn("Genero");

	            PreparedStatement pstmt;
	            String editorialIngresado = editorial1.getText().toUpperCase();
	            pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_LIBRO_X_EDITORIAL);
	            pstmt.setString(1, "%" + editorialIngresado + "%");
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                Datos datos = new Datos();
	                datos.setTitulo(rs.getString("titulo"));
	                datos.setAutor(rs.getString("nombreyapellidoAutor"));
	                datos.setPaginas(rs.getInt("paginas"));
	                datos.setAnioedicion(rs.getInt("anio"));
	                datos.setGenero(rs.getString("genero"));

	                lista.add(datos);
	            }

	            for (Datos dato : lista) {
	                Object[] fila = new Object[5];
	                fila[0] = dato.getTitulo();
	                fila[1] = dato.getAutor();
	                fila[2] = dato.getPaginas();
	                fila[3] = dato.getAnioedicion();
	                fila[4] = dato.getGenero();
	                tablanew.addRow(fila);
	            }

	            tablaListados3.setModel(tablanew);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    });
	}



   
   //LISTADO 6 CASE 5= LISTADO POR EDITORIAL EN RANGO DE AÑOS 
   private static void listadoLibrosRangoAño(JTextField anio1, JTextField anio2, JTextField editorial3, JButton buscar3Button,
	        JTable tablaListados4) {
	    buscar3Button.addActionListener(e -> {
	        try {
	            ArrayList<Datos> lista = new ArrayList<>();

	            // Creo el modelo de datos para la tabla
	            DefaultTableModel tablanew = new DefaultTableModel();
	            tablanew.addColumn("Titulo");
	            tablanew.addColumn("Autor");
	            tablanew.addColumn("Paginas");
	            tablanew.addColumn("Editorial");
	            tablanew.addColumn("Año Edicion");
	            tablanew.addColumn("Genero");

	            PreparedStatement pstmt;
	            pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_RANGO_DE_AÑOS);
	            pstmt.setString(1, "%" + editorial3.getText().toUpperCase() + "%");
	            pstmt.setInt(2, Integer.parseInt(anio1.getText().trim()));
	            pstmt.setInt(3, Integer.parseInt(anio2.getText().trim()));
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                Datos datos = new Datos();
	                datos.setTitulo(rs.getString("titulo"));
	                datos.setAutor(rs.getString("nombreyapellidoAutor"));
	                datos.setPaginas(rs.getInt("paginas"));
	                datos.setEditorial(rs.getString("editorial"));
	                datos.setAnioedicion(rs.getInt("anio"));
	                datos.setGenero(rs.getString("genero"));
	                lista.add(datos);
	            }

	            String[] fila = new String[6];

	            for (Datos dato : lista) {
	                fila[0] = dato.getTitulo();
	                fila[1] = dato.getAutor();
	                fila[2] = String.valueOf(dato.getPaginas());
	                fila[3] = dato.getEditorial();
	                fila[4] = String.valueOf(dato.getAnioedicion());
	                fila[5] = dato.getGenero();
	                tablanew.addRow(fila);
	            }

	            tablaListados4.setModel(tablanew);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    });
	}

   //LISTADO 7: CASE 6 = LISTA LISTA DE AUTORES POR EDITORIAL 
   private static void listadoAutoresPorEditorial( JTextField editorial2, JButton buscar4Button, JTable tablaListados5) {
	  
 		// TODO Auto-generated method stub	     
 	   buscar4Button.addActionListener(e ->
 	   {
 	   try {
 		     ArrayList<Datos> lista = new ArrayList<>();
 		  
 		   //Creo el modelo de datos para la tabla
 		     DefaultTableModel tablanew = new DefaultTableModel();
 		     
 		     tablanew.addColumn("Autores que pertenecen a la editorial ingresada");

 		     PreparedStatement pstmt;	
 			
 		     String editorialIngresado = editorial2.getText().toUpperCase();
 		     pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_AUTOR_X_EDITORIAL);		
 		     pstmt.setString(1, "%"+ editorialIngresado +"%");
 		
 			 ResultSet rs= pstmt.executeQuery(); 
 			 while(rs.next()) //se recorre del resultset, 
 			 {
 				 //se obtienen los valores de las columnas, con Int o String segun el tipo de dato
 				 
 				 datos = new Datos();
 				 datos.setAutor(rs.getString(1));

 				 lista.add(datos);
 			  }
 			 String[] fila = new String[1];

 		       for(int f = 0; f < lista.size(); f++){ 
 		    	   fila[0] = lista.get(f).getAutor();

 		        	 tablanew.addRow(fila);
 		       }

 		       tablaListados5.setModel(tablanew);
 		   } catch (SQLException ex) {
 				// TODO Auto-generated catch block
 				ex.printStackTrace();
 			}
 	   
    });
 	   
 	  
 	}
   
   //LISTADO 8= CASE 7 = LISTA LIBROS POR AÑOS 
   private static void listadoLibroPorAnio(JTextField anioEdicion, JButton buscar5Button, JTable tablaListados6) {
	    buscar5Button.addActionListener(e -> {
	        try {
	            ArrayList<Datos> lista = new ArrayList<>();

	            // Creo el modelo de datos para la tabla
	            DefaultTableModel tablanew = new DefaultTableModel();
	            tablanew.addColumn("Título");
	            tablanew.addColumn("Autor");
	            tablanew.addColumn("Páginas");
	            tablanew.addColumn("Editorial");
	            tablanew.addColumn("Género");

	            PreparedStatement pstmt;
	            String anioIngresado = anioEdicion.getText().toUpperCase();
	            pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_LIBRO_X_AÑO);
	            pstmt.setString(1, "%" + anioIngresado + "%");

	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                Datos datos = new Datos();
	                datos.setTitulo(rs.getString("titulo"));
	                datos.setAutor(rs.getString("nombreyapellidoAutor"));
	                datos.setPaginas(rs.getInt("paginas"));
	                datos.setEditorial(rs.getString("editorial"));
	                datos.setGenero(rs.getString("genero"));

	                lista.add(datos);
	            }

	            for (Datos dato : lista) {
	                Object[] fila = new Object[5];
	                fila[0] = dato.getTitulo();
	                fila[1] = dato.getAutor();
	                fila[2] = dato.getPaginas();
	                fila[3] = dato.getEditorial();
	                fila[4] = dato.getGenero();
	                tablanew.addRow(fila);
	            }

	            tablaListados6.setModel(tablanew);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    });
	}

   
   //LISTADO 9 = CASE 8 = LISTA LIBROS POR LETRA DEL APELLIDO DEL AUTOR 
   private static void buscarAutorPorLetraDelApellido(JTextField letra, JButton buscar6Button, JTable tablaListados7) {
	    buscar6Button.addActionListener(e -> {
	        try {
	            ArrayList<Datos> lista = new ArrayList<>();
	            
	            // Creo el modelo de datos para la tabla
	            DefaultTableModel tablanew = new DefaultTableModel();
	            tablanew.addColumn("Título");
	            tablanew.addColumn("Autor");
	            tablanew.addColumn("Páginas");
	            tablanew.addColumn("Editorial");
	            tablanew.addColumn("Género");
	            tablanew.addColumn("Año");
	            
	            PreparedStatement pstmt;
	            pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA_LIBROS_X_LETRA_AUTOR);
	            pstmt.setString(1, letra.getText().trim().toUpperCase() + "%"); // Filtrar por la primera letra del apellido
	            
	            ResultSet rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	                Datos datos = new Datos();
	                datos.setTitulo(rs.getString("titulo"));
	                datos.setAutor(rs.getString("nombreyapellidoAutor"));
	                datos.setPaginas(rs.getInt("paginas"));
	                datos.setEditorial(rs.getString("editorial"));
	                datos.setGenero(rs.getString("genero"));
	                datos.setAnioedicion(rs.getInt("anio"));
	                lista.add(datos);
	            }
	            
	            for (Datos dato : lista) {
	                String[] fila = new String[6];
	                fila[0] = dato.getTitulo();
	                fila[1] = dato.getAutor();
	                fila[2] = String.valueOf(dato.getPaginas());
	                fila[3] = dato.getEditorial();
	                fila[4] = dato.getGenero();
	                fila[5] = String.valueOf(dato.getAnioedicion());
	                tablanew.addRow(fila);
	            }
	            
	            tablaListados7.setModel(tablanew);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    });
	}

//----------------------------------------ABM----------------------------------------------------
   //ALTA, BAJA Y MODIFICACION
   
   //ALTA
private static int altaLibro(Datos rowData) throws Exception {
		
		
		PreparedStatement pstmt;
			int id = 0;
		 try {
			 //Alta libro en la base de datos
			 pstmt = conexion.prepareStatement(Constants.SQL_INSERT_LIBRO, Statement.RETURN_GENERATED_KEYS);
		
			 pstmt.setString(1, rowData.getTitulo());
			 pstmt.setInt(2, rowData.getPaginas());
			 pstmt.setInt(3, rowData.getAnioedicion());
			 pstmt.setString(4, rowData.getEditorial());
			 pstmt.setString(5, rowData.getGenero());
			 pstmt.setString(6, rowData.getAutor());
			 
			 int row = pstmt.executeUpdate();
			
			 
		 if (row > 0) {
			 ResultSet rs = pstmt.getGeneratedKeys(); 
			 while(rs.next()) 
				id = rs.getInt(1);
			 	         //Mensaje de confirmacion del alta
 	        JOptionPane.showMessageDialog(null, "El libro ha sido dado de alta correctamente.");
	     } else {
	         throw new Exception("No se pudo dar de alta el libro en la base de datos.");
	     }
	     pstmt.close();
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return id;
	}
   
     
   private static void eliminarLibro(String id) {
	   PreparedStatement pstmt;
		
		 try {
			 //Buscar libro en la base de datos
			 pstmt = conexion.prepareStatement(Constants.SQL_DELETE_LIBRO);
		
			 pstmt.setInt(1, Integer.valueOf(id));
			 			 
			 int row = pstmt.executeUpdate();
			 if (row>0) {
				 				 
					buscarLibro("","TODOS");
								 
			 }
			 pstmt.close();
		 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		 }
					 
   }
  
   //BUSCAR CONSULTA 1
   private static void buscarLibro(String titulo, String opcion) throws Exception {
		
		DefaultTableModel tabla = new DefaultTableModel();
		ArrayList<Datos> lista = new ArrayList<>();
		PreparedStatement pstmt;
			
		 try {
			 if(opcion=="TODOS") {
				 pstmt = conexion.prepareStatement(Constants.SQL_CONSULTA1);
					
			 }else {
			 //Buscar libro en la base de datos
			 pstmt = conexion.prepareStatement(Constants.SQL_BUSCAR_LIBRO);
		
			 pstmt.setString(1, "%" + titulo + "%");
			 }
			 
			 ResultSet rs= pstmt.executeQuery(); 
			 while(rs.next()) //se recorre del resultset, 
			 {
				 //se obtienen los valores de las columnas, con Int o String segun el tipo de dato
				 datos = new Datos();
				 datos.setIdlibro(rs.getInt(1));
				 datos.setTitulo(rs.getString(2));
				 datos.setPaginas(rs.getInt(3));
				 datos.setAnioedicion(rs.getInt(4));
				 datos.setEditorial(rs.getString(5));
				 datos.setGenero(rs.getString(6));
				 datos.setAutor(rs.getString(7));
				 lista.add(datos);
			 }
			   String[] fila = new String[7];//el 6 es por los campos y se almacenan los datos de cada fila
		         
		         //se agregan las columnas de la tabla
		         tabla.addColumn("Titulo");
		         tabla.addColumn("Autor");
		         tabla.addColumn("Cant. Paginas");
		         tabla.addColumn("Editorial");
		         tabla.addColumn("Año Edicion");
		         tabla.addColumn("Genero");
		         tabla.addColumn("ID");
		        
		         
		         //agrega las finas al modelo de datos de la tabla
		         //recorro la lista de los datos
		         for(int f = 0; f < lista.size(); f++){ //el f se incrementa de a 1
		        	 fila[0] = lista.get(f).getTitulo();
		        	 fila[1] = lista.get(f).getAutor();
		        	 fila[2] = lista.get(f).getPaginas().toString();
		        	 fila[3] = lista.get(f).getEditorial();
		        	 fila[4] = lista.get(f).getAnioedicion().toString();
		        	 fila[5] = lista.get(f).getGenero();
		        	 fila[6] = lista.get(f).getIdlibro().toString();
		        	 
		        	 //le sumo el modelo a cada una d elas filas, y desp le carga el modelo a la tabla 1 
		        	 tabla.addRow(fila);
		         }
		     //Se establece el modelo de datos en la tabla1
		         tabla1.setModel(tabla);
		 
	    
	     pstmt.close();
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
	}

  
}