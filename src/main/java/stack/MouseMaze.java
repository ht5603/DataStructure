package stack;

import java.util.Stack;

class Trace {
	int x;
	int y;
	public Trace(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class MouseMaze {
	
	public static int ExitX= 8;			//定義出口的X座標在第八列
	public static int ExitY= 10;			//定義出口的Y座標在第十行
	public static int [][] MAZE= 
		             {{1,1,1,1,1,1,1,1,1,1,1,1},	//宣告迷宮陣列
			          {1,0,0,0,1,1,1,1,1,1,1,1},
					  {1,1,1,0,1,1,0,0,0,0,1,1},
					  {1,1,1,0,1,1,0,1,1,0,1,1},
					  {1,1,1,0,0,0,0,1,1,0,1,1},			  		
	                  {1,1,1,0,1,1,0,1,1,0,1,1},
					  {1,1,1,0,1,1,0,1,1,0,1,1},
					  {1,1,1,1,1,1,0,1,1,0,1,1},
				      {1,1,0,0,0,0,0,0,1,0,0,1},
				      {1,1,1,1,1,1,1,1,1,1,1,1}};

	public static void main(String[] args) {
		int i, j, x=1, y=1;
		Stack<Trace> path = new Stack<Trace>();
		System.out.print("[迷宮的路徑(0的部分)]\n"); 
		for(int a = 0; a<10; a++){
			for(int b=0; b<12; b++){
				System.out.print(MAZE[a][b]);
			}
			System.out.print("\n");
		}
		
		while(x<=ExitX&&y<=ExitY)
		{
			MAZE[x][y]=2;
			if(MAZE[x-1][y]==0)
			{
				x -= 1;		
				path.push(new Trace(x,y));
			}
			else if(MAZE[x+1][y]==0)
			{
				x+=1;
				path.push(new Trace(x,y));
			}
			else if(MAZE[x][y-1]==0)
			{
				y-=1;
				path.push(new Trace(x,y));
			}
			else if(MAZE[x][y+1]==0)
			{
				y+=1;
				path.push(new Trace(x,y));
			}
			else if(chkExit(x,y,ExitX,ExitY)) 
				break;
			else
			{
				MAZE[x][y]=2;
				Trace back = path.pop();
				x=back.x;
				y=back.y;
			}
		}
		
		System.out.print("[老鼠走過的路徑(2的部分)]\n"); 
		for(i=0;i<10;i++)
		{
			for(j=0;j<12;j++)
				System.out.print(MAZE[i][j]);
			System.out.print("\n");
		}

	}
	

	public static boolean chkExit(int x,int y,int ex,int ey)
	{
		if(x==ex&&y==ey)
		{
			if(MAZE[x-1][y]==1||MAZE[x+1][y]==1||MAZE[x][y-1] ==1||MAZE[x][y+1]==2)
				return true;
			if(MAZE[x-1][y]==1||MAZE[x+1][y]==1||MAZE[x][y-1] ==2||MAZE[x][y+1]==1)
				return true;
			if(MAZE[x-1][y]==1||MAZE[x+1][y]==2||MAZE[x][y-1] ==1||MAZE[x][y+1]==1)
				return true;
			if(MAZE[x-1][y]==2||MAZE[x+1][y]==1||MAZE[x][y-1] ==1||MAZE[x][y+1]==1)
				return true;
	    }
		return false;
	}
}
