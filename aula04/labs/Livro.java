package aula04;

import java.util.Scanner;

public class Livro {
		
		private String titulo;
		private String autor;
		public int nroPaginas;
		private int paginaAtual = 1;
		
		public Livro(String titulo, String autor, int nroPaginas, int paginaAtual) {
			
			this.titulo = titulo;
			this.autor = autor;
			this.nroPaginas = nroPaginas;
			this.paginaAtual = paginaAtual;
			
		}
		
		public String getTitulo() {
			return titulo;
		}
		
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		public String getAutor() {
			return autor;
		}
		
		public void setAutor(String autor) {
			this.autor = autor;
		}
		
		public int getNroPaginas() {
			return this.nroPaginas;
		}
		
		public void setNroPaginas(int nroPaginas) {
			this.nroPaginas = nroPaginas;
		}
		
		public int getPaginaAtual() {
			return this.paginaAtual;
		}
		
		public void setPaginaAtual(int paginaAtual) {
			this.paginaAtual = paginaAtual;
		}
	
		public void virarPagina() {
			if(nroPaginas == paginaAtual) {
				return;
			}
			this.paginaAtual++;
		}
    
		public void retrocederPagina() {
			if(nroPaginas == 1) {
				return;
			}
			this.paginaAtual--;
		}
    
		public int irParaPagina(int pagina) {
			
			if (pagina >= 1 && pagina <= nroPaginas) {
				paginaAtual = pagina;
				return pagina;
			} else {
				System.out.println("Não existe essa página neste livro.");
				return 0;
			}
			
		}
        
		public String getInformacoes() {
		
			String informacoes = ("Título: " + titulo + "\nAutor: "+ autor + "\nPáginas: " + nroPaginas +"\nPágina Atual: " + paginaAtual);
			return informacoes;
			
        }
		
		public static void main(String[] args) throws InterruptedException {
			
			Scanner sc = new Scanner(System.in);
			
			int menu;
			
			Livro livro1 = new Livro ("Por Lugares Incríveis", "Jennifer Niven", 355, 2);
		
			livro1.getTitulo();
			livro1.getAutor();	
			livro1.getNroPaginas();
			livro1.getPaginaAtual();
			
			System.out.println(livro1.getInformacoes());
					
			
			do {
				System.out.println("\n\nO que você deseja fazer?");
				System.out.println("1 - Próxima página");
				System.out.println("2 - Retroceder página");
				System.out.println("3 - Ir para página");
				System.out.println("4 - Ler as informações");
				System.out.println("5 - Sair");
				menu = sc.nextInt();
				
				switch(menu){
				
					case 1:
					livro1.virarPagina();
					System.out.println("Você está na página: " + livro1.paginaAtual);
					Thread.sleep(1000);
					System.out.println("Você será redirecionado ao menu :]");
					Thread.sleep(2000);
					break;
					
					case 2:
					livro1.retrocederPagina();
					System.out.println("Você está na página: " + livro1.paginaAtual);
					Thread.sleep(1000);
					System.out.println("Você será redirecionado ao menu :]");
					Thread.sleep(2000);
					break;
					
					case 3:
					System.out.println("Digite para qual página quer ir");
					int pagina = sc.nextInt();
					livro1.irParaPagina(pagina);
					System.out.println("Você está na página: " + livro1.paginaAtual);
					Thread.sleep(1000);
					System.out.println("Você será redirecionado ao menu :]");
					Thread.sleep(2000);
					break;
					
					case 4:
					livro1.getInformacoes();
					System.out.println(livro1.getInformacoes());
					System.out.println("Você será redirecionado ao menu :]");
					Thread.sleep(2000);
					break;
					
				}		
				
			} while (menu != 5);
			
			System.out.println("Volte sempre! :]");
		
		}    
}

