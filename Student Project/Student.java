import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
class Student extends JFrame implements ActionListener{
Container c;
JButton b1,b2,b3,b4,b5,b6;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JTextField t1,t2,t3,t4,t5,t6,t7;
JTextArea a1,a2,a3;
JTable table;
String comm="";
Student(){
		c=getContentPane();
		setSize(1366,768);
		//setLocation(100,100);
		c.setLayout(null);
		Image icon = Toolkit.getDefaultToolkit().getImage("images\\Nc.jpg");    
		setIconImage(icon);
		
		JPanel pAdd=new JPanel();
		pAdd.setLayout(null);
		pAdd.setBounds(20,20,1300,650);
		pAdd.setBackground(Color.pink);
      
		c.add(pAdd);
		
		l1=new JLabel(new ImageIcon("images\\Nc.jpg"));
		l1.setBounds(270,20,103,114);
		pAdd.add(l1);
		
		Font setfont=new Font("Calibri", Font.PLAIN, 40);
		JLabel l2=new JLabel("NC College Of Engineering, Panipat");
		l2.setBounds(400,20,600,100);
		l2.setFont(setfont);
		pAdd.add(l2);
		
		JPanel pAdd1=new JPanel();
		pAdd1.setLayout(null);
		pAdd1.setBounds(850,225,400,300);
		pAdd1.setBackground(Color.gray);
		pAdd.add(pAdd1);
		
		l3=new JLabel("Roll NO :");
		l3.setBounds(20,20,90,60);
		
		Font set=new Font("Calibri", Font.PLAIN, 20);
		l3.setFont(set);
		l3.setForeground(Color.WHITE);
		pAdd1.add(l3);
		
		t1=new JTextField();
		t1.setBounds(110,30,60,40);
		t1.setFont(set);
		pAdd1.add(t1);
		
		b1=new JButton("Search");
		b1.setBounds(240,30,120,40);
		pAdd1.add(b1);
		
		b2=new JButton("Clear");
		b2.setBounds(950,540,120,40);
		pAdd.add(b2);
		
		a1=new JTextArea();
		a1.setBounds(20,110,360,170);
		a1.setFont(set);
		a1.setEditable(false);
		pAdd1.add(a1);
		
		JPanel pAdd3=new JPanel();
		pAdd3.setLayout(null);
		pAdd3.setBounds(550,265,260,200);
		pAdd3.setBackground(Color.gray);
		pAdd.add(pAdd3);
		
		l4=new JLabel("For Delete the record");
		l4.setBounds(580,230,200,35);
		Font setf=new Font("Calibri", Font.BOLD, 22);
		l4.setFont(setf);
		pAdd.add(l4);
		
		t2=new JTextField();
		t2.setBounds(150,30,60,40);
		t2.setFont(set);
		pAdd3.add(t2);
		
		b3=new JButton("Delete");
		b3.setBounds(80,110,100,40);
		pAdd3.add(b3);
		
		b4=new JButton("clear");
		b4.setBounds(625,490,100,40);
		pAdd.add(b4);
		
		l5=new JLabel("ROLL NO:");
		l5.setBounds(40,20,90,60);
		l5.setFont(set);
		l5.setForeground(Color.WHITE);
		pAdd3.add(l5);
		
		
		a3=new JTextArea();
		a3.setFont(setf);
		JScrollPane sc=new JScrollPane(a3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(50,225,450,300);
				
		pAdd.add(sc);
		b5=new JButton("Show All");
		b5.setBounds(190,545,100,40);
		pAdd.add(b5);
		
		l6=new JLabel("DataBase");
		l6.setBounds(50,160,100,30);
		l6.setFont(setf);
		pAdd.add(l6);
		
		t4=new JTextField();
		t4.setBounds(170,160,100,30);
		pAdd.add(t4);
		
		l7=new JLabel("Password");
		l7.setBounds(300,160,100,30);
		l7.setFont(setf);
		pAdd.add(l7);
		
		t5=new JTextField();
		t5.setBounds(420,160,100,30);
		pAdd.add(t5);
		
		a3.setEditable(false);
		l8=new JLabel("Table Name");
		l8.setBounds(550,160,120,30);
		l8.setFont(setf);
		pAdd.add(l8);
		
		t6=new JTextField();
		t6.setBounds(680,160,100,30);
		pAdd.add(t6);
		
		l9=new JLabel("Username");
		l9.setBounds(810,160,100,30);
		l9.setFont(setf);
		pAdd.add(l9);
		
		t7=new JTextField();
		t7.setBounds(930,160,100,30);
		pAdd.add(t7);
		
		b6=new JButton("Back");
		b6.setBounds(625,550,100,40);
		pAdd.add(b6);
		
		
		b1.addActionListener(this);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Object o=e.getSource();
		if(o.equals(b6)){
		dispose();
		SetComponent.display();
		}
		else if(!t4.getText().isEmpty()&&!t5.getText().isEmpty()&&!t6.getText().isEmpty()&&!t7.getText().isEmpty()){
		String a=t4.getText();
		String b=t7.getText();
		String d1=t5.getText();
		String url="jdbc:mysql://localhost:3306/"+a+"?verifyServerCertificate=false&useSSL=true&autoReconnect=true";
		if(o.equals(b1)&&!t1.getText().isEmpty()){
		try{
			
			if(!t1.getText().isEmpty()){
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(url,b,d1);
								
			String sql="select name,mobile,DOB,Gender,Address from studentrecord where mobile=?";
			
			PreparedStatement ptr=con.prepareStatement(sql);
			ptr.setInt(1,Integer.parseInt(t1.getText()));
			ResultSet rs=ptr.executeQuery();
			int m=0;
			while(rs.next()){
			a1.setText("Name :"+" "+rs.getString(1)+"\n"+"mobile :"+" "+rs.getInt(2)+"\n"+"DOB :"+" "+rs.getString(3)+"\n"+"Gender :"+" "+rs.getString(4)+"\n"+"Address :"+" "+rs.getString(5));
			m++;}
			if(m==0)
			a1.setText("NO SUCH ROLLNO EXIT");
			}
			else
			a1.setText("PLEASE ENTER A ROLL NUMBER !!");
		}catch(Exception ee){System.out.println(ee);
		JOptionPane.showMessageDialog(c,a);}}
		
		if(o.equals(b2)){
		t1.setText(null);
		a1.setText(null);}
		if(o.equals(b3)&&!t2.getText().isEmpty()){
			String ans="";
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(url,b,d1);//"jdbc:mysql://localhost:3306/arpit?verifyServerCertificate=false&useSSL=true&autoReconnect=true","root","root");
			String sql="delete from"+" "+t6.getText()+" "+"where mobile=?";
			
			PreparedStatement ptr=con.prepareStatement(sql);
			ptr.setInt(1,Integer.parseInt(t2.getText()));
			int i=ptr.executeUpdate();
			ans=i+" "+"record deleted";
			if(i>0)
			JOptionPane.showMessageDialog(c,ans);
			else
			JOptionPane.showMessageDialog(c,"ROLLNO NOT EXIT!!");
			}catch(Exception ee){System.out.println(ee);
			}}
		if(o.equals(b4))
		t2.setText(null);
		
		if(o.equals(b5)){
			String arg="Name"+"  "+"Rollno"+"  "+"DOB"+"  "+ "Gender"+"  "+"Address"; 
			a3.setText(arg);
			try{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection(url,b,d1);//"jdbc:mysql://localhost:3306/arpit?verifyServerCertificate=false&useSSL=true&autoReconnect=true","root","root");
			String sql="select * from studentrecord";
			
			PreparedStatement ptr=con.prepareStatement(sql);
			ResultSet rs=ptr.executeQuery();
			int i=0;
			a3.setText("NAME"+"\t"+"ROLLNO"+"  \t"+"DOB"+"\t"+"GENDER"+" \t "+"ADDRESS"+"\n");
			
			while(rs.next()){
			a3.append(rs.getString(1)+" \t "+rs.getInt(2)+" \t "+rs.getString(3)+" \t "+rs.getString(4)+" \t "+rs.getString(5)+"\n");
			i++;
			}
			
			if(i==0)
			JOptionPane.showMessageDialog(c,"NO record");
			
			}catch(Exception ee){System.out.println(ee);
			}
		}
	}else
	JOptionPane.showMessageDialog(c,"please enter the database,password,tablename,username");}
	 	
}

