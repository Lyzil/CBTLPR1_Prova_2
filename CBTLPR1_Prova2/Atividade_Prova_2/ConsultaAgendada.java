import java.util.Scanner; 

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
	
	System.out.println("=== Consulta p1 (construtor com parametros) ===");
	System.out.println("Data: " +p1.getData());
	System.out.println("Hora: " +p1.getHora());
	System.out.println("Nome do paciente: " + p1.getNomePaciente());
	System.out.println("Nome do medico: " + p1.getNomeMedico());
	System.out.println();
	
	ConsultaAgendada p2 = new ConsultaAgendada();
	
	System.out.println("\n=== Consulta p2 (construtor sem parametros) ===");
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
	
	System.out.println("\n=== Alterando os dados de p1 ===");
	System.out.println("Data: " +p1.getData());
	System.out.println("Hora: " +p1.getHora());
	System.out.println("Nome do paciente: " + p1.getNomePaciente());
	System.out.println("Nome do medico: " + p1.getNomeMedico());
	System.out.println();
	
	System.out.println("Quantidade de consultas: "+ getAmostra());
	
	Entrada.scan.close();
	}
}