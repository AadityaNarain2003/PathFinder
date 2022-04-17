/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aaditya
 */
public class PathFinder 
{
    //start will be always the 0,0 place and end will be always 1,1 place
    // 0 will represent open and 1 will represent blockage
    /*sample input
    0 1 0 1 1 1
    0 0 0 1 0 1
    1 1 0 0 0 0
    0 0 0 0 1 0
    0 0 0 1 1 1
    1 1 0 0 0 0
    */
    int n;
    int grid[][];
    int col[][];
    int visited[][];
    PathFinder(int n)
    {
        this.n=n;
        grid= new int[n][n];
        col=new int[n][n];
        visited=new int[n][n];
    }
    
    public int findPath(int grid[][],int n)
    {
        return go(grid,visited,n,0,0);
    }
    
    public  int go(int grid[][],int visited[][],int n ,int startx,int starty)
    {
        if(grid[startx][starty]==0 && visited[startx][starty]==1)
        {
            col[startx][starty]=1;
        }
        if(startx==n-1 && starty==n-1)
        {
            return 1;
        }
        if(visited[startx][starty]==1 || grid[startx][starty]==1)
        {
            return 0;
        }
        visited[startx][starty]++;
        try
        {            
            if(go(grid,visited,n,startx+1,starty)==1)
            {
                return 1;
            }
        }
        catch(Exception e){}
        try
        {            
            if(go(grid,visited,n,startx-1,starty)==1)
            {
                return 1;
            }
        }
        catch(Exception e){}
        try
        {            
            if(go(grid,visited,n,startx,starty+1)==1)
            {
                return 1;
            }
        }
        catch(Exception e){}
        try
        {            
            if(go(grid,visited,n,startx,starty-1)==1)
            {
                return 1;
            }
        }
        catch(Exception e){}
        
        return 0;
    }
    
    public static void main(String args[])
    {
        int n=6;
        int grid[][]={{0,1,0,1,1,1},{0,0,0,1,0,1},{1,1,0,0,0,0},{0,0,0,0,1,0},{0,0,0,1,1,1},{1,1,0,0,0,0}};
        PathFinder p=new PathFinder(n);
        p.grid=grid;
        System.out.println(p.findPath(grid, n));
    }
}
