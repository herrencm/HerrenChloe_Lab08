import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class TagExtractorGUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private JButton chooseFileButton, chooseStopWordButton, extractButton, saveButton;
    private File selectedFile, stopWordsFile;
    private Map<String, Integer> tagFrequencyMap;

    public TagExtractorGUI() {
        super("Tag Extractor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        chooseFileButton = new JButton("Choose File");
        chooseFileButton.addActionListener(this);

        chooseStopWordButton = new JButton("Choose Stop Word File");
        chooseStopWordButton.addActionListener(this);

        extractButton = new JButton("Extract Tags");
        extractButton.addActionListener(this);

        saveButton = new JButton("Save Tags");
        saveButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(chooseFileButton);
        buttonPanel.add(chooseStopWordButton);
        buttonPanel.add(extractButton);
        buttonPanel.add(saveButton);


        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);


        tagFrequencyMap = new HashMap<>();

        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseFileButton) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setFileFilter(filter);
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                textArea.append("Selected file: " + selectedFile.getName() + "\n");
            }
        } else if (e.getSource() == chooseStopWordButton) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setFileFilter(filter);
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                stopWordsFile = fileChooser.getSelectedFile();
                textArea.append("Selected stop word file: " + stopWordsFile.getName() + "\n");
            }
        } else if (e.getSource() == extractButton) {
            if (selectedFile == null) {
                JOptionPane.showMessageDialog(this, "Please select a file to extract tags from.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (stopWordsFile == null) {
                JOptionPane.showMessageDialog(this, "Please select a stop word file.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                try {
                    Scanner scanner = new Scanner(stopWordsFile);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                HashSet<String> stopWords = new HashSet<>();

            } finally {

            }
        }
    }
}