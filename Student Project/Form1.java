import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
class SetComponent{
static JFrame frame;
JLabel l1,jl6,jl7,jl8,jl9,jl10;
JLabel l2;
JLabel l3;
JLabel l4;
JLabel l5;
JTextArea ar;
JTextArea area;
JTextArea result;
JButton b,b1,bt ;
JPanel p;
JCheckBox c;
JRadioButton r1;
JRadioButton r2;
JTextField tf;
JTextField tf1;
JTextField tf2,jt4,jt5,jt6,jt7;
JComboBox day;
JComboBox month;	
JComboBox year;
JLabel res;
JTextArea ans;
JPanel pa;
public void component(){
		frame=new JFrame("Registration form");
		frame.setSize(1366,768);

		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\images\\Nc.jpg");    
		frame.setIconImage(icon);
		JLabel L=new JLabel(new ImageIcon("images\\im.jpg"));
		L.setBounds(1060,20,259,194);
		
		JLabel L1=new JLabel(new ImageIcon("images\\image24.jpg"));
		L1.setBounds(1060,240,259,194);
		
		JLabel L2=new JLabel(new ImageIcon("images\\image3.jpg"));
		L2.setBounds(1060,459,259,194);
		
		pa=new JPanel();
		
		pa.setBounds(180,20,103,114);
		JLabel pal=new JLabel(new ImageIcon("images\\Nc.jpg"));
		pal.setBounds(0,20,103,114);
		pa.add(pal);
		Font setfont=new Font("Calibri", Font.PLAIN, 40);
		JLabel pa2=new JLabel("NC College Of Engineering, Panipat");
		pa2.setBounds(300,20,600,100);
		pa2.setFont(setfont);
		
		//pa.add(pa2);
		
		
		l1=new JLabel("Name");
		l1.setBounds(50,250,60,30);
		
		tf=new JTextField();
		tf.setBounds(150,255,100,20);
		
		l2=new JLabel("Rollno");
		l2.setBounds(50,305,60,30);
		
		tf1=new JTextField();
		tf1.setBounds(150,315,100,20);
		
		l3=new JLabel("DOB");
		l3.setBounds(50,365,60,30);
		
		l4=new JLabel("Gender");
		l4.setBounds(50,415,60,30);
		
		l5=new JLabel("Address");
		l5.setBounds(50,470,70,30);
		
		ar=new JTextArea();
		ar.setBounds(150,460,270,60);
		
		r1=new JRadioButton("Male");
		r1.setBounds(150,415,60,30);
		
		r2=new JRadioButton("Female");
		r2.setBounds(250,415,80,30);
		
		b=new JButton(new ImageIcon("images\\register-button-png-30.png"));
		b.setBounds(150,600,100,40);
		
		c=new JCheckBox("Accept all terms and Conditions");
		c.setBounds(50,540,250,30);
		
		//p=new JPanel();
		//p.setBounds(430,40,330,330);
		
		res=new JLabel("Your submit record is shown here");
		res.setBounds(460,230,300,30);
		
		ans=new JTextArea();
		ans.setBounds(460,260,300,300);
		ans.setEditable(false);
		
		//p.add(res);
		//p.add(ans);
		
		//result=new JTextArea();
		//result.setBounds()
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		String[] d=new String[31];  
		for(int i=1;i<=31;i++)
		d[i-1]=Integer.toString(i);
		
		day=new JComboBox<String>(d);
		day.setBounds(150,365,50,30);
		String[] m={"jan","feb","mar","apr","may","jun","july","aug","sep","oct","nov","dec"}; 
		
		month=new JComboBox<String>(m);
		month.setBounds(250,365,50,30);
		
		String[] y=new String[41];	
		for(int i=1980;i<=2020;i++)
			y[i-1980]=Integer.toString(i);
		
		year=new JComboBox<String>(y);
		year.setBounds(350,365,60,30);
		
		Font setf=new Font("Calibri", Font.BOLD, 22);
		jl6=new JLabel("DataBase");
		jl6.setBounds(50,160,100,30);
		jl6.setFont(setf);
		
		jt4=new JTextField();
		jt4.setBounds(170,160,100,30);
		//jAdd.add(t4);
		
		jl7=new JLabel("Password");
		jl7.setBounds(300,160,100,30);
		jl7.setFont(setf);
	//	pAdd.add(jl7);
		
		jt5=new JTextField();
		jt5.setBounds(420,160,100,30);
		//jpAdd.add(t5);
		
		//a3.setEditable(false);
		jl8=new JLabel("Table Name");
		jl8.setBounds(550,160,120,30);
		jl8.setFont(setf);
		//pAdd.add(jl8);
		
		jt6=new JTextField();
		jt6.setBounds(680,160,100,30);
		//pAdd.add(jt6);
		
		jl9=new JLabel("Username");
		jl9.setBounds(810,160,100,30);
		jl9.setFont(setf);
		//pAdd.add(l9);
		
		jt7=new JTextField();
		jt7.setBounds(930,160,100,30);
		//pAdd.add(t7);
		
		jl10=new JLabel("Alter records");
		jl10.setBounds(840,360,150,40);
		jl10.setFont(setf);
		
		bt=new JButton("CLICK");
		bt.setBounds(850,410,100,40);
		
		
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
				new Student();
			}
		});
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				submit_action(e);
			}
		});
		
		JButton b1=new JButton(new ImageIcon("images\\mp.png"));
		b1.setBounds(540,590,146,51);
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				submit_record(e);
			}
		});
		
		//frame.add(pa);
		frame.add(pa2);
		frame.add(tf);
		frame.add(l1);
		frame.add(tf1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(day);
		frame.add(month);
		frame.add(year);
		frame.add(r1);
		frame.add(r2);
		frame.add(l5);
		frame.add(ar);
		frame.add(c);
		frame.add(b);
		frame.add(res);
		frame.add(ans);
		frame.add(jl9);
		frame.add(jt7);
		frame.add(jl6);
		frame.add(jl7);
		frame.add(jl8);
		frame.add(jt4);
		frame.add(jt5);
		frame.add(jt6);
		frame.add(L);
		frame.add(jl10);
		frame.add(bt);
		frame.add(L1);
		frame.add(L2);
		frame.add(b1);
		frame.setLayout(null);
		frame.setVisible(true);
		Container c=frame.getContentPane();
		c.setBackground(Color.pink);
		c.add(pa);
		//c.add(pa2);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	public static void display(){
	frame.setVisible(true);
}
	public void submit_action(ActionEvent e){
		if(c.isSelected()==true){
			String host1=tf.getText();
			String host2=tf1.getText();
			String host3=(String)day.getSelectedItem();
			String host4=(String)month.getSelectedItem();
			String host5=(String)year.getSelectedItem();
			String host6=" ";
			if(r2.isSelected())
				host6="Female";
			else
				host6="Male";
			//else
			//JOptionPane.showMessageDialog(frame,"Fill all the details???"); 
			String host7=ar.getText();
			//if((tf.getText().isEmpty()==true&&tf1.getText().isEmpty()==true&&ar.getText().isEmpty()==true)){
			if((tf.getText().isEmpty()==true||tf1.getText().isEmpty()==true)||(ar.getText().isEmpty()==true ))
			JOptionPane.showMessageDialog(frame,"Fill all the details???"); 
			else if(r1.isSelected()==false&&r2.isSelected()==false)
			JOptionPane.showMessageDialog(frame,"Fill all the details???"); 	
			else{ 
			ans.setText(host1+"\n"+host2+"\n"+host3+" "+host4+" "+host5+"\n"+host6+"\n"+host7+"\n");
			 
		}} 			
		
		else
		JOptionPane.showMessageDialog(frame,"Please accept the term and condition");  
	}
	public void submit_record(ActionEvent e){
		if(!jt4.getText().isEmpty()&&!jt5.getText().isEmpty()&&!jt6.getText().isEmpty()&&!jt7.getText().isEmpty()){
		if(!tf.getText().isEmpty()){
		try{  
		int temp;
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/arpit?verifyServerCertificate=false&useSSL=true&autoReconnect=true","root","root");  
		PreparedStatement ps=con.prepareStatement("insert into studentrecord (name, mobile, DOB, Gender, address) values(?,?,?,?,?)");
		ps.setString(1,tf.getText());
		temp=Integer.parseInt(tf1.getText());
		ps.setInt(2,temp);
		String s=(String)(day.getSelectedItem()+" "+month.getSelectedItem()+" "+year.getSelectedItem());
		
		ps.setString(3,s);
		if(r2.isSelected())
		ps.setString(4,"female");
		else
		ps.setString(4,"male");
		ps.setString(5,ar.getText());
		  int count=ps.executeUpdate();
		    if(count>0)
		    	JOptionPane.showMessageDialog(frame,"Saved");
		    else
		    	
		    	JOptionPane.showMessageDialog(frame,"Sorry");
		    	con.close();
				tf.setText(null);
				tf1.setText(null);
				ar.setText(null);
				ans.setText(null);
		}  
	catch(Exception ee){System.out.println(ee);}  
		}
		else
		JOptionPane.showMessageDialog(frame,"fill the details??");
	}
	
	else
	JOptionPane.showMessageDialog(frame,"Enter the database,password,tablename and username??");	
	}}
public class Form1{
	
	public static void main(String[] args){
	
	SetComponent set=new SetComponent();
	set.component();
		
	}
}