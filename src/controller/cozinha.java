package controller;

import java.util.concurrent.Semaphore;

public class cozinha extends Thread {
 private int id; 
 private Semaphore sema;
 double temposopa, tempolasanha;
 double percentual;
 
 
	
	public cozinha(int id, Semaphore sema) {
		this.id=id;
		this.sema=sema;
	}
	 @Override
		public void run() {
			separa();
			pronto();
			entrega(id);
			
		}
	
	private void separa() {
		 if(id%2==0) {
			 tempolasanha=(int)((Math.random()*8)+6);
			 double tempoGasto = 0;
				System.out.println("#"+id+" - Lasanha a Bolonhesa");
				
				while(temposopa > tempoGasto) {
					System.out.println("#"+id+" - progresso em: "+((tempoGasto*100)/tempolasanha)+"%");
					
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tempoGasto++;
				}
				System.out.println("#"+id+" - Finalizado"); 
		 }
		 else if(id%2==1) {
			 temposopa=(int)((Math.random()*8)+6);
			 double tempoGasto = 0;
				System.out.println("#"+id+" - Sopa cebola ");
				
				while(temposopa > tempoGasto) {
					System.out.println("#"+id+" - progresso em: "+((tempoGasto*100)/temposopa)+"%");
					
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tempoGasto++;
				}
				System.out.println("#"+id+" - Finalizado"); 
		 }
		 
			 
		 }
	private void pronto() {
		try {
			sleep(MAX_PRIORITY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O pranto do "+ id +"Está pronto para entrega");
	}
	private void entrega(int id) {
		try {
			sema.acquire();
			
			int tempoEntrega = 5;
			int tempoGasto = 0;
			
			while(tempoGasto < tempoEntrega) {			
				sleep(1000);
				tempoGasto++;
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("#"+id+" - Entrega Finalizada");
			sema.release();
		}
	}
		
	}


