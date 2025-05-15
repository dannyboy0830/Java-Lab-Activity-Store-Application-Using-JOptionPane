/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programming.logic.and.design.computer.programming;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author PALOMO_CPE121
 */
public class ProgrammingLogicAndDesignComputerProgramming {

    /**
     * @param args the command line arguments
     */
   public static double calculateRectangleArea(double length, double width) {
        if (length <= 0 || width <= 0) {
            return -1; 
        }
        return length * width;
    }

    
    public static double calculateTriangleArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            return -1; 
        }
        return 0.5 * base * height;
    }

    
    public static double calculateCircleArea(double radius) {
        if (radius <= 0) {
            return -1; 
        }
        return Math.PI * radius * radius;
    }

    // Function: Volume of a Cube
    public static double calculateCubeVolume(double side) {
        if (side <= 0) {
            return -1; // Indicate an error
        }
        return side * side * side;
    }

    // Function: Volume of a Sphere
    public static double calculateSphereVolume(double radius) {
        if (radius <= 0) {
            return -1;
        }
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Function: Volume of a Cylinder
    public static double calculateCylinderVolume(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            return -1;
        }
        return Math.PI * radius * radius * height;
    }

    // Function: Trigonometry (Law of Cosines)
    public static double calculateTriangleSide(double a, double b, double angleC) {
        if (a <= 0 || b <= 0 || angleC <= 0 || angleC >= 180) {
            return -1; // Invalid triangle
        }
        double angleCRad = Math.toRadians(angleC);
        return Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(angleCRad));
    }

    // Function: Geometry (Area of a Circle Segment)
    public static double calculateCircleSegmentArea(double radius, double angle) {
        if (radius <= 0 || angle <= 0) {
            return -1;
        }
        double angleRad = Math.toRadians(angle);
        return (radius * radius / 2.0) * (angleRad - Math.sin(angleRad));
    }

    // Function: Solid Mensuration (Volume and Surface Area of a Sphere)
    public static double calculateSphereSurfaceArea(double radius) {
        if (radius <= 0) {
            return -1;
        }
        return 4 * Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Area and Volume Calculator ---");
            System.out.println("1. Calculate Rectangle Area");
            System.out.println("2. Calculate Triangle Area");
            System.out.println("3. Calculate Circle Area");
            System.out.println("4. Calculate Cube Volume");
            System.out.println("5. Calculate Sphere Volume");
            System.out.println("6. Calculate Cylinder Volume");
            System.out.println("7. Calculate Triangle Side (Law of Cosines)");
            System.out.println("8. Calculate Circle Segment Area");
            System.out.println("9. Calculate Sphere Surface Area");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                choice = -1; // Go back to the loop
                continue;
            }

            double result = 0; // Initialize result

            switch (choice) {
                case 1:
                    System.out.print("Enter rectangle length: ");
                    double length = scanner.nextDouble();
                    System.out.print("Enter rectangle width: ");
                    double width = scanner.nextDouble();
                    result = calculateRectangleArea(length, width);
                    if (result != -1)
                        System.out.println("Rectangle area: " + result);
                    else
                        System.out.println("Invalid input. Length and width must be positive.");
                    break;
                case 2:
                    System.out.print("Enter triangle base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter triangle height: ");
                    double height = scanner.nextDouble();
                    result = calculateTriangleArea(base, height);
                    if (result != -1)
                        System.out.println("Triangle area: " + result);
                    else
                        System.out.println("Invalid input. Base and height must be positive.");
                    break;
                case 3:
                    System.out.print("Enter circle radius: ");
                    double radius = scanner.nextDouble();
                    result = calculateCircleArea(radius);
                    if (result != -1)
                        System.out.println("Circle area: " + result);
                    else
                        System.out.println("Invalid input. Radius must be positive.");
                    break;
                case 4:
                    System.out.print("Enter cube side: ");
                    double side = scanner.nextDouble();
                    result = calculateCubeVolume(side);
                    if (result != -1)
                        System.out.println("Cube volume: " + result);
                    else
                        System.out.println("Invalid input. Side must be positive.");
                    break;
                case 5:
                    System.out.print("Enter sphere radius: ");
                    radius = scanner.nextDouble();
                    result = calculateSphereVolume(radius);
                    if (result != -1)
                        System.out.println("Sphere volume: " + result);
                    else
                        System.out.println("Invalid input. Radius must be positive.");
                    break;
                case 6:
                    System.out.print("Enter cylinder radius: ");
                    radius = scanner.nextDouble();
                    System.out.print("Enter cylinder height: ");
                    height = scanner.nextDouble();
                    result = calculateCylinderVolume(radius, height);
                    if (result != -1)
                        System.out.println("Cylinder volume: " + result);
                    else
                        System.out.println("Invalid input. Radius and height must be positive.");
                    break;
                case 7:
                    System.out.print("Enter side a: ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter side b: ");
                    double b = scanner.nextDouble();
                    System.out.print("Enter angle C (in degrees): ");
                    double angleC = scanner.nextDouble();
                    result = calculateTriangleSide(a, b, angleC);
                    if (result != -1)
                        System.out.println("Third side of the triangle: " + result);
                    else
                        System.out.println("Invalid input. Sides must be positive, and angle must be between 0 and 180 degrees.");
                    break;
                case 8:
                    System.out.print("Enter circle segment radius: ");
                    radius = scanner.nextDouble();
                    System.out.print("Enter central angle (in degrees): ");
                    double angle = scanner.nextDouble();
                    result = calculateCircleSegmentArea(radius, angle);
                    if (result != -1)
                        System.out.println("Circle segment area: " + result);
                    else
                        System.out.println("Invalid input. Radius and angle must be positive.");
                    break;
                case 9:
                    System.out.print("Enter sphere radius: ");
                    radius = scanner.nextDouble();
                    result = calculateSphereSurfaceArea(radius);
                    if (result != -1)
                        System.out.println("Sphere surface area: " + result);
                    else
                        System.out.println("Invalid input.  Radius must be positive.");
                    break;
                case 0:
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
