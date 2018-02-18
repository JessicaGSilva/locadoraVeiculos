
public class MainTest extends Main {
	
	public void RetornaMelhorCarro() {
		String TipoCliente = "Normal";
		String NumPessoas = "2";
		String Datas = "20fev2018(ter), 21fev2018(qua), 24fev2018(sab)";
		
		Main instace = new Main();
		
		String expResult = "Carro sugerido: Carro Sport da loja WestCar";
		String result = instace.RetornaMelhorCarro(TipoCliente, NumPessoas, Datas);
	}

}
