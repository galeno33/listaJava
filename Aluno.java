package aluno;

public class Aluno {
    
    //DEclaraço da variavel nome para nome do aluno
    private String nome;
    
    public String getnome(){
        return nome;
    }

    public void SetNome(String nome){
        this.nome = nome;
    }

    //metodo toString para imprimir os alunos na tela
    public String toString(){
        return this.nome;
    }

    //metodo equals para comparar dois objetos do tipo Aluno, como criterio de comparaçao o nome do aluno 
    public boolean equals(Object o){
        Aluno outro = (Aluno) o;
        return this.nome.equals(outro.nome);
    }
}