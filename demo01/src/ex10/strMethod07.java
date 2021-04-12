package ex10;

public class strMethod07 {

	public static void main(String[] args) {

		// split() 메서드 사용 
		
		String animals = "dog,cat,bear"; // , (콤마)가 문자열에서 구분자로 존재할 경우
		
		String[] arr = animals.split(","); // arr[0], arr[1], arr[2]
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("--------------------");
		// 향상되 for문 ( 요소의 타입변수 : 배열 or 컬렉션)
		for(String animal : arr) {
			System.out.println(animal);
		}
		
		System.out.println("--------------------");
		
		String[] arr2 = animals.split(",", 2);
		
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
/*실행결과
dog
cat
bear
--------------------
dog
cat
bear
--------------------
dog
cat
*/

