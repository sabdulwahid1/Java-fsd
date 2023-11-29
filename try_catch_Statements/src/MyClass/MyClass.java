package MyClass;

public class MyClass {
	public static void main(String[] args) {
		int[] array = new int[5];
		try {
			array[7]=5;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index is out of bounds!..");
		}finally {
			System.out.println("Array size is "+array.length);
		}
	}

}
