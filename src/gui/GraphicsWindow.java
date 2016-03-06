package gui;

import javax.swing.JFrame;




public class GraphicsWindow extends JFrame
{
 private static final long serialVersionUID = 1L;
 public GraphicsWindow()
 {
	 this.setResizable(false);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setSize(1200, 800); //  need to make these global
	 this.setVisible(true);
  }
 }
