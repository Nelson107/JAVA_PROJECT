package com.mycompany.news;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class details {
    public static void showDetailView(String title, String description, BufferedImage image) {
        // Create the JFrame for the detail view with reduced size
        JFrame detailFrame = new JFrame("Detail View");

        // Set the size of the frame to 300x300
        detailFrame.setSize(400, 400);
        detailFrame.setLocationRelativeTo(null);  // Center on screen
        detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BoxLayout to hold all components vertically
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.setBackground(Color.WHITE);
        detailPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 30)); // Add some padding

        // Title label with wrapping, left-aligned
        JLabel titleLabel = new JLabel("<html><div style='width:260px; word-wrap:break-word; text-align:left;'>" + title + "</div></html>");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to left
        detailPanel.add(titleLabel);

        // Image label with dynamic resizing and left alignment
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.LEFT);  // Align the image to left
        
        // Resize image to fit within 260px width (adjusted for padding)
        int imageWidth = 260; // Set a smaller width for the image
        int imageHeight = (int) ((imageWidth / (double) image.getWidth()) * image.getHeight()); // Maintain aspect ratio
        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH));
        imageLabel.setIcon(imageIcon);
        imageLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align the image to left
        detailPanel.add(imageLabel);

        // Description label with wrapping and left-aligned
        JLabel descriptionLabel = new JLabel("<html><div style='width:260px; word-wrap:break-word; text-align:left;'>" + description + "</div></html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align to left
        detailPanel.add(descriptionLabel);

        // Close button with padding, left-aligned
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> detailFrame.dispose());
        JPanel closeButtonPanel = new JPanel();
        closeButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align the button to left
        closeButtonPanel.add(closeButton);
        detailPanel.add(closeButtonPanel);

        // Wrap detailPanel inside a JScrollPane with only vertical scrolling enabled
        JScrollPane scrollPane = new JScrollPane(detailPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Disable smooth scrolling animations by setting a fixed scroll increment
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);  // Set a fixed scroll increment for instant scrolling
        verticalScrollBar.setBlockIncrement(16); // Ensure block increments are also instant

        // Add JScrollPane to the JFrame
        detailFrame.add(scrollPane);

        // Make frame visible
        detailFrame.setVisible(true);
    }

    // Sample main method to test the code
    
}