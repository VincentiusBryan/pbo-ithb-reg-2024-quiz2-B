package View;

import Controller.ArtworkController;
import Model.Artworks;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ArtworkListView extends JFrame {

    private JButton addArtworkButton;
    private JPanel artworkPanel;

    public ArtworkListView(int userId) {
        setTitle("Artwork List");
        setSize(600, 500);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        artworkPanel = new JPanel();
        artworkPanel.setLayout(new BoxLayout(artworkPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(artworkPanel);

        addArtworkButton = new JButton("Add Artwork");
        addArtworkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addArtworkButton.addActionListener(e -> new AddArtworkView(userId).setVisible(true));

        add(addArtworkButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        loadArtworkList(userId);
    }

    private void loadArtworkList(int userId) {
        ArtworkController controller = new ArtworkController();
        List<Artworks> artworks = controller.getArtworksByUser(userId);

        artworkPanel.removeAll();

        for (Artworks artwork : artworks) {
            JPanel artworkItem = new JPanel();
            artworkItem.setLayout(new BoxLayout(artworkItem, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel("Title: " + artwork.getTitle());
            JLabel descriptionLabel = new JLabel("Description: " + artwork.getDescription());
            ImageIcon artworkImage = new ImageIcon(artwork.getImage_path());
            JLabel imageLabel = new JLabel("image: " + artworkImage);
            JLabel border = new JLabel("-------------------------------------------------");

            artworkItem.add(titleLabel);
            artworkItem.add(descriptionLabel);
            artworkItem.add(imageLabel);
            artworkItem.add(border);

            artworkPanel.add(artworkItem);
        }

        artworkPanel.revalidate();
        artworkPanel.repaint();
    }

    public static void main(String[] args) {
        new ArtworkListView(1).setVisible(true);
    }
}
