package main;

import javax.swing.SwingUtilities;

import controller.Controller;
import view.View;
public class Main
{
 public static void main(String[] args)
 {
 // Swing graphics should be done in a concurrently-running
 // thread. This creates just such a thread.
 SwingUtilities.invokeLater(new Runnable() {
 @Override
 public void run() {
 // The new thread starts running in this method.
 // All this method does is call the _setup method.
 _setup();
 }
 });
 }
 private static void _setup()
 {
	
	Controller _controller = new Controller();
	View _view = new View(_controller);
	_controller.setView(_view);
 }
}