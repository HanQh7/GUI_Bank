package thread1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class RajhiBankThread extends JFrame implements Runnable,  ActionListener{
  Container cp;
  JPanel top,center,bottom,radios;
  JLabel img,title,name,identity,job,birth,address,gender,accountType,timer;
  JTextField nametxt,idtxt,jobtxt,birthtxt;
  JTextArea addresstxt;
  JScrollPane scroll;
  JComboBox<String> accounts;
  JRadioButton m,f;
  ButtonGroup bg;
  JButton save;
  int counter;
  Thread t;
  public RajhiBankThread() {
    cp = getContentPane();
    cp.setLayout(new BorderLayout());
    img = new JLabel();
    img.setIcon(new ImageIcon("raj.jpg"));
    title = new JLabel("Alrajhi Bank");
    timer = new JLabel("Time: 0 seconds");
    timer.setForeground(Color.blue);
    t = new Thread(this);
    t.start();
    title.setForeground(Color.blue);
    title.setFont(new Font("Monospaced",Font.BOLD,20));
    top = new JPanel(new FlowLayout());
    top.add(img);
    top.add(title);
    cp.add(top,BorderLayout.NORTH);
    center = new JPanel(new GridLayout(15,1));
    center.setBorder(BorderFactory.createTitledBorder("Account information"));
    name = new JLabel("Full name:");
    name.setForeground(Color.blue);
    center.add(name);
    nametxt = new JTextField();
    center.add(nametxt);
    identity = new JLabel("Identity No.:");
    identity.setForeground(Color.blue);
    center.add(identity);
    idtxt = new JTextField();
    center.add(idtxt);
    job = new JLabel("Job title:");
    job.setForeground(Color.blue);
    center.add(job);
    jobtxt = new JTextField();
    center.add(jobtxt);
    birth = new JLabel("Birth date:");
    birth.setForeground(Color.blue);
    center.add(birth);
    birthtxt = new JTextField();
    center.add(birthtxt);
    address = new JLabel("Address");
    address.setForeground(Color.blue);
    center.add(address);
    addresstxt = new JTextArea();
    scroll = new JScrollPane(addresstxt);
    center.add(scroll);
    radios = new JPanel(new FlowLayout());
    gender = new JLabel("Gender:");
    gender.setForeground(Color.blue);
    center.add(gender);
    m = new JRadioButton("male");
    f = new JRadioButton("female");
    radios.add(m); radios.add(f);
    bg = new ButtonGroup();
    bg.add(m);bg.add(f);
    center.add(radios);
    cp.add(center);
    accountType = new JLabel("Type of account:");
    accountType.setForeground(Color.blue);
    center.add(accountType);
    String type[] = {"Checking account",
        "Savings account",
        "Money market account",
        "Certificate of deposit account"};
    accounts = new JComboBox<String>(type);
    center.add(accounts);
    center.add(timer);
    bottom = new JPanel(new FlowLayout());
    save = new JButton("Save");
    save.addActionListener(this);
    save.setBackground(Color.blue);
    save.setForeground(Color.white);
    bottom.add(save);
    cp.add(bottom,BorderLayout.SOUTH);
    setTitle("Alrajhi Bank");
    setSize(400,700);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
  public static void main(String[] args) {
    
    new RajhiBankThread();

}
  public void actionPerformed(ActionEvent e) {
    JButton b = (JButton) e.getSource();
    if(b.equals(save)) {
      String message = "Your account has been created\nAccount information:\n";
      message += "Name: "+nametxt.getText()+"\n";
      message += "Identity No.: "+idtxt.getText()+"\n";
      message += "Job title: "+jobtxt.getText()+"\n";
      message += "Birthdate: "+birthtxt.getText()+"\n";
      message += "Address: "+addresstxt.getText()+"\n";
      message += "Gender: ";
      if(m.isSelected())
        message += m.getText()+"\n";
      else if (f.isSelected())
        message += f.getText()+"\n";
      message += "Account type: "+accounts.getSelectedItem();
      JOptionPane.showMessageDialog(this, message);
    }
  }
  @Override
  public void run() {
    
    try {
      while(counter <= 60 ) {
        Thread.sleep(1000);
        counter++;
        timer.setText("Time: "+counter+" seconds");
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
      }
    
  }}
