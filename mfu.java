import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MFU extends JFrame
{
    int full=0,n;
	int a[]=new int[21];
	int frame[]=new int[3];
	int ctr[]=new int[3];
	int repptr;
	int count=0;
    JPanel jp =new JPanel();
    MFU(String page[])
    {  
        setContentPane(jp);
        jp.setLayout(new GridLayout(8,0));
        for(int i=0;i<10;i++)
        {
                a[i]=Integer.parseInt(page[i]);
        }    
        for(int i=0;i<10;i++)	
		{
			if(Search(a[i])!=1)
			{
				Pagefault(a[i]);
				display();
				count++;
			}
		}
        jp.add(new JLabel(" "));
        jp.add(new JLabel("The number of page faults are  "+count));
        setVisible(true);
        setSize(900,700);
    }
    void init()
	{
		for(int i=0;i<3;i++)
		{
			ctr[i]=0;
		}
	}
	void display()
	{
		int i;
        JLabel framel[]=new JLabel[3];
		for(i=0;i<3;i++)
		{
            String temp=Integer.toString(frame[i]);
            framel[i]=new JLabel(temp);
            jp.add(framel[i]);
		}
	}
	int Longestopt()
	{
		int i,max;
		max=0;
		for(i=0;i<3;i++)
			if(ctr[max]<ctr[i])
				max=i;	
			repptr=max;
		return repptr;
	}
	int Pagerep(int ele)
	{
		int temp;
		repptr=Longestopt();
		temp=frame[repptr];
		frame[repptr]=ele;
		ctr[repptr]=1;
		return temp;	
	}
	void Pagefault(int ele)
	{
		if(full!=3)	
		{
			ctr[full]++;
			frame[full++]=ele;	
		}
		else
		{
            int x=Pagerep(ele);
        }
	}
	int Search(int ele)
	{
		int i,flag;
		flag=0;
		if(full!=0)
		{
			for(i=0;i<full;i++)
				if(ele==frame[i])
				{
					flag=1;
					ctr[i]++;
					break;
				}
		}
		return flag;	
	}
}
