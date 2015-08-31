public class DrawSquareDriver
{ 	
  public static void main(String[] args)
  {
  	// create a DrawSquare object named sq
  	//    this "calls" the constructor, which takes 
  	//    no parameters (nothing in the parentheses) 
  	DrawSquare sq = new DrawSquare();
  	
  	// use the DrawSquare object to call the method it contains to draw itself
	sq.draw();    
  }
}
