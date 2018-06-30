package br.com.felipe.consulta.cep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaExecutor {

    private static String ENDPOINT_CONSULTA_CEP = "http://api.postmon.com.br/v1/cep/";
    private String cep;

    public ConsultaExecutor(String cep){
        this.cep = cep;
    }

    public String execute(){
        return consultarCep();
    }

    private String consultarCep() {
        try {

            URL url = new URL(ENDPOINT_CONSULTA_CEP + this.cep);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            conn.disconnect();
            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
