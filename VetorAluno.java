package vetorAluno;

//import java.util.Arrays;
import aluno.Aluno;

public class VetorAluno {
   

   private Aluno[]alunos = new Aluno[100];

    private int totalDeAluno = 0;

   public void adicionarAluno(Aluno aluno){
    
    this.garantaEspaco(); //chamado do metodo garantaEspaco linha 114
    this.alunos[this.totalDeAluno] = aluno;
    this.totalDeAluno++;
    
   }

   public void adicionarAluno(int posicao, Aluno aluno){

    this.garantaEspaco();//chamado do metodo garantaEspaco linha 114

    if (!this.posicaoValida(posicao)){
        throw new IllegalArgumentException("posicao invalida");
    }

    for (int i = this.totalDeAluno - 1; i >= posicao; i -= 1){
        this.alunos[i + 1] = this.alunos[i];
    }

    this.alunos[posicao] = aluno;
    this.totalDeAluno++;

   }

   public Aluno pegarAluno(int posicao) {
  
    if(!this.posicaoOcupada(posicao)){
        throw new IllegalArgumentException("posiçao invalida");
    }
    return this.alunos[posicao];

   }

   //metodo para remover aluno de cada posiçao
   public void removerAluno(int posicao){

    if (!this.posicaoOcupada(posicao)){
        throw new IllegalArgumentException("Posicao invalida");
    }

    for (int i = posicao; i < this.totalDeAluno - 1; i++){
        this.alunos[i] = this.alunos[i + 1];
    }

    this.totalDeAluno--;
    
   }
   
   //verifica se um aluno est presente no vetor
   public boolean contemAluno(Aluno aluno){
       
        for(int i = 0; i < this.totalDeAluno; i++){
            if(aluno == this.alunos[i]){
                return true;
            }
        }
        return false;
   }



   public int tamanho(){
       
        return this.totalDeAluno;

   }

   public String toString(){

    if(this.totalDeAluno == 0){
        return "[]";
    }

    StringBuilder builder = new StringBuilder();
    builder.append("[");

    for(int i = 0; i < this.totalDeAluno - 1; i++){
        builder.append(this.alunos[i]);
        builder.append(",");
    }

    builder.append(this.alunos[this.totalDeAluno - 1]);
    builder.append("]");

    return builder.toString();
    //return Arrays.toString(alunos);

   }

   private boolean posicaoOcupada(int posicao){
    return posicao >= 0 && posicao < this.totalDeAluno;

    

   }

   private boolean posicaoValida(int posicao) {

        return posicao >= 0 && posicao <= this.totalDeAluno;
        
    }

    private void garantaEspaco(){

        if(this.totalDeAluno == this.alunos.length){
            Aluno[] novaArray = new Aluno[this.alunos.length * 2];

            for(int i = 0; i < this.alunos.length; i++){
                novaArray[i] = this.alunos[i];

            }
            this.alunos = novaArray;
        }
    }
}