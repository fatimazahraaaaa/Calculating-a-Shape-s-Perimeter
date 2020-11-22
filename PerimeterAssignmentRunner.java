import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int S=0;
        for (Point pt: s.getPoints()){
            S=S+1;
        }
        return S;
    }

    public double getAverageLength(Shape s) {
        double A = 0.0;
        A=getPerimeter(s)/getNumPoints(s);
        return A;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double L=getAverageLength(s);
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist>=L)
            { L=currDist;}
        }
        return L;
    }

    public double getLargestX(Shape s) {
        double D=s.getLastPoint().getX();
        for (Point pt : s.getPoints()) {
            if (pt.getX()>D)
               { D=pt.getX();
        }}
        return D;
    }

    public double getLargestPerimeterMultipleFiles() {
        double length;
        double M=0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            length = getPerimeter(s);
            if (length>M)
            { M=length;
            }
            
            
        }
        return M;
    }

    public String getFileWithLargestPerimeter() {
        double length;
        File temp= null;
        double M=0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            length = getPerimeter(s);
            if (length>M)
            { M=length;
            }
            if (getPerimeter(s) == M)
            {   temp =new File(f.getName()); }}
           // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double D=getLargestX(s);
        double A=getAverageLength(s);
        int S= getNumPoints(s);
        double length = getPerimeter(s);
        double L=getLargestSide(s);
        System.out.println("perimeter = " + length);
        System.out.println("nombre de points dans le shape est  = " + S);
        System.out.println("average side dans le shape est  = " + A);
        System.out.println("largest side  dans le shape est  = " + L);
        System.out.println("largest X  dans le shape est  = " + D);
        
    }
    
    public void testPerimeterMultipleFiles() {
        double M= getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter is " + M);
    }

    public void testFileWithLargestPerimeter() {
        String f=getFileWithLargestPerimeter();
        System.out.println("file li 3endou largest perimetre:" + f);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.getLargestPerimeterMultipleFiles();
        pr.getFileWithLargestPerimeter();
    }
}
