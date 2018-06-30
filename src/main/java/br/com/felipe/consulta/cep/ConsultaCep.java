package br.com.felipe.consulta.cep;

public class ConsultaCep {

    public static void main(String[] args){

         while(true) {
            System.out.println(new CommandConsultaCep("08340200").execute());
         }

    }

}
