import java.util.Scanner;
public class Hora
{
	private int hora;
	private int min;
	private int seg;

	public Hora()
	{
		setHor();
		setMin();
		setSeg();
	}

	public Hora(int h, int m, int s){
		if (h >= 0 && h <= 23 && m >= 0 && m < 60 && s >= 0 && s < 60) {
			this.hora = h;
			this.min = m;
			this.seg = s;
	}else{
			throw new IllegalArgumentException("Hora inválida: " + h + ":" + m + ":" + s);
		}
	}
	public void setHor(int h) {
		if (h >= 0 && h <= 23)
        	this.hora = h;
		else
			throw new IllegalArgumentException("Hora inválida");
    }
	public void setMin(int m) {
        if (m >= 0 && m <= 59)	
			this.min = m;
		else
			throw new IllegalArgumentException("Minuto inválido");
    }
	public void setSeg(int s) {
        if (s >= 0 && s <= 59)	
			this.seg = s;
		else
			throw new IllegalArgumentException("Segundo inválido");
    }
	public void setHor() {
		int resH;
		boolean verificador = false;
        while(!verificador){
		System.out.print("Digite a hora: ");
		try {
			resH = Entrada.scan.nextInt();
			if(resH <= 23 && resH >= 0)
			{
				this.hora = resH;
				verificador = true;
			}else{
				System.out.println("Valor errado!!! digite novamente!");
				}
		} catch (Exception e)
		{
			System.out.println("Entrada inválida. Digite um número inteiro.");
        	Entrada.scan.next();
		}
		}
    }
	public void setMin() {
		int resM;
		boolean verificador = false;
		while(!verificador){
        System.out.print("Digite o minuto: ");
		try{
			resM = Entrada.scan.nextInt();
			if (resM >= 0 && resM < 60)
			{
				this.min = resM;
				verificador = true;
			}else{
				System.out.println("Valor errado!!! digite novamente!");
				}
		} catch (Exception e)
		{
			System.out.println("Entrada inválida. Digite um número inteiro.");
        	Entrada.scan.next();
		}
		}
    }
	public void setSeg() {
        int resS;
		boolean verificador = false;
		while(!verificador){
        System.out.print("Digite o segundo: ");
		try {
			resS = Entrada.scan.nextInt();
			if (resS >= 0 && resS < 60)
			{
				this.seg = resS;
				verificador = true;
			}else{
				System.out.println("Valor errado!!! digite novamente!");
				}
		} catch (Exception e)
		{
			System.out.println("Entrada inválida. Digite um número inteiro.");
        	Entrada.scan.next();
		}
		}
    }

	public int getHor() {
        return hora;
    }
	public int getMin() {
        return min;
    }
	public int getSeg() {
        return seg;
    }

    public String getHora1()
	{
		return String.format("%02d:%02d:%02d", hora, min, seg);
	}
     public String getHora2()
	{
	    String periodo = hora < 12 ? "AM" : "PM";
		int hora12 = (hora == 0 || hora == 12) ? 12 : hora % 12;
		return String.format("%02d:%02d:%02d %s", hora12, min, seg, periodo);
	}
	public int getSegundos()
	{
		return ((hora * 3600) + (min * 60) + seg);
	}

	private static int escolherHorario() {
    System.out.print("Selecione o horário que quer mudar (1 a 3): ");
    try {
        int op = Entrada.scan.nextInt();
        if (op >= 1 && op <= 3) return op;
        else System.out.println("Opção inválida.");
    } catch (Exception e) {
        System.out.println("Entrada inválida.");
        Entrada.scan.next(); // limpar
    }
	return -1;	
}
}