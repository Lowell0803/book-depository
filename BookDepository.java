import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ClassCastException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;
import java.io.FileInputStream;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.text.DocumentFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.AbstractDocument;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

import java.text.DecimalFormat;

class BookDepository {
	public static void createMainWindow() {
		Font font1, font2, font3, font4, font2_1, font3_1, font4_1, font4_3;
		try {
			font1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/bebas_neue/BebasNeue-Regular.ttf"));
			font2 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/montserrat/Montserrat-Regular.ttf"));
			font3 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/roboto/Roboto-Regular.ttf"));
			font4 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/open_sans/OpenSans-Regular.ttf"));
			font2_1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/montserrat/Montserrat-Bold.ttf"));
			font3_1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/roboto/Roboto-Bold.ttf"));
			font4_1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/open_sans/OpenSans-Bold.ttf"));
			font4_3 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("fonts/open_sans/OpenSans-Light.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font1);
		} catch (IOException | FontFormatException e) {
			System.out.println("IOException | FontFormatException error!");
			font1 = new Font("Century Gothic", Font.BOLD, 20);
       		font2 = new Font("Century Gothic", Font.BOLD, 20);
       		font3 = new Font("Century Gothic", Font.BOLD, 20);
       		font4 = new Font("Century Gothic", Font.BOLD, 20);
       		font2_1 = new Font("Century Gothic", Font.BOLD, 20);
       		font3_1 = new Font("Century Gothic", Font.BOLD, 20);
       		font4_1 = new Font("Century Gothic", Font.BOLD, 20);
       		font4_3 = new Font("Century Gothic", Font.BOLD, 20);
			e.printStackTrace();
		}

		JFrame mainFrame = new JFrame("Book Depository");

		Border buttonBorder = BorderFactory.createCompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 2, 2, Color.decode("#4479B3")),
			BorderFactory.createEmptyBorder(0, 0, 0, 0)
		);
		Border selectedButtonBorder = BorderFactory.createCompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 1, 2, Color.decode("#4479B3")),
			BorderFactory.createMatteBorder(0, 0, 5, 0, Color.decode("#2a9df4"))
		);
		Border regularButtonBorder = BorderFactory.createCompoundBorder(
			BorderFactory.createMatteBorder(0, 0, 2, 2, Color.decode("#4479B3")),
			BorderFactory.createEmptyBorder(0, 0, 0, 0)
		);
		Border textFieldBorder = BorderFactory.createCompoundBorder(
			BorderFactory.createMatteBorder(1, 1, 2, 2, Color.decode("#4479B3")),
			BorderFactory.createEmptyBorder(0, 0, 0, 0)
		);

		int mainFrame_w = 1000;
		int mainFrame_h = 600;
		mainFrame.setSize(mainFrame_w, mainFrame_h);

		mainFrame.getContentPane().setBackground(Color.WHITE);

		int topnav_w = mainFrame_w;
		int topnav_h = 75;
		int topnav_x = 0;
		int topnav_y = 0;

		JPanel topnav = new JPanel();
		topnav.setBounds(topnav_x, topnav_y, topnav_w, topnav_h);
        topnav.setBackground(Color.decode("#163e88"));

        JLabel mainHeader = new JLabel("| Book Depository");
        mainHeader.setFont(font1.deriveFont(40f));
        mainHeader.setForeground(Color.WHITE);
        mainHeader.setBounds(10, 20, 246, 40);

		int sidenav_w = 100;
		int sidenav_h = 100;
		int sidenav_x = 0;
		int sidenav_y = topnav_h;

		int icon_w = sidenav_w;
		int icon_h = sidenav_h;

		ImageIcon icon1 = new ImageIcon("img/favorites.png");
		Image image1 = icon1.getImage();
		Image new_image1 = image1.getScaledInstance(icon_w, icon_h, java.awt.Image.SCALE_SMOOTH);
		Icon favIcon = new ImageIcon(new_image1);

		ImageIcon icon2 = new ImageIcon("img/bookshelf.png");
		Image image2 = icon2.getImage();
		Image new_image2 = image2.getScaledInstance(icon_w, icon_h, java.awt.Image.SCALE_SMOOTH);
		Icon bookshelfIcon = new ImageIcon(new_image2);

		ImageIcon icon3 = new ImageIcon("img/statistics.png");
		Image image3 = icon3.getImage();
		Image new_image3 = image3.getScaledInstance(icon_w, icon_h, java.awt.Image.SCALE_SMOOTH);
		Icon statisticsIcon = new ImageIcon(new_image3);

		ImageIcon icon4 = new ImageIcon("img/settings.png");
		Image image4 = icon4.getImage();
		Image new_image4 = image4.getScaledInstance(icon_w, icon_h, java.awt.Image.SCALE_SMOOTH);
		Icon settingsIcon = new ImageIcon(new_image4);

		JButton favButton = new JButton(favIcon);
		favButton.setBounds(sidenav_x, sidenav_y, sidenav_w, sidenav_h);

		JButton bookButton = new JButton(bookshelfIcon);
		bookButton.setBounds(sidenav_x, sidenav_y + (sidenav_h * 1), sidenav_w, sidenav_h);

		JButton statsButton = new JButton(statisticsIcon);
		statsButton.setBounds(sidenav_x, sidenav_y + (sidenav_h * 2), sidenav_w, sidenav_h); 

		JButton settingsButton = new JButton(settingsIcon);
		settingsButton.setBounds(sidenav_x, sidenav_y + (sidenav_h * 3), sidenav_w, sidenav_h);

		favButton.setBackground(Color.WHITE);
		bookButton.setBackground(Color.WHITE);
		statsButton.setBackground(Color.WHITE);
		settingsButton.setBackground(Color.WHITE);

		favButton.setBorder(buttonBorder);
		bookButton.setBorder(buttonBorder);
		statsButton.setBorder(buttonBorder);
		settingsButton.setBorder(buttonBorder);

		favButton.setFocusPainted(false);
		bookButton.setFocusPainted(false);
		statsButton.setFocusPainted(false);
		settingsButton.setFocusPainted(false);

		JButton donateButton = new JButton();

		int panel_w = mainFrame_w - sidenav_w;
		int panel_h = mainFrame_h - topnav_h;
		int panel_x = sidenav_w + 1;
		int panel_y = topnav_h + 1; 

		/* -------------------- FAVORITES -------------------- */

		Border blackBottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK); 

		JPanel favPanel = new JPanel();
		favPanel.setLayout(null);
		favPanel.setBounds(panel_x, panel_y, panel_w, panel_h);

		JLabel favHeader = new JLabel("Add a Book");
		favHeader.setFont(font2_1.deriveFont(50f));
		favHeader.setBounds(40, 20, 400, 80);

		int fLbl_x = 40;
		int fLbl_y = 150;
		int fLbl_w = 70;
		int fLbl_h = 28;

		int fLbl_y_diff = 50;
		int space1 = 2;

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(fLbl_x, fLbl_y, fLbl_w, fLbl_h);
		lblTitle.setFont(font4.deriveFont(22f));
		lblTitle.setForeground(Color.BLACK);
		JTextField tfTitle = new JTextField();
		tfTitle.setFont(font4_3.deriveFont(20f));
		tfTitle.setForeground(Color.BLACK);
		tfTitle.setOpaque(false);
		tfTitle.setBounds(fLbl_x + fLbl_w, fLbl_y + space1, 400, fLbl_h);
		tfTitle.setBorder(blackBottomBorder);
		String tfTitlePrompt = "Ex: Kaguya-sama: Love is War Vol. 01";
		tfTitle.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (tfTitle.getText().trim().equals(tfTitlePrompt.trim())) {
                	tfTitle.setText("");
                    tfTitle.setForeground(Color.BLACK);
                }
                else if (tfTitle.getText().length() <= 0) {
                    tfTitle.setText("");
                    tfTitle.setForeground(Color.BLACK);
                } 
                else {
                	
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (tfTitle.getText().length() >=1) {
                    
                }else {
                    tfTitle.setText(tfTitlePrompt);
                    tfTitle.setForeground(Color.RED);
                }
            }
        });

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(fLbl_x, fLbl_y + fLbl_y_diff, fLbl_w + 20, fLbl_h);
		lblAuthor.setFont(font4.deriveFont(22f));
		lblAuthor.setForeground(Color.BLACK);
		JTextField tfAuthor = new JTextField();
		tfAuthor.setFont(font4_3.deriveFont(20f));
		tfAuthor.setForeground(Color.BLACK);
		tfAuthor.setOpaque(false);
		tfAuthor.setBounds(fLbl_x + fLbl_w + 20, fLbl_y + (fLbl_y_diff + space1), 220, fLbl_h);
		tfAuthor.setBorder(blackBottomBorder);
		String tfAuthorPrompt = "Ex: Aka Akasaka";
		tfAuthor.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (tfAuthor.getText().trim().equals(tfAuthorPrompt.trim())) {
                	tfAuthor.setText("");
                    tfAuthor.setForeground(Color.BLACK);
                }
                else if (tfAuthor.getText().length() <= 0) {
                    tfAuthor.setText("");
                    tfAuthor.setForeground(Color.BLACK);
                } 
                else {
                	
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (tfAuthor.getText().length() >=1) {
                    
                }else {
                    tfAuthor.setText(tfAuthorPrompt);
                    tfAuthor.setForeground(Color.RED);
                }
            }
        });

		JLabel lblPageNum = new JLabel("No. of Pages:");
		lblPageNum.setBounds(fLbl_x + fLbl_w + 420, fLbl_y, 400, fLbl_h);
		lblPageNum.setFont(font4.deriveFont(22f));
		lblPageNum.setForeground(Color.BLACK);
		JTextField tfPageNum = new JTextField();
		tfPageNum.setFont(font4_3.deriveFont(20f));
		tfPageNum.setForeground(Color.BLACK);
		tfPageNum.setOpaque(false);
		tfPageNum.setBounds(fLbl_x + fLbl_w + 560, fLbl_y, 160, fLbl_h);
		tfPageNum.setBorder(blackBottomBorder);
		String tfPageNumPrompt = "204";
		tfPageNum.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (tfPageNum.getText().trim().equals(tfPageNumPrompt.trim())) {
                	tfPageNum.setText("");
                    tfPageNum.setForeground(Color.BLACK);
                }
                else if (tfPageNum.getText().length() <= 0) {
                    tfPageNum.setText("");
                    tfPageNum.setForeground(Color.BLACK);
                } 
                else {
                	
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (tfPageNum.getText().length() >=1) {
                    
                }else {
                    tfPageNum.setText(tfPageNumPrompt);
                    tfPageNum.setForeground(Color.RED);
                }
            }
        });
		((AbstractDocument)tfPageNum.getDocument()).setDocumentFilter(new DocumentFilter(){
		        Pattern regEx = Pattern.compile("\\d*");

		        @Override
		        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
		            Matcher matcher = regEx.matcher(text);
		            if(!matcher.matches()){
		                return;
		            }
		            super.replace(fb, offset, length, text, attrs);
		        }
		    });

		JLabel lblPubComp = new JLabel("Publishing Company:");
		lblPubComp.setBounds(fLbl_x + 330, fLbl_y + fLbl_y_diff, fLbl_w + 150, fLbl_h);
		lblPubComp.setFont(font4.deriveFont(22f));
		lblPubComp.setForeground(Color.BLACK);
		JTextField tfPubComp = new JTextField();
		tfPubComp.setFont(font4_3.deriveFont(20f));
		tfPubComp.setForeground(Color.BLACK);
		tfPubComp.setOpaque(false);
		tfPubComp.setBounds(fLbl_x + fLbl_w + 20 + 470, fLbl_y + (fLbl_y_diff + space1), 231, fLbl_h);
		tfPubComp.setBorder(blackBottomBorder);
		String tfPubCompPrompt = "Ex: Viz Media";
		tfPubComp.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (tfPubComp.getText().trim().equals(tfPubCompPrompt.trim())) {
                	tfPubComp.setText("");
                    tfPubComp.setForeground(Color.BLACK);
                }
                else if (tfPubComp.getText().length() <= 0) {
                    tfPubComp.setText("");
                    tfPubComp.setForeground(Color.BLACK);
                } 
                else {
                	
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (tfPubComp.getText().length() >=1) {
                    
                }else {
                    tfPubComp.setText(tfPubCompPrompt);
                    tfPubComp.setForeground(Color.RED);
                }
            }
        });

		JLabel lblDate = new JLabel("Date Finished:");
		lblDate.setBounds(fLbl_x, fLbl_y + (fLbl_y_diff * 2), fLbl_w + 80, fLbl_h);
		lblDate.setFont(font4.deriveFont(22f));
		lblDate.setForeground(Color.BLACK);
		JTextField tfDate = new JTextField();
		tfDate.setFont(font4_3.deriveFont(20f));
		tfDate.setForeground(Color.BLACK);
		tfDate.setOpaque(false);
		tfDate.setBounds(fLbl_x + fLbl_w + 90, fLbl_y + ((fLbl_y_diff * 2) + space1), 220, fLbl_h);
		tfDate.setBorder(blackBottomBorder);
		String tfDatePrompt = "Ex: October 05, 2020";
		tfDate.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (tfDate.getText().trim().equals(tfDatePrompt.trim())) {
                	tfDate.setText("");
                    tfDate.setForeground(Color.BLACK);
                }
                else if (tfDate.getText().length() <= 0) {
                    tfDate.setText("");
                    tfDate.setForeground(Color.BLACK);
                } 
                else {
                	
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (tfDate.getText().length() >=1) {
                    
                }else {
                    tfDate.setText(tfDatePrompt);
                    tfDate.setForeground(Color.RED);
                }
            }
        });

		JLabel lblPubYr = new JLabel("Year Published:");
		lblPubYr.setBounds(fLbl_x + 389, fLbl_y + (fLbl_y_diff * 2), fLbl_w + 110, fLbl_h);
		lblPubYr.setFont(font4.deriveFont(22f));
		lblPubYr.setForeground(Color.BLACK);
		JTextField tfPubYr = new JTextField();
		tfPubYr.setFont(font4_3.deriveFont(20f));
		tfPubYr.setForeground(Color.BLACK);
		tfPubYr.setOpaque(false);
		tfPubYr.setBounds(fLbl_x + fLbl_w + 490, fLbl_y + ((fLbl_y_diff * 2) + space1), 231, fLbl_h);
		tfPubYr.setBorder(blackBottomBorder);
		String tfPubYrPrompt = "2018";
		tfPubYr.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (tfPubYr.getText().trim().equals(tfPubYrPrompt.trim())) {
                	tfPubYr.setText("");
                    tfPubYr.setForeground(Color.BLACK);
                }
                else if (tfPubYr.getText().length() <= 0) {
                    tfPubYr.setText("");
                    tfPubYr.setForeground(Color.BLACK);
                } 
                else {
                	
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (tfPubYr.getText().length() >=1) {
                    
                }else {
                    tfPubYr.setText(tfPubYrPrompt);
                    tfPubYr.setForeground(Color.RED);
                }
            }
        });
        ((AbstractDocument)tfPubYr.getDocument()).setDocumentFilter(new DocumentFilter(){
		        Pattern regEx = Pattern.compile("\\d*");

		        @Override
		        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
		            Matcher matcher = regEx.matcher(text);
		            if(!matcher.matches()){
		                return;
		            }
		            super.replace(fb, offset, length, text, attrs);
		        }
		    });

		JLabel lblRating = new JLabel("Rating:");
		lblRating.setBounds(fLbl_x, fLbl_y + (fLbl_y_diff * 3), fLbl_w + 100, fLbl_h);
		lblRating.setFont(font4.deriveFont(22f));
		lblRating.setForeground(Color.BLACK);
		JTextField tfRating = new JTextField();
		tfRating.setFont(font4_3.deriveFont(20f));
		tfRating.setForeground(Color.BLACK);
		tfRating.setOpaque(false);
		tfRating.setBounds(fLbl_x + fLbl_w + 20, fLbl_y + ((fLbl_y_diff * 3) + space1), 291, fLbl_h);
		tfRating.setBorder(blackBottomBorder);
		String tfRatingPrompt = "9";
		tfRating.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (tfRating.getText().trim().equals(tfRatingPrompt.trim())) {
                	tfRating.setText("");
                    tfRating.setForeground(Color.BLACK);
                }
                else if (tfRating.getText().length() <= 0) {
                    tfRating.setText("");
                    tfRating.setForeground(Color.BLACK);
                } 
                else {
                	
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (tfRating.getText().length() >=1) {
                    
                }else {
                    tfRating.setText(tfRatingPrompt);
                    tfRating.setForeground(Color.RED);
                }
            }
        });
        ((AbstractDocument)tfRating.getDocument()).setDocumentFilter(new DocumentFilter(){
		        Pattern regEx = Pattern.compile("\\d*");

		        @Override
		        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
		            Matcher matcher = regEx.matcher(text);
		            if(!matcher.matches()){
		                return;
		            }
		            super.replace(fb, offset, length, text, attrs);
		        }
		    });

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setBounds(35, 125, 805, 225);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(font1.deriveFont(24f));
		btnSubmit.setBackground(Color.decode("#163e88"));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBorderPainted(false);
		btnSubmit.setBounds(40, 380, 120, 44);

		JButton btnClear = new JButton("Clear");
		btnClear.setFont(font1.deriveFont(24f));
		btnClear.setBackground(Color.decode("#ff0000"));
		btnClear.setForeground(Color.WHITE);
		btnClear.setBorderPainted(false);
		btnClear.setBounds(180, 380, 120, 44);

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tfTitle.setText("");
				tfAuthor.setText("");
				tfPageNum.setText("");
				tfDate.setText("");
				tfPubComp.setText("");
				tfPubYr.setText("");
				tfRating.setText("");
			}
		});

		favPanel.add(favHeader);

		favPanel.add(lblTitle);
		favPanel.add(lblAuthor);
		favPanel.add(lblPageNum);
		favPanel.add(lblDate);
		favPanel.add(lblPubComp);
		favPanel.add(lblPubYr);
		favPanel.add(lblRating);

		favPanel.add(tfTitle);
		favPanel.add(tfAuthor);
		favPanel.add(tfPageNum);
		favPanel.add(tfDate);
		favPanel.add(tfPubComp);
		favPanel.add(tfPubYr);
		favPanel.add(tfRating);

		favPanel.add(infoPanel);

		favPanel.add(btnSubmit);
		favPanel.add(btnClear);

		/* -------------------- BOOKSHELF -------------------- */
		
		JPanel bookPanel = new JPanel();
		bookPanel.setLayout(null);
		bookPanel.setBounds(panel_x, panel_y, panel_w, panel_h);

		JPanel tablePanel = new JPanel();
		
		TableModel tableModel = new DefaultTableModel(){
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		JTable mainTable = new JTable(tableModel);

		mainTable.getTableHeader().setReorderingAllowed(false);
		mainTable.getTableHeader().setResizingAllowed(false);

		int tableSPane_x = 25;
		int tableSPane_y = 25;
		int tableSPane_w = panel_w - ((tableSPane_x * 2) + 25);
		int tableSPane_h = panel_h - 200;
		
		JScrollPane tableSPane = new JScrollPane(mainTable);
		tableSPane.setBounds(tableSPane_x, tableSPane_y, tableSPane_w, tableSPane_h);

		Border blackBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);

		mainTable.getTableHeader().setFont(font1.deriveFont(14f));
		mainTable.getTableHeader().setBackground(new Color(40, 40, 40));
		mainTable.setBorder(blackBorder);
		mainTable.setShowGrid(true);
		mainTable.setGridColor(Color.BLACK);
		mainTable.setOpaque(false);

		tableSPane.setOpaque(false);
		tableSPane.getViewport().setOpaque(false);
		tableSPane.setBorder(blackBorder);

		mainTable.setFocusable(false);

		String filePath = "data/data.txt";
        File file = new File(filePath);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(">");
            DefaultTableModel model = (DefaultTableModel)mainTable.getModel();
            model.setColumnIdentifiers(columnsName);
            
            Object[] tableLines = br.lines().toArray();
            
            int lineNumbers = 0;
            for(int i = 0; i < tableLines.length; i++)
            {
            	lineNumbers += 1;
                String line = tableLines[i].toString().trim();
                line = " " + String.valueOf(lineNumbers) + line;
                String[] dataRow = line.split(">");
                model.addRow(dataRow);
            } 

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(mainTable.getModel());

        int lblFilter_x = 640;
        int lblFilter_y = 370;
        int lblFilter_w = 50;
        int lblFilter_h = 22;

        JLabel jlblFilter = new JLabel("Search:");
        jlblFilter.setFont(font1.deriveFont(20f));
        jlblFilter.setBounds(lblFilter_x, lblFilter_y, lblFilter_w, lblFilter_h);

	    JTextField jtfFilter = new JTextField();
	    jtfFilter.setBounds(lblFilter_x + (lblFilter_w + 10), lblFilter_y, lblFilter_w + 100,lblFilter_h);

	        mainTable.setRowSorter(rowSorter);

	        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

	            @Override
	            public void insertUpdate(DocumentEvent e) {
	                String text = jtfFilter.getText();

	                if (text.trim().length() == 0) {
	                    rowSorter.setRowFilter(null);
	                } else {
	                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	                }
	            }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	                String text = jtfFilter.getText();

	                if (text.trim().length() == 0) {
	                    rowSorter.setRowFilter(null);
	                } else {
	                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	                }
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	                throw new UnsupportedOperationException("Not supported yet."); 
	            }

	        });

	    JTextField removeRowTField = new JTextField();
		removeRowTField.setOpaque(false);
		removeRowTField.setForeground(Color.BLACK);
		removeRowTField.setBounds(25, 370, 40, 30);

		JButton removeRowButton = new JButton("Remove");
		removeRowButton.setFont(font1.deriveFont(20f));
		removeRowButton.setBackground(Color.decode("#163e88"));
		removeRowButton.setForeground(Color.WHITE);
		removeRowButton.setBorderPainted(false);
		removeRowButton.setBounds(70, 370, 100, 30);

		removeRowButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				if (removeRowTField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please input a number.", 
						"Value Error!", JOptionPane.ERROR_MESSAGE);
					removeRowTField.setText("");
				}
				else {
					String removeRowIndexValue = removeRowTField.getText();
					int index = 2;
					try{
			    		index = Integer.parseInt(removeRowIndexValue) - 1;
					} catch(NumberFormatException e){ 
			    		System.out.println("Exception catched!");
					}
					int intCurrentNumber = mainTable.getRowCount();
					String strCurrentNumber = "[Current Number of Books: " + String.valueOf(intCurrentNumber) + "]";

					if(index >= mainTable.getRowCount()){

					JOptionPane.showMessageDialog(null, "The number exceeded the number of books in your list.\n" + strCurrentNumber, 
						"Removal Denied!", JOptionPane.ERROR_MESSAGE);
					removeRowTField.setText("");
					}
					else if (index <= -1) {

					JOptionPane.showMessageDialog(null, "Please input a number greater than zero.", 
						"Removal Denied!", JOptionPane.ERROR_MESSAGE);
					removeRowTField.setText("");
				} else {
			

					DefaultTableModel model = (DefaultTableModel)mainTable.getModel();
					model.removeRow(index);

					File file = new File("data/data.txt");

					File tempFile = new File("data/tempdata.txt");
					try {
		
						BufferedReader br = new BufferedReader(new FileReader(file));

						Object[] tableLines = br.lines().toArray();


						String dataRowRemoved = "";
					    for(int i = 0; i < tableLines.length; i++)
					    {
					        if (i == (index + 1)) {
						        String line = tableLines[i].toString().trim();
						        String[] dataRow = line.split(">");
						        int dataRowIndex = 0;
						        for (String dataRowValue : dataRow) {
						        	dataRowIndex += 1;
						        	dataRowRemoved += dataRowValue;
						        	if (dataRowIndex < 8) {
							        	dataRowRemoved += ">";
							        }
						        	
						        }

						    } else {
						    	continue;
						    }
					    }  
					    br.close();

					    BufferedReader reader = new BufferedReader(new FileReader(file));
					    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

					    String lineToRemove = dataRowRemoved;
					    String currentLine;

					    while((currentLine = reader.readLine()) != null) {
					    	String trimmedLine = currentLine.trim();
					    	if (trimmedLine.equals(lineToRemove)) continue;
					    	writer.write(currentLine + System.getProperty("line.separator"));
					    }
					    writer.close();
					    reader.close();

					    file.delete();
					    boolean success = tempFile.renameTo(file);
					    tempFile.renameTo(file);
					    model.setRowCount(0);   
					} catch (Exception e) {
						e.printStackTrace();

					}
					
					String e_filePath = "data/data.txt";
			        File e_file = new File(e_filePath);

			        BufferedReader e_br = null;
			        try {
			            e_br = new BufferedReader(new FileReader(e_file));

			            String e_firstLine = e_br.readLine().trim();
			            String[] e_columnsName = e_firstLine.split(">");
			            DefaultTableModel e_model = (DefaultTableModel)mainTable.getModel();
			            e_model.setColumnIdentifiers(e_columnsName);
			            
			            Object[] e_tableLines = e_br.lines().toArray();
			            
			            int e_lineNumbers = 0;
			            for(int i = 0; i < e_tableLines.length; i++)
			            {
			            	e_lineNumbers += 1;
			                String e_line = e_tableLines[i].toString().trim();
			                e_line = " " + String.valueOf(e_lineNumbers) + e_line;
			                String[] e_dataRow = e_line.split(">");
			                e_model.addRow(e_dataRow);
			            } 

			            e_br.close();

			        } catch (Exception e) {
			            e.printStackTrace();
			            
			        }

			        int pfWidth = 100;
					mainTable.getColumnModel().getColumn(0).setPreferredWidth(pfWidth - 57);
					mainTable.getColumnModel().getColumn(1).setPreferredWidth(pfWidth * 2);
					mainTable.getColumnModel().getColumn(2).setPreferredWidth(pfWidth);
					mainTable.getColumnModel().getColumn(3).setPreferredWidth(pfWidth - 20);
					mainTable.getColumnModel().getColumn(4).setPreferredWidth(pfWidth + 20);
					mainTable.getColumnModel().getColumn(5).setPreferredWidth(pfWidth + 10);
					mainTable.getColumnModel().getColumn(6).setPreferredWidth(pfWidth - 10);
					mainTable.getColumnModel().getColumn(7).setPreferredWidth(pfWidth - 20);

					removeRowTField.setText("");
				}
				}
				
				
			}
		});

		bookPanel.add(removeRowTField);
		bookPanel.add(removeRowButton);

	    bookPanel.add(jlblFilter);
	    bookPanel.add(jtfFilter);

		bookPanel.add(tableSPane);

		/* FAVORITES EXTRA */

		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				String valTitle = tfTitle.getText().replace(">", "").trim();
				String valAuthor = tfAuthor.getText().replace(">", "").trim();
				String valPageNum = tfPageNum.getText().replace(">", "").trim();
				String valDate = tfDate.getText().replace(">", "").trim();
				String valPubComp = tfPubComp.getText().replace(">", "").trim();
				String valPubYr = tfPubYr.getText().replace(">", "").trim();
				String valRating = tfRating.getText().replace(">", "").trim();

				try {
					if (valTitle.equals("") | valAuthor.equals("") | valPageNum.equals("") | valDate.equals("") | 
						valPubComp.equals("") | valPubYr.equals("") | valRating.equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill in the text fields.", 
							"Submission Denied!", JOptionPane.ERROR_MESSAGE);
					} else if (valPubYr.length() < 4 | valPubYr.length() > 4) {
						JOptionPane.showMessageDialog(null, "Make sure to follow the format of the year\n[Ex: 1998, 2007, 2018]", 
							"Submission Denied!", JOptionPane.ERROR_MESSAGE);
					} else if (Integer.parseInt(valRating) < 1 | Integer.parseInt(valRating) > 10) {
						JOptionPane.showMessageDialog(null, "The rating should be from 1 to 10.", 
							"Submission Denied!", JOptionPane.ERROR_MESSAGE);
					} else {
						PrintWriter ppw = null;
						PrintWriter ypw = null;
						PrintWriter rpw = null;

						PrintWriter pw = null;

						int pdata = Integer.parseInt(valPageNum);
						int ydata = Integer.parseInt(valPubYr);
						int rdata = Integer.parseInt(valRating);
						
						String dataset = "> " + valTitle + "> " + valAuthor + "> " + valPageNum + " pages> " + 
							valDate + "> " + valPubComp + "> " + valPubYr + "> " + valRating + " stars";

						try {
							File file = new File("data/data.txt");
							
							FileWriter fw = new FileWriter(file, true);
							pw = new PrintWriter(fw);
							pw.println(dataset);

							BufferedReader br = new BufferedReader(new FileReader(file));
							DefaultTableModel model = (DefaultTableModel)mainTable.getModel();

							Object[] tableLines = br.lines().toArray();
		            
				            for(int i = 0; i < tableLines.length; i++)
				            {
				            	if (i == tableLines.length-1) {
					                String[] dataRow = dataset.split(">");
					                model.addRow(dataRow);
					        	} else {
					        		continue;
					        	}
				            } 
				            String statsMessage = " Also, restart your application to update the \"Statistics\" tab.";
							JOptionPane.showMessageDialog(null, "The book was added into the list. Check it in your \"bookshelf\"." + statsMessage, 
								"Book Added!", JOptionPane.PLAIN_MESSAGE);
				            br.close();
				            pw.close();
				            fw.close(); 

						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							if (pw != null) {
								pw.close();
							}
						}
				        pw.close();
				        DefaultTableModel model = (DefaultTableModel)mainTable.getModel();
				        model.setRowCount(0);

				        String e_filePath = "data/data.txt";
				        File e_file = new File(e_filePath);

				        BufferedReader e_br = null;
				        try {
				            e_br = new BufferedReader(new FileReader(e_file));

				            String e_firstLine = e_br.readLine().trim();
				            String[] e_columnsName = e_firstLine.split(">");
				            DefaultTableModel e_model = (DefaultTableModel)mainTable.getModel();
				            e_model.setColumnIdentifiers(e_columnsName);
				            
				            Object[] e_tableLines = e_br.lines().toArray();
				            
				            int e_lineNumbers = 0;
				            for(int i = 0; i < e_tableLines.length; i++)
				            {
				            	e_lineNumbers += 1;
				                String e_line = e_tableLines[i].toString().trim();
				                e_line = " " + String.valueOf(e_lineNumbers) + e_line;
				                String[] e_dataRow = e_line.split(">");
				                e_model.addRow(e_dataRow);
				            } 

				            e_br.close();

				        } catch (Exception e) {
				            e.printStackTrace();
				            
				        }

				        int pfWidth = 100;
						mainTable.getColumnModel().getColumn(0).setPreferredWidth(pfWidth - 57);
						mainTable.getColumnModel().getColumn(1).setPreferredWidth(pfWidth * 2);
						mainTable.getColumnModel().getColumn(2).setPreferredWidth(pfWidth);
						mainTable.getColumnModel().getColumn(3).setPreferredWidth(pfWidth - 20);
						mainTable.getColumnModel().getColumn(4).setPreferredWidth(pfWidth + 20);
						mainTable.getColumnModel().getColumn(5).setPreferredWidth(pfWidth + 10);
						mainTable.getColumnModel().getColumn(6).setPreferredWidth(pfWidth - 10);
						mainTable.getColumnModel().getColumn(7).setPreferredWidth(pfWidth - 20);

						removeRowTField.setText("");

					}
				} catch(NumberFormatException e){ 
				    System.out.println("Pages exception catched.");
				}

				tfTitle.setText("");
				tfAuthor.setText("");
				tfPageNum.setText("");
				tfDate.setText("");
				tfPubComp.setText("");
				tfPubYr.setText("");
				tfRating.setText("");
			}
		});

		/* FAVORITES EXTRA */

		/* -------------------- STATISTICS -------------------- */

		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(null);
		statsPanel.setBounds(panel_x, panel_y, panel_w, panel_h);

		JLabel statsHeader = new JLabel("Statistics");
		statsHeader.setFont(font2_1.deriveFont(50f));
		statsHeader.setBounds(40, 20, 400, 80);

		try {
			int sLbl_x = 45;
			int sLbl_y = 150;
			int sLbl_w = 450;
			int sLbl_h = 28;

			int sLbl_y_diff = 50;
			
			ArrayList<String> listPages = new ArrayList<String>();
			for (int i = 0;i<mainTable.getModel().getRowCount();i++) {
				listPages.add(String.valueOf(mainTable.getModel().getValueAt(i,3)));
			}
			int totalPages = 0;
			for (int i = 0;i<listPages.size();i++) {
				String strPages = listPages.get(i).replaceAll("[^0-9]", "");
				try{
				    totalPages += Integer.parseInt(strPages);
				} catch(NumberFormatException e){ 
				    System.out.println("Pages exception catched.");
				}
			}

			String unitPages = "";
			if (totalPages <= 1) {
				unitPages = " page";
			} else {
				unitPages = " pages";
			}

			JLabel lblTotalPages = new JLabel("Total Number of Pages: ");
			lblTotalPages.setBounds(sLbl_x, sLbl_y, sLbl_w, sLbl_h);
			lblTotalPages.setFont(font4.deriveFont(22f));
			lblTotalPages.setForeground(Color.BLACK);

			JLabel a_lblTotalPages = new JLabel(String.valueOf(totalPages) + unitPages);
			a_lblTotalPages.setBounds(sLbl_x + sLbl_w, sLbl_y, sLbl_w, sLbl_h);
			a_lblTotalPages.setFont(font4.deriveFont(22f));
			a_lblTotalPages.setForeground(Color.BLACK);

			int totalRating = 0;
			int count = 0;

			for (int i = 0;i<mainTable.getModel().getRowCount();i++) {
				try{
					String strTempRating = String.valueOf(mainTable.getModel().getValueAt(i,7)).trim().replaceAll("[^0-9]", "");
				    totalRating += Integer.parseInt(strTempRating); 
				    count += 1;
				} catch(NumberFormatException e){ 
				    System.out.println("Rating exception catched.");
				}
			}
			Double avgRating = (double)totalRating / count;
			DecimalFormat decimalFormat = new DecimalFormat("#.00");

			JLabel lblAvgRating = new JLabel("Average Rating: ");
			lblAvgRating.setBounds(sLbl_x, sLbl_y + sLbl_y_diff, sLbl_w, sLbl_h);
			lblAvgRating.setFont(font4.deriveFont(22f));
			lblAvgRating.setForeground(Color.BLACK);

			JLabel a_lblAvgRating = new JLabel(decimalFormat.format(avgRating) + " stars");
			a_lblAvgRating.setBounds(sLbl_x + sLbl_w, sLbl_y + sLbl_y_diff, sLbl_w, sLbl_h);
			a_lblAvgRating.setFont(font4.deriveFont(22f));
			a_lblAvgRating.setForeground(Color.BLACK);

			ArrayList<String> listAuthor = new ArrayList<String>();
			for (int i = 0;i<mainTable.getModel().getRowCount();i++) {
				listAuthor.add(String.valueOf(mainTable.getModel().getValueAt(i,2)).trim());
			}
			String mostFrequentAuthor
			    = listAuthor.stream()
			          .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
			          .entrySet()
			          .stream()
			          .max(Comparator.comparing(Map.Entry::getValue))
			          .get()
			          .getKey();

			JLabel lblFrequentAuthor = new JLabel("Most Frequent Author: ");
			lblFrequentAuthor.setBounds(sLbl_x, sLbl_y + (sLbl_y_diff * 2), sLbl_w, sLbl_h);
			lblFrequentAuthor.setFont(font4.deriveFont(22f));
			lblFrequentAuthor.setForeground(Color.BLACK);

			JLabel a_lblFrequentAuthor = new JLabel(mostFrequentAuthor);
			a_lblFrequentAuthor.setBounds(sLbl_x + sLbl_w, sLbl_y + (sLbl_y_diff * 2), sLbl_w, sLbl_h);
			a_lblFrequentAuthor.setFont(font4.deriveFont(22f));
			a_lblFrequentAuthor.setForeground(Color.BLACK);

			ArrayList<Integer> listYear = new ArrayList<Integer>();
			for (int i = 0;i<mainTable.getModel().getRowCount();i++) {
				try{
				    listYear.add(Integer.parseInt(String.valueOf(mainTable.getModel().getValueAt(i,6)).trim())); 
				} catch(NumberFormatException e){ 
				    System.out.println("Years exception catched.");
				}
			}

			int mostMatches = 0;

		    Integer[] arrListYear = listYear.toArray(new Integer[listYear.size()]);;
			Map<Integer,Integer> countYear = new LinkedHashMap<Integer,Integer>();

			for (Integer i : arrListYear){
			    if (!countYear.containsKey(i))
			        countYear.put(i, 1);
			    else
			        countYear.put(i, countYear.get(i) + 1);
			    }

			LinkedHashMap<Integer, Integer> countYearSorted = 
			    countYear.entrySet()
			       .stream()             
			       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			       .collect(Collectors.toMap(e -> e.getKey(), 
			                                 e -> e.getValue(), 
			                                 (e1, e2) -> null,
			                                 () -> new LinkedHashMap<Integer, Integer>()));

			
			int max = Collections.max(countYear.values());

			String countFrequentYear = (countYear.entrySet().stream()
			    .filter(entry -> entry.getValue() == max)
			    .map(entry -> entry.getKey())
			    .collect(Collectors.toList())).toString();

			String f_countFrequentYear = countFrequentYear.replaceAll("[^0-9.,]+","");
			f_countFrequentYear = f_countFrequentYear.replace(",","/");

			JLabel lblFrequentYear = new JLabel("Most Frequent Published Year: ");
			lblFrequentYear.setBounds(sLbl_x, sLbl_y + (sLbl_y_diff * 3), sLbl_w, sLbl_h);
			lblFrequentYear.setFont(font4.deriveFont(22f));
			lblFrequentYear.setForeground(Color.BLACK);

			JLabel a_lblFrequentYear = new JLabel(f_countFrequentYear);
			a_lblFrequentYear.setBounds(sLbl_x + sLbl_w, sLbl_y + (sLbl_y_diff * 3), sLbl_w, sLbl_h);
			a_lblFrequentYear.setFont(font4.deriveFont(22f));
			a_lblFrequentYear.setForeground(Color.BLACK);

			ArrayList<String> listPubComp = new ArrayList<String>();
			for (int i = 0;i<mainTable.getModel().getRowCount();i++) {
				listPubComp.add(String.valueOf(mainTable.getModel().getValueAt(i,5)).trim());
			}
			String mostFrequentPubComp
			    = listPubComp.stream()
			          .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
			          .entrySet()
			          .stream()
			          .max(Comparator.comparing(Map.Entry::getValue))
			          .get()
			          .getKey();

			JLabel lblFrequentPubComp = new JLabel("Most Frequent Publishing Company: ");
			lblFrequentPubComp.setBounds(sLbl_x, sLbl_y + (sLbl_y_diff * 4), sLbl_w, sLbl_h);
			lblFrequentPubComp.setFont(font4.deriveFont(22f));
			lblFrequentPubComp.setForeground(Color.BLACK);

			JLabel a_lblFrequentPubComp = new JLabel(mostFrequentPubComp);
			a_lblFrequentPubComp.setBounds(sLbl_x + sLbl_w, sLbl_y + (sLbl_y_diff * 4), sLbl_w, sLbl_h);
			a_lblFrequentPubComp.setFont(font4.deriveFont(22f));
			a_lblFrequentPubComp.setForeground(Color.BLACK);

			statsPanel.add(lblTotalPages);
			statsPanel.add(lblAvgRating);
			statsPanel.add(lblFrequentAuthor);
			statsPanel.add(lblFrequentYear);
			statsPanel.add(lblFrequentPubComp);

			statsPanel.add(a_lblTotalPages);
			statsPanel.add(a_lblAvgRating);
			statsPanel.add(a_lblFrequentAuthor);
			statsPanel.add(a_lblFrequentYear);
			statsPanel.add(a_lblFrequentPubComp);
		} catch (NoSuchElementException e) {
			System.out.println("No data in the datafile.");
		}

		JPanel sInfoPanel = new JPanel();
	    sInfoPanel.setBackground(Color.WHITE);
	    sInfoPanel.setBounds(35, 125, 700, 270);
		
		statsPanel.add(statsHeader);
		statsPanel.add(sInfoPanel);

		/* -------------------- SETTINGS -------------------- */

		JPanel settingsPanel = new JPanel();
		settingsPanel.setLayout(null);
		settingsPanel.setBounds(panel_x, panel_y, panel_w, panel_h);

		JLabel settingsHeader = new JLabel("Settings");
		settingsHeader.setFont(font2_1.deriveFont(50f));
		settingsHeader.setBounds(40, 20, 400, 80);

		int seLbl_x = 45;
		int seLbl_y = 160;
		int seLbl_w = 450;
		int seLbl_h = 28;

		JLabel lblDeleteAll = new JLabel("Do you want to delete all data?");
		lblDeleteAll.setBounds(seLbl_x, seLbl_y, seLbl_w, seLbl_h);
		lblDeleteAll.setFont(font4.deriveFont(22f));
		lblDeleteAll.setForeground(Color.BLACK);

		JButton btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.setFont(font1.deriveFont(24f));
		btnDeleteAll.setBackground(Color.decode("#ff0000"));
		btnDeleteAll.setForeground(Color.WHITE);
		btnDeleteAll.setBorderPainted(false);
		btnDeleteAll.setBounds(seLbl_x, seLbl_y + 60, 120, 44);

		btnDeleteAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				String message = "Are you sure?\n(Action can't be undone.)";
				int reply = JOptionPane.showConfirmDialog(null, message, "Warning!", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					File file = new File("data/data.txt");
					File tempFile = new File("data/tempdata_deleted.txt");
					try {
					    DefaultTableModel model = (DefaultTableModel)mainTable.getModel();
					 	BufferedReader reader = new BufferedReader(new FileReader(file));
						BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

						writer.write("No.>Title>Author>No. of Pages>Date Finished>Publishing Company>Year Published>Rating");

						writer.close();
						reader.close();

						file.delete();
						boolean success = tempFile.renameTo(file);
						tempFile.renameTo(file);
						if (success) {
							System.out.println("Delete all data | Success!");
						}
						JOptionPane.showMessageDialog(null, "All the data were deleted.");
						model.setRowCount(0);
					} catch (Exception e) {
						e.printStackTrace();

					}
				}

			}
		});

		JPanel seInfoPanel = new JPanel();
        seInfoPanel.setBackground(Color.WHITE);
        seInfoPanel.setBounds(35, 125, 400, 200);

        settingsPanel.add(settingsHeader);

		settingsPanel.add(lblDeleteAll);
		settingsPanel.add(btnDeleteAll);

		settingsPanel.add(seInfoPanel);

		favPanel.setVisible(true);
		bookPanel.setVisible(false);
		statsPanel.setVisible(false);
		settingsPanel.setVisible(false);

		favButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				favPanel.setVisible(true);
				statsPanel.setVisible(false);
				bookPanel.setVisible(false);
				settingsPanel.setVisible(false);

				favButton.setBorder(selectedButtonBorder);
				bookButton.setBorder(buttonBorder);
				statsButton.setBorder(buttonBorder);
				settingsButton.setBorder(buttonBorder);
				
				System.out.println("Panel #1");
			}
		});

		bookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				statsPanel.setVisible(false);
				bookPanel.setVisible(true);
				favPanel.setVisible(false);
				settingsPanel.setVisible(false);

				favButton.setBorder(buttonBorder);
				bookButton.setBorder(selectedButtonBorder);
				statsButton.setBorder(buttonBorder);
				settingsButton.setBorder(buttonBorder);

				tfTitle.setText("");
				tfAuthor.setText("");
				tfPageNum.setText("");
				tfDate.setText("");
				tfPubComp.setText("");
				tfPubYr.setText("");
				tfRating.setText("");

				System.out.println("Panel #2");
			}
		});

		statsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bookPanel.setVisible(false);
				favPanel.setVisible(false);
				statsPanel.setVisible(true);
				settingsPanel.setVisible(false);

				favButton.setBorder(buttonBorder);
				bookButton.setBorder(buttonBorder);
				statsButton.setBorder(selectedButtonBorder);
				settingsButton.setBorder(buttonBorder);

				tfTitle.setText("");
				tfAuthor.setText("");
				tfPageNum.setText("");
				tfDate.setText("");
				tfPubComp.setText("");
				tfPubYr.setText("");
				tfRating.setText("");

				System.out.println("Panel #3");
			}
		});

		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				statsPanel.setVisible(false);
				bookPanel.setVisible(false);
				favPanel.setVisible(false);
				settingsPanel.setVisible(true);

				favButton.setBorder(buttonBorder);
				bookButton.setBorder(buttonBorder);
				statsButton.setBorder(buttonBorder);
				settingsButton.setBorder(selectedButtonBorder);

				tfTitle.setText("");
				tfAuthor.setText("");
				tfPageNum.setText("");
				tfDate.setText("");
				tfPubComp.setText("");
				tfPubYr.setText("");
				tfRating.setText("");
				
				System.out.println("Panel #4");
			}
		});

		JPanel othersPanel = new JPanel();
		othersPanel.setBounds(sidenav_x, topnav_h + (sidenav_h * 4), sidenav_w, mainFrame_h - (topnav_h + (sidenav_h * 4)));
		othersPanel.setBackground(Color.decode("#4479B3"));

		JButton btnAboutMe = new JButton("About Me");
		btnAboutMe.setFont(font1.deriveFont(22f));
		btnAboutMe.setBackground(Color.decode("#000000")); //163e88
		btnAboutMe.setForeground(Color.WHITE);
		btnAboutMe.setBorderPainted(false);
		btnAboutMe.setBounds(0, 0, sidenav_w, sidenav_h / 4);

		btnAboutMe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msgAboutMe = "My name is Yvan Lowell T. Aquino. Section: 12-Magpili\nThis CSS (specialized subject) project" +
					" is submitted to Sir Josh Sotto.";
				JOptionPane.showMessageDialog(null, msgAboutMe, 
						"Hi there!", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JLabel lblVersion = new JLabel("version 1.0.rc");
		lblVersion.setFont(font1.deriveFont(16f));
		lblVersion.setBounds(0, 40, sidenav_w, sidenav_h / 4);

		othersPanel.add(btnAboutMe);
		othersPanel.add(lblVersion);

		mainFrame.add(mainHeader);
		mainFrame.add(topnav);

		mainFrame.add(statsButton);
		mainFrame.add(bookButton);
		mainFrame.add(favButton);
		mainFrame.add(settingsButton);

		mainFrame.add(statsPanel);
		mainFrame.add(bookPanel);
		mainFrame.add(favPanel);
		mainFrame.add(settingsPanel);

		mainFrame.add(othersPanel);

		mainTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		int pfWidth = 100;
		mainTable.getColumnModel().getColumn(0).setPreferredWidth(pfWidth - 57);
		mainTable.getColumnModel().getColumn(1).setPreferredWidth(pfWidth * 2);
		mainTable.getColumnModel().getColumn(2).setPreferredWidth(pfWidth);
		mainTable.getColumnModel().getColumn(3).setPreferredWidth(pfWidth - 20);
		mainTable.getColumnModel().getColumn(4).setPreferredWidth(pfWidth + 20);
		mainTable.getColumnModel().getColumn(5).setPreferredWidth(pfWidth + 10);
		mainTable.getColumnModel().getColumn(6).setPreferredWidth(pfWidth - 10);
		mainTable.getColumnModel().getColumn(7).setPreferredWidth(pfWidth - 20);

		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public static void main(String[] args) {
		System.out.println("Initializing Application...");
		System.out.println("Importing data file... (please do not touch \"data.txt\")");
		System.out.println("Please wait.\n");

		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookDepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookDepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookDepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookDepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		createMainWindow();

		System.out.println("Execution of application successful.");
	}
}