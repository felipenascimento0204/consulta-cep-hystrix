package br.com.felipe.consulta.cep;

public class ConsultaCep {

    private static String CEP_CONSULTA = "01311-929";

    public static void main(String[] args){
         while(true) {
            System.out.println(new CommandConsultaCep(CEP_CONSULTA).execute());
         }
    }

}
