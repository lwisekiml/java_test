package test;

public class TEST1
{
	public static void main(String[] args)
	{
//		char dst1[] =
//		{ '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
//		char src1[] =
//		{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
//
//		System.arraycopy(src1, 0, dst1, 0, 9);
//		System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
//		System.out.println("ThreadName =" + Thread.currentThread().getName() + ", dst :" + new String(dst1));

		ThreadEX threadex1 = new ThreadEX();
		ThreadEX threadex2 = new ThreadEX();

		Thread thread1 = new Thread(threadex1, "A");
		Thread thread2 = new Thread(threadex2, "B");

		thread1.start();
		thread2.start();

		try
		{
			thread1.join();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try
		{
			thread2.join();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " Thread end, dst1 = " + new String(ThreadEX.dst1));
	}
}

class ThreadEX implements Runnable
{
	static char dst1[] =
	{ '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
	static char src1[] =
	{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
	static char src2[] =
	{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++)
		{
			if (Thread.currentThread().getName().equals("A"))
			{
				synchronized (this)
				{
					System.arraycopy(src1, 0, dst1, 0, 10);
				}
			}

			if (Thread.currentThread().getName().equals("B"))
			{
				synchronized (this)
				{
					System.arraycopy(src2, 0, dst1, 0, 10);
				}
			}

			System.out.println("ThreadName =" + Thread.currentThread().getName() + ", dst :" + new String(dst1));

//			try
//			{
//				Thread.sleep(500);
//			}
//			catch (InterruptedException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}