import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

public class main {

	private JFrame frame;
	public JTextField head;
	public JTextField num;
	public JTextField start;
	public JTextField end;
	public JTextField res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 180, 140));
		frame.setBounds(100, 100, 485, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("FCFS");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Random R= new Random();
				int hd,st,ed,n,i,j,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
			//	int d[]=new int[n];
				System.out.println("Input");
				 	    int[] a = new int[n];
				 	    for (i = 0; i < n; i++)
				 	    {
				 	        a[i] = R.nextInt(ed-st) + st;
				 	       System.out.println(a[i]);
				 	    }
				 	    System.out.println("Output: ");
				 	    if ((hd-a[0])<0)
				 	    {
				 	    	count = a[0]-hd;
				 	    }
				 	    else
				 	    {
				 	    	count = hd-a[0];
				 	    }
				 	    System.out.println(hd+" "+a[0]);
				 	    for (i = 1; i < n; i++)
				 	    {
				 	    	 //System.out.println(a[i]-a[i-1]);
				 	    	 if ((a[i]-a[i-1])<0)
				 	 	    {
				 	 	    	count=count + (a[i-1]-a[i]);
				 	 	    	 System.out.println(a[i-1]+" "+a[i]);
				 	 	    }
				 	 	    else
				 	 	    {
				 	 	    	count=count - (a[i-1]-a[i]);
				 	 	    	System.out.println(a[i-1]+" "+a[i]);
				 	 	    }

				 	     }
				 	    System.out.println("Total Seek Time");
				 	    System.out.println(count);
				 	   res.setText(String.valueOf(count));
				 	   
				 	   JFrame frame = new JFrame("Charts");

		                 frame.setSize(600, 400);
		                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                 frame.setVisible(true);

		                 XYSeries fcfs = new XYSeries("FCFS");
		                 
		                 fcfs.add(0, hd);
		                 int nat = 1;
		                 for(int raj=0;raj<n;raj++)
		                 {
		                	 fcfs.add(nat, a[raj]);
		                	 nat = nat + 1;
		                 }
		                 XYSeriesCollection dataset = new XYSeriesCollection();
		                 dataset.addSeries(fcfs);
		                 XYDataset ds = dataset;
		                 
		                 JFreeChart chart = ChartFactory.createXYLineChart("DISK MANAGEMENT",
		                         "x", "y", ds, PlotOrientation.VERTICAL, true, true,
		                         false);
		                
		                 ChartPanel cp = new ChartPanel(chart);

		                 frame.getContentPane().add(cp);
				 	}
		});
		btnNewButton.setBounds(37, 28, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SSTF");
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random R= new Random();
				int hd,st,ed,n,i,j,tmp=0,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				int d[]=new int[n];
				int in[]=new int[n];
				System.out.println("Input");
				for(i=0;i<n;i++)
				{
					in[i]=R.nextInt(ed-st)+st;
					System.out.println(in[i]);
				}
				int m=0,k=0;
				System.out.println("Output :");
				int [] out = new int[n+1];
				int sp = 0;
				out[sp++] = hd;
				for(i=0;i<n;i++)
				{
					for(k=0;k<n;k++)
					{
					//	if(in[k]!=hd)
					//	{
							d[k]=in[k]-hd;
							if(d[k]<0)
								d[k]=-d[k];
					//	}
					}
					m=fun(d,n);
					System.out.println(hd+" "+in[m]);
					
					if(in[m]>hd)
						count=count+(in[m]-hd);
					else
						count=count+(hd-in[m]);
					hd=in[m];
					out[sp] = hd;
					sp = sp+1;
					in[m]=100000000;
				}
				res.setText(String.valueOf(count));
				
				JFrame frame = new JFrame("Charts");

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                XYSeries sstf = new XYSeries("SSTF");
               
                
                int nat = 0;
                for(int raj=0;raj<n+1;raj++)
                {
               	 sstf.add(nat, out[raj]);
               	 nat = nat + 1;
                }
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(sstf);
                XYDataset ds = dataset;
                
                JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                        "x", "y", ds, PlotOrientation.VERTICAL, true, true,
                        false);
               
                ChartPanel cp = new ChartPanel(chart);

                frame.getContentPane().add(cp);
			}
			public int fun(int a[],int n)
			{
				int min=a[0],j,p=0;
				for(j=0;j<n;j++)
				{
					if(a[j]<min)
					{
						min=a[j];
						p=j;
					}
				}
				return p;
			}
			
			
				
		});
		btnNewButton_1.setBounds(181, 28, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LOOK");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random R= new Random();
				int hd,st,ed,n,i,j,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				System.out.println("Input");
				 	    int[] a = new int[n+1];
				 	    a[0]=hd;
				 	    for (i = 1; i < n+1; i++)
				 	    {
				 	        a[i] = R.nextInt(ed-st)+st;
				 	       System.out.println(a[i]);
				 	    }
				 	    System.out.println("Output: ");
				 	    int [] out = new int[n+1];
				 	    int sp = 0;
					    Arrays.sort(a);
					    int p;
					    p=0;
					    for ( i = 0; i < (n+1); i++)
					    {
					        if(a[i]==hd)
					        {
					        	p=i;
					        }
					    }
					    for ( i = p; i > 0; i--)
					    {
					
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]+" 1Fi");
					 	    	out[sp++] = a[i];
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]+" 1Fe");
					 	    	out[sp++] = a[i];
					 	    }

					     }

					    if((a[p+1]-a[0])>0)
					    {
					    	count = count + (a[p+1]-a[0]);
					    	System.out.println(a[0]+" "+a[p+1]+" i");
					    	out[sp++] = a[0];
					    	if(sp == n){
					    		out[sp++] = a[p+1];
					    	}
					    }
					    else
					    {
					    	count= count-(a[p+1]-a[0]); 
					    }
					    for (i = (p+1); i < (n); i++)
					    {
					    	 if ((a[i]-a[i+1])<0)
					 	    {
					 	    	count=count + (a[i+1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i+1]+" 2Fi");
					 	    	if(i!=n-1){
					 	    		out[sp++] = a[i];
					 	    	}
					 	    	else if(i == n-1){
					 	    		out[sp++] = a[i];
					 	    		out[sp++] = a[i+1];
					 	    	}
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i+1]-a[i]);
					 	    	System.out.println(a[i+1]+" "+a[i]+" 2Fe");
					 	    	if(i!=n-1){
					 	    		out[sp++] = a[i+1];
					 	    	}
					 	    	else if(i == n-1){
					 	    		out[sp++] = a[i];
					 	    		out[sp++] = a[i+1];
					 	    	}
					 	    }

					     }
					    System.out.println(count);
					    res.setText(String.valueOf(count));
					    
					    JFrame frame = new JFrame("Charts");

		                 frame.setSize(600, 400);
		                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                 frame.setVisible(true);

		                 XYSeries look = new XYSeries("LOOK");
		                 
		                 int nat = 0;
		                 for(int raj=0;raj<n+1;raj++)
		                 {
		                	 look.add(nat++, out[raj]);
		                 }
		                 XYSeriesCollection dataset = new XYSeriesCollection();
		                 dataset.addSeries(look);
		                 XYDataset ds = dataset;
		                 
		                 JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
		                         "x", "y", ds, PlotOrientation.VERTICAL, true, true,
		                         false);
		                
		                 ChartPanel cp = new ChartPanel(chart);

		                 frame.getContentPane().add(cp);
				
			}
		});
		btnNewButton_2.setBounds(320, 28, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SCAN");
		btnNewButton_3.setForeground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Random R= new Random();
				int hd,st,ed,n,i,j,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				System.out.println("Input");
				 	    int[] a = new int[n+1];
				 	    a[0]=hd;
				 	    for (i = 1; i < n+1; i++)
				 	    {
				 	        a[i] = R.nextInt(ed-st)+st;
				 	       System.out.println(a[i]);
				 	    }
				 	    System.out.println("Output: ");
				 	    int [] out = new int[n+3];
				 	    int sp = 0;
					    Arrays.sort(a);
					    int p;
					    p=0;
					    for ( i = 0; i < (n+1); i++)
					    {
					        if(a[i]==hd)
					        {
					        	p=i;
					        }
					    }
					    for (i = p; i > 0; i--)
					    {
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	        System.out.println(a[i-1]+" "+a[i]+" 1Fi");
					 	        out[sp++] = a[i-1];
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]+" 1Fe");
					 	    	out[sp++] = a[i];
					 	    }

					     }
				    	 System.out.println(a[i]+" "+0+" O");
				    	 out[sp++] = a[i];
				    	 if(n<=3){
				    		 out[sp++] = 0;
				    	 }
				    	 if(p+1<n+1)
				    	 {
				    	 System.out.println(0+" "+a[p+1]+" 1i");
				    	 out[sp++] = 0;
					    if((a[p+1]-a[0])>0)
					    {
					    	count = count + (a[p+1]-a[0]);
					    }
					    else
					    {
					    	count= count-(a[p+1]-a[0]); 
					    }
					    for (i = (p+1); i < (n); i++)
					    {
					    	 if ((a[i]-a[i+1])<0)
					 	    {
					 	    	count=count + (a[i+1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i+1]+" 2Fi");
					 	    	if(i != n-1){
					 	    		out[sp++] = a[i];
					 	    		}
					 	    	if(i == n-1){
					 	    		out[sp++] = a[i];
					 	    		out[sp++] = a[i+1];
					 	    	}
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i+1]-a[i]);
					 	    	System.out.println(a[i+1]+" "+a[i]+" 2Fe");
					 	    	if(i != n-1){
					 	    		out[sp++] = a[i];
					 	    		}
					 	    	if(i == n-1){
					 	    		out[sp++] = a[i];
					 	    		out[sp++] = a[i+1];
					 	    	}	
					 	    }
 
					     }
				    	 }
				    	 if(out[sp-1] != ed){
				    		 System.out.println(out[sp-1]+" "+ed);
				    		 out[sp++] = ed;
				    	 }
					    count=count+(2*(a[0]-st));
					    System.out.println(count);
					    res.setText(String.valueOf(count));
					   
					    JFrame frame = new JFrame("Charts");

		                 frame.setSize(600, 400);
		                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                 frame.setVisible(true);

		                 XYSeries scan = new XYSeries("SCAN");
		                 
		                 int nat = 0;
		                 for(int raj=0;raj<sp;raj++)
		                 {
		                	 scan.add(nat, out[raj]);
		                	 nat = nat + 1;
		                 }
		                 XYSeriesCollection dataset = new XYSeriesCollection();
		                 dataset.addSeries(scan);
		                 XYDataset ds = dataset;
		                 
		                 JFreeChart chart = ChartFactory.createXYLineChart("Disk Management",
		                         "x", "y", ds, PlotOrientation.VERTICAL, true, true,
		                         false);
		                
		                 ChartPanel cp = new ChartPanel(chart);

		                 frame.getContentPane().add(cp);
				
			}
		});
		btnNewButton_3.setBounds(37, 215, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CSCAN");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random R= new Random();
				int n,i,j,tmp=0, hd,st,ed;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				int a[]=new int[n+1];
				System.out.println("Input");
			    int head=hd;
			    int lb=st,ub=ed;
				for(i=1;i<n+1;i++)
				{
					a[i]=R.nextInt(ub-lb)+lb;
					System.out.println(a[i]);
				}	
				System.out.println("Output: ");
				int [] out=new int[n+1];
				int sp=0;
					    a[0]=head;
					    out[sp]=hd;
					    sp++;
					    Arrays.sort(a);
					    int p;
					    p=0;
					    for (i = 0; i < (n+1); i++)
					    {
					       // System.out.println(a[i]);
					       // a[i] = input.nextDouble();
					        if(a[i]==head)
					        {
					        	p=i;
					        }
					    }
					    int count=0;
					    for (i = p; i > 0; i--)
					    {
					    	 //System.out.println(a[i]-a[i-1]);
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	 System.out.println(a[i]+" "+a[i-1]);
					 	    	 out[sp++]=a[i];
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	 System.out.println(a[i]+" "+a[i-1]);
					 	    	 out[sp++]=a[i];
					 	    }

					     }
				    	 System.out.println(a[0]+" "+st);
				    	 out[sp++]=a[0];
				    	 out[sp++]=st;
				    	 System.out.println(ed+" "+a[n]);
				    	 out[sp++]=ed;
				    	 out[sp++]=a[n];
					    for (i = n; i > (p+1); i--)
					    {
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	 System.out.println(a[i]+" "+a[i-1]);
					 	    	 out[sp++]=a[i];
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	 System.out.println(a[i]+" "+a[i-1]);
					 	    	 out[sp++]=a[i];
					 	    }

					     }
					    count=count+(a[0]-lb)+(ub-a[n]);
					    System.out.println(count);
					    res.setText(String.valueOf(count));  
					    
					    JFrame frame = new JFrame("Charts");

		                 frame.setSize(600, 400);
		                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                 frame.setVisible(true);

		                 XYSeries cscan = new XYSeries("CSCAN");
		                 
		                 cscan.add(0, hd);
		                 int nat = 1;
		                 for(int raj=0;raj<n+1;raj++)
		                 {
		                	 cscan.add(nat, a[raj]);
		                	 nat = nat + 1;
		                 }
		                 XYSeriesCollection dataset = new XYSeriesCollection();
		                 dataset.addSeries(cscan);
		                 XYDataset ds = dataset;
		                 
		                 JFreeChart chart = ChartFactory.createXYLineChart("DISK MANAGEMENT",
		                         "x", "y", ds, PlotOrientation.VERTICAL, true, true,
		                         false);
		                
		                 ChartPanel cp = new ChartPanel(chart);

		                 frame.getContentPane().add(cp);
					}
		});
		btnNewButton_4.setBounds(181, 215, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("CLOOK");
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_5.setBackground(Color.CYAN);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//   Scanner input = new Scanner(System.in);
				Random R= new Random();
				int hd,st,ed,n,i,j,tmp=0,count=0;
				hd=Integer.parseInt(head.getText());
				st=Integer.parseInt(start.getText());
				ed=Integer.parseInt(end.getText());
				n=Integer.parseInt(num.getText());
				int d[]=new int[n];
				int a[]=new int[n+1];
				System.out.println("Input");
				for(i=1;i<n+1;i++)
				{
					a[i]=R.nextInt(ed-st)+st;
					System.out.println(a[i]);
				}		
				int out[]=new int[n+1];
				int sp=0;
					    a[0]=hd;
					    Arrays.sort(a);
					    int p;
					    p=0;
					    System.out.println("Output :");
					    for (i = 0; i < (n+1); i++)
					    {
					       // System.out.println(a[i]);
					       // a[i] = input.nextDouble();
					        if(a[i]==hd)
					        {
					        	p=i;
					        }
					    }
					    for (i = p; i > 0; i--)
					    {
					    	 //System.out.println(a[i]-a[i-1]);
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	 //System.out.println(count);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    	out[sp++]=a[i];
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    	out[sp++]=a[i];
					 	    }

					     }
				    	 //System.out.println(a[p+1]-a[0]);
					    out[sp++]=a[0];
					    for ( i = n; i > (p+1); i--)
					    {
					    	 //System.out.println(a[i]-a[i+1]);
					    	 if ((a[i]-a[i-1])<0)
					 	    {
					 	    	count=count + (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    	out[sp++]=a[i];
					 	    }
					 	    else
					 	    {
					 	    	count=count - (a[i-1]-a[i]);
					 	    	System.out.println(a[i]+" "+a[i-1]);
					 	    	out[sp++]=a[i];
					 	    }

					     }
					 //   count=count+(a[0]-lb)+(ub-a[n]);
					    System.out.println(count);
					    res.setText(String.valueOf(count));
					    
					    JFrame frame = new JFrame("Charts");

		                 frame.setSize(600, 400);
		                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                 frame.setVisible(true);

		                 XYSeries cscan = new XYSeries("CSCAN");
		                 
		                 cscan.add(0, hd);
		                 int nat = 1;
		                 for(int raj=0;raj<n+1;raj++)
		                 {
		                	 cscan.add(nat, a[raj]);
		                	 nat = nat + 1;
		                 }
		                 XYSeriesCollection dataset = new XYSeriesCollection();
		                 dataset.addSeries(cscan);
		                 XYDataset ds = dataset;
		                 
		                 JFreeChart chart = ChartFactory.createXYLineChart("DISK MANAGEMENT",
		                         "x", "y", ds, PlotOrientation.VERTICAL, true, true,
		                         false);
		                
		                 ChartPanel cp = new ChartPanel(chart);

		                 frame.getContentPane().add(cp);
					    
					}

		});
		btnNewButton_5.setBounds(320, 215, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		head = new JTextField();
		head.setForeground(Color.BLACK);
		head.setBounds(40, 98, 86, 20);
		frame.getContentPane().add(head);
		head.setColumns(10);
		
		num = new JTextField();
		num.setText("");
		num.setBounds(184, 98, 86, 20);
		frame.getContentPane().add(num);
		num.setColumns(10);
		
		start = new JTextField();
		start.setBounds(37, 165, 86, 20);
		frame.getContentPane().add(start);
		start.setColumns(10);
		
		end = new JTextField();
		end.setText("");
		end.setBounds(184, 165, 86, 20);
		frame.getContentPane().add(end);
		end.setColumns(10);
		
		res = new JTextField();
		res.setBounds(323, 116, 86, 20);
		frame.getContentPane().add(res);
		res.setColumns(10);
		
		JLabel lblOutput = new JLabel("Seek Time");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setBounds(320, 82, 89, 23);
		frame.getContentPane().add(lblOutput);
		
		JLabel lblHead = new JLabel("Head");
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHead.setForeground(Color.BLACK);
		lblHead.setBounds(37, 73, 46, 14);
		frame.getContentPane().add(lblHead);
		
		JLabel lblNum = new JLabel("Num");
		lblNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNum.setBounds(184, 73, 46, 14);
		frame.getContentPane().add(lblNum);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStart.setBounds(37, 140, 46, 14);
		frame.getContentPane().add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnd.setBounds(184, 140, 46, 14);
		frame.getContentPane().add(lblEnd);
		
	}
	
	/*private static XYDataset createDataset() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };

        ds.addSeries("series1", data);

        return ds;
    }*/

}
