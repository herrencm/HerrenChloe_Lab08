public class TagExtractorRunner {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TagExtractorGUI frame = new TagExtractorGUI();
                frame.setVisible(true);
            }
        });
    }
}