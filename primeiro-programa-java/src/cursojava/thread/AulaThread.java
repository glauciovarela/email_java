package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {
	
	public static void main(String[] args) throws InterruptedException {
		
		new Thread() {
			
			public void rum() {/*Executa o que queremos*/
				/*C�digo da rotina */
				
				/*Rotina em pararelo*/
				for (int pos = 0; pos < 10; pos++) {
					
					/*Execute este envio com um tempo de parada*/
					System.out.println("Executando alguma rotina, por exemplo envio de email");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				/*Fim do c�digo em paralelo*/
				
			};
			
		}.start();/*Aciona a thread*/
		
				
		/*C�digo do sistema continua o fluxo */
		System.out.println("Chegou ao fim o c�digo de teste da THREAD");
		/*Fluxo do sistema */
		JOptionPane.showMessageDialog(null, "O Sistema continua para o usu�rio");
	}
}

