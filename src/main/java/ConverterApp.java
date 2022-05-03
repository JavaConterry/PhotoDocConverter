import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConverterApp {
    private JPanel mainPanel;
    private JButton applyButton;
    private JTextField pathField;
    private JTextArea outputLog;
    private JTextField outputPath;
    private JTextField outputName;

    public ConverterApp() {
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pathField.getText()!=null){
                    Converter converter = new Converter();
                    Path inputPath = Paths.get(pathField.getText());
                    Path outputPath = Paths.get(pathField.getText());
                    String text = converter.getImgText(inputPath.toString());
                    System.out.println(text);
                    converter.docFromText(text, outputPath.toString(), outputName.getText());
                    System.out.println("Success!!!");
                }
                else {
                    outputLog.setText("path didn't set");
                }
            }
        });
    }

    public void initialize() {
        JFrame frame = new JFrame("Converter App");
        frame.setContentPane(new ConverterApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
