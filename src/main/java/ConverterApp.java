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

    public ConverterApp() {
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pathField.getText()!=null){
                    Converter converter = new Converter();
                    Path path = Paths.get(pathField.getText());
                    String text = converter.getImgText(path.toString());
                    System.out.println(text);
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
