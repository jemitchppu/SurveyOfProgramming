package Module2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NetflixMovieGUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Netflix Movie Management");
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Create a panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(13, 2, 10, 10));

        // Input fields with labels
        JLabel titleLabel = new JLabel("Movie/Series Title:");
        JTextField titleField = new JTextField();
        titleField.setPreferredSize(new Dimension(200, 20)); 
        titleField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel genreLabel = new JLabel("Genre:");
        JTextField genreField = new JTextField();
        genreField.setPreferredSize(new Dimension(200, 20)); 
        genreField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel yearLabel = new JLabel("Release Year:");
        JTextField yearField = new JTextField();
        yearField.setPreferredSize(new Dimension(200, 20)); 
        yearField.setFont(new Font("Arial", Font.PLAIN, 10));

        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField();
        directorField.setPreferredSize(new Dimension(200, 20)); 
        directorField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel actorLabel = new JLabel("Main Actor:");
        JTextField actorField = new JTextField();
        actorField.setPreferredSize(new Dimension(200, 20));
        actorField.setFont(new Font("Arial", Font.PLAIN, 10));

        JLabel actressLabel = new JLabel("Main Actress:");
        JTextField actressField = new JTextField();
        actressField.setPreferredSize(new Dimension(200, 20)); 
        actressField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel languageLabel = new JLabel("Language:");
        JTextField languageField = new JTextField();
        languageField.setPreferredSize(new Dimension(200, 20)); 
        languageField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel durationLabel = new JLabel("Duration (min):");
        JTextField durationField = new JTextField();
        durationField.setPreferredSize(new Dimension(200, 20));
        durationField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel imdbLabel = new JLabel("IMDb Rating:");
        JTextField imdbField = new JTextField();
        imdbField.setPreferredSize(new Dimension(200, 20));
        imdbField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel contentTypeLabel = new JLabel("Content Type:");
        JComboBox<String> contentTypeComboBox = new JComboBox<>(new String[]{"Movie", "Series"});

        JLabel seasonsLabel = new JLabel("Number of Seasons:");
        JTextField seasonsField = new JTextField();
        seasonsField.setPreferredSize(new Dimension(200, 20));
        seasonsField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel episodesLabel = new JLabel("Number of Episodes:");
        JTextField episodesField = new JTextField();
        episodesField.setPreferredSize(new Dimension(200, 20));
        episodesField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        JLabel ageLabel = new JLabel("Viewer Age Restriction:");
        JTextField ageField = new JTextField();
        ageField.setPreferredSize(new Dimension(200, 20)); 
        ageField.setFont(new Font("Arial", Font.PLAIN, 10)); 

        // Add components to the panel
        inputPanel.add(titleLabel);
        inputPanel.add(titleField);

        inputPanel.add(genreLabel);
        inputPanel.add(genreField);

        inputPanel.add(yearLabel);
        inputPanel.add(yearField);

        inputPanel.add(directorLabel);
        inputPanel.add(directorField);

        inputPanel.add(actorLabel);
        inputPanel.add(actorField);

        inputPanel.add(actressLabel);
        inputPanel.add(actressField);

        inputPanel.add(languageLabel);
        inputPanel.add(languageField);

        inputPanel.add(durationLabel);
        inputPanel.add(durationField);

        inputPanel.add(imdbLabel);
        inputPanel.add(imdbField);

        inputPanel.add(contentTypeLabel);
        inputPanel.add(contentTypeComboBox);

        inputPanel.add(seasonsLabel);
        inputPanel.add(seasonsField);

        inputPanel.add(episodesLabel);
        inputPanel.add(episodesField);

        inputPanel.add(ageLabel);
        inputPanel.add(ageField);

        // Set default visibility for series fields
        seasonsLabel.setVisible(false);
        seasonsField.setVisible(false);
        episodesLabel.setVisible(false);
        episodesField.setVisible(false);

        // Content type selection
        contentTypeComboBox.addActionListener(e -> {
            boolean isSeries = contentTypeComboBox.getSelectedItem().equals("Series");
            seasonsLabel.setVisible(isSeries);
            seasonsField.setVisible(isSeries);
            episodesLabel.setVisible(isSeries);
            episodesField.setVisible(isSeries);
        });

        // Text area for output
        JTextArea outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        outputArea.setPreferredSize(new Dimension(400, 100));
        JScrollPane outputScroll = new JScrollPane(outputArea);

        // Buttons
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        // Add action listeners
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = titleField.getText().trim();
                    String genre = genreField.getText().trim();
                    String yearText = yearField.getText().trim();
                    String director = directorField.getText().trim();
                    String actor = actorField.getText().trim();
                    String actress = actressField.getText().trim();
                    String language = languageField.getText().trim();
                    String durationText = durationField.getText().trim();
                    String imdbText = imdbField.getText().trim();
                    String ageText = ageField.getText().trim();

                    if (title.isEmpty() || genre.isEmpty() || yearText.isEmpty() || director.isEmpty() ||
                            actor.isEmpty() || actress.isEmpty() || language.isEmpty() || durationText.isEmpty() ||
                            imdbText.isEmpty() || ageText.isEmpty()) {
                        throw new IllegalArgumentException("All fields must be filled.");
                    }

                    int year = Integer.parseInt(yearText);
                    int duration = Integer.parseInt(durationText);
                    double imdbRating = Double.parseDouble(imdbText);
                    int age = Integer.parseInt(ageText);

                    if (imdbRating < 0.0 || imdbRating > 10.0) {
                        throw new IllegalArgumentException("IMDb Rating must be between 0.0 and 10.0.");
                    }
                    if (age < 0) {
                        throw new IllegalArgumentException("Viewer Age Restriction must be a positive number.");
                    }

                    String result = "Movie Title: " + title + "\n" +
                            "Genre: " + genre + "\n" +
                            "Release Year: " + year + "\n" +
                            "Director: " + director + "\n" +
                            "Main Actor: " + actor + "\n" +
                            "Main Actress: " + actress + "\n" +
                            "Language: " + language + "\n" +
                            "Duration: " + duration + " minutes\n" +
                            "IMDb Rating: " + imdbRating + "\n" +
                            "Viewer Age Restriction: " + age + "\n";

                    if (contentTypeComboBox.getSelectedItem().equals("Series")) {
                        String seasonsText = seasonsField.getText().trim();
                        String episodesText = episodesField.getText().trim();

                        if (seasonsText.isEmpty() || episodesText.isEmpty()) {
                            throw new IllegalArgumentException("Seasons and Episodes fields must be filled for a series.");
                        }

                        int seasons = Integer.parseInt(seasonsText);
                        int episodes = Integer.parseInt(episodesText);

                        result += "Number of Seasons: " + seasons + "\n" +
                                "Number of Episodes: " + episodes + "\n";
                    }

                    outputArea.setText(result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Numeric fields must contain valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(e -> {
            titleField.setText("");
            genreField.setText("");
            yearField.setText("");
            directorField.setText("");
            actorField.setText("");
            actressField.setText("");
            languageField.setText("");
            durationField.setText("");
            imdbField.setText("");
            seasonsField.setText("");
            episodesField.setText("");
            ageField.setText("");
            outputArea.setText("");
        });

        // Create a container panel for both the input panel and output area
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(inputPanel); 
        centerPanel.add(outputScroll); 

        // Add panels and components to the frame
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
