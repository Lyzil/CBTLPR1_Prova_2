import java.text.DateFormat;
import java.util.Date;
import java.util.Locale; 
import java.util.Scanner;

public class Data{
	
	private int dia;
	private int mes;
	private int ano;
	private int diasNoMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public Data()
	{
	    this.mes = 1;
        this.dia = 1;
        this.ano = 1;
        //colocando valores inicias para a verificação funcionar
		setAno();
		setMes();
		setDia();
	}
	public Data(int d, int m, int a){
	    if(a > 0 && a <= 9999)
	    {this.ano = a;} // fazer primeiro para não dar erro no metodo bissexto
	    else {
            throw new IllegalArgumentException("Ano inválido: " + a);
        }
		if (m > 0 && m <= 12) {
            this.mes = m;
        } else {
            throw new IllegalArgumentException("Mês inválido: " + m);
        }
        if (d > 0 && d <= getDiasNoMes(mes, ano)) {
            this.dia = d;
        } else {
            throw new IllegalArgumentException("Dia inválido: " + d);
        }
    }
    
    private int getDiasNoMes(int mes, int ano) {
        int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (mes == 2 && bissexto(ano)) {
            return 29;
        }
        return dias[mes - 1];
    }
	public void setDia(int d){
		if(d>0 && d <= getDiasNoMes(mes, ano)){
			this.dia = d;
		}
		else{
			throw new IllegalArgumentException("Dia inválido");
		}
	}
	public void setMes(int m){
		if(m>0 && m <=12){
			this.mes = m;
			if (dia > getDiasNoMes(mes, ano)) {
            dia = getDiasNoMes(mes, ano);
        }
		}
		else{
			throw new IllegalArgumentException("Mes inválido");
		}
	}
	public void setAno(int a){
		if(a > 0 && a<=9999){
			this.ano = a;
			if (dia > getDiasNoMes(mes, ano)) {
            dia = getDiasNoMes(mes, ano);
        }
		}
		else{
			throw new IllegalArgumentException("Ano inválido");
		}
	}
	public void setDia(){
	    int resD;
	    boolean verificador = false;
	    Entrada.scan.nextLine();
	    while (!verificador){
	        System.out.print("Digite o dia: ");
	        try {
			resD = Entrada.scan.nextInt();
			if(resD >0 && resD <= getDiasNoMes(mes, ano))
			{
				this.dia = resD;
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
	public void setMes() {
        int resM;
        boolean verificador = false;
        while (!verificador) {
            System.out.print("Digite o mes: ");
            try {
                resM = Entrada.scan.nextInt();
                if (resM > 0 && resM <= 12) {
                    this.mes = resM;
                    if (dia > getDiasNoMes(mes, ano)) {
                        dia = getDiasNoMes(mes, ano);
                    }
                    verificador = true;
                } else {
                    System.out.println("Valor errado!!! digite novamente!");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                Entrada.scan.next();
            }
        }
    }
    public void setAno() {
        int resA;
        boolean verificador = false;
        while (!verificador) {
            System.out.print("Digite o ano: ");
            try {
                resA = Entrada.scan.nextInt();
                if (resA > 0 && resA <= 9999) {
                    this.ano = resA;
                    if (dia > getDiasNoMes(mes, ano)) {
                        dia = getDiasNoMes(mes, ano);
                    }
                    verificador = true;
                } else {
                    System.out.println("Valor errado!!! digite novamente!");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                Entrada.scan.next();
            }
        }
    }
	
	public int getDia(){return dia;}
	public int getMes(){return mes;}
	public int getAno(){return ano;}
	
	public String mostra1(){
		return String.format("%02d/%02d/%04d", dia, mes, ano);
	}
	
	public String mostra2(){
	    String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		return String.format("%02d/%s/%04d", dia, meses[mes-1], ano);
	}
	
	public static boolean bissexto(int ano){
		if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0))
        {
            return true;
        }
		else{return false;}
	}
	public int diasTranscorridos(){
		int qtdDias = 0;
        diasNoMes[1] = bissexto(ano) ? 29 : 28;
            for (int i = 0; i < mes - 1; i++) {
                qtdDias += diasNoMes[i];
            }
            qtdDias += dia;
        return qtdDias;
	}
	
	public void apresentarDataAtual(){
		Date dataAtual = new Date();
        DateFormat formatar = DateFormat.getDateInstance(DateFormat.FULL, new Locale("pt", "BR"));
        	System.out.print(formatar.format(dataAtual));
	}
	private static int escolherData() {
    System.out.print("Selecione a data que quer mudar (1 a 3): ");
    try {
        int op =Entrada.scan.nextInt();
        if (op >= 1 && op <= 3) return op;
        else System.out.println("Opção inválida.");
    } catch (Exception e) {
        System.out.println("Entrada inválida.");
        Entrada.scan.next(); // limpar
    }
	return -1;	
    }
}