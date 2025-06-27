import java.text.DateFormat;
import java.util.Date;
import java.util.Locale; 
import java.util.Scanner;

class Entrada {
    public static final Scanner scan = new Scanner(System.in);
}

class Data{
	
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

class Hora
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

public class ConsultaAgendada
{
    private Data dataConsulta;
    private Hora horaConsulta;
    private String nomePaciente;
    private static int quantidade = 0;
    private String nomeMedico;
    
    //metodos da classe ConsultaAgendada
    
    public ConsultaAgendada ()
    {
        setData();
        setHora();
        Entrada.scan.nextLine(); // <-- limpa o buffer
        setNomePaciente();
        setNomeMedico();
        quantidade++;
    }
    public ConsultaAgendada (int h, int mi, int s, int d, int m, int a, String p, String md)
    {
        this.dataConsulta = new Data(d, m, a);
        this.horaConsulta = new Hora(h, mi, s);
        
        if(!p.trim().isEmpty()){
            this.nomePaciente = p;
        }
        else{System.out.println("nome do paciente vazio");}
        if(!md.trim().isEmpty())
        {
            this.nomeMedico = md;
        }
        else{System.out.println("nome do medico vazio");}
        
        quantidade++;
    }
    
    public ConsultaAgendada (Data d, Hora h, String p, String m){
        this.dataConsulta = d;
        this.horaConsulta = h;
        
        if(!p.trim().isEmpty()){
            this.nomePaciente = p;
        }
        else{System.out.println("nome do paciente vazio");}
        if(!m.trim().isEmpty())
        {
            this.nomeMedico = m;
        }
        else{System.out.println("nome do medico vazio");}
    
        quantidade++;
    }
    
    public void setData(int a, int b, int c){
        this.dataConsulta = new Data(a, b, c);
    }
    public void setData(){
        this.dataConsulta = new Data();
    }
    
    public void setHora(int a, int b, int c){
        this.horaConsulta = new Hora(a, b, c);
    }
    public void setHora(){
        this.horaConsulta = new Hora();
    }
    
    public void setNomePaciente(String p){
        if(!p.trim().isEmpty()){
			this.nomePaciente = p;
		}
		else{
			throw new IllegalArgumentException("paciente inválido");
		}
    }
    public void setNomePaciente(){
        String resNP;
		boolean verificador = false;
        while(!verificador){
		System.out.print("Digite o nome do paciente: ");
		try {
			resNP = Entrada.scan.nextLine();
			if(!resNP.trim().isEmpty())
			{
				this.nomePaciente = resNP;
				verificador = true;
			}else{
				System.out.println("nome errado!!! digite novamente!");
				}
		} catch (Exception e)
		{
			System.out.println("Entrada inválida. Digite um nome valido.");
        	Entrada.scan.next();
		}
		}
    }
    public void setNomeMedico(String m){
        if(!m.trim().isEmpty()){
			this.nomeMedico = m;
		}
		else{
			throw new IllegalArgumentException("medico inválido");
		}
    }
    public void setNomeMedico(){
        String resNM;
		boolean verificador = false;
        while(!verificador){
		System.out.print("Digite o nome do medico: ");
		try {
			resNM = Entrada.scan.nextLine();
			if(!resNM.trim().isEmpty())
			{
				this.nomeMedico = resNM;
				verificador = true;
			}else{
				System.out.println("nome errado!!! digite novamente!");
				}
		} catch (Exception e)
		{
			System.out.println("Entrada inválida. Digite um nome valido.");
        	Entrada.scan.next();
		}
		}
    }
    public static int getAmostra(){
        return quantidade;
    }
    public String getData(){
        return dataConsulta.mostra1();
    }
    public String getHora(){
        return horaConsulta.getHora1();
    }
    public String getNomePaciente (){
        return nomePaciente;
    }
    public String getNomeMedico(){
        return nomeMedico;
    }

	public static void main(String[] args) {
	    
	ConsultaAgendada p1 = new ConsultaAgendada(13, 49, 25, 29 , 2, 2024, "Henrique", "Dr. Matias");
	System.out.println("Data: " +p1.getData());
	System.out.println("Hora: " +p1.getHora());
	System.out.println("Nome do paciente: " + p1.getNomePaciente());
	System.out.println("Nome do medico: " + p1.getNomeMedico());
	System.out.println();
	
	ConsultaAgendada p2 = new ConsultaAgendada();
	
	System.out.println();
	System.out.println("Data: " + p2.getData());
	System.out.println("Hora: " + p2.getHora());
	System.out.println("Nome do paciente: " + p2.getNomePaciente());
	System.out.println("Nome do medico: " + p2.getNomeMedico());
	System.out.println();
	
	p1.setData();
	p1.setHora();
	Entrada.scan.nextLine(); // <-- limpa o buffer
	p1.setNomePaciente();
	p1.setNomeMedico();
	
	System.out.println();
	System.out.println("Data: " +p1.getData());
	System.out.println("Hora: " +p1.getHora());
	System.out.println("Nome do paciente: " + p1.getNomePaciente());
	System.out.println("Nome do medico: " + p1.getNomeMedico());
	System.out.println();
	
	System.out.println("Quantidade de consultas: "+ getAmostra());
	
	Entrada.scan.close();
	}
}