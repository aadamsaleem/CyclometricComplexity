package cyclomatic.complexity;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;

public class CyclomaticComplexity extends JFrame implements ActionListener {

    JFileChooser jfc;
    public String s;
    public File f;
    public JTextField jtf1;
    public JTextArea jta1, jta2;

    @SuppressWarnings("LeakingThisInConstructor")
    public CyclomaticComplexity() {
        super("Cyclometric Complexity by Aadam");
        jfc = new JFileChooser("C:\\Users\\Aadam\\Documents\\Studies\\College\\IV yr\\8 Sem\\SPM Lab\\CyclometricComplexity\\Cyclometric Complexity\\src\\cyclomatic\\complexity");
        JButton jb = new JButton("Browse");
        jtf1 = new JTextField(35);
        jta1 = new JTextArea();
        jta1.setSize(110, 10);
        jta2 = new JTextArea();
        jb.addActionListener(this);
        getContentPane().add(jtf1);
        getContentPane().add(jb);
        getContentPane().add(jta1);
        getContentPane().add(jta2);
        setLayout(new FlowLayout());
        setBounds(400, 100, 500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int x = jfc.showOpenDialog(null);
        if (x == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
            s = jfc.getName(f);
            jtf1.setText(s);

            System.out.println(s);
            displayCyclomaticComplexity(getCyclomaticCompexity());

        }
        if (x == JFileChooser.CANCEL_OPTION) {
            System.out.println("cancel");
        }

    }
@SuppressWarnings("UnusedAssignment")
    public int getCyclomaticCompexity() {
        int complexity = 1;
        String fileName;
        String[] keywords = {"if", "for", "do", "while", "switch", "case", "default", "continue", "break", "&&", "||", "?", ":", "return"};
        String words = "";
        String line = null;
        try {

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();

            while (line != null) {
                StringTokenizer stTokenizer = new StringTokenizer(line);
                while (stTokenizer.hasMoreTokens()) {
                    words = stTokenizer.nextToken();
                    for (int i = 0; i < keywords.length; i++) {
                        if (keywords[i].equals(words)) {
                            System.out.println(keywords[i]);
                            complexity++;
                        }
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (complexity);
    }

    public void displayCyclomaticComplexity(int ccValue) {
        jta1.setText("\nThe Cyclomatic Complexity is : " + ccValue);

        if (ccValue > 50) {
            jta2.setText("Most complex and highly unstable program");
            jta2.setBackground(Color.RED);
        } else if (ccValue >= 21 && ccValue <= 50) {
            jta2.setText("High risk program");
            jta2.setBackground(Color.ORANGE);
        } else if (ccValue >= 11 && ccValue <= 20) {
            jta2.setText("Moderate risk program");
            jta2.setBackground(Color.YELLOW);
        } else {
            jta2.setText("Low risk program");
            jta2.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new CyclomaticComplexity();

    }
}
