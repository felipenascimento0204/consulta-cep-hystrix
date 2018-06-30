package br.com.felipe.consulta.cep;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommandConsultaCep extends HystrixCommand<String> {

    private ConsultaExecutor executor;

    public CommandConsultaCep(String cep){
        super(HystrixCommandGroupKey.Factory.asKey("ConsultaCEP"));
        this.executor = new ConsultaExecutor(cep);
    }

    protected String run() throws Exception {
        return this.executor.execute();
    }

    @Override
    protected String getFallback() {
        return "{\"message\": \"SERVICO DE CONSULTA DE CEP INDISPONIVEL\"}";
    }
}
