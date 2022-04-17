import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PathFinderVisuals extends JFrame implements ActionListener, KeyListener
{
    JFrame jf;
    JPanel jp;
    PathFinder pf;
    PathFinderVisuals(int grid[][])
    {
        this.setName("PathFinder");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setFocusable(true);
        this.setSize(new Dimension(520,530));
        this.setLayout(null);
        this.addKeyListener(this);
        
        jp=new JPanel();
        jp.setLayout(new GridLayout(grid.length,grid.length));
        jp.setSize(new Dimension(500,500));
        setPanel(grid,jp);
        this.add(jp);
        this.setVisible(true);
        
        pf=new PathFinder(grid.length);
        int n=pf.findPath(grid,grid.length);
        if(n==0)
        {
            JOptionPane.showMessageDialog(null, "No Path Avaiable");
        }
        else
        {
            this.remove(jp);
            jp.removeAll();
            setPanelAfter(grid,jp,pf);
            this.add(jp);
        }
        
        this.setVisible(true);
    }
    public static void main(String args[])
    {
       SwingUtilities.invokeLater(new Runnable(){
           public void run()
           {
               int grid[][]={{0,0,0,0,0,1},
                             {1,0,0,1,0,1},
                             {1,1,0,1,0,1},
                             {0,0,0,0,0,0},
                             {0,1,0,1,0,0},
                             {1,1,0,1,0,0}};;
               
               PathFinderVisuals pfv=new PathFinderVisuals(grid);
           }
       });
    }
    public JLabel jtf(int num,int len)
    {
        JLabel jt=new JLabel(Integer.toString(num),JLabel.CENTER);
        jt.setSize(new Dimension(500/len,500/len));
        jt.setBackground(new Color(100,100,100));
        jt.setForeground(Color.red);
        jt.setBorder(BorderFactory.createLineBorder(Color.black));
        jt.setFont(new Font("Ariel",Font.BOLD,40));
        return jt;
    }
    public void setPanel(int grid[][],JPanel jp)
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                jp.add(jtf(grid[i][j],grid.length));
            }
        }
    }
    
    public JLabel jtfAfter(int num,int len,PathFinder pf,int i,int j)
    {
        JLabel jt=new JLabel(Integer.toString(num),JLabel.CENTER);
        jt.setSize(new Dimension(500/len,500/len));
        jt.setBackground(new Color(100,100,100));
        jt.setForeground(Color.red);
        if(pf.col[i][j]==1)
        {
            jt.setForeground(Color.GREEN);
        }
        jt.setBorder(BorderFactory.createLineBorder(Color.black));
        jt.setFont(new Font("Ariel",Font.BOLD,40));
        return jt;
    }
    
    public void setPanelAfter(int grid[][],JPanel jp, PathFinder pf)
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                jp.add(jtfAfter(grid[i][j],grid.length,pf,i,j ));
            }
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
