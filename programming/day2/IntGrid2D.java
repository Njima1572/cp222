/*
Kochi Nakajima - 11/28/2017
CP222 daily assignment day2
*/

public class IntGrid2D implements IIntGrid2D{
	int x1, x2, y1, y2;
	char value;
	char[][] grid;

	public IntGrid2D(int up_left_x, int up_left_y, int low_right_x, int low_right_y, char v){
		x1 = up_left_x;
		x2 = low_right_x;
		y1 = up_left_y;
		y2 = low_right_y;
		value = v;
		grid = new char[Math.abs(x2 - x1) + 1][Math.abs(y2 - y1) + 1];
		for(int i = 0; i < Math.abs(x2 - x1) + 1; i++){
			for(int j = 0; j < Math.abs(y2 - y1) + 1; j++){
				grid[i][j] = value;
			}
		}
	}

	public void setPoint(IIntPoint2D p, char v){
		grid[p.getX() + this.x2][p.getY() + this.y1] = v;
	}
	public char getPoint(IIntPoint2D p){
		return grid[p.getX() + this.x2][p.getY() + this.y1];
	}
	public IIntPoint2D getUpperLeftCorner(){
		IIntPoint2D p = new IntPoint2D(this.x1, this.y1);
		return p;
	}
	public IIntPoint2D getLowerRightCorner(){
		IIntPoint2D p = new IntPoint2D(this.x2, this.y2);
		return p;
	}
}
