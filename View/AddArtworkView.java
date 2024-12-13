package View;

import Controller.ArtworkController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddArtworkView extends JFrame {

    private JTextField titleField;
    private JTextArea descriptionArea;
    private JButton uploadImageButton;
    private JButton submitButton;
    private int userId;

    public AddArtworkView(int userId) {
        this.userId = userId;

        setTitle("Add Artwork");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        JLabel titleLabel = new JLabel("Title:");
        JLabel descriptionLabel = new JLabel("Description:");
        JLabel imageLabel = new JLabel("Image:");

        titleField = new JTextField();
        descriptionArea = new JTextArea();
        uploadImageButton = new JButton("Upload Image");
        submitButton = new JButton("Submit");

        inputPanel.add(titleLabel);
        inputPanel.add(titleField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(new JScrollPane(descriptionArea));
        inputPanel.add(imageLabel);
        inputPanel.add(uploadImageButton);

        add(inputPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        uploadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                    JOptionPane.showMessageDialog(null, "Image uploaded: " + imagePath);
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionArea.getText();

                ArtworkController controller = new ArtworkController();
                boolean success = controller.addArtwork(userId, title, description, "path/to/image.jpg");

                if (success) {
                    JOptionPane.showMessageDialog(null, "Karya seni berhasil ditambahkan.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menambah seni.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new AddArtworkView(1).setVisible(true);
    }
}
