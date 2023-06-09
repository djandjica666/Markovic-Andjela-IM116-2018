package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dialog.DialogCircle;
import dialog.DialogCircleM;
import dialog.DialogDonut;
import dialog.DialogDonutM;
import dialog.DialogLineM;
import dialog.DialogPointM;
import dialog.DialogRectangle;
import dialog.DialogRectangleM;
import geometry.Circle;
import geometry.Donut;
import geometry.DrawingPanel;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DrawingPanel drawingPanel;
	private ArrayList<Shape> slctd = new ArrayList<Shape>();
	private boolean selected;
	private Color clr;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton btnLine;
	private int counter = 0;
	private Point startPoint, endPoint, upperLeft, center;
	private JToggleButton btnRectangle;
	private JToggleButton btnCircle;
	private JToggleButton btnColor;
	private JToggleButton btnSelect;

	

	public Frame() {
		setForeground(new Color(238, 130, 238));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 840, 550);
		contentPane = new JPanel();
		drawingPanel = new DrawingPanel();
		drawingPanel.setBackground(new Color(204, 255, 255));
		drawingPanel.setForeground(new Color(0, 0, 0));
		drawingPanel.setBounds(101, 11, 662, 468);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnPoint = new JToggleButton("Point");
		btnPoint.setBackground(Color.WHITE);
		btnPoint.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnPoint.setForeground(new Color(0, 0, 153));
		btnPoint.setBounds(9, 11, 82, 33);
		contentPane.add(btnPoint);
		buttonGroup.add(btnPoint);
		drawingPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 102)));
		contentPane.add(drawingPanel);
		contentPane.add(btnPoint, BorderLayout.SOUTH);
		drawingPanel.setLayout(null);
		
		btnLine = new JToggleButton("Line");
		btnLine.setBackground(Color.WHITE);
		btnLine.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnLine.setForeground(new Color(0, 0, 153));
		btnLine.setBounds(9, 55, 82, 33);
		buttonGroup.add(btnLine);
		contentPane.add(btnLine);
		
		btnRectangle = new JToggleButton("Rectangle");
		btnRectangle.setBackground(Color.WHITE);
		btnRectangle.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnRectangle.setForeground(new Color(0, 0, 153));
		btnRectangle.setBounds(9, 99, 82, 33);
		buttonGroup.add(btnRectangle);
		contentPane.add(btnRectangle);
		
		btnCircle = new JToggleButton("Circle");
		btnCircle.setBackground(Color.WHITE);
		btnCircle.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCircle.setForeground(new Color(0, 0, 128));
		btnCircle.setBounds(9, 143, 82, 33);
		buttonGroup.add(btnCircle);
		contentPane.add(btnCircle);
		
		JToggleButton btnDonut = new JToggleButton("Donut");
		btnDonut.setBackground(new Color(255, 255, 255));
		btnDonut.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDonut.setForeground(new Color(0, 0, 128));
		btnDonut.setBounds(9, 187, 82, 31);
		buttonGroup.add(btnDonut);
		contentPane.add(btnDonut);
		
		btnColor = new JToggleButton("Color");
		btnColor.setBackground(new Color(240, 248, 255));
		btnColor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnColor.setForeground(new Color(0, 0, 128));
		btnColor.addActionListener(new ActionListener() {
			//coloring
			public void actionPerformed(ActionEvent e) {
				
				for(Shape s : slctd) {
					clr = JColorChooser.showDialog(null, "Choose the color:",Color.BLACK);
					if(s instanceof Point){
							repaint();
							s.setColor(clr);
							repaint();
					}else if(s instanceof Line) {
							repaint();
							s.setColor(clr);
							repaint();
					}else if(s instanceof Rectangle) {
							repaint();
							s.setColor(clr);
							repaint();
					}else if(s instanceof Circle) {
						if(s.getClass() != Circle.class) {
							repaint();
							s.setColor(clr);
							repaint();
						}else {
							repaint();
							s.setColor(clr);
							repaint();
						}		
					}}
			}
		});
		btnColor.setBounds(9, 358, 82, 33);
		contentPane.add(btnColor);
		buttonGroup.add(btnColor);
		
		btnSelect = new JToggleButton("Select");
		btnSelect.setBackground(new Color(240, 248, 255));
		btnSelect.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnSelect.setForeground(new Color(0, 0, 128));
		btnSelect.setBounds(9, 314, 82, 33);
		contentPane.add(btnSelect);
		buttonGroup.add(btnSelect);
		
		JToggleButton btnModify = new JToggleButton("Modify");
		btnModify.setBackground(new Color(240, 248, 255));
		btnModify.setBounds(9, 402, 82, 33);
		contentPane.add(btnModify);
		btnModify.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnModify.setForeground(new Color(0, 0, 102));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//modify
				if(drawingPanel.getShapes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No shapes to modify. Create a shape first.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(slctd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "If you want to modify a shape select it first.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(slctd.size() > 1) {
					JOptionPane.showMessageDialog(null, "It is not possible to modify multiple shapes at once. Select only one.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					try {
					for(Shape s : drawingPanel.getShapes()) {
						if(s instanceof Point) {
							if(s.isSelected()) {
								Point temp = (Point) s;
								Point p = new Point();
								
								DialogPointM dlgPointM = new DialogPointM();
								dlgPointM.getxField().setText(Integer.toString(temp.getX()));
								dlgPointM.getyField().setText(Integer.toString(temp.getY()));
								dlgPointM.setVisible(true);
								
								if(dlgPointM.isCommited()) {
									p.setColor(temp.getColor());
									p.setX(Integer.parseInt(dlgPointM.getxField().getText()));
									p.setY(Integer.parseInt(dlgPointM.getyField().getText()));
									p.setSelected(false);
									drawingPanel.getShapes().remove(s);
									drawingPanel.getShapes().add(p);
									//drawingPanel.getShapes().set(drawingPanel.getShapes().indexOf(temp), p);
									repaint();
									slctd.clear();
								}
							}
						} else if (s instanceof Line){
							if(s.isSelected()) {
								Line temp = (Line) s;
								Line l = new Line();
								
								DialogLineM dlgLineM = new DialogLineM();
								dlgLineM.getSpXField().setText(Integer.toString(temp.getStartPoint().getX()));
								dlgLineM.getSpYField().setText(Integer.toString(temp.getStartPoint().getY()));
								dlgLineM.getEpXField().setText(Integer.toString(temp.getEndPoint().getX()));
								dlgLineM.getEpYField().setText(Integer.toString(temp.getEndPoint().getY()));
								dlgLineM.setVisible(true);
								
								if(dlgLineM.isCommited()) {
									l.setColor(temp.getColor());
									l.setSelected(false);
									drawingPanel.getShapes().remove(s);
									drawingPanel.getShapes().add(l);
									l.setStartPoint(new Point(Integer.parseInt(dlgLineM.getSpXField().getText()), Integer.parseInt(dlgLineM.getSpYField().getText())));
									l.setEndPoint(new Point(Integer.parseInt(dlgLineM.getEpXField().getText()), Integer.parseInt(dlgLineM.getEpYField().getText())));
									//drawingPanel.getShapes().set(drawingPanel.getShapes().indexOf(temp), l);
									repaint();
									slctd.clear();
								}
							}
						
						} else if(s instanceof Rectangle) {
							if(s.isSelected()) {
								Rectangle temp = (Rectangle) s;
								Rectangle r = new Rectangle();
								
								DialogRectangleM dlgRectangleM = new DialogRectangleM();
								dlgRectangleM.getHeightField().setText(Integer.toString(temp.getHeight()));
								dlgRectangleM.getWidthField().setText(Integer.toString(temp.getWidth()));
								dlgRectangleM.getUpperXField().setText(Integer.toString(temp.getUpperLeft().getX()));
								dlgRectangleM.getUpperYField().setText(Integer.toString(temp.getUpperLeft().getY()));
								dlgRectangleM.setVisible(true);
								
								if(dlgRectangleM.isCommited()) {
									r.setColor(temp.getColor());
									r.setSelected(false);
									drawingPanel.getShapes().remove(s);
									drawingPanel.getShapes().add(r);
									r.setHeight(Integer.parseInt(dlgRectangleM.getHeightField().getText()));
									r.setWidth(Integer.parseInt(dlgRectangleM.getWidthField().getText()));
									r.setUpperLeft(new Point(Integer.parseInt(dlgRectangleM.getUpperXField().getText()), Integer.parseInt(dlgRectangleM.getUpperYField().getText())));
									//drawingPanel.getShapes().set(drawingPanel.getShapes().indexOf(temp), r);
									repaint();
									slctd.clear();
								}
							}
						}else if(s instanceof Circle) {
							if(s.isSelected()) {
								if(s.getClass() != Circle.class) {
										Donut temp = (Donut) s;
										Donut d = new Donut();
										
										DialogDonutM dlgDonutM = new DialogDonutM();
										dlgDonutM.getInRField().setText(Integer.toString(temp.getInnerR()));
										dlgDonutM.getOutRField().setText(Integer.toString(temp.getR()));
										dlgDonutM.getCenterXField().setText(Integer.toString(temp.getCenter().getX()));
										dlgDonutM.getCenterYField().setText(Integer.toString(temp.getCenter().getY()));
										dlgDonutM.setVisible(true);
										
										if(dlgDonutM.isCommited()) {
											d.setColor(temp.getColor());
											d.setSelected(false);
											drawingPanel.getShapes().remove(s);
											drawingPanel.getShapes().add(d);
											d.setInnerR(Integer.parseInt(dlgDonutM.getInRField().getText()));
											d.setR(Integer.parseInt(dlgDonutM.getOutRField().getText()));
											d.setCenter(new Point(Integer.parseInt(dlgDonutM.getCenterXField().getText()), Integer.parseInt(dlgDonutM.getCenterYField().getText())));
											//drawingPanel.getShapes().set(drawingPanel.getShapes().indexOf(temp), d);
											repaint();
											slctd.clear();
									}
								}else {
									Circle temp = (Circle) s;
									Circle c = new Circle();
									
									DialogCircleM dlgCircleM = new DialogCircleM();
									dlgCircleM.getrField().setText(Integer.toString(temp.getR()));
									dlgCircleM.getCenterXField().setText(Integer.toString(temp.getCenter().getX()));
									dlgCircleM.getCenterYField().setText(Integer.toString(temp.getCenter().getY()));
									dlgCircleM.setVisible(true);
									
									if(dlgCircleM.isCommited()) {
										c.setColor(temp.getColor());
										c.setSelected(false);
										drawingPanel.getShapes().remove(s);
										drawingPanel.getShapes().add(c);
										c.setR(Integer.parseInt(dlgCircleM.getrField().getText()));
										c.setCenter(new Point(Integer.parseInt(dlgCircleM.getCenterXField().getText()), Integer.parseInt(dlgCircleM.getCenterYField().getText())));
										//drawingPanel.getShapes().set(drawingPanel.getShapes().indexOf(temp), c);
										repaint();
										slctd.clear();
									}
								}
							}
				
						}}}
				catch (Exception izuzetak){
					
				}
				
			}}});
		buttonGroup.add(btnModify);
		
		JToggleButton btnErase = new JToggleButton("Erase");
		btnErase.setBackground(new Color(240, 248, 255));
		btnErase.setBounds(9, 446, 82, 33);
		contentPane.add(btnErase);
		btnErase.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnErase.setForeground(new Color(255, 0, 0));
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(drawingPanel.getShapes().isEmpty()) {
					JOptionPane.showMessageDialog(null, "The drawing panel is empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				}else if(!drawingPanel.getShapes().isEmpty() && slctd.isEmpty()) {
					JOptionPane.showMessageDialog(null, "The shape that you want to erase isn't selected.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
					if(JOptionPane.showConfirmDialog(null, "Are you sure you want to erase the selected shape?", "ERASE",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
							drawingPanel.getShapes().removeAll(slctd);
							slctd.clear();
							repaint();	
					}
				}
			}
		});
		buttonGroup.add(btnErase);
		
		
		
		drawingPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//to select
				if (btnSelect.isSelected()) {
					for(Shape s : drawingPanel.getShapes()) {
						if(s.contains(e.getX(), e.getY())){
							if(s instanceof Point) {
								if(!s.isSelected()) {
									s.setSelected(true);
									slctd.add(s);
									repaint();
								}else {
									s.setSelected(false);
									slctd.remove(s);
									repaint();
								}
							} else if(s instanceof Line) {
								if(!s.isSelected()) {
									s.setSelected(true);
									slctd.add(s);
									repaint();
								}else {
									s.setSelected(false);
									slctd.remove(s);
									repaint();
								}
							}else if(s instanceof Rectangle) {
								if(!s.isSelected()) {
									s.setSelected(true);
									slctd.add(s);
									repaint();
								}else {
									s.setSelected(false);
									slctd.remove(s);
									repaint();
								}
							}else if(s instanceof Circle) {
								if(s.getClass() != Circle.class) {
									if(!s.isSelected()) { 
										s.setSelected(true);
										slctd.add(s);
										repaint();
									}else {
										s.setSelected(false);
										slctd.remove(s);
										repaint();
									}
								}else {
									if(!s.isSelected()) { //circle
										s.setSelected(true);
										slctd.add(s);
										repaint();
									}else {
										s.setSelected(false);
										slctd.remove(s);
										repaint();
									}
								}
							}
							
						}
					}
					
				
					
				
					//drawing	
				
		 } else if(btnPoint.isSelected()) {
					Point p = new Point(e.getX(),e.getY());
					drawingPanel.getShapes().add(p);
					repaint();
				}else if(btnLine.isSelected()) {
					counter++;
					if(counter == 1) {
						startPoint = new Point(e.getX(), e.getY());
					}else if(counter == 2){
						endPoint = new Point(e.getX(),e.getY());
						Line l = new Line(startPoint, endPoint);
						drawingPanel.getShapes().add(l);
						repaint();
						counter = 0;
					}
				}else if(btnRectangle.isSelected()) {
					upperLeft = new Point(e.getX(),e.getY());
					DialogRectangle dlgRectangle = new DialogRectangle();
					dlgRectangle.setVisible(true);
					
					if(dlgRectangle.isCommited()) {
						int width = Integer.parseInt(dlgRectangle.getWidthField().getText());
						int height = Integer.parseInt(dlgRectangle.getHeightField().getText());
						Rectangle r = new Rectangle(upperLeft, width, height);
						drawingPanel.getShapes().add(r);
						repaint();
						
					}
				}else if (btnCircle.isSelected()) {
					center = new Point(e.getX(),e.getY());
					DialogCircle dlgCircle = new DialogCircle();
					dlgCircle.setVisible(true);
					
					if(dlgCircle.isCommited()) {
						int r = Integer.parseInt(dlgCircle.getRField().getText());
						Circle c = new Circle(center, r);
						drawingPanel.getShapes().add(c);
						repaint();
					}
					
				}else if (btnDonut.isSelected()){
					center = new Point(e.getX(),e.getY());
					DialogDonut dlgDonut = new DialogDonut();
					dlgDonut.setVisible(true);
					
					if(dlgDonut.isCommited()) {
						int innerR = Integer.parseInt(dlgDonut.getInRField().getText());
						int r = Integer.parseInt(dlgDonut.getOutRField().getText());
						Donut d = new Donut(center, r, innerR);
						drawingPanel.getShapes().add(d);
						repaint();
						}
				}
				
			}
			
			
		});
		
	}			



	public boolean isSelected() {
		return selected;
	}



	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		}
