package com.exception.handling;

 class MultipleCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			int []a=new int[5];
			a[5]=30/0;
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("=======end");
	}

}
