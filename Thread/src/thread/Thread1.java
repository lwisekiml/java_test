package thread;
/*
출처 : https://postitforhooney.tistory.com/entry/JavaThread-Java-Thread-Pool%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-Thread%EB%A5%BC-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0Thread-Runnable
run() : class에 오버라이딩 된 메소드를 호출해서 사용하는것으로 생각
start() : 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택(공간)을 생성한 다음 run()을 호출해서 그 안(스택)에 run()이 저장되는 것이다.
즉, 쓰레드를 사용하기 위해 start()를 실행기키는 순간 쓰에드만의 독립적인 작업 공간인 호출스택이 만들어지는 것이다.
그 후에 호출 스택안에 각 실행하고자 하는 예를 들면 run()과 같은 메소드들이 저장되는 것이다.
호출 스택에 있는 애요들이 모두 수행하고 나면 쓰레드는 호출스택 공간과 함께 메모리 상에서 소멸된다.
*/
public class Thread1 {
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
// 동시에 출력	: 001122....
//		t1.start();
//		t2.start();

// 한개 완료 되면 다음거 출력 : 0123...9012...
		t1.run();
		t2.run();
	}
}
