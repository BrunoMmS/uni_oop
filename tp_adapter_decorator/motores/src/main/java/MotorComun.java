class MotorComun implements Motor{
	@Override
	public void arrancar(){
		System.out.println("Se arranco el auto");
	}

	@Override
	public void acelerar(){
		System.out.println("Se acelero el auto");
	}

	@Override
	public void apagar(){
		System.out.println("Se apago el motor el auto");
	}
}