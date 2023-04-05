package Main;

import java.util.concurrent.Semaphore;

import controller.cozinha;

public class Principal {
	public static void main(String[] args) {
		int id, permissoes=1; // o id e as permissoes=1;
		Semaphore sema=new Semaphore(permissoes);
		for(id=1;id<6;id++) { // for que vai startar as Threads 
			cozinha t= new cozinha(id,sema); // passando o id e semaforo
			t.start();
		}
	}
	}

